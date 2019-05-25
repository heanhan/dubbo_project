/**
 * 
 */
package com.dubbo.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.Data;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Thunisoft
 *
 */
//@Configuration 
//@EnableSwagger2 
//@EnableWebMvc 
//@ConfigurationProperties(prefix="swagger")
////必须存在 扫描的API Controller包
//@ComponentScan(basePackages = { "com.zjh.consumer.controller" })
//@Data//添加lombok
public class SwaggerConfig {
	@Value(value = "${swagger.title}")
	private String title;//swagger 标题
	@Value(value="${swagger.description}")
	private String description;//描述
	@Value(value="${swagger.name}")
	private String name;//作者
	@Value(value="${swagger.url}")
	private String url;//地址
	@Value(value="${swagger.email}")
	private String email;//邮箱
	@Value(value="${swagger.version}")
	private String version;
	@Bean
	public Docket customDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		Contact contact = new Contact(name, url, email);
		return new ApiInfoBuilder()
				.title(title)
				.description(description)
				.contact(contact)
				.version(version)
				.build();
	}

}
