/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.model;
import com.mitzuke.domain.valueobjects.*;

/**
 *
 * @author Mitzuke
 */
public class Turista {
    private final CodigoTuristaId codigo;
    private String nombre;
    private String apellido;
    private Direccion direccion;
    private Telefono telefono;
    private CodigoSucursalId sucursalAsociada;

    public Turista(CodigoTuristaId codigo, String nombre, String apellido, Direccion direccion, Telefono telefono, CodigoSucursalId sucursalAsociada) {
        
        if (nombre == null || nombre.isBlank() || apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El nombre y el apellido del Turista son obligatorios");
        }
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sucursalAsociada = sucursalAsociada;
    }

    
    //GETTERS
    public CodigoTuristaId getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    //SETTERS
    
    public CodigoSucursalId getSucursalAsociada() {
        return sucursalAsociada;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public void setSucursalAsociada(CodigoSucursalId sucursalAsociada) {
        this.sucursalAsociada = sucursalAsociada;
    }
    
    //METODOS
    
    public void cambiarDireccion(Direccion nuevaDireccion) {
        this.direccion = nuevaDireccion;
    }
    
    public boolean perteneceASucursal(CodigoSucursalId codigoSucursal) {
        return this.sucursalAsociada.equals(codigoSucursal);
    }
}
