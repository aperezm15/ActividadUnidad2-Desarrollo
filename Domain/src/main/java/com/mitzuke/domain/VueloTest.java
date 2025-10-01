package com.mitzuke.domain; // Asumiendo un paquete de test, ajusta si es necesario

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*; // <<-- ¡CLAVE! Importación estática de AssertJ
import java.time.LocalDateTime;

// Importaciones de tu dominio (ajustadas según tu código)
import com.mitzuke.domain.model.Vuelo;
import com.mitzuke.domain.valueobjects.NumeroVueloId;
import com.mitzuke.domain.valueobjects.FechaViaje;
import com.mitzuke.domain.valueobjects.Plazas;
import com.mitzuke.domain.enums.ClaseAsiento;
import com.mitzuke.domain.exceptions.ReservaInvalidaException;

/**
 * Pruebas Unitarias para la Entidad Vuelo
 *
 * @author Mitzuke
 */
public class VueloTest {

    // 1. Declaración de variables de instancia
    private NumeroVueloId vueloId;
    private FechaViaje fechaFutura;

    // 2. Método de setup: se ejecuta antes de cada @Test
    @BeforeEach
    void setUp() {
        // Inicialización de datos base para todos los tests
        this.vueloId = new NumeroVueloId("VA100");
        // Asegura que la fecha esté en el futuro, según la regla del VO FechaViaje
        this.fechaFutura = new FechaViaje(LocalDateTime.now().plusDays(5));
    }

    // --- 1. Prueba Value Object (Fallo) ---
    @Test
    void debeFallarAlCrearNumeroVueloIdConValorNulo() {
        // La prueba del VO es independiente y se inicializa en el mismo aserto.
        assertThatThrownBy(() -> new NumeroVueloId(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("no puede estar vacío");
    }

    // --- 2. Prueba de Entidad (Éxito) ---
    @Test
    void debeReservarAsientoTuristaExitosamenteYDecrementarPlazas() {
        // Arrange (Configuración)
        Plazas totales = new Plazas(100);
        Plazas turista = new Plazas(80);
        // Usamos las variables inicializadas en setUp()
        Vuelo vuelo = new Vuelo(this.vueloId, this.fechaFutura, "BOG", "CTG", totales, turista);

        // Act (Acción)
        vuelo.reservarAsiento(ClaseAsiento.TURISTA, 2);

        // Assert (Verificación)
        // **NOTA:** Esta aserción asume que tu Entidad Vuelo tiene un método
        // público `getPlazasDisponiblesTurista()` que devuelve el valor INT (78).
        assertThat(vuelo.getPlazasDisponiblesTurista()).isEqualTo(78);
    }

    // --- 3. Prueba de Entidad (Fallo) ---
    @Test
    void debeLanzarExcepcionAlReservarMasPlazasDeLasDisponibles() {
        // Arrange (Configuración)
        Plazas totales = new Plazas(20);
        Plazas turista = new Plazas(1); // Solo 1 plaza disponible
        Vuelo vuelo = new Vuelo(this.vueloId, this.fechaFutura, "MDE", "SCL", totales, turista);

        // Act & Assert (Acción y Verificación)
        // Intentar reservar 2 asientos cuando solo hay 1.
        assertThatThrownBy(() -> vuelo.reservarAsiento(ClaseAsiento.TURISTA, 2))
            .isInstanceOf(ReservaInvalidaException.class) // La excepción personalizada
            .hasMessageContaining("No hay suficientes plazas disponibles."); // El mensaje de la regla de negocio
    }
}