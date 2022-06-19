package com.ssafy.happyhouse.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("HappyHouse").select()
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.happyhouse.controller")).paths(regex("/happyhouse/.*")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SSAFY HappyHouse REST API").description(
				"Swagger를 이용한 HappyHouse API<br>\"")// <img src=\"/ssafy.png\">
				.contact(new Contact("SSAFY Gwangju04 Park S.H. & Jung H. J", "https://edu.ssafy.com", "ssafy@ssafy.com")).license("SSAFY License")
				.licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp").version("1.0").build();
	}
	
}
