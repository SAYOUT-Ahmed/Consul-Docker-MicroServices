package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientApplication {

    /*@GetMapping("/accessAPI")
    public String invokeHelloWorld(){
        URI Service = discoveryClient.getInstances("SERVER").stream().map(serviceInstance -> serviceInstance.getUri()).findFirst()
                .map((s-> s.resolve("/hello"))).get();
        return template().getForObject("", String.class);
    }*/

   /* @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;*/

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    CommandLineRunner initializeH2Database(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client(Long.parseLong("1"), "Amine SAFI", Float.parseFloat("23")));
            clientRepository.save(new Client(Long.parseLong("2"), "Amal ALAOUI", Float.parseFloat("22")));
            clientRepository.save(new Client(Long.parseLong("3"), "Samir RAMI", Float.parseFloat("22")));
        };
    }

    /*@Bean
    public RestTemplate template(){
        return new RestTemplate();
    }*/
}
