package com.example.springdataunderstanding;

import lombok.Value;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node
@Value
public class RootMarker {
    @Id Long id;
    long lastModifiedDate;
    boolean p5Latest;
    List<String> messageIds;
    String messageId;
    String deviceId;
    String domainId;
    int resourcesBPI;
    long createdDate;
    long drniId;
    boolean isFull;
    String resyncId;
    String status;
    List<Integer> latest;
}
