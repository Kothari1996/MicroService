package com.kothari.gamesDetails.Entity;



import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GameDescription {
	@Id
	@Column(name="description_id")
	private int description_id;
	private BigDecimal rating;
	private String Desciption;
	private Long noOFDownload;
	
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(
		        name = "game_id",
		        referencedColumnName = "game_id"
		    )
	private GameList gameList;
	
	*/
	public  GameDescription() {
		
	}
	public GameDescription(int id, BigDecimal rating, String desciption, Long noOFDownload) {
		super();
		this.description_id = id;
		this.rating = rating;
		Desciption = desciption;
		this.noOFDownload = noOFDownload;
		
	}
	public int getId() {
		return description_id;
	}
	public void setId(int id) {
		this.description_id = id;
	}
	public BigDecimal getRating() {
		return rating;
	}
	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}
	public String getDesciption() {
		return Desciption;
	}
	public void setDesciption(String desciption) {
		Desciption = desciption;
	}
	public Long getNoOFDownload() {
		return noOFDownload;
	}
	public void setNoOFDownload(Long noOFDownload) {
		this.noOFDownload = noOFDownload;
	}
	
	@Override
	public String toString() {
		return "GameDescription [id=" + description_id + ", rating=" + rating + ", Desciption=" + Desciption + ", noOFDownload="
				+ noOFDownload + "]";
	}
	
	
	
	

}
