package com.imd.store.service;

import com.imd.store.model.Failure;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FailureService {

    private final Failure failure;  // Falha geral
    private boolean isError = false;
    private long errorStartTime = 0;

    // Falha específica para o endpoint product
    private final Failure productFailure;
    private boolean isProductError = false;

    public FailureService() {
        // Inicializa a falha geral com probabilidade 0.1% e duração de 5000ms (5 segundos)
        this.failure = new Failure("Error", 0.1, 5000);

        // Inicializa a falha específica para o product com probabilidade 0.2% e sem duração
        this.productFailure = new Failure("Omission", 0.2, 0);  // 0.2% de chance, sem duração
    }

    /**
     * Simula a falha de tipo "Error" com base na probabilidade e duração.
     */
    public boolean simulateFailure() {
        if (isError && System.currentTimeMillis() - errorStartTime < failure.getDuration()) {
            return true;
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
     * Simula a falha de omissão específica para o produto com base na probabilidade.
     */
    public boolean simulateProductFailure() {
        Random random = new Random();

        // Se a falha de omissão já foi ativada, retorna true (simula a omissão)
        if (isProductError) {
            return true;
        }

        // Caso contrário, ativa a falha de omissão com base na probabilidade
        if (random.nextDouble() < productFailure.getProbability()) {
            isProductError = true;
            return true;  // Falha de omissão simulada
        }

        return false;  // Sem falha
    }

    /**
     * Reseta o estado da falha de omissão do produto.
     */
    public void resetProductFailure() {
        isProductError = false;
    }

    /**
     * Reseta o estado da falha geral.
     */
    public void resetFailure() {
        isError = false;
    }
}
