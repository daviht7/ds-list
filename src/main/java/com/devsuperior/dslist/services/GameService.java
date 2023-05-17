package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.dtos.GameMinDTO;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true) //não bloqueia banco de dados, somente consulta
    public GameDTO findById(Long id) {
        var game = gameRepository.findById(id).get();
        return new GameDTO(game);
    }

}
