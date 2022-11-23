package com.example.springdataunderstanding;

import org.springframework.beans.factory.annotation.Value;

public interface MyProjectionDTO {

    String getResyncId();
    Long getCounter();
}
