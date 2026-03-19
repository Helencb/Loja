package com.naturagarden.exception;

import java.util.UUID;

public class PlantaNaoEncontradaException extends RuntimeException{
    public PlantaNaoEncontradaException(UUID id){
        super("Planta não encontrada com id: " + id);
    }
}
