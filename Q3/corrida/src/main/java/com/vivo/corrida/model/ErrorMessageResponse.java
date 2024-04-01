package com.vivo.corrida.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessageResponse {
    private int status;
    private Date timestamp;
    private String message;

    public ErrorMessageResponse(Date timestamp, int status, String message) {
        super();
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
    }
}
