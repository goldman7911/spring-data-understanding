package com.example.springdataunderstanding;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.summary.ResultSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.core.Neo4jClient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class SpringDataUnderstandingApplicationTests {

    private final MyService ms;

    @Autowired
    public SpringDataUnderstandingApplicationTests(MyService ms, Neo4jClient nc) {
        this.ms = ms;
    }

    @BeforeAll
    static void initializeNeo4j(@Autowired Neo4jClient nc) throws IOException {
        String CQL = Files.readString(Paths.get("src/test/java/resources/MERGE.cql"));
        int nodesCreated = nc.query(CQL).run().counters().nodesCreated();
        assertEquals(3,nodesCreated);
    }

    @AfterAll
    static void stopNeo4j(@Autowired Neo4jClient nc) {
        nc.query("match (r:RootMarker) detach delete r").run();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void getRootMarker() {
        ms.getRootMarker().forEach(System.out::println);
    }

    @Test
    void getResyncIdAndMessageIdsCount() {
        ms.getResyncIdandMessageIdsCount().forEach(System.out::println);
    }

    @Test
    void getCountPureSDN(){
        ms.countRootMarker();
    }

    @Test
    void getResyncIdAndMessageIdsCountPureSDN(){
        ms.getResyncIdAndMessageIdsCountPureSDN();
    }

    @Test
    void getResyncIdAndMessageIdsCountPureSDNProjections(){
        ms.getResyncIdAndMessageIdsCountPureSDNProjections();
    }

}
