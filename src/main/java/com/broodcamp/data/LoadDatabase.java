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
			customerRepository.save(new Customer("Kira Yamato", 21, "kira@gundam.com"));
			customerRepository.save(new Customer("Aerith Gainsborough", 21, "aerith@ffvii.com"));
			customerRepository.save(new Customer("Tifa Lockheart", 21, "tifa@ffvii.com"));
			customerRepository.save(new Customer("Garnet Til Alexandros", 21, "tifa@ffix.com"));
			customerRepository.save(new Customer("Terra Branford", 21, "terra@ffvi.com"));
		};
	}

}
