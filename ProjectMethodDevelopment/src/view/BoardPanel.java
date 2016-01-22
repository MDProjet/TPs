package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.SimpleBoard;
import model.IStrategy;
import model.Player;
import control.Manager;

public class BoardPanel extends JPanel implements Runnable {

	File[] f = new File[7];
	Image[] img = new Image[7];
	private IStrategy board;
	int mouseX, mouseY;

	public BoardPanel() {
		try {
			f[1] = new File("assets/rouge.png");
			f[2] = new File("assets/violet.png");
			f[3] = new File("assets/bleu.png");
			f[4] = new File("assets/jaune.png");
			f[5] = new File("assets/autre2.png");
			f[6] = new File("assets/vert.png");
			img[1] = ImageIO.read(f[1]);
			img[2] = ImageIO.read(f[2]);
			img[3] = ImageIO.read(f[3]);
			img[4] = ImageIO.read(f[4]);
			img[5] = ImageIO.read(f[5]);
			img[6] = ImageIO.read(f[6]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		board = Manager.getInstance().getBoard();
		while (board.fill())
			;
		// enlever les alignements existants
		while (board.removeAlignments()) {
			board.fill();
		}
	}

	public void run() {
		while (true) {
			// un pas de simulation toutes les 100ms
			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
			}

			if (!board.fill()) {
				board.removeAlignments();
			}

			repaint();
		}
	}

	public void update(Graphics g) {
		paint(g);
	}

	// routine d'affichage : on fait du double buffering
	public void paint(Graphics g2) {
		if (board.getBuffer() == null)
			board.setBuffer(createImage(800, 600));
		Graphics2D g = (Graphics2D) board.getBuffer().getGraphics();

		// fond
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		// afficher la grille vide
		g.setColor(Color.BLACK);
		for (int i = 0; i < 9; i++) {
			g.drawLine(32 * i, 0, 32 * i, 8 * 32 + 1);
			g.drawLine(0, 32 * i, 8 * 32 + 1, 32 * i);
		}

		// afficher la première case sélectionnée
		if (board.getSelectedCase() != null) {
			if (this.getMouseX() < 260 && this.getMouseY() < 300) {
				g.setColor(Color.ORANGE);
				g.fillRect(board.getSelectedCase().getX() * 32 + 1, board.getSelectedCase().getY() * 32 + 1, 31, 31);
			}
		}

		// afficher la deuxième case sélectionnée
		if (board.getSwappedCase() != null) {
			if (this.getMouseX() < 260 && this.getMouseY() < 300) {
				g.setColor(Color.YELLOW);
				g.fillRect(board.getSwappedCase().getX() * 32 + 1, board.getSwappedCase().getY() * 32 + 1, 31, 31);
			}
		}

		// afficher le contenu de la grille
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				// g.setColor(SimpleBoard.colors[board.getCases()[i][j].getCandy().getColor()]);
				// g.fillOval(32 * i + 3, 32 * j + 3, 27, 27);
				if (board.getCases()[i][j].getCandy().getColor() != 0)
					g.drawImage(img[board.getCases()[i][j].getCandy().getColor()], 32 * i + 3, 32 * j + 3, 27, 27,
							null);
				else {
					g.setColor(SimpleBoard.colors[board.getCases()[i][j].getCandy().getColor()]);
					g.fillOval(32 * i + 3, 32 * j + 3, 27, 27);
				}
			}
		}
		g.setColor(Color.BLACK);
		g.fillRect(290, 220- Player.score/100, 20, Player.score / 100 );
		g.drawString("Score", 290, 240);
		System.out.println("SCORE : "+Player.score);

		// copier l'image à l'écran
		g2.drawImage(board.getBuffer(), 0, 0, null);
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

	public IStrategy getBoard() {
		return board;
	}

}
