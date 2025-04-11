package kr.co.chhak.controller;

import brave.Span;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@
@RestController
public class MainController {

    @GetMapping("/")
    public String index(){
        return "service2 index!!!";
    }


    @GetMapping("/traceId")
    public String traceId(){

        log.info("traceId...");

        Span currentSpan = tracer.currentSpan().tag("traceId", "123");

        String traceId = currentSpan.context().traceIdString();
        String spanId = currentSpan.context().spanIdString();

        return "[traceId: " + traceId + ", spanId: " + spanId + "]";
    }

}
