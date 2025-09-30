/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.model;

import com.mitzuke.domain.valueobjects.*;
import com.mitzuke.domain.exceptions.ReservaInvalidaException;

public class Hotel {
    private final CodigoHotelId codigo;
    private String nombre;
    private final Direccion direccion;
    private final String ciudad;
    private final Telefono telefono;
    private Plazas plazasTotales;
    private Plazas plazasDisponiblesActual;

    public Hotel(CodigoHotelId codigo, String nombre, Direccion direccion, String ciudad, Telefono telefono, Plazas plazasTotales, Plazas plazasDisponiblesActual) {
        
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del hotel es obligatorio");
        }
        
        if (ciudad == null || ciudad.isBlank()) {
            throw new IllegalArgumentException("La ciudad es obligatoria");
        }
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.plazasTotales = plazasTotales;
        this.plazasDisponiblesActual = plazasDisponiblesActual;
    }
    
    //GETTERS
    public CodigoHotelId getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public Plazas getPlazasTotales() {
        return plazasTotales;
    }

    public Plazas getPlazasDisponiblesActual() {
        return plazasDisponiblesActual;
    }
    
    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPlazasTotales(Plazas plazasTotales) {
        this.plazasTotales = plazasTotales;
    }

    public void setPlazasDisponiblesActual(Plazas plazasDisponiblesActual) {
        this.plazasDisponiblesActual = plazasDisponiblesActual;
    }
    
    //METODOS
    public void reservarPlazas(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a reservar debe ser positiva");
        }
        Plazas nuevasPlazasDisponibles = this.plazasDisponiblesActual.decrementar(cantidad);
        
        this.plazasDisponiblesActual = nuevasPlazasDisponibles;
    }
    
    public void liberarPlazas(int cantidad) {
        this.plazasDisponiblesActual = new Plazas(this.plazasDisponiblesActual.cantidad() + cantidad);
        
        if (this.plazasDisponiblesActual.cantidad() > this.plazasTotales.cantidad()) {
            this.plazasDisponiblesActual = this.plazasTotales;
        }
    }
    
    public int getPlazasDisponibles() {
        return this.plazasDisponiblesActual.cantidad();
    }
}
