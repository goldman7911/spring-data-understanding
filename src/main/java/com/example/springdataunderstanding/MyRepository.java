package com.example.springdataunderstanding;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface MyRepository extends Neo4jRepository<RootMarker, Long> {

    @Query("MATCH (n:RootMarker) RETURN n ORDER BY n.domainId")
    List<RootMarker> getRootMarker();

    @Query("MATCH (n:RootMarker) RETURN count(n)")
    Long countRootMarker();

    //THAT'S NOT WORKING
    @Query("match (r:RootMarker) UNWIND r.messageIds as rx return r.resyncId as resyncId, count(rx) as counter")
    List<MyDTO> getResyncIdAndMessageIdsCountPureSDN();

}
