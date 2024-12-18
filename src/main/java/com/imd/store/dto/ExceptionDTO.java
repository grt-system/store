package com.imd.store.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ExceptionDTO {

    private String menssage;
    private int statusCode;

    public ExceptionDTO(HttpStatus httpStatus, String message) {
    }

    public String getMensage() {
        return menssage;
    }

    public void setMensage(String mensage) {
        this.menssage = mensage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
