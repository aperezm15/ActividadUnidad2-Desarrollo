/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.valueobjects;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FechaViaje(LocalDateTime valor) { 
    public FechaViaje {
        if (valor == null) {
            throw new IllegalArgumentException("La fecha de viaje no puede ser nula.");
        }
        // Regla: No se pueden reservar viajes en el pasado (regla simple de ejemplo)
        if (valor.isBefore(LocalDateTime.now().minusDays(1))) {
            throw new IllegalArgumentException("La fecha de viaje debe ser futura o el día actual.");
        }
    }
}
