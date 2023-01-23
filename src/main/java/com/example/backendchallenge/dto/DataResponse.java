package com.example.backendchallenge.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataResponse<T> extends Response {

    private T data;

    @Builder(builderMethodName = "dataResponseBuilder")
    public DataResponse(Boolean status, String message, T data) {
        super(status, message);
        this.data = data;
    }
}
