package com.dawntechbd.springJDBC;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class JdbcSimpleApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(JdbcSimpleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JdbcSimpleApplication.class, args);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void run(String... String) throws Exception {
        log.info("Creating tables");

        jdbcTemplate.execute("drop table customers if exists");
        jdbcTemplate.execute("create table customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        // Split up the array of whole names into an array of first/last names
        List<Object[]> splitUpNames = Arrays.asList("John Doe", "Jeff Dean", "John Bloch", "Jofra Archer")
                .stream()
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        // Use a Java 8 Stream to print out each tuple of the list
        splitUpNames.forEach(name -> log.info(java.lang.String.format("Inserting customer record for %s %s",
                name[0], name[1])));

        // Uses JdbcTemplate's batchUpdate operation to bulk load data
        jdbcTemplate.batchUpdate("INSERT into customers(first_name, last_name) values (?,?)",
                splitUpNames);

        log.info("Querying for customer records where first_name = 'John':");
        jdbcTemplate.query(
                "select id, first_name, last_name from customers where first_name = ?",
                new Object[]{"John"},
                (rs, rowNum) -> new Customer(rs.getLong("id"),
                        rs.getString("first_name"), rs.getString("last_name"))
        ).forEach(customer -> log.info(customer.toString()));
    }
}
