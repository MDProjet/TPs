package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.SimpleBoard;
import model.IStrategy;
import model.MenuBoard;
import model.Player;
import control.Manager;

public class MenuPanel extends JPanel implements Runnable {

	File[] f = new File[7];
	Image[] img = new Image[7];
	int mouseX, mouseY;
	MenuBoard board;

	public MenuPanel() {
		try {
			f[1] = new File("assets/fond.png");
			
			img[1] = ImageIO.read(f[1]);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			// un pas de simulation toutes les 100ms
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
			}

			repaint();
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	// routine d'affichage : on fait du double buffering
	public void paint(Graphics g2) {

		g2.drawImage(img[1], 0, 60, 260, 295, null);
		

	}

	// taille de la fenêtre
	public Dimension getPreferredSize() {
		return new Dimension(32 * 8 + 1, 32 * 8 + 1);
	}

	public int getMouseX() {
		return mouseX;
	}

	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}

	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

}
