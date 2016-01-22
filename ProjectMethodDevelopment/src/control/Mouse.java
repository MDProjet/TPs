package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import view.BoardPanel;

public class Mouse implements MouseListener, MouseMotionListener {

	private BoardPanel parent;

	public Mouse(BoardPanel parent) {
		this.parent = parent;
	}

	public void mousePressed(MouseEvent e) {
		parent.setMouseX(e.getX());
		parent.setMouseY(e.getY());
		System.out.println("je clique" + e.getX() / 32 + "," + e.getY() / 32);
		if (parent != null) {
			parent.getBoard().setSelectedCase(e.getX() / 32, e.getY() / 32);
			parent.repaint();
		}

	}

	public void mouseMoved(MouseEvent e) {
		// on bouge la souris : récupérer les coordonnées de la deuxième
		// case
		if (parent.getBoard().getSelectedCase().getX() != -1 && parent.getBoard().getSelectedCase().getY() != -1) {

			// System.out.println("init swap " + e.getX() / 32 + "," + e.getY()
			// / 32);
			parent.getBoard().setSwappedCase(e.getX() / 32, e.getY() / 32);

			if (!parent.getBoard().isValidSwap(parent.getBoard().getSelectedCase(),
					parent.getBoard().getSwappedCase())) {
				parent.getBoard().setSwappedCase(-1, -1);
			}
		}
		parent.repaint();
	}

	public void mouseReleased(MouseEvent e) {

		System.out.println("je relache " + parent.getBoard().getSelectedCase().getX() + ","
				+ parent.getBoard().getSelectedCase().getY() + "Swapped " + parent.getBoard().getSwappedCase().getX()
				+ "," + parent.getBoard().getSwappedCase().getY());

		if (parent.getBoard().getSelectedCase().getX() != -1 && parent.getBoard().getSelectedCase().getY() != -1
				&& parent.getBoard().getSwappedCase().getX() != -1 && parent.getBoard().getSwappedCase().getY() != -1) {
			
			parent.getBoard().swap(parent.getBoard().getSelectedCase(), parent.getBoard().getSwappedCase());
		}
		parent.getBoard().setSelectedCase(-1, -1);
		parent.getBoard().setSwappedCase(-1, -1);
		parent.repaint();
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		mouseMoved(e);
	}

}
