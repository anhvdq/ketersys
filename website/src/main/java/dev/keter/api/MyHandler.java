package dev.keter.api;

import dev.keter.service.MyService;
import dev.keter.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class MyHandler {
    @Autowired
    private MyService productService;

    public Mono<ServerResponse> getListModels(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(productService.findAllMyModel()
                        .collectList()
                        .map(Response::success), Response.class);
    }

    public Mono<ServerResponse> getModelInfo(ServerRequest request) {
        String id = request.pathVariable("id");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(productService.findMyModelById(id)
                        .map(Response::success), Response.class);
    }
}
