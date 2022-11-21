package com.example.springdataunderstanding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MyService {

    MyRepository myRepo;
    Neo4jClient neo4jClient;

    @Autowired
    public MyService(MyRepository myRepository, Neo4jClient neo4jClient) {
        this.myRepo = myRepository;
        this.neo4jClient = neo4jClient;
    }

    public List<RootMarker> getRootMarker(){
        return myRepo.getRootMarker();
    }

    public void getRootMarkerByNeo4jClient() throws NoSuchElementException {
        //Optional<List> ls = neo4jClient.query("MATCH (n:RootMarker) RETURN collect(n)").fetchAs(List.class).first();
        //Optional<Map<String, String>> ls = neo4jClient.query("MATCH (n:RootMarker) RETURN n ORDER BY n.domainId").fetchAs(String.class).first();
        //Optional<Map<String, Object>> ls = neo4jClient.query("MATCH (n:RootMarker) RETURN n ORDER BY n.domainId").fetch().first();
        //Map<String, Object> test = ls.orElseThrow();
        //System.out.println();
    }

    public void count(){
        System.out.println(Long.toString(myRepo.count()));
    }

}
