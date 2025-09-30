package org.jcr.entidades;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
@Getter
@ToString(callSuper = true, exclude = {"citas", "historiaClinica"})
@SuperBuilder
public class Paciente extends Persona implements Serializable {
    private final HistoriaClinica historiaClinica;
    private final String telefono;
    private final String direccion;
    private Hospital hospital;
    private final List<Cita> citas = new ArrayList<>();


    protected Paciente(PacienteBuilder<?, ?> builder) {
        super(builder);
        this.telefono = validarString(builder.telefono, "El teléfono no puede ser nulo ni vacío");
        this.direccion = validarString(builder.direccion, "La dirección no puede ser nula ni vacía");
        this.historiaClinica = HistoriaClinica.builder()
                .paciente(this)
                .build();
    }

    public void setHospital(Hospital hospital) {
        if (this.hospital != hospital) {
            if (this.hospital != null) {
                this.hospital.getInternalPacientes().remove(this);
            }
            this.hospital = hospital;
        }
    }

    public void addCita(Cita cita) {
        this.citas.add(cita);
    }

    public List<Cita> getCitas() {
        return Collections.unmodifiableList(new ArrayList<>(citas));
    }

    private String validarString(String valor, String mensajeError) {
        Objects.requireNonNull(valor, mensajeError);
        if (valor.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
        return valor;
    }

}
