/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.model;

import com.mitzuke.domain.valueobjects.*;
import com.mitzuke.domain.enums.ClaseAsiento;
import com.mitzuke.domain.exceptions.ReservaInvalidaException;
/**
 *
 * @author Mitzuke
 */
public class ReservaVuelo {
    private final Long reservaId; 
    private final CodigoTuristaId turistaId; 
    private final NumeroVueloId vueloId;
    private ClaseAsiento claseAsiento;
    private FechaViaje fechaVuelo;
    private int numeroAsientos;

    public ReservaVuelo(Long reservaId, CodigoTuristaId turistaId, NumeroVueloId vueloId, ClaseAsiento claseAsiento, FechaViaje fechaVuelo, int numeroAsientos) {
        
        if (numeroAsientos <= 0) {
            throw new ReservaInvalidaException("Debe reservar al menos un asiento.");
        }
        
        if (claseAsiento == ClaseAsiento.PRIMERA_CLASE && numeroAsientos > 2) {
             throw new ReservaInvalidaException("Solo se permite reservar un máximo de 2 asientos en Primera Clase por reserva.");
        }
        
        this.reservaId = reservaId;
        this.turistaId = turistaId;
        this.vueloId = vueloId;
        this.claseAsiento = claseAsiento;
        this.fechaVuelo = fechaVuelo;
        this.numeroAsientos = numeroAsientos;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public CodigoTuristaId getTuristaId() {
        return turistaId;
    }

    public NumeroVueloId getVueloId() {
        return vueloId;
    }

    public ClaseAsiento getClaseAsiento() {
        return claseAsiento;
    }

    public FechaViaje getFechaVuelo() {
        return fechaVuelo;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setClaseAsiento(ClaseAsiento claseAsiento) {
        this.claseAsiento = claseAsiento;
    }

    public void setFechaVuelo(FechaViaje fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }
    
    public void cambiarClase(ClaseAsiento nuevaClase) {
        if (nuevaClase == ClaseAsiento.PRIMERA_CLASE && this.numeroAsientos > 2) {
             throw new ReservaInvalidaException("No puede cambiarse a Primera Clase con " + this.numeroAsientos + " asientos.");
        }
        this.claseAsiento = nuevaClase;
    }
    
}
