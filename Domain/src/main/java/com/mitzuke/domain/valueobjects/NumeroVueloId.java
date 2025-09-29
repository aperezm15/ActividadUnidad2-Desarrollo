/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.valueobjects;

/**
 *
 * @author Mitzuke
 */
public record NumeroVueloId(String value) {
    public NumeroVueloId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El Número de Vuelo no puede estar vacío.");
        }
    }
}
