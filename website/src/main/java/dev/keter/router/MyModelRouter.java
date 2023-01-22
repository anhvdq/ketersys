package dev.keter.router;

import dev.keter.api.MyHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class MyModelRouter {
    @Bean
    public RouterFunction<ServerResponse> route(MyHandler handler) {
        return RouterFunctions
                .nest(path("/api/models").and(accept(MediaType.APPLICATION_JSON)),
                        RouterFunctions.route(GET(""), handler::getListModels)
                                .andRoute(GET("/{id}"), handler::getModelInfo));
    }
}
