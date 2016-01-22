package model;

import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import control.Manager;
import exception.ExceptionCreation;

public class SimpleBoard implements IStrategy {

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

	public SimpleBoard() {
		length = 8;
		width = 8;
		cases = new Case[8][8];
		marked = new boolean[8][8];
		
		try {
			selectedCase = CaseFactory.getCase(EnumCase.SIMPLE_CASE);
			swappedCase = CaseFactory.getCase(EnumCase.SIMPLE_CASE);
		} catch (ExceptionCreation e) {
			e.toString();
		}
		
		initBoard();

	}

	public ICase getSelectedCase() {
		return this.selectedCase;
	}

	public void setSelectedCase(int x, int y) {
		this.selectedCase.setX(x);
		this.selectedCase.setY(y);
	}

	public ICase getSwappedCase() {
		return this.swappedCase;
	}

	public void setSwappedCase(int x, int y) {
		this.swappedCase.setX(x);
		this.swappedCase.setY(y);
	}

	public Case[][] getCases() {
		return cases;
	}

	public void setCases(Case[][] cases) {
		this.cases = cases;
	}

	public Image getBuffer() {
		return buffer;
	}

	public void setBuffer(Image buffer) {
		this.buffer = buffer;
	}

	public void swap(ICase case1, ICase case2) {
		//System.out.println("je swap");
		int x1 = case1.getX();
		int x2 = case2.getX();
		int y1 = case1.getY();
		int y2 = case2.getY();
		ICase tmp = new Case(cases[x1][y1].getCandy().getColor(), x1, y1);
		cases[x1][y1].setCandy(cases[x2][y2].getCandy().getColor());
		cases[x1][y1].setX(x2);
		cases[x1][y1].setX(y2);
		cases[x2][y2].setCandy(tmp.getCandy().getColor());
		cases[x2][y2].setX(tmp.getX());
		cases[x2][y2].setX(tmp.getY());
	}

	public boolean isValidSwap(ICase case1, ICase case2) {

		int x1 = case1.getX();
		int x2 = case2.getX();
		int y1 = case1.getY();
		int y2 = case2.getY();
		if (x1 == -1 || x2 == -1 || y1 == -1 || y2 == -1)
			return false;
		if (Math.abs(x2 - x1) + Math.abs(y2 - y1) != 1)
			return false;

		if (cases[x1][y1].getCandy().equals(cases[x2][y2].getCandy()))
			return false;

		swap(case1, case2);

		boolean newAlignment = false;
		for (int i = 0; i < 3; i++) {
			newAlignment |= horizontalAligned(x1 - i, y1);
			newAlignment |= horizontalAligned(x2 - i, y2);
			newAlignment |= verticalAligned(x1, y1 - i);
			newAlignment |= verticalAligned(x2, y2 - i);
		}

		swap(case1, case2);
		return newAlignment;
	}

	public boolean fill() {
		Random rand = new Random();
		boolean modified = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 7; j >= 0; j--) {
				if (cases[i][j].isEmpty()) {
					if (j == 0)
						cases[i][j] = new Case(
								1 + rand.nextInt(colors.length - 1), i, j);
					else {
						cases[i][j] = new Case(cases[i][j - 1].getCandy()
								.getColor(), i, j);
						cases[i][j - 1].removeCandy();
					}
					modified = true;
				}
			}
		}
		return modified;
	}

	public boolean removeAlignments() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (!cases[i][j].isEmpty() && horizontalAligned(i, j)) {
					marked[i][j] = marked[i + 1][j] = marked[i + 2][j] = true;
				}
				if (!cases[i][j].isEmpty() && verticalAligned(i, j)) {
					marked[i][j] = marked[i][j + 1] = marked[i][j + 2] = true;
				}
			}
		}
		// passe 2 : supprimer les cases marquées
		boolean modified = false;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (marked[i][j]) {
					cases[i][j].removeCandy();
					int s = Player.score;
					s = s+10;
					Player.score +=100;
					System.out.println("LOOOOOL   " + Player.score);
					marked[i][j] = false;
					modified = true;
				}
			}
		}
		return modified;
	}

	
	public boolean horizontalAligned(int i, int j) {
		if (i < 0 || j < 0 || i >= 6 || j >= 8)
			return false;
		if (cases[i][j].getCandy().equals(cases[i + 1][j].getCandy())
				&& cases[i][j].getCandy().equals(cases[i + 2][j].getCandy()))
			return true;
		return false;
	}

	
	public boolean verticalAligned(int i, int j) {
		if (i < 0 || j < 0 || i >= 8 || j >= 6)
			return false;
		if (cases[i][j].getCandy().equals(cases[i][j + 1].getCandy())
				&& cases[i][j].getCandy().equals(cases[i][j + 2].getCandy()))
			return true;
		return false;
	}

	private void initBoard() {
		Random rand = new Random();
		for (int i = 0; i < length; i++) {
			for (int j = width - 1; j >= 0; j--) {
				cases[i][j] = new Case(1 + rand.nextInt(colors.length - 1), i,
						j);
			}
		}
		

	}

}
