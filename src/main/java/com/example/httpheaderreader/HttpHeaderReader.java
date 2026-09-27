package com.example.httpheaderreader;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Setter
@Getter
@RequiredArgsConstructor
@RestController()
@RequestMapping("/api")
public class HttpHeaderReader {


    @GetMapping("/print")
    public String sayHi(@RequestHeader("print") String message) {
        return message;
    }

    @GetMapping("/host")
    public String currentShell() {
        return System.getenv("HOSTNAME");
    }
}
