package example.practical.assignment.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DSConfig {
    @Bean
    public DataSource dataSource(){
        return DataSourceBuilder
                .create()
                .username("sa")
                .password("")
                .url("jdbc:h2:mem:testdb")
                .driverClassName("org.h2.Driver")
                .build();
    }
}
