package control;

import exception.ExceptionCreation;
import init.GameParams;
import model.EnumStrategy;
import model.SimpleBoard;
import model.IStrategy;

public class Manager {

	private static Manager instance;
	private IStrategy board;
	private int score=0;

	private Manager() throws ExceptionCreation {
		if (GameParams.GAME_BOARD == EnumStrategy.SIMPLE_GAME.ordinal())
			board = new SimpleBoard();
		else {
			throw new ExceptionCreation("BoardStratery");
		}
	}

	public static Manager getInstance() {
		if (instance == null) {
			try {
				return new Manager();
			} catch (ExceptionCreation e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	public IStrategy getBoard() {
		return board;
	}


}
