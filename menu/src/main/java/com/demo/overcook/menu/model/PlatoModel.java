package com.demo.overcook.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "plato")
public class PlatoModel implements Serializable {

    @NonNull
    @NotEmpty
    private String id;

    @NonNull
    @NotEmpty
    private String nombrePlato;

    @NonNull
    @NotEmpty
    private String descripcionPlato;

    @NonNull
    @NotEmpty
    private List<String> ingredientes;

    @NonNull
    @NotEmpty
    private String tiempoCocinado;

    private static final long serialVersionUID = 1285454306356845811L;
}
