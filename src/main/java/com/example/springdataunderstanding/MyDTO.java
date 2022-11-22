package com.example.springdataunderstanding;

import lombok.Value;

@Value
public class MyDTO {
    String resyncId;
    Long counter;

    @Override
    public String toString() {
        return "MyDTO{" +
                "resyncId='" + resyncId + '\'' +
                ", CountMessageIds=" + counter +
                '}';
    }
}
