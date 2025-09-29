/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.valueobjects;

/**
 *
 * @author Mitzuke
 */
public record Direccion(String calle, String ciudad) {
    public Direccion {
        if (calle == null || calle.isBlank()) {
            throw new IllegalArgumentException("La calle de la dirección no puede ser vacía.");
        }
        if (ciudad == null || ciudad.isBlank()) {
            // La ciudad también es crucial para el Hotel [cite: 147]
            throw new IllegalArgumentException("La ciudad de la dirección no puede ser vacía.");
        }
    }
}
