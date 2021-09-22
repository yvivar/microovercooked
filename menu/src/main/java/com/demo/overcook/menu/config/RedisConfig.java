package com.demo.overcook.menu.config;

import com.demo.overcook.menu.model.PedidoModel;
import com.demo.overcook.menu.repository.PedidoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.ReactiveRedisMessageListenerContainer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.UUID;

public class RedisConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

    @Bean
    public ReactiveRedisConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory("localhost", 6379);
    }

    /*@Bean
    public ReactiveRedisMessageListenerContainer redisMessageListenerContainer(PedidoRepository pedidos, ReactiveRedisConnectionFactory connectionFactory) {
        ReactiveRedisMessageListenerContainer container = new ReactiveRedisMessageListenerContainer(connectionFactory);
        ObjectMapper objectMapper = new ObjectMapper();
        container.receive(ChannelTopic.of("pedido"))
                .map(p->p.getMessage())
                .map(m -> {
                    try {
                        PedidoModel pedido = objectMapper.readValue(m, PedidoModel.class);
                        pedido.setId(UUID.randomUUID().toString());
                        return pedido;
                    } catch (IOException e) {
                        return null;
                    }
                })
                .switchIfEmpty(Mono.error(new IllegalArgumentException()))
                .flatMap(p-> pedidos.save(p))
                .subscribe(c-> LOGGER.info(" count:" + c), null , () -> LOGGER.info("saving pedido."));
        return container;
    }*/

    @Configuration
    public class CoffeeConfiguration {
        @Bean
        ReactiveRedisOperations<String, PedidoModel> redisOperations(ReactiveRedisConnectionFactory factory) {
            Jackson2JsonRedisSerializer<PedidoModel> serializer = new Jackson2JsonRedisSerializer<>(PedidoModel.class);
            RedisSerializationContext.RedisSerializationContextBuilder<String, PedidoModel> builder =
                    RedisSerializationContext.newSerializationContext(new StringRedisSerializer());
            RedisSerializationContext<String, PedidoModel> context = builder.value(serializer).build();
            return new ReactiveRedisTemplate<>(factory, context);
        }

    }

}
