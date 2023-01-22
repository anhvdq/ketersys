package dev.keter.service;

import dev.keter.model.MyModel;
import dev.keter.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    private MyRepository repository;

    @Override
    public Flux<MyModel> findAllMyModel() {
        return repository.findAllMyModel();
    }

    @Override
    public Mono<MyModel> findMyModelById(String id) {
        return repository.findMyModelById(id);
    }
}
