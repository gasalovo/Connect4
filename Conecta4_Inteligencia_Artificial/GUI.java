
import java.awt.event.ActionEvent;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

import com.sun.org.apache.xpath.internal.axes.SelfIteratorNoPredicate;

public class GUI {

    int gameSize = 8; //get from the grid class
    JFrame frame = new JFrame("Your PC is Dominated by this AI");
    JLabel grid_gui [][];
    int Player;
    Player Player_1=new Player('A'); // its driving me crazy
    Player Player_2=new Player('B');
    JPanel panel;
    JPanel menu;
    JButton play;
    JButton exit;
    JComboBox<String> cb;
    JComboBox<String> cb2;
    handler hand=new handler();
    Color background_color= new Color(0x24b8f0);
    int difficult = 4; //por defecto
    int algoritmo = 0; //por defecto MiniMax Simple

    public GUI(){

    frame.setBackground(Color.yellow); // pretty clear :)
    frame.setExtendedState(Frame.MAXIMIZED_BOTH); //maximizing the screen
    frame.setUndecorated(true); // removing window decore
     //menu = (JPanel) frame.getContentPane(); // the Panel on the frame
    	
        //setting all the Icons in the menu
         ImageIcon iconPlay1 = new ImageIcon("pics\\Play_1.png");
    	 ImageIcon iconPlay2 = new ImageIcon("pics\\Play_2.png");
         ImageIcon iconExit1 = new ImageIcon("pics\\Exit_1.png");
         ImageIcon iconExit2 = new ImageIcon("pics\\Exit_2.png");
         
         ImageIcon co = new ImageIcon("pics\\Slogen.png");
         ImageIcon co2 = new ImageIcon("pics\\About.png");

     //Creating the menu Panel
     menu = new JPanel();
     menu.setLayout(new GridBagLayout());//GridBagLayout
     GridBagConstraints c = new GridBagConstraints();
     menu.setBackground(Color.white);
     //menu.add(theComponent, c);
     frame.getContentPane().add(menu,BorderLayout.CENTER);
     //menu.setLayout(new GridBagLayout());
     
     /*JLabel coo =new JLabel (co);
     c.gridx =100;
     c.gridy =100;
     c.insets = new Insets (0,0,0,0);
     menu.add(coo,c);
     
    /* JLabel coo2 =new JLabel (co2);
     c.gridx =10;
     c.gridy =50;
     c.insets = new Insets (0,0,0,0);
     menu.add(coo2,c);
     */
     
     JLabel text =new JLabel (co);
     c.gridx =0;
     c.gridy =0;
     c.insets = new Insets (0,0,0,0);
     menu.add(text,c);
     
     
     JLabel about =new JLabel (co2);
     c.gridx =0;
     c.gridy =100;
     c.insets = new Insets (0,0,0,0);
     menu.add(about,c);
     
     
     //Seleccion algoritmo
     String algoritmos[]={"Minimax Simple","Minimax Alfa-Beta"};        
     cb2 = new JComboBox<String>(algoritmos);
     cb2.setSelectedItem(algoritmos[0]); //valor por defecto 0
     cb2.setBounds(50,100,90,20);    
     JLabel labelAlgoritmo =new JLabel ("Algoritmo");
     labelAlgoritmo.setHorizontalAlignment(JLabel.CENTER);  
     labelAlgoritmo.setSize(400,100);  
     
     //Dificultad
     String levels[]={"1","2","3","4","5","6","7","8","9","10","11"};        
     cb = new JComboBox<String>(levels);
     cb.setSelectedItem(levels[3]); //valor por defecto 4
     cb.setBounds(50,100,90,20);    
     JLabel labelDif =new JLabel ("Difficult");
     labelDif.setHorizontalAlignment(JLabel.CENTER);  
     labelDif.setSize(400,100);  
     
     
     //put elements
     c.gridx =0;
     c.gridy =200;
     c.insets = new Insets (0,0,0,0);
     menu.add(labelAlgoritmo, c);
     c.gridx =20;
     c.gridy =300;
     c.insets = new Insets (0,0,0,0);
     menu.add(cb2,c);
     c.gridx =0;
     c.gridy =400;
     c.insets = new Insets (0,0,0,0);
     menu.add(labelDif, c);
     c.gridx =20;
     c.gridy =500;
     c.insets = new Insets (0,0,0,0);
     menu.add(cb,c);
     
     
    
     //creating and setting the exit button
     play=new JButton(iconPlay1);
     c.gridx =0;
     c.gridy =50;
     c.insets = new Insets (50,50,50,50);
     play.setRolloverIcon(iconPlay2); //set the rollover pic
     play.setBorderPainted(false); //removes the border on the button
     menu.add(play,c);

     //creating and setting the exit button
     exit=new JButton(iconExit1);
     c.fill = GridBagConstraints.HORIZONTAL;
     c.weightx = 0;
     c.gridx = 0;
     c.gridy = -10;
     c.insets = new Insets (10,10,10,10);
     exit.setRolloverIcon(iconExit2);
     exit.setBorderPainted(false); //removes the border on the button

     menu.add(exit,c);
     play.addActionListener(hand);
     exit.addActionListener(hand);
     cb.addActionListener(hand);
     cb2.addActionListener(hand);
     menu.setSize(700,600);

     //creating the Game Panel
     panel = new JPanel();
     panel.setLayout(new GridLayout(gameSize,gameSize)); // setting the grid

     grid_gui = new JLabel[gameSize][gameSize]; // initlizing the Labels (better than buttons)

     for(int i=0 ; i<8 ; i++)
     {
         for(int j=0 ; j<8 ; j++)
         {
            grid_gui[i][j]= new JLabel();
            //grid_gui[i][j].setBorder(new LineBorder(Color.BLACK));
            grid_gui[i][j].setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(grid_gui[i][j]);
            grid_gui[i][j].setIcon(new ImageIcon("pics\\Advanced_empty.png"

	));
         }
     }

    panel.setBackground(background_color);
    panel.setSize(600, 500);
    //frame.setContentPane(panel);
    frame.setSize(700,600); // try this later
    frame.setVisible(true);
    Player = 1;
    }
    
