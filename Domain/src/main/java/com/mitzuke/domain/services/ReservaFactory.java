/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.services;

import com.mitzuke.domain.model.*;
import com.mitzuke.domain.enums.*;
import com.mitzuke.domain.exceptions.ReservaInvalidaException;
import com.mitzuke.domain.valueobjects.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 *
 * @author Mitzuke
 */
public class ReservaFactory {
    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);
    
    
    public ReservaVuelo crearReservaVuelo(CodigoTuristaId turistaId,
            NumeroVueloId vueloId, ClaseAsiento claseAsiento,
            FechaViaje fechaVuelo, int numeroAsientos) {
                if (fechaVuelo.valor().isBefore(java.time.LocalDateTime.now().plusHours(24))) {
                    throw new ReservaInvalidaException("Los vuelos deben reservarse con al menos 24 horas de antelacion");
                }
                
                Long nuevoId = ID_GENERATOR.incrementAndGet();
                
                return new ReservaVuelo(nuevoId, turistaId, vueloId, claseAsiento, fechaVuelo, numeroAsientos);
            }
    
    public ReservaHospedaje crearReservaHospedaje(CodigoTuristaId turistaId, CodigoHotelId hotelId,
            RegimenHospedaje regimen, FechaViaje fechaLlegada, FechaViaje fechaSalida, int numeroPlazas) {
        Long diasEstancia = java.time.temporal.ChronoUnit.DAYS.between(fechaLlegada.valor(), fechaSalida.valor());
        if (regimen == RegimenHospedaje.PENSION_COMPLETA && diasEstancia < 5) {
            throw new ReservaInvalidaException("Pension Completa requiere una estancia minima de 5 dias");
        }
        Long nuevoId = ID_GENERATOR.incrementAndGet();
        
        return new ReservaHospedaje(nuevoId, turistaId, hotelId, regimen, fechaLlegada, fechaSalida, numeroPlazas);
    }
}
