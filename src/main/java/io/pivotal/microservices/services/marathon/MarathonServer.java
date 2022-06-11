package io.pivotal.microservices.services.marathon;

import io.pivotal.microservices.services.accounts.AccountsServer;
import io.pivotal.microservices.services.registration.RegistrationServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MarathonServer {
    public static void main(String[] args) {
        if (System.getProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME) == null)
            System.setProperty(RegistrationServer.REGISTRATION_SERVER_HOSTNAME, "localhost");

        System.setProperty("spring.config.name", "marathon-server");

        SpringApplication.run(AccountsServer.class, args);
    }
}
