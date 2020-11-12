package com.api.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

/**
 * This is a the main class to run and start the application
 * 
 * @author ibrahimabdourahmane
 *
 */
@EntityScan(basePackages = { "com.api.springboot*" })
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class })

public class RunApplication {

	public static void main(String[] args) {

		SpringApplication.run(RunApplication.class, args);

	}

}
