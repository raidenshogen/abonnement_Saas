package org.ang.projet_abonnement_saas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProjetAbonnementSaasApplication {

    public static void main(String[] args) {


        SpringApplication.run(ProjetAbonnementSaasApplication.class, args);
    }

}
