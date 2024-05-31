package com.manav.quizapp.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class Response {
    private Integer id;
    private String response;

    public Response() {
    }

    public Response(Integer id, String response) {
        this.id = id;
        this.response = response;
    }
}
