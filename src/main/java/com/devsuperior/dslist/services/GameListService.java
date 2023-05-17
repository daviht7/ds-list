package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.repositories.GameListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

}
