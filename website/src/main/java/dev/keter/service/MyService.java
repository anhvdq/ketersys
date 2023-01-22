package dev.keter.service;

import dev.keter.model.MyModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface MyService {
    Flux<MyModel> findAllMyModel();

    Mono<MyModel> findMyModelById(String id);
}
