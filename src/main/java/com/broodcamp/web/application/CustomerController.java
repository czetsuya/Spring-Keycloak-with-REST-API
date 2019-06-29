package com.broodcamp.web.application;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.business.exception.CustomerNotFoundException;
import com.broodcamp.data.entity.Customer;
import com.broodcamp.data.repository.CustomerRepository;
import com.broodcamp.web.assembler.CustomerResourceAssembler;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@Autowired
	private CustomerResourceAssembler assembler;

	/**
	 * Get all the customer available in the underlying system
	 * 
	 * @return list of customers
	 */
	@GetMapping(path = "")
	public Resources<Resource<Customer>> all() {
		List<Resource<Customer>> entities = repository.findAll().stream().map(assembler::toResource).collect(Collectors.toList());

		return new Resources<>(entities, linkTo(methodOn(CustomerController.class).all()).withSelfRel());
	}

	/**
	 * Create a customer with the system.This end point accepts customer information
	 * in the json format.It will create and send back the data to the REST
	 * customer.
	 * 
	 * @param newCustomer
	 * @return newly created customer
	 * @throws URISyntaxException
	 */
	@PostMapping(path = "")
	public ResponseEntity<Resource<Customer>> newCustomer(@RequestBody Customer newCustomer) throws URISyntaxException {

		Resource<Customer> resource = assembler.toResource(repository.save(newCustomer));
		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) throws URISyntaxException {

		Customer updatedEmployee = repository.findById(id).map(employee -> {
			employee.setName(newCustomer.getName());
			employee.setAge(newCustomer.getAge());
			employee.setEmail(newCustomer.getEmail());
			return repository.save(employee);
		}).orElseGet(() -> {
			newCustomer.setId(id);
			return repository.save(newCustomer);
		});

		Resource<Customer> resource = assembler.toResource(updatedEmployee);

		try {
			Thread.sleep(5000);
			
		} catch (InterruptedException e) {

		}

		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

	/**
	 * Deleted the customer from the system.client will pass the ID for the customer
	 * and this end point will remove customer from the system if found.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	/**
	 * Get the customer detail based on the id passed by the client API.
	 * 
	 * @param id
	 * @return customer detail
	 */
	@GetMapping(path = "/{id}")
	public Resource<Customer> one(@PathVariable Long id) {

		Customer entity = repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
		return assembler.toResource(entity);
	}
}
