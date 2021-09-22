package com.demo.overcook.menu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "menu")
@RedisHash("Menu")
public class MenuModel implements Serializable {

    @NonNull
    @NotEmpty
    private String id;

    @NonNull
    @NotEmpty
    private List<PlatoModel> platos;

    private static final long serialVersionUID = 1285454306356845812L;
}
