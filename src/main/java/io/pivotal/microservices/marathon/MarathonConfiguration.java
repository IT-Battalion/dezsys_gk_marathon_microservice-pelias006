package io.pivotal.microservices.marathon;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;
import java.util.logging.Logger;

@Configuration
@ComponentScan
@EntityScan("io.pivotal.microservices.marathon")
@EnableJpaRepositories("io.pivotal.microservices.marathon")
@PropertySource("classpath:db-config.properties")
public class MarathonConfiguration {
    protected Logger logger;


    public MarathonConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }

    @Bean
    public DataSource dataSource() {
        //TODO implementation missing
        return null;
    }
}
