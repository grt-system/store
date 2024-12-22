package com.imd.store.service;

import com.imd.store.model.Failure;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FailureService {

    private final Failure failure;
    private boolean isError = false;
    private long errorStartTime = 0;

    public FailureService() {
        this.failure = new Failure("Error", 0.1, 5000);
    }

    /**
     * Simula a falha de tipo "Error" com base na probabilidade e duração.
     */
    public boolean simulateFailure() {

        if (isError && System.currentTimeMillis() - errorStartTime < failure.getDuration()) {
            return true;  /
        }

        Random random = new Random();
        if (!isError && random.nextDouble() < failure.getProbability()) {

            isError = true;
            errorStartTime = System.currentTimeMillis();
            return true;
        }

        return false;
    }

    /**
     * Reseta o estado da falha.
     */
    public void resetFailure() {
        isError = false;
    }
}

