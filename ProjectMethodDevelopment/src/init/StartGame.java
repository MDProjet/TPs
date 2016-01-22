package init;

import control.CandyCrushMain;
import model.Sound;
import view.WelcomeFrame;



public class StartGame {

	private CandyCrushMain start;
	private Sound s = new Sound();
	
	public StartGame() {
		start = new CandyCrushMain();
	}

	public void go() {
		start.getFrames().get(EnumFrame.WELCOME.getValue()).setVisible(true);
		s.playSound();
	}

	public static void main(String[] args) {
		StartGame c = new StartGame();
		c.go();

	}

}
