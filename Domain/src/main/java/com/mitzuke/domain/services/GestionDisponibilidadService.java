/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.services;

import com.mitzuke.domain.model.*;
import com.mitzuke.domain.enums.*;
import com.mitzuke.domain.exceptions.ReservaInvalidaException;

public class GestionDisponibilidadService {
    public boolean gestionarNuevaReservaVuelo(Vuelo vuelo, ClaseAsiento claseAsiento, int asientosAReservar) {
        try {
            vuelo.reservarAsiento(claseAsiento, asientosAReservar);
            return true;
        } catch (ReservaInvalidaException e) {
            System.err.println("Fallor al reservar vuelo: " + e.getMessage());
            return false;
        }
    }
    
     public boolean gestionarReservaCompleta(Vuelo vuelo, Hotel hotel, ClaseAsiento claseVuelo, int asientos, int plazasHotel) {
        try {
            hotel.reservarPlazas(plazasHotel);
            vuelo.reservarAsiento(claseVuelo, asientos);
            return true;
        } catch (ReservaInvalidaException e) {
            System.err.println("Fallo en la reserva completa: " + e.getMessage());
            return false;
        }
    }
}
