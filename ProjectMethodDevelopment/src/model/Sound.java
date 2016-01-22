package model;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javazoom.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sound implements Runnable {

	public void playSound() {
		try {
			File m = new File("assets/music.mp3");
			FileInputStream fis = new FileInputStream(m);
			BufferedInputStream bis = new BufferedInputStream(fis);

			try {
				Player p = new Player(bis);
				p.play();
			} catch (JavaLayerException e) {
			}

		} catch (IOException e) {
		}
		// TODO: handle exception
	}

	@Override
	public void run() {

		playSound();
	}
}