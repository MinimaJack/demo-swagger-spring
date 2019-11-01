package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-10-31T05:31:33.705Z[GMT]")
@Configuration
public class SwaggerDocumentationConfig
{

    ApiInfo apiInfo()
    {
        return new ApiInfoBuilder().title( "Project for nexign" ).description( "This is an example api for nexign" )
            .license( "MIT" ).licenseUrl( "http://unlicense.org" ).termsOfServiceUrl( "" ).version( "1.0.0" )
            .contact( new Contact( "Minimajack", "https://github.com/MinimaJack", "minimajack@gmail.com" ) ).build();
    }

    @Bean
    public Docket customImplementation()
    {
        return new Docket( DocumentationType.SWAGGER_2 ).select()
            .apis( RequestHandlerSelectors.basePackage( "io.swagger.controllers" ) )
            .paths( Predicates.not( PathSelectors.regex( "/" ) ) ).build()

            .directModelSubstitute( org.threeten.bp.LocalDate.class, java.sql.Date.class )
            .directModelSubstitute( org.threeten.bp.OffsetDateTime.class, java.util.Date.class ).apiInfo( apiInfo() );
    }

}
