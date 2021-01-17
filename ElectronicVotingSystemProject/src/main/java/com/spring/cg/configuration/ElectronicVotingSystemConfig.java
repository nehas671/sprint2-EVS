package com.spring.cg.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ElectronicVotingSystemConfig {
	@Bean 
	public Docket evsModule() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.spring.cg"))
				.paths(PathSelectors.regex("/evs.*"))
				.build()
				.apiInfo(getApiInfo());
	}
	private ApiInfo getApiInfo() {
		ApiInfo apiInfo = new ApiInfo("Electronic Voting System API Documentation", 
				"This is electronic voting management system info", 
				"1.0", 
				"public terms of services",
				new Contact("EVS Teams", "http://evsteam.com", "evsteam@gmail.com"),
				"GPL",
				"http://gpl.info"
				);
		return apiInfo;
	}
}
