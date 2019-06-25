

public class Grid{
	
	public int gameSize=8;  // defining the game size  
	protected char[][] game = new char[gameSize][gameSize];
	
	public Grid () //Constructor for our Grid
	{
		for(int i=0 ; i< gameSize ; i++)
		{
			for(int j=0 ; j< gameSize ; j++)
			{ 
				game[i][j] = 'e';  // e for empty and when a player acquire the slot will be set to the okayer sign before him like A , B
			}
		}
		
	}
        
        public Grid(char[][] x)
        {
         game=x;   
        }

        public Grid(Grid src) // copy constructor which calls second constructor.
        {
         this(src.game);
        }
	
	public void Display() // To display the Grid on the Screen
	{
		for(int i=0 ; i< game.length ; i++)
		{
			for(int j=0 ; j< game[i].length ; j++)
			{ 
				if(game[i][j] == 'e')
					System.out.printf("* \t");
				
				else
					System.out.printf("%s \t",game[i][j]);
						
			}
			System.out.println();
		}
	return;
		
	}
	
	public boolean isFull() //Check the Grid if its Full
	{
		for(int col = 0 ; col < gameSize ; col++){
		 if(game[0][col] == 'e')
		  return false;
		}
		return true;
	}
	
	public boolean collisFull(int col) //Check the column if its Full
	{
		for(int i=0 ; i<gameSize ; i++)  // i am smart
		{ 
			if(game[i][col] == 'e')
				return false;      // check if there is one empty slot we will return false
		}
		return true; // the test fails
	}
	
	public int getGameSize() // getting the game size to use in some conditions 
	{
		return gameSize;
	}

        public char[][] getGame()
        {
            return game;
        }

       
}
