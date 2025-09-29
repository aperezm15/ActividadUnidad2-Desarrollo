/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.model;

import com.mitzuke.domain.valueobjects.NumeroVueloId;
import com.mitzuke.domain.valueobjects.Plazas;
import com.mitzuke.domain.valueobjects.FechaViaje;
import com.mitzuke.domain.enums.ClaseAsiento;
import com.mitzuke.domain.exceptions.ReservaInvalidaException;


public class Vuelo {
    private final NumeroVueloId numeroVuelo;
    private final FechaViaje fechaHora;
    private final String origen;
    private final String destino;
    private Plazas plazasTotales;
    private Plazas plazasDisponiblesTurista;
    
    public Vuelo(NumeroVueloId numeroVuelo, FechaViaje fechaHora, String origen, String destino, 
                 Plazas plazasTotales, Plazas plazasDisponiblesTurista) {
    
            if (origen == null || origen.isBlank() || destino == null || destino.isBlank()) {
            throw new IllegalArgumentException("Origen y Destino son obligatorios.");
        }
        
            // Regla 2: Validar que las plazas totales sean mayores o iguales a las plazas disponibles para turista
            if (plazasDisponiblesTurista.cantidad() > plazasTotales.cantidad()) {
            throw new ReservaInvalidaException("Las plazas de turista no pueden exceder las plazas totales del vuelo.");
        }
    }
    
}
