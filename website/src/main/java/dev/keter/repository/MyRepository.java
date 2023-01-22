package dev.keter.repository;

import dev.keter.model.MyModel;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MyRepository {
    Flux<MyModel> findAllMyModel();

    Mono<MyModel> findMyModelById(String id);
}
