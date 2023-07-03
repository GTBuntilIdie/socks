package com.example.socks.controller;

import com.example.socks.model.Socks;
import com.example.socks.service.SocksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/socks")
public class SocksController {
    private SocksService socksService;
    @GetMapping
    public ResponseEntity<Integer> getSocks(
            @RequestParam String color,
            @RequestParam String operation,
            @RequestParam Integer cottonPart ) {
        return ResponseEntity.ok(socksService.getSocks(
                color,
                operation,
                cottonPart ));
    }

    @PostMapping
    @RequestMapping("/income")
    public ResponseEntity<Socks> incomeSocks(
            @RequestBody Socks socks ) {
        return ResponseEntity.ok(socksService.incomeSocks(socks));
    }

    @PostMapping
    @RequestMapping("/outcome")
    public ResponseEntity<Socks> outcomeSocks(
            @RequestBody Socks socks ) {
        return ResponseEntity.ok(socksService.outcomeSocks(socks));
    }
}
