package com.learn.docker.firstrun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class FirstrunApplication implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public FirstrunApplication(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(FirstrunApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Boolean tableExists = this.jdbcTemplate.queryForObject("SELECT EXISTS ( SELECT FROM information_schema. tables WHERE table_name = ?)", new Object[] {"person"}, Boolean.class);
        log.info("return value: " + tableExists);
        if (!tableExists) {
            this.jdbcTemplate.execute("CREATE TABLE person(id VARCHAR(255), firstName VARCHAR(255), lastName VARCHAR(255))");
        }
    }
}
