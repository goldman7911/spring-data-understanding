package com.example.springdataunderstanding;

import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Value
public class MyDTO {
    String resyncId;
    Long counter;

    @Override
    public String toString() {
        return "MyDTO{" +
                "resyncId='" + resyncId + '\'' +
                ", counter=" + counter +
                '}';
    }
}
