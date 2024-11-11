package com.rancho_smart.ms_produccion_carne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProduccionCarneApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProduccionCarneApplication.class, args);
	}

}
