package com.jackspot.game.controller;

import com.jackspot.game.service.JackspotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/jackpot")
public class JackpotController {

    @Autowired
    private JackspotService jackspotService;

    @GetMapping
    public ResponseEntity<?> runJackpot(@RequestParam(name="alavanca") int alavanca){
        try{
            return ResponseEntity.ok().body(jackspotService.runExecute(alavanca));
        }catch (Exception e){
            return ResponseEntity.status(400).body(Map.of("message",e.getMessage()));
        }
    }
}
