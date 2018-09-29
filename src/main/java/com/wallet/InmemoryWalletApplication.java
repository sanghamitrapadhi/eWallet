package com.wallet;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages={"com.wallet"})
@EnableJpaRepositories
@EnableSwagger2
public class InmemoryWalletApplication implements CommandLineRunner {

	private Logger LOG= LoggerFactory.getLogger("InmemoryWalletApplication");
	public static void main(String[] args) {
		SpringApplication.run(InmemoryWalletApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.debug("InmemoryWalletApplication started....");
		
	}
}
