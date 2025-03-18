package org.krkmz.postapp;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition( info = @Info(
        title = "Post App  - OpenAPI",
        version = "0.3.1",
        description = "API for Post App.\n" +
                "\n",
        contact = @Contact(
                name = "Contact",
                url = "www.krkmz.io",
                email = "developer@krkmz.io"
        )
),
        externalDocs = @ExternalDocumentation(
                description = "Post App Service Documentation",
                url = "www.krkmz.io"
        )
)
@SpringBootApplication
public class PostAppApplication {

    public static void main (String[] args) {
        SpringApplication.run(PostAppApplication.class, args);
    }

}
