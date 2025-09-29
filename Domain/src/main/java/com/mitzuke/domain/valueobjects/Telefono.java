/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.valueobjects;

/**
 *
 * @author Mitzuke
 */
public record Telefono(String value) {
    public Telefono {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El teléfono no puede estar vacío.");
        }
        // Se podría agregar validación de formato (e.g., regex) aquí.
    }
}
