package com.example.springdataunderstanding;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface MyRepository extends Neo4jRepository<RootMarker, Long> {

    @Query("MATCH (n:RootMarker) RETURN n ORDER BY n.domainId")
    List<RootMarker> getRootMarker();


}
