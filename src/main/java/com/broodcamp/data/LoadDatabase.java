package com.broodcamp.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.broodcamp.data.entity.Customer;
import com.broodcamp.data.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Edward P. Legaspi
 */
@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(final CustomerRepository customerRepository) {
		return args -> {
			log.debug("Preloading 6 customers");
			customerRepository.save(new Customer("Kira Yamato", 16, "kira@gundam.com"));
			customerRepository.save(new Customer("Aerith Gainsborough", 16, "aerith@ffvii.com"));
			customerRepository.save(new Customer("Tifa Lockheart", 16, "tifa@ffvii.com"));
			customerRepository.save(new Customer("Garnet Til Alexandros", 16, "tifa@ffix.com"));
			customerRepository.save(new Customer("Terra Branford", 16, "terra@ffvi.com"));
		};
	}

}
