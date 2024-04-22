package com.api.apirestuser.controller;

import io.jsonwebtoken.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.io.InputStream;

@RestController
public class OpenApiController {

    @GetMapping(value = "/openapi.yaml", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public StreamingResponseBody getOpenApiYaml() throws IOException, java.io.IOException {
        Resource resource = new ClassPathResource("openapi.yaml");
        InputStream inputStream = resource.getInputStream();
        return outputStream -> {
            int nRead;
            byte[] data = new byte[1024];
            while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                outputStream.write(data, 0, nRead);
            }
            inputStream.close();
        };
    }

}
