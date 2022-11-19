package com.example.springdataunderstanding;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.core.Neo4jClient;

@org.springframework.context.annotation.Configuration
public class Configuration {

    /*
    @Bean
    public Neo4jClient neo4jClient(){
        Driver driver = GraphDatabase.driver("neo4j://localhost:7687", AuthTokens.basic("neo4j", "secret"));
        return Neo4jClient.create(driver);
    }*/

}
