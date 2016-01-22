package model;

import java.awt.Image;

public interface IStrategy {
	
	void swap(ICase case1, ICase case2) ;
	boolean isValidSwap(ICase case1, ICase case2);
	boolean fill();
	boolean horizontalAligned(int i, int j);
	boolean verticalAligned(int i, int j);
	public boolean removeAlignments();
	public ICase getSelectedCase();
	public void setSelectedCase(int x, int y) ;
	public ICase getSwappedCase() ;
	public void setSwappedCase(int x, int y);
	public Image getBuffer();
	ICase[][] getCases();
	void setBuffer(Image img);
	
}
