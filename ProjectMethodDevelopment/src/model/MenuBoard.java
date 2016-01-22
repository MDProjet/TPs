package model;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import control.Manager;
import exception.ExceptionCreation;

public class MenuBoard {

	private Case[][] cases;
	Manager m;
	private boolean[][] marked;
	private ICase selectedCase;
	private ICase swappedCase;
	private Image buffer;
	private int length;
	private int width;
	public static final Color[] colors = { Color.WHITE, Color.RED, Color.GREEN,
			Color.BLUE, Color.GRAY, Color.MAGENTA, Color.ORANGE };

	public MenuBoard() {
		length = 8;
		width = 8;
}

	public Image getBuffer() {
		return buffer;
	}

	public void setBuffer(Image buffer) {
		this.buffer = buffer;
	}

	

	



}
