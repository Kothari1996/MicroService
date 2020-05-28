package com.kothari.GamingService.Controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kothari.GamingService.Entity.GameDescription;

@Repository
public interface GameDescriptionRepository extends JpaRepository<GameDescription,Integer> {

}
