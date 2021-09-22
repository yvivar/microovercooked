package com.demo.overcook.menu.repository;

import com.demo.overcook.menu.model.PedidoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PedidoRepository {

    private final ReactiveRedisOperations<String, PedidoModel> reactiveRedisOperations;

}
