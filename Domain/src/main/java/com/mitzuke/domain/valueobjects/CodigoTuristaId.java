/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.valueobjects;

/**
 *
 * @author Mitzuke
 */
public record CodigoTuristaId(String value) {
    public CodigoTuristaId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El Código de Turista no puede estar vacío.");
        }
    }  
}
