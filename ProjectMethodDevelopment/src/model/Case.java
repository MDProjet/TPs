package model;

import control.Manager;

public class Case implements ICase {

	private Candy candy;
	private int x;
	private int y;

	public Case() {
		this.candy = new Candy(0);
		this.x = -1;
		this.y = -1;
	}
	
	public Case(int couleur, int x, int y) {
		this.candy = new Candy(couleur);
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Candy getCandy() {
		return candy;
	}

	public void setCandy(int couleur) {
		this.candy.setColor(couleur);
	}

	public boolean isEmpty() {
		return candy.getColor() == 0;
	}

	public void removeCandy() {
		this.candy.setColor(0);
	}

}
