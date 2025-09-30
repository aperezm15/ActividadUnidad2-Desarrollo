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
public class Sucursal {
    private final CodigoSucursalId codigo;
    private Direccion direccion;
    private Telefono telefono;

    public Sucursal(CodigoSucursalId codigo, Direccion direccion, Telefono telefono) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public CodigoSucursalId getCodigo() {
        return codigo;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }


    public void actualizarTelefono(Telefono nuevoTelefono) {
        this.telefono = nuevoTelefono;
    }
    
    
    
}
