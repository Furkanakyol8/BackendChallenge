package com.example.backendchallenge.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    private boolean status;
    private String message;
}
