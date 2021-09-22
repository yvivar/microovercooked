package com.demo.overcook.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "pedido")
public class PedidoModel implements Serializable {

    @NonNull
    @NotEmpty
    private String id;

    @NonNull
    @NotEmpty
    private Menu menu;

    @NonNull
    @NotEmpty
    private LocalDate limiteTiempo;

    @NonNull
    @NotEmpty
    private Date fecha;

    @NonNull
    @NotEmpty
    private String estado;
}
