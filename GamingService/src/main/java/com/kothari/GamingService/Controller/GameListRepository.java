package com.kothari.GamingService.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kothari.GamingService.Entity.GameList;

@Repository
public interface GameListRepository extends JpaRepository<GameList,Integer> {

}
