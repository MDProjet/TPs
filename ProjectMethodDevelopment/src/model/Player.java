package model;

import control.Manager;
import exception.ExceptionCreation;
import init.GameParams;

public class Player {
	Integer id;
	String pseudo;
	public static int score=0;
	
	public Player() {
		id = 1;
		pseudo = "Larry";
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setScore(int score2) {
		this.score = score2;
		
	}
}
