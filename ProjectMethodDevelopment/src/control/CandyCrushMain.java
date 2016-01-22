package control;

import java.awt.Frame;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import view.AcceuilFrame;
import view.BoardPanel;
import view.WelcomeFrame;
import model.SimpleBoard;
import model.IStrategy;
import model.IPlay;

public class CandyCrushMain {
	private IStrategy b;
	private Integer countdown;
	private List<IPlay> play;
	private Integer x;
	private Integer y;
	private List<Frame> frames;
	

	private static CandyCrushMain instance = null;


	public CandyCrushMain() {
		b = new SimpleBoard();
		frames = new ArrayList<Frame>();
		frames.add(new AcceuilFrame());
		frames.add(new WelcomeFrame());
		//		b.setLength(8);
		//		b.setWidth(8);
		b.fill();
	}

	public static CandyCrushMain getInstance() {
		if(instance == null) {
			instance = new CandyCrushMain();
		}
		return instance;
	}


	public IStrategy getB() {
		return b;
	}


	public void setB(IStrategy b) {
		this.b = b;
	}


	public Integer getCountdown() {
		return countdown;
	}


	public void setCountdown(Integer countdown) {
		this.countdown = countdown;
	}



	
	public List<IPlay> getPlay() {
		return play;
	}


	public void setPlay(List<IPlay> play) {
		this.play = play;
	}



	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}


	public Integer getY() {
		return y;
	}


	public void setY(Integer y) {
		this.y = y;
	}

	public List<Frame> getFrames() {
		return frames;
	}

	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}
	
	

}
