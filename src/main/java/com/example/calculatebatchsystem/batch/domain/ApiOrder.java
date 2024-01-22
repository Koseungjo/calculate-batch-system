package com.example.calculatebatchsystem.batch.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiOrder {

    public String id;
    public Long customerId;
    private String url;
    private State state;
    private String createAt;

    public ApiOrder(String id, Long customerId, String url, State state, String createAt) {
        this.id = id;
        this.customerId = customerId;
        this.url = url;
        this.state = state;
        this.createAt = createAt;
    }

    public enum State {
        SUCCESS, FAIL
    }
}
