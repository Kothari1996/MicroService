package com.kothari.gamesDetails.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kothari.gamesDetails.Entity.GameDescription;

@Repository
public interface GameDescriptionRepository extends JpaRepository<GameDescription,Integer> {

}
