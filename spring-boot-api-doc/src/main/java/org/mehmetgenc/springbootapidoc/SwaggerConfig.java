package org.mehmetgenc.springbootapidoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    public SwaggerConfig() {
        System.out.println("SwaggerConfig initialized");
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.mehmetgenc.springbootapidoc.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiEndPointsInfo())
                .useDefaultResponseMessages(false)
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }
    private ApiInfo apiEndPointsInfo(){
        System.out.println("ApiInfo initialized");
        return new ApiInfoBuilder()
                .title("Spring Boot Swagger Example")
                .description("Pet Api Documentation")
                .contact(new Contact("Mehmet Genc", ".com", "mehmetgencv@gmail.com"))
                .license("Apache 2.0")
                .licenseUrl(".com")
                .version("1.0.0")
                .build();
    }
}
