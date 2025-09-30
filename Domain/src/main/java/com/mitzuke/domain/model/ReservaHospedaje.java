/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.model;

import com.mitzuke.domain.valueobjects.*;
import com.mitzuke.domain.enums.RegimenHospedaje;
import com.mitzuke.domain.exceptions.ReservaInvalidaException;
/**
 *
 * @author Mitzuke
 */
public class ReservaHospedaje {
    private final Long reservaId;
    private final CodigoTuristaId turistaId; 
    private final CodigoHotelId hotelId; 
    private final RegimenHospedaje regimen;
    private FechaViaje fechaLlegada;
    private FechaViaje fechaSalida;
    private int numeroPlazas;

    public ReservaHospedaje(Long reservaId, CodigoTuristaId turistaId, CodigoHotelId hotelId, RegimenHospedaje regimen, FechaViaje fechaLlegada, 
                            FechaViaje fechaSalida, int numeroPlazas) {
        
        if (!fechaLlegada.valor().isBefore(fechaSalida.valor())) {
            throw new ReservaInvalidaException("La fecha de llegada debe ser anterior a la fecha de salida.");
        }
        
        if (numeroPlazas <= 0) {
            throw new ReservaInvalidaException("Debe reservar al menos una plaza.");
        }
        
        this.reservaId = reservaId;
        this.turistaId = turistaId;
        this.hotelId = hotelId;
        this.regimen = regimen;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.numeroPlazas = numeroPlazas;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public CodigoTuristaId getTuristaId() {
        return turistaId;
    }

    public CodigoHotelId getHotelId() {
        return hotelId;
    }

    public RegimenHospedaje getRegimen() {
        return regimen;
    }

    public FechaViaje getFechaLlegada() {
        return fechaLlegada;
    }

    public FechaViaje getFechaSalida() {
        return fechaSalida;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setFechaLlegada(FechaViaje fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public void setFechaSalida(FechaViaje fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }
    
    public void modificarFechas(FechaViaje nuevaLlegada, FechaViaje nuevaSalida) {
        if (!nuevaLlegada.valor().isBefore(nuevaSalida.valor())) {
            throw new ReservaInvalidaException("Las nuevas fechas son inválidas.");
        }
        this.fechaLlegada = nuevaLlegada;
        this.fechaSalida = nuevaSalida;
    }
    
}