    public int getDifficult() {
    	return difficult;
    }
    
    public int getAlgoritmo() {
    	return algoritmo;
    }
    
    public int getColumn(JLabel label)
    {
        int returnColumn = -1;                         // -1 is the error code
        for (int row=0; row<8; row++)
        {
            for (int column=0; column<8; column++)    // This will Loop will spen
            {
                if (grid_gui[row][column] == label)     //    Until finding the
                {
                returnColumn = column;              //      Clicked JLabel
                }                                  //  Will return the Error code
            }                                     // if
        }
        return returnColumn;
    }

    public void gridListener(Listener listener)
    {
        for (int row=0; row<8; row++)
        {
            for (int column=0; column<8 ; column++)
            {
                grid_gui[column][row].addMouseListener(listener);
            }
        }
    }

    public void setPicture(int column, int row , Player p) // sets the player pic on the JLabel
    {
	// slots[column][row].setText("*" + currentPlayer + "*");
	if (p.getSign() == 'A') {
	grid_gui[row][column].setIcon(new ImageIcon("pics\\Advanced_Red.png"

	));
	}
	else {
	grid_gui[row][column].setIcon(new ImageIcon("pics\\Advanced_Blue.png"

	));
	}
	Player = (Player%2)+1;
    }



    public class handler implements ActionListener{

        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == play)
            {
                menu.revalidate();
                frame.remove(menu);
                frame.add(panel);
            }
            if(event.getSource() == exit)
            {
                System.exit(0);
            }
            
            //Evento del gui de seleccion de dificultad
            if(event.getSource() == cb) {
            	int intDif = Integer.parseInt(cb.getItemAt(cb.getSelectedIndex()));
            	System.out.println("Dificultad: "+intDif);
            	setDifficult(intDif);
            }
            
            //Evento del gui de seleccion de algoritmo
            if(event.getSource() == cb2) {
            	int algo = 0;
            	String stringAlgoritmo = cb2.getItemAt(cb2.getSelectedIndex());
            	System.out.println("Algoritmo: "+stringAlgoritmo);
            	if (stringAlgoritmo != "Minimax Simple") {
            		algo = 1;
            	}
            	setAlgoritmo(algo);
            }
        }
        
        //Al tocar la interfaz para incluir la funcionalidad de introducir
        //dificultad y algoritmo, se ha incluido esta funcion auxiliar
        public void setDifficult(int difficult) {
        	GUI.this.difficult = difficult;
        }
        
        //Al tocar la interfaz para incluir la funcionalidad de introducir
        //dificultad y algoritmo, se ha incluido esta funcion auxiliar
        public void setAlgoritmo(int algoritmo) {
        	GUI.this.algoritmo = algoritmo;
        }

    }
    

}































