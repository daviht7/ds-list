package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.dtos.GameMinDTO;
import com.devsuperior.dslist.dtos.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDTO>> findAll() {
        return ResponseEntity.ok(gameListService.findAll());
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDTO>> findByList(@PathVariable("listId") Long listId) {
        return ResponseEntity.ok(gameService.findByList(listId));
    }

    @PostMapping("/{listId}/replacement")
    public ResponseEntity<?> move(@PathVariable("listId") Long listId, @RequestBody ReplacementDTO replacementDTO) {
        gameListService.move(listId, replacementDTO.getSourceIndex(), replacementDTO.getSourceIndex());
        return ResponseEntity.ok().build();
    }


}
