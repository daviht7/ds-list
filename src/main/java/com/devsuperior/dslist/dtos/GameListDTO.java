package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.GameList;
import org.springframework.beans.BeanUtils;

public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO() {

    }

    public GameListDTO(GameList gameList) {
        BeanUtils.copyProperties(gameList, this);
    }

    public GameListDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
