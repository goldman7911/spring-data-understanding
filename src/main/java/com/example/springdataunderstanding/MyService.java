package com.example.springdataunderstanding;

import org.neo4j.driver.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

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

    public Collection<MyDTO> getResyncIdandMessageIdsCount() throws NoSuchElementException {
        Collection<MyDTO> result = neo4jClient.query("match (r:RootMarker) UNWIND r.messageIds as rx return r.resyncId as resyncId, count(rx) as counter")
                .fetchAs(MyDTO.class)
                .mappedBy((typeSystem, record) -> {
                    String resyncId = record.get("resyncId").asString();
                    Long counter = record.get("counter").asLong();
                    return new MyDTO(resyncId, counter);
                }).all();
        return result;
    }

    public void countRootMarker(){
        System.out.println(myRepo.countRootMarker());
    }

    public void getResyncIdAndMessageIdsCountPureSDN(){
        Collection<MyDTO> myDTO = myRepo.getResyncIdAndMessageIdsCountPureSDN();
        for (MyDTO my : myDTO) {
            System.out.println(my.toString());
        }
    }

    public void getResyncIdAndMessageIdsCountPureSDNProjections(){
        Collection<MyProjectionDTO> myDTO = myRepo.getResyncIdAndMessageIdsCountPureSDNProjections();
        for (MyProjectionDTO my : myDTO) {
            System.out.println(my.toString());
        }
    }

}
