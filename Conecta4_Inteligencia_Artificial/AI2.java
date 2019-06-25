//Algoritmo minimax alfa-beta
public class AI2 implements AI {

    Integer Alpha=-999999999; //simula menos infinito
    Integer Beta=+999999999; //simula mas infinito
    static int counter=0; //para llevar la cuenta de los nodos
    Player computer= new Player('B'); // ordenador
    Player me= new Player('A');       // humano
    
    //un estado representa un tablero y puede tener hasta 8 hijos
    class State
    {
        //CLASS STATE
        Integer value=null; // columna anterior  ; -1 es el valor de la raiz
        char[][] state= new char[8][];
        State child[]; // array de estados de los hijos
        
        State(char[][] src)
        {
           for (int i = 0; i < src.length ; i++)
            {
                state[i] = new char[src[i].length];
                System.arraycopy(src[i], 0, state[i], 0, state[i].length);
            }
            
            child=new State[8];
            counter++;
        }

    //funcion de evaluacion de un estado
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



	//comprueba las horizontales, puntuando 1000 a 4 en raya, 100 a 3 en raya
	//10 a 2 en raya y 1 si esta sola. En caso de ser el contrario, resta esa cantidad.
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

	//comprueba verticales
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


	//Comprueba diagonales (pendiente positiva)
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



	//comprueba diagonales (pendiente negativa)
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
        //Inicializa el arbol
        State rootNode = new State(currentGrid);
        counter=0;
        
        //Comienzo del algoritmo
        System.out.println("AI: MiniMax Alpha Beta Start");
        int v =maxValue(rootNode,depth ,Alpha , Beta);

        //Llegado a este punto, el algoritmo ha acabado
        System.out.printf("AI: MiniMax Alpha Beta, el mejor valor es %d. \n", v);

        //Buscamos el mejor movimiento Value=v.
        for(int Action=0 ; Action<8 ; Action++) //De los 8 posibles movimentos
        {
        	  //Si la columna no esta llena el movimiento es posible
              if(!isColumnFull(rootNode.state,Action))
              {
                    if(v == rootNode.child[Action].value)
                    {  
                       Display(rootNode.state);
                       System.out.println("Number of Nodes = "+counter);
                       return Action;//mejor movimiento
                    }


             }
        }
        	//Teoricamente no es posible ejecutar este código
            System.out.println("AI:Hey. ehm .. program return -1 at line 59, which means your program sucks.");
            return -1; // the program will not reach this place unless there is something seriously wrong with it.
    }


    //Primera funcion recursiva que evalua los nodos max
    private int maxValue(State currentState , int depth , int Alpha , int Beta)
    {
      //Lo primero que se mira es si es un nodo meta
      //Si es un nodo final con la función hasWon o si se ha alcanzado la profundidad maxima
      //que en nuestro caso es decreciente
      boolean winState=hasWon(currentState.state);
      if(depth==0 || winState )
      {
         if(winState)
        {
  
        } 
        currentState.value= currentState.evaluate(currentState.state);
        currentState.state=null;
        return currentState.value;
      }
       for(int i=0; i<8 ;i++)// Iteramos los hijos
       {
          //Probamos todos los movimientos legales
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
                //Para este hijo, se llama la funcion que evalua los nodos minimos
                //Se le pasan los valores de alfa y beta actuales, el tablero y la profundidad menos uno
                currentState.value= max(currentState.value, miniValue(currentState.child[i] , depth-1 , Alpha , Beta));
                //Esta parte es la comprobacion de si seguimos explorando o esa rama puede ser descartada
                if(currentState.value >= Beta)
                {
                //Si llegamos a este punto es porque hemos podado una rama
                    return currentState.value;
                }
                //Como es un nodo max, se coje el mayor de los valores
                Alpha=max(Alpha , currentState.value);
           }
        }
        return currentState.value;
    }
    
    //Segunda función recursiva que evalua los nodos min
    private int miniValue(State currentState , int depth , int Alpha , int Beta)
    {
      boolean winState=hasWon(currentState.state);
      if(depth==0  || winState  )
      {
        if(winState)
        {
        } 
        currentState.value= currentState.evaluate(currentState.state);
        return currentState.value;
      }

       for(int i=0; i<8 ;i++)// Iteramos los hijos
       {
          //Probamos todos los movimientos legales
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
                currentState.value= min(currentState.value,maxValue(currentState.child[i] , depth-1 , Alpha , Beta)) ; // we compare the values

              //Esta parte es la comprobacion de si seguimos explorando o esa rama puede ser descartada
                if(currentState.value <= Alpha)
                {
                	//Si llegamos a este punto es porque hemos podado una rama
                    return currentState.value;
                }
                
                //Como es un nodo min, se coje el menor de los valores
                Beta=min(Beta , currentState.value);
           }

       }

            return currentState.value;
       
    }



    int max(Integer x, Integer y) // funcion auxiliar max
    {
        if(x==null)return y;
        if(y==null)return x;
        if(x>y)
            return x;
        else
            return y;
    }

    int min(Integer x, Integer y) // funcion auxiliar min
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
        for(int i=0 ; i<8 ; i++)
		{
			if(grid[i][column] == 'e')
				return false;      //La columna no esta llena
		}
		return true; //La columna esta llena
    }

    void play(char[][] grid ,Player p, int column)
    {
        for(int i=7 ; 0 <= i ; i--)
		{
			if(grid[i][column] == 'e')
			{
				grid[i][column]= p.getSign();
                return;
			}

		}
    }
    //Funcion para mostrar las fichas en la pantalla
    public void Display(char[][] game)
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


    //Se comprueba si se gana por 4 en raya horizontal
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

    //Se comprueba si se gana por 4 en raya vertical
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


    //Se comprueba si se gana por 4 en raya diagonal (pendiente positiva)
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



    //Se comprueba si se gana por 4 en raya diagonal (pendiente negativa)
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




