

public class Player {
	private char sign; // should change this to player sign
	private char color;
	private String Name;

	public Player(char n)
	{
		sign=n;
	}
	
	
	public static int play(Grid g , Player p , int col) // will get input and play
	{

                for(int i=(g.gameSize-1) ; 0 <= i ; i--)  // i am smart rofl i am stupid i thot i was smart
		{ 
			if(g.game[i][col] == 'e')
			{
				g.game[i][col]= p.getSign();       // will put player name in the nearest slot
				return i;
			}
				
		}
		
		return -1; 
	}

	public char getSign()
	{
		return sign;
	}
	
	public char getColor()
	{
		return color;
	}

        public void setName(String pn)
        {
            Name=pn;
        }

        public String getName()
        {
            return Name;
        }

}
