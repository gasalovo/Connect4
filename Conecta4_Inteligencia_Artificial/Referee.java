
public class Referee {
	
	protected Grid g = new Grid();
	
	public Referee()  // a Constructor for our Class
	{
		
	}
	
	public boolean isAllowed(int col) // Check if the play is Allowed 
	{
		if( col < g.getGameSize()  && col>= 0 )
		{
			if(g.collisFull(col))
			{	
				// if the column is full we cant allow the play
				System.out.println("Columna llena, intenta otra");
				return false;
			}
			
			else
				return true;
		}
	
		System.out.println("Juega en el tablero...");
		return false;
	}
	
	public boolean isNull() //Check if the game is a draw (full)
	{
		if(g.isFull())    // the game will be draw only if the grid(board) is full
			return true;
		else 
			return false;
	}
	//public boolean hasWin(Player j,int col ,int lig) // Check if player has won
	//{
	//	return true;// wierd...how can we get the Lig :s will figure it out when writing the game
	//}
	
	   
	   
	  
	public boolean hasWon() 
	{ 
	        boolean status = false;
		int size= g.getGameSize(); 
	  
	    // check for a horizontal win 
	    for (int row=0; row<size; row++) 
	    { 
	      for (int column=0; column<size-3; column++) 
	      { 
	        if (g.game[column][row] != 'e' && 
	        		g.game[column][row] == g.game[column+1][row] && 
	        		g.game[column][row] == g.game[column+2][row] && 
	        		g.game[column][row] == g.game[column+3][row])
		        { 
		          status = true;    
		        }
	      }
	    } 
	     
	    // check for a vertical win 
	    for (int row1=0; row1<size-3; row1++) 
	    { 
	      for (int column1=0; column1<size; column1++) 
	      { 
	        if (g.game[column1][row1] != 'e' && 
	        		g.game[column1][row1] == g.game[column1][row1+1] && 
	        		g.game[column1][row1] == g.game[column1][row1+2] && 
	        		g.game[column1][row1] == g.game[column1][row1+3])
		        { 
		          status = true;   
		        }
	      }
	    } 
	    
	     
	    // check for a diagonal win (positive slope) 
	    for (int row2=0; row2<size-3; row2++) 
	    { 
	      for (int column2=0; column2<size-3; column2++) 
	      { 
	        if (g.game[column2][row2] != 'e' && 
	        		g.game[column2][row2] == g.game[column2+1][row2+1] && 
	        		g.game[column2][row2] == g.game[column2+2][row2+2] && 
	        		g.game[column2][row2] == g.game[column2+3][row2+3])
		        { 
		          status = true;   
		        }
	      }
	    }
	      
	    
	     
	    // check for a diagonal win (negative slope) 
	    for (int row3=3; row3<size; row3++) 
	    { 
	      for (int column3=0; column3<size-3; column3++) 
	      { 
	        if (g.game[column3][row3] != 'e' && 
	        		g.game[column3][row3] == g.game[column3+1][row3-1] && 
	        		g.game[column3][row3] == g.game[column3+2][row3-2] && 
	        		g.game[column3][row3] == g.game[column3+3][row3-3])
		        { 
		          status = true;    
		        }
	      }
	    } 
	     
	    return status; 
	   }
		   

}

