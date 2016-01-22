package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import model.Case;
import model.SimpleBoard;

import org.junit.Test;

public class TestModel {
    @Test
    public void TestModelTrue() {
        assertTrue(1 == 1);
    }
    
    @Test
    public void NotEmptySimpleBoard(){
    	SimpleBoard b = new SimpleBoard();
    	assertNotNull(b);
    }
    
    @Test
    public void SwapSimpleBoard(){
    	SimpleBoard b = new SimpleBoard();
    	Random rand = new Random();
    	Case current_c = null;
    	Case leftC = null;
    	Case rigthC = null;
    	Case topC = null;
    	Case botC = null;
    	
    	for (int i = 0; i < 1000000; i++){
    		int x = rand.nextInt(8);
    		int y = rand.nextInt(8);
    		
    		current_c = b.getCases()[x][y];
    		if(y+1 <= 7) leftC = b.getCases()[x][y+1];
    		if(y-1 >= 0) rigthC = b.getCases()[x][y-1];
    		if(x+1 <= 7) topC = b.getCases()[x+1][y];
    		if(x-1 >= 0) botC = b.getCases()[x-1][y];
    		
    		if(leftC != null && b.isValidSwap(current_c, leftC))
    			b.swap(current_c, leftC);
    		if(rigthC != null &&b.isValidSwap(current_c, rigthC))
    			b.swap(current_c, rigthC);
    		if(topC != null &&b.isValidSwap(current_c, topC))
    			b.swap(current_c, topC);
    		if(botC != null &&b.isValidSwap(current_c, botC))
    			b.swap(current_c, botC);
    	}
    }
    
    private void cleanBoard(Case[][] cases){
    	for(int i=0; i<8; i++)
    		for(int j=0; j<8; j++)
    			cases[i][j].setCandy(0);
    }
    
    @Test
    public void FillSimpleBoard(){
    	SimpleBoard b = new SimpleBoard();
    	
    	for (int i = 0; i < 1000000; i++){
    		b.fill();
    		cleanBoard(b.getCases());
    	}
    }
}


