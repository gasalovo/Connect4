

import javax.swing.JOptionPane;

public class Connect4{
	public Referee r = new Referee();
	//public AI2 Computer;
    public Player p1 = new Player('A');
	public Player p2 = new Player('B');
	private int turn=1;
        private boolean AI=false;
	
	Connect4(boolean Ai)
        {
            AI=Ai; // to idntifiy if there is an AI used or not.
        }
        
        public boolean gameHasAI()
        {
            return AI;
        }

        public int placePiece(int column) //this will place the tile
        {                                 // in its right place and return the row it was placed
            int row=-1;// -1 is the error code "column is full"

            if(r.hasWon())
            {
                
                JOptionPane.showMessageDialog(null, "IA GANA!", "Connect 4", JOptionPane.PLAIN_MESSAGE);
                System.exit(0);

                return row;
            }

            if(!r.isAllowed(column))
                return row;

            if(turn==1)row=Player.play(r.g , p1 , column); // if PvP
            
            
            if(turn==2) row= Player.play(r.g , p2 , column); // if there is no AI

            if(!AI)
            turn=(turn%2)+1; // we will not change turns if AI is playing

            return row;
        }
        
        public static void main(String[] args) {
            Connect4 game = new Connect4(true); // true=> use AI , false=> PvP
            GUI gui = new GUI();
            Listener listener = new Listener(game, gui);

        }
}
