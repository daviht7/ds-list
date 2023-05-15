package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameMinDTO;
import com.devsuperior.dslist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameMinDTO>> findAll() {
        return ResponseEntity.ok(gameService.findAll());
    }

}
