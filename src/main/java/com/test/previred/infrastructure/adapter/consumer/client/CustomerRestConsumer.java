package com.test.previred.infrastructure.adapter.consumer.client;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerRestConsumer {


    private final String apiUrl = "http://127.0.0.1:8080/agcv2/Control";


    //http://servidor.agcinformatica.es:82/agcv2/Control?Usuario=PruebasE19&password=v2a1OEm387DDg%23s&Tabla=35&accion=UPDATE&valor={"0":"1","83":"10"}



    public ClientResponse sendDataToEndpoint(String usuario, String password, String tabla, String valor) throws MalformedURLException, URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        // Construir la URL con los parámetros
        String url = apiUrl + "?Usuario=" + usuario + "&password=" + password + "&Tabla=" + tabla + "&accion=UPDATE&valor={valor}";
        // Hacer una solicitud GET al endpoint y recibir una respuesta
         ClientResponse res = restTemplate.getForObject(url, ClientResponse.class,valor);
        ResponseEntity<String> test = restTemplate.getForEntity(url, String.class,valor);

        return res;
    }


    public List<ClientResponse> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        // Construir la URL con los parámetros
        String url = apiUrl + "?Usuario=Leo_desarrollo&password=111111&Tabla=35&accion=UPDATE&valor={valor}";
        // Hacer una solicitud GET al endpoint y recibir una respuesta
        ResponseEntity<ClientResponse[]> response = restTemplate.getForEntity(url, ClientResponse[].class);
        return List.of(response.getBody());
    }


}
