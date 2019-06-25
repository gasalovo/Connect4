//Algoritmo minimax simple (sin poda alfa-beta)
public class AI3 implements AI {

    static int counter=0;
    Player computer= new Player('B'); // ordenador
    Player me= new Player('A');       // humano

    class State
    {
        //CLASS STATE
        Integer value=null; // prevoius column  ; -1 is value of the root
        char[][] state= new char[8][];
        State child[]; // childeren of curruent state which the max of them are 8
        State(char[][] src)
        {
            //state=src;

           for (int i = 0; i < src.length ; i++)
            {
                state[i] = new char[src[i].length];
                System.arraycopy(src[i], 0, state[i], 0, state[i].length);
            }
            
            child=new State[8];
            counter++;
        }

    private int evaluate(char[][] state)
        {
	int size = 8;
	char[][] ev= new char[size][size];

	for (int i = 0; i < state.length ; i++)
             {
                 ev[i] = new char[state[i].length];
                 System.arraycopy(state[i], 0, ev[i], 0, ev[i].length);
             }

	int V =0;



	// check horizontal 
	for (int row=0; row<size; row++)
	    {
	for (int column=0; column<size; column++)
	      {

		for(int k=1 ; k<2 ; k++)
		{
			if(column+3 >= 8)
				break ;

			  if (ev[column][row] == 'B' )
    			 if (ev[column+1][row] == 'B' )
    				 if (ev[column+2][row] == 'B' )
    					 if (ev[column+3][row] == 'B' )
    						 V+=1000;
    					 else
    						 V+=100;
    				 else
						 V+=10;
    			 else
    				 V++;

			  if (ev[column][row] == 'B' )
	    			 if (ev[column+1][row] == 'e' )
	    				 if (ev[column+2][row] == 'e' )
	    					 if (ev[column+3][row] == 'e' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V+=0;

    		 if (ev[column][row] == 'A' )
    			 if (ev[column+1][row] == 'A' )
    				 if (ev[column+2][row] == 'A' )
    					 if (ev[column+3][row] == 'A' )
    						 V-=1000;
    					 else
    						 V-=100;
    				 else
						 V-=10;
    			 else
    				 V--;

    		 if (ev[column][row] == 'A' )
    			 if (ev[column+1][row] != 'B' )
    				 if (ev[column+2][row] != 'B' )
    					 if (ev[column+3][row] != 'B' )
    						 V-=15;
    					 else
    						 V-=10;
    				 else
						 V-=5;
    			 else
    				 V+=0;

    		 if (ev[column][row] == 'e' )
    			 if (ev[column+1][row] != 'A' )
    				 if (ev[column+2][row] != 'A' )
    					 if (ev[column+3][row] != 'A' )
    						 V+=15;
    					 else
    						 V+=10;
    				 else
						 V+=5;
    			 else
    				 V++;



		  }




		for(int k=1 ; k<2 ; k++)
		  {
			if(column-3 <= -1)
				break ;

				if (ev[column][row] == 'B' )
	    			 if (ev[column-1][row] == 'B' )
	    				 if (ev[column-2][row] == 'B' )
	    					 if (ev[column-3][row] == 'B' )
	    						 V+=1000;
	    					 else
	    						 V+=100;
	    				 else
							 V+=10;
	    			 else
	    				 V++;

				if (ev[column][row] == 'B' )
	    			 if (ev[column-1][row] == 'e' )
	    				 if (ev[column-2][row] == 'e' )
	    					 if (ev[column-3][row] == 'e' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V+=0;

	    		 if (ev[column][row] == 'A' )
	    			 if (ev[column-1][row] == 'A' )
	    				 if (ev[column-2][row] == 'A' )
	    					 if (ev[column-3][row] == 'A' )
	    						 V-=1000;
	    					 else
	    						 V-=100;
	    				 else
							 V-=10;
	    			 else
	    				 V--;

	    		 if (ev[column][row] == 'A' )
	    			 if (ev[column-1][row] != 'B' )
	    				 if (ev[column-2][row] != 'B' )
	    					 if (ev[column-3][row] != 'B' )
	    						 V-=15;
	    					 else
	    						 V-=10;
	    				 else
							 V-=5;
	    			 else
	    				 V+=0;

	    		 if (ev[column][row] == 'e' )
	    			 if (ev[column-1][row] != 'A' )
	    				 if (ev[column-2][row] != 'A' )
	    					 if (ev[column-3][row] != 'A' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V++;



	        }




	      }
	    }

	// check vertical
	for (int row1=0; row1<size; row1++)
	    {
	for (int column1=0; column1<size; column1++)
	      {


		for(int k=1 ; k<2 ; k++)
		{
			if(row1+3 >= 8)
				break;

				if (ev[column1][row1] == 'B' )
	    			 if (ev[column1][row1+1] == 'B' )
	    				 if (ev[column1][row1+2] == 'B' )
	    					 if (ev[column1][row1+3] == 'B' )
	    						 V+=1000;
	    					 else
	    						 V+=100;
	    				 else
							 V+=10;
	    			 else
	    				 V++;

				if (ev[column1][row1] == 'B' )
	    			 if (ev[column1][row1+1] == 'e' )
	    				 if (ev[column1][row1+2] == 'e' )
	    					 if (ev[column1][row1+3] == 'e' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V+=0;

	    		 if (ev[column1][row1] == 'A' )
	    			 if (ev[column1][row1+1] == 'A' )
	    				 if (ev[column1][row1+2] == 'A' )
	    					 if (ev[column1][row1+3] == 'A' )
	    						 V-=1000;
	    					 else
	    						 V-=100;
	    				 else
							 V-=10;
	    			 else
	    				 V--;

	    		 if (ev[column1][row1] == 'A' )
	    			 if (ev[column1][row1+1] != 'B' )
	    				 if (ev[column1][row1+2] != 'B' )
	    					 if (ev[column1][row1+3] != 'B' )
	    						 V-=15;
	    					 else
	    						 V-=10;
	    				 else
							 V-=5;
	    			 else
	    				 V+=0;

	    		 if (ev[column1][row1] == 'e' )
	    			 if (ev[column1][row1+1] != 'A' )
	    				 if (ev[column1][row1+2] != 'A' )
	    					 if (ev[column1][row1+3] != 'A' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V++;


		}


		for(int k=1 ; k<2 ; k++)
		  {
				if(row1-3 <= -1)
					break ;

				if (ev[column1][row1] == 'B' )
	    			 if (ev[column1][row1-1] == 'B' )
	    				 if (ev[column1][row1-2] == 'B' )
	    					 if (ev[column1][row1-3] == 'B' )
	    						 V+=1000;
	    					 else
	    						 V+=100;
	    				 else
							 V+=10;
	    			 else
	    				 V++;

				if (ev[column1][row1] == 'B' )
	    			 if (ev[column1][row1-1] == 'e' )
	    				 if (ev[column1][row1-2] == 'e' )
	    					 if (ev[column1][row1-3] == 'e' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V+=0;

	    		 if (ev[column1][row1] == 'A' )
	    			 if (ev[column1][row1-1] == 'A' )
	    				 if (ev[column1][row1-2] == 'A' )
	    					 if (ev[column1][row1-3] == 'A' )
	    						 V-=1000;
	    					 else
	    						 V-=100;
	    				 else
							 V-=10;
	    			 else
	    				 V--;

	    		 if (ev[column1][row1] == 'A' )
	    			 if (ev[column1][row1-1] != 'B' )
	    				 if (ev[column1][row1-2] != 'B' )
	    					 if (ev[column1][row1-3] != 'B' )
	    						 V-=15;
	    					 else
	    						 V-=10;
	    				 else
							 V-=5;
	    			 else
	    				 V+=0;

	    		 if (ev[column1][row1] == 'e' )
	    			 if (ev[column1][row1-1] != 'A' )
	    				 if (ev[column1][row1-2] != 'A' )
	    					 if (ev[column1][row1-3] != 'A' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V++;

			}



	      }
	    }


	// check diagonal (positive slope)
	for (int row2=0; row2<size; row2++)
	    {
	for (int column2=0; column2<size; column2++)
	      {

		for(int k=1 ; k<2 ; k++)
		  {
				if (row2+3 >= 8 || column2+3 >= 8)
					break;

				if (ev[column2][row2] == 'B' )
	    			 if (ev[column2+1][row2+1] == 'B' )
	    				 if (ev[column2+2][row2+2] == 'B' )
	    					 if (ev[column2+3][row2+3] == 'B' )
	    						 V+=1000;
	    					 else
	    						 V+=100;
	    				 else
							 V+=10;
	    			 else
	    				 V++;

				if (ev[column2][row2] == 'B' )
	    			 if (ev[column2+1][row2+1] == 'e' )
	    				 if (ev[column2+2][row2+2] == 'e' )
	    					 if (ev[column2+3][row2+3] == 'e' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V+=0;


				if (ev[column2][row2] == 'A' )
	    			 if (ev[column2+1][row2+1] == 'A' )
	    				 if (ev[column2+2][row2+2] == 'A' )
	    					 if (ev[column2+3][row2+3] == 'A' )
	    						 V-=1000;
	    					 else
	    						 V-=100;
	    				 else
							 V-=10;
	    			 else
	    				 V--;

				if (ev[column2][row2] == 'A' )
	    			 if (ev[column2+1][row2+1] != 'B' )
	    				 if (ev[column2+2][row2+2] != 'B' )
	    					 if (ev[column2+3][row2+3] != 'B' )
	    						 V-=15;
	    					 else
	    						 V-=10;
	    				 else
							 V-=5;
	    			 else
	    				 V+=0;

				if (ev[column2][row2] == 'e' )
	    			 if (ev[column2+1][row2+1] != 'A' )
	    				 if (ev[column2+2][row2+2] != 'A' )
	    					 if (ev[column2+3][row2+3] != 'A' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V++;
			}

		for(int k=1 ; k<2 ; k++)
		  {
				if (row2-3 <= -1 || column2-3 <= -1)
					break;

				if (ev[column2][row2] == 'B' )
	    			 if (ev[column2-1][row2-1] == 'B' )
	    				 if (ev[column2-2][row2-2] == 'B' )
	    					 if (ev[column2-3][row2-3] == 'B' )
	    						 V+=1000;
	    					 else
	    						 V+=100;
	    				 else
							 V+=10;
	    			 else
	    				 V++;

				if (ev[column2][row2] == 'B' )
	    			 if (ev[column2-1][row2-1] == 'e' )
	    				 if (ev[column2-2][row2-2] == 'e' )
	    					 if (ev[column2-3][row2-3] == 'e' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V+=0;

				if (ev[column2][row2] == 'A' )
	    			 if (ev[column2-1][row2-1] == 'A' )
	    				 if (ev[column2-2][row2-2] == 'A' )
	    					 if (ev[column2-3][row2-3] == 'A' )
	    						 V-=1000;
	    					 else
	    						 V-=100;
	    				 else
							 V-=10;
	    			 else
	    				 V--;

				if (ev[column2][row2] == 'A' )
	    			 if (ev[column2-1][row2-1] != 'B' )
	    				 if (ev[column2-2][row2-2] != 'B' )
	    					 if (ev[column2-3][row2-3] != 'B' )
	    						 V-=15;
	    					 else
	    						 V-=10;
	    				 else
							 V-=5;
	    			 else
	    				 V+=0;


				if (ev[column2][row2] == 'e' )
	    			 if (ev[column2-1][row2-1] != 'A' )
	    				 if (ev[column2-2][row2-2] != 'A' )
	    					 if (ev[column2-3][row2-3] != 'A' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V++;

	  }

	      }
	    }



	// check  diagonal (negative slope)
	for (int row3=3; row3<size; row3++)
	    {
	for (int column3=0; column3<size; column3++)
	      {

		for(int k=1 ; k<2 ; k++)
		  {
				if (row3-3 <= -1 || column3+3 >= 8)
					break;

				if (ev[column3][row3] == 'B' )
	    			 if (ev[column3+1][row3-1] == 'B' )
	    				 if (ev[column3+2][row3-2] == 'B' )
	    					 if (ev[column3+3][row3-3] == 'B' )
	    						 V+=1000;
	    					 else
	    						 V+=100;
	    				 else
							 V+=10;
	    			 else
	    				 V++;

				if (ev[column3][row3] == 'B' )
	    			 if (ev[column3+1][row3-1] == 'e' )
	    				 if (ev[column3+2][row3-2] == 'e' )
	    					 if (ev[column3+3][row3-3] == 'e' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V+=0;

				if (ev[column3][row3] == 'A' )
	    			 if (ev[column3+1][row3-1] == 'A' )
	    				 if (ev[column3+2][row3-2] == 'A' )
	    					 if (ev[column3+3][row3-3] == 'A' )
	    						 V-=1000;
	    					 else
	    						 V-=100;
	    				 else
							 V-=10;
	    			 else
	    				 V--;

				if (ev[column3][row3] == 'e' )
	    			 if (ev[column3+1][row3-1] != 'A' )
	    				 if (ev[column3+2][row3-2] != 'A' )
	    					 if (ev[column3+3][row3-3] != 'A' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V++;


				if (ev[column3][row3] == 'A' )
	    			 if (ev[column3+1][row3-1] != 'B' )
	    				 if (ev[column3+2][row3-2] != 'B' )
	    					 if (ev[column3+3][row3-3] != 'B' )
	    						 V-=15;
	    					 else
	    						 V-=10;
	    				 else
							 V-=5;
	    			 else
	    				 V+=0;
			}


		for(int k=1 ; k<2 ; k++)
		  {
				if (row3+3 >= 8 || column3-3 <= -1)
					break;

				if (ev[column3][row3] == 'B' )
	    			 if (ev[column3-1][row3+1] == 'B' )
	    				 if (ev[column3-2][row3+2] == 'B' )
	    					 if (ev[column3-3][row3+3] == 'B' )
	    						 V+=1000;
	    					 else
	    						 V+=100;
	    				 else
							 V+=10;
	    			 else
	    				 V++;


				if (ev[column3][row3] == 'B' )
	    			 if (ev[column3-1][row3+1] == 'e' )
	    				 if (ev[column3-2][row3+2] == 'e' )
	    					 if (ev[column3-3][row3+3] == 'e' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V+=0;

				if (ev[column3][row3] == 'A' )
	    			 if (ev[column3-1][row3+1] == 'A' )
	    				 if (ev[column3-2][row3+2] == 'A' )
	    					 if (ev[column3-3][row3+3] == 'A' )
	    						 V-=1000;
	    					 else
	    						 V-=100;
	    				 else
							 V-=10;
	    			 else
	    				 V--;

				if (ev[column3][row3] == 'A' )
	    			 if (ev[column3-1][row3+1] != 'B' )
	    				 if (ev[column3-2][row3+2] != 'B' )
	    					 if (ev[column3-3][row3+3] != 'B' )
	    						 V-=15;
	    					 else
	    						 V-=10;
	    				 else
							 V-=5;
	    			 else
	    				 V+=0;

				if (ev[column3][row3] == 'e' )
	    			 if (ev[column3-1][row3+1] != 'A' )
	    				 if (ev[column3-2][row3+2] != 'A' )
	    					 if (ev[column3-3][row3+3] != 'A' )
	    						 V+=15;
	    					 else
	    						 V+=10;
	    				 else
							 V+=5;
	    			 else
	    				 V++;

	  }

	      }
	    }

	return V;
	   }
    }


    public int MiniMax(char[][] currentGrid , int depth)
    {
        //intilazing the tree
        State rootNode = new State(currentGrid);
        counter=0;
        
        //this is the start of the minimax algorithem

        System.out.println("AI: MiniMax Start");
        int v =maxValue(rootNode, 0 , 1 , depth);

        //if the program reaches this point the MiniMax Algorithem is done
        System.out.printf("AI: MiniMax, best move value is %d. \n", v);

        //now we search for the Action with the Value=v.

        for(int Action=0 ; Action<8 ; Action++) // we are seaching for the best move.
        {
            //if(rootNode.child[Action].value == null)
          //  {

              if(!isColumnFull(rootNode.state,Action))
              {
                    if(v == rootNode.child[Action].value)
                    {    //by comparing the v we got with values already saved in nodes
                       //System.out.printf("\n Best Action=%d \n ", Action);
                       Display(rootNode.state);
                       System.out.println("Number of Nodes="+counter);
                       return Action;//to get the best Action
                    }


             }
        }

            System.out.println("AI:Hey. ehm .. program return -1 at line 59, which means your program sucks.");
            return -1; // the program will not reach this place unless there is something seriously wrong with it.
    }



    private int maxValue(State currentState , int depth , int player , int maxDepth)
    {
      boolean winState=hasWon(currentState.state);
      if(depth==maxDepth || winState )
      {
         if(winState)
        {
            //Display(currentState.state);
           // System.out.println("Win State has been evaluated");
        } 
        currentState.value= currentState.evaluate(currentState.state);
       // System.out.printf("Maximum Depth Reached Value of the Node is %d \n", currentState.value);
        currentState.state=null;
        return currentState.value;
      }

       for(int i=0; i<8 ;i++)// to loop Childern
       {
          //make the move
           if(!isColumnFull(currentState.state,i))
           {
               char target[][] = new char[currentState.state.length][0];

                for (int j = 0; j < currentState.state.length ; j++)
                {
                target[j] = new char[currentState.state[j].length];
                System.arraycopy(currentState.state[j], 0, target[j], 0, target[j].length);
                }

               
                currentState.child[i]=new State(target);
                play(currentState.child[i].state , computer , i);
                currentState.value= max(currentState.value, miniValue(currentState.child[i] , depth+1 , 2 , maxDepth)) ; // we compare the values
                
           }
        }
        return currentState.value;
    }

    private int miniValue(State currentState , int depth , int player , int maxDepth)
    {
      boolean winState=hasWon(currentState.state);
      if(depth==maxDepth  || winState  )
      {
        if(winState)
        {
            //Display(currentState.state);
          //  System.out.println("Win State has been evaluated");
        } 
        currentState.value= currentState.evaluate(currentState.state);
       // System.out.printf("Maximum Depth Reached Value of the Node is %d \n", currentState.value);
        return currentState.value;
      }

       for(int i=0; i<8 ;i++)// to loop Childern
       {
          //make the move
           if(!isColumnFull(currentState.state,i))
           {
                char target[][] = new char[currentState.state.length][0];

                for (int j = 0; j < currentState.state.length ; j++)
                {
                    target[j] = new char[currentState.state[j].length];
                    System.arraycopy(currentState.state[j], 0, target[j], 0, target[j].length);
                }

                currentState.child[i]=new State(target);
                play(currentState.child[i].state , me , i);
                currentState.value= min(currentState.value,maxValue(currentState.child[i] , depth+1 , 1 , maxDepth)) ; // we compare the values

           }

       }

        //if(!(currentState.value==null))
            return currentState.value;
       
    }



    int max(Integer x, Integer y) // max
    {
        if(x==null)return y;
        if(y==null)return x;
        if(x>y)
            return x;
        else
            return y;
    }

    int min(Integer x, Integer y) // min
    {
        if(x==null)return y;
        if(y==null)return x;

        if(x<y)
            return x;
        else
            return y;
    }

    boolean isColumnFull(char[][] grid ,int column)
    {
        for(int i=0 ; i<8 ; i++)  // i am smart
		{
			if(grid[i][column] == 'e')
				return false;      // check if there is one empty slot we will return false
		}
		return true; // the test fails
    }

    void play(char[][] grid ,Player p, int column)
    {
        for(int i=7 ; 0 <= i ; i--)
		{
			if(grid[i][column] == 'e')
			{
				grid[i][column]= p.getSign();
                                return;// will put player name in the nearest slot
			}

		}
    }

    public void Display(char[][] game) // To display the Grid on the Screen
	{
		for(int y=0 ; y<8 ; y++)
                    System.out.printf("--**");

                System.out.printf("\n");
                for(int i=0 ; i<8  ; i++)
		{
			for(int j=0 ; j< 8 ; j++)
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

    public boolean hasWon(char game[][])
{
        boolean status = false;
	int size= 8;

    //Display(game);
    // check for a horizontal win
    for (int row=0; row<size; row++)
    {
      for (int column=0; column<size-3; column++)
      {
        if (game[column][row] != 'e' &&
        		game[column][row] == game[column+1][row] &&
        		game[column][row] == game[column+2][row] &&
        		game[column][row] == game[column+3][row])
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
        if (game[column1][row1] != 'e' &&
        		game[column1][row1] == game[column1][row1+1] &&
        		game[column1][row1] == game[column1][row1+2] &&
        		game[column1][row1] == game[column1][row1+3])
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
        if (game[column2][row2] != 'e' &&
        		game[column2][row2] == game[column2+1][row2+1] &&
        		game[column2][row2] == game[column2+2][row2+2] &&
        		game[column2][row2] == game[column2+3][row2+3])
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
        if (game[column3][row3] != 'e' &&
        		game[column3][row3] == game[column3+1][row3-1] &&
        		game[column3][row3] == game[column3+2][row3-2] &&
        		game[column3][row3] == game[column3+3][row3-3])
	        {
	          status = true;
	        }
      }
    }

    return status;
   }


    //Al tocar la interfaz para incluir la funcionalidad de introducir
    //dificultad y algoritmo, se ha incluido esta funcion auxiliar
	@Override
	public Player getComputer() {
		return computer;
	}
}




