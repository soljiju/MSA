package kr.co.chhak.controller;

import brave.Span;
import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class MainController {

    private final Tracer tracer;


    @GetMapping("/")
    public String index(){
        return "service1 index!!!";
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
