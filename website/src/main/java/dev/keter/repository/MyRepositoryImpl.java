package dev.keter.repository;

import dev.keter.model.MyModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
public class MyRepositoryImpl implements MyRepository {

    private static final List<MyModel> MY_MODELS = Arrays.asList(new MyModel("1", "test1"), new MyModel("2", "test2"));

    @Override
    public Flux<MyModel> findAllMyModel() {
        return Flux.fromIterable(MY_MODELS);
    }

    @Override
    public Mono<MyModel> findMyModelById(String id) {
        return Mono.justOrEmpty(MY_MODELS.stream().filter(product -> product.getId().equals(id))
                .findFirst());
    }
}
