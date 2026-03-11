package com.naturagarden.exception;

public class PlantaNaoEncontradaException extends RuntimeException{
    public PlantaNaoEncontradaException(Long id){
        super("Planta não encontrada com id: " + id);
    }
}
