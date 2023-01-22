package dev.keter.config;

import dev.keter.util.ErrorInfo;
import dev.keter.util.Response;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

@Component
@Order(-2)
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {
    public GlobalExceptionHandler(ErrorAttributes errorAttributes, WebProperties.Resources resources, ApplicationContext applicationContext, ServerCodecConfigurer configurer) {
        super(errorAttributes, resources, applicationContext);
        this.setMessageWriters(configurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse);
    }

    private Mono<ServerResponse> formatErrorResponse(ServerRequest request) {
        Throwable e = getError(request);

        if (e instanceof IllegalArgumentException) {
            return ServerResponse.ok()
                    .body(Mono.just(Response.error(ErrorInfo.newError(ErrorInfo.ErrorType.MISSING_PARAMS_ERROR, e.getMessage()))),
                            Response.class);
        }
        return ServerResponse.ok()
                .body(Mono.just(Response.error(ErrorInfo.newError(ErrorInfo.ErrorType.UNHANDLED_ERROR,
                                "%s: %s".formatted(e.getClass().getSimpleName(), e.getMessage())))),
                        Response.class);
    }
}