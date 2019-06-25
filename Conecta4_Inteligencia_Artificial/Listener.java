import javax.swing.*;
import java.awt.event.*;

public class Listener implements MouseListener
{
    GUI gui;
    Connect4 game;
    //Algoritmo Minimax Alpha Beta
    //AI2 Computer=new AI2();
    
    //Algoritmo Minimax Simple
    AI Computer;

    public Listener(Connect4 game, GUI gui)
    {
        this.game = game;
        this.gui = gui;
        gui.gridListener(this);
        if (gui.getAlgoritmo() == 0) {
        	Computer = new AI3(); //Minimax Simple
        } else {
        	Computer = new AI2(); //Minimax Alfa Beta
        }
    }

    public void mouseClicked(MouseEvent event)
    {
        JLabel label = (JLabel) event.getComponent();
        int column = gui.getColumn(label);
        int row = game.placePiece(column); //placing the tile in the Grid.
        if (row != -1)
        {
            System.out.printf("Me: Column %d , Row %d \n",column , row);
            gui.setPicture(column, row , game.p1); // the picture changes here
        }

        if( game.gameHasAI() && row != -1)
            {
                column=-1;// error code
                boolean win=game.r.hasWon();
                boolean draw=game.r.isNull();
                if(!win && !draw)
                {
                	//Algoritmo 0 es Minimax Simple, 1 es Minimax Alfa Beta	
            	if (gui.getAlgoritmo() == 0) {
                	Computer = new AI3(); //Minimax Simple
                } else {
                	Computer = new AI2(); //Minimax Alfa Beta
                }
                System.out.println("Algoritmo: "+gui.getAlgoritmo()+", dificultad es: "+gui.getDifficult());
                column = Computer.MiniMax( game.r.g.game , gui.getDifficult()); // computer will search for best move
                if(column != -1) row=Player.play(game.r.g, game.p2, column);
                }
                else
                {
                    if(win) JOptionPane.showMessageDialog(null, "GANASTE!", "Connect 4", JOptionPane.PLAIN_MESSAGE);
                    if(draw)JOptionPane.showMessageDialog(null, "EMPATE!", "Connect 4", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0);
                }

            }
        if (row != -1)
        {
            System.out.printf("Computer: Column %d , Row %d \n",column , row);
            gui.setPicture(column, row , Computer.getComputer()); // the picture changes here
            //game.r.g.Display();
        }
        boolean win=game.r.hasWon();
        boolean draw=game.r.isNull();
       
        	if(win) 
        	{
        		JOptionPane.showMessageDialog(null, "IA GANA", "Connect 4", JOptionPane.PLAIN_MESSAGE);
        		System.exit(0);
        	}
        	if(draw)
            {
            	JOptionPane.showMessageDialog(null, "EMPATE!", "Connect 4", JOptionPane.PLAIN_MESSAGE);
            	System.exit(0);
            }
       
       
    }

    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent me) {
       // throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
