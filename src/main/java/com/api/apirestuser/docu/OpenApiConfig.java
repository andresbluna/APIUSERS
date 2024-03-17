package com.api.apirestuser.docu;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Alibou",
                        email = "hola@hola.com",
                        url = "http://www.google.com"
                ),
                description = "OpenApi documentation for Spring Security",
                title = "Open Api especification - ApiRest Users",
                version = "1.0",
                license = @License(
                        name = "License name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"

                ),
                servers = {
                    @Server(
                         description = "Local Env",
                         url = "http://localhost:8080"
                    ),
                        @Server(
                                description = "PROD ENV",
                                url = "http://localhost:8080"
                        )
                }
)

public class OpenApiConfig {


}
