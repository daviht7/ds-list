package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.services.GameListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService gameListService;

    public GameListController(GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.ok(gameListService.findAll());
    }


}
