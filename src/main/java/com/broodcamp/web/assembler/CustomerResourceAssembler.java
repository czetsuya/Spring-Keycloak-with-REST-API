package com.broodcamp.web.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.broodcamp.data.entity.Customer;
import com.broodcamp.web.application.CustomerController;

/**
 * @author Edward P. Legaspi
 */
@Component
public class CustomerResourceAssembler implements ResourceAssembler<Customer, Resource<Customer>> {

	@Override
	public Resource<Customer> toResource(Customer customer) {

		return new Resource<>(customer, linkTo(methodOn(CustomerController.class).one(customer.getId())).withSelfRel(),
				linkTo(methodOn(CustomerController.class).all()).withRel("/v1/customers"));
	}
}
