package dev.keter.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
public class HomeController {
    @RequestMapping(value = {"", "index"})
    public Mono<String> home() {
        return Mono.just("index");
    }

    @RequestMapping("projects")
    public Mono<String> project() {
        return Mono.just("projects");
    }
}
