package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dtos.GameListDTO;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    private final GameRepository gameRepository;

    public GameListService(GameListRepository gameListRepository,GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    public List<GameListDTO> findAll() {
        return gameListRepository.findAll().stream().map(GameListDTO::new).toList();
    }

    public void move(Long listId, int sourceIndex, int destinationIndex) {

        var gamesList = gameRepository.searchByList(listId);

        var obj = gamesList.remove(sourceIndex);
        gamesList.add(destinationIndex,obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId,gamesList.get(i).getId(),i);
            
        }

    }

}
