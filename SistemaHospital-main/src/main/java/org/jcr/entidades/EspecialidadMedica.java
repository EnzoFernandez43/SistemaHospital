package org.jcr.entidades;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter

public enum EspecialidadMedica {
    CARDIOLOGIA("Cardiologia"),
    NEUROLOGIA("Neurologia"),
    PEDIATRIA("Pediatria"),
    TRAUMATOLOGIA("Traumatologia"),
    GINECOLOGIA("Ginecologia"),
    UROLOGIA("Urologia"),
    OFTALMOLOGIA("Oftalmologia"),
    DERMATOLOGIA("Dermatologia"),
    PSIQUIATRIA("Psiquiatria"),
    MEDICINA_GENERAL("Medicina General"),
    CIRUGIA_GENERAL("Cirugia General"),
    ANESTESIOLOGIA("Anestesiologia");

    private final String descripcion;
}
