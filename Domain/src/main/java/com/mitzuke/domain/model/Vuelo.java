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
        
        
        if (plazasDisponiblesTurista.cantidad() > plazasTotales.cantidad()) {
        throw new ReservaInvalidaException("Las plazas de turista no pueden exceder las plazas totales del vuelo.");
        }
        
        this.numeroVuelo = numeroVuelo;
        this.fechaHora = fechaHora;
        this.origen = origen;
        this.destino = destino;
        this.plazasTotales = plazasTotales;
        this.plazasDisponiblesTurista = plazasDisponiblesTurista;       
    }

    //GETTERS
    public NumeroVueloId getNumeroVuelo() {
        return numeroVuelo;
    }

    public FechaViaje getFechaHora() {
        return fechaHora;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Plazas getPlazasTotales() {
        return plazasTotales;
    }

    public Plazas getPlazasDisponiblesTurista() {
        return plazasDisponiblesTurista;
    }
    
    //SETTERS
    public void setPlazasTotales(Plazas plazasTotales) {
        this.plazasTotales = plazasTotales;
    }

    public void setPlazasDisponiblesTurista(Plazas plazasDisponiblesTurista) {
        this.plazasDisponiblesTurista = plazasDisponiblesTurista;
    }
    
    //METODOS
    public void reservarAsiento(ClaseAsiento clase, int cantidad) {
        
        if (clase == ClaseAsiento.TURISTA) {
            // Utilizamos el método inmutable del VO 'Plazas' que ya incluye la validación de no-negativos.
            Plazas nuevasPlazas = plazasDisponiblesTurista.decrementar(cantidad); 
            this.plazasDisponiblesTurista = nuevasPlazas;
            
        } else if (clase == ClaseAsiento.PRIMERA_CLASE) {
            // Lógica similar, pero usando un VO para Plazas de Primera Clase (a crear).
            // Por simplicidad, asumimos que se decrementan las plazas totales.
            Plazas nuevasPlazasTotales = plazasTotales.decrementar(cantidad);
            this.plazasTotales = nuevasPlazasTotales;
            
        } else {
            throw new IllegalArgumentException("Clase de asiento no válida.");
        }
    }
}
