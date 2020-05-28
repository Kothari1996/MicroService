package com.kothari.GamingService.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GameList {
	@Id
	@Column(name="game_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int GameID;
	@Column(name="game_name")
	private String GameName;
	
	/*
	@OneToMany(mappedBy="game_list")
	private List<GameDescription> gameDesc;
	
	*/
	protected GameList() {
		
	}
	
	public GameList(int gameID, String gameName) {
		super();
		GameID = gameID;
		GameName = gameName;
	}

	public int getGameID() {
		return GameID;
	}
	public void setGameID(int gameID) {
		GameID = gameID;
	}
	public String getGameName() {
		return GameName;
	}
	public void setGameName(String gameName) {
		GameName = gameName;
	}

	/*
	public List<GameDescription> getGameDesc() {
		return gameDesc;
	}

	public void setGameDesc(List<GameDescription> gameDesc) {
		this.gameDesc = gameDesc;
	}

*/
	@Override
	public String toString() {
		return "GameList [GameID=" + GameID + ", GameName=" + GameName + "]";
	}
	

}
