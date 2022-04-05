package com.example.vehicleMngt.Service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoVehicleFoundException extends RuntimeException {
    private static final String ERROR_MESSAGE = "Invalid Input ";

    public NoVehicleFoundException() {
        super(ERROR_MESSAGE);
    }
}
