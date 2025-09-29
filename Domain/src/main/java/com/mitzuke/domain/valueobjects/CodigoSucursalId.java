/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mitzuke.domain.valueobjects;

/**
 *
 * @author Mitzuke
 */
public record CodigoSucursalId(String value) {
    public CodigoSucursalId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El Codigo de sucursal no puede estar vacio.");
        }
    }
}
