/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.valueobjects;
import com.mitzuke.domain.exceptions.*;

/**
 *
 * @author Mitzuke
 */
public record Plazas(int cantidad) {
    public Plazas {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad de plazas no puede ser negativa.");
        }
    }

    // Método de dominio: devuelve un nuevo VO si la cantidad cambia.
    public Plazas decrementar(int aReservar) {
        if (this.cantidad - aReservar < 0) {
            throw new ReservaInvalidaException("No hay suficientes plazas disponibles.");
        }
        return new Plazas(this.cantidad - aReservar);
    }
}
