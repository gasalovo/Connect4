//Interfaz que debe cumplir cualquier clase AI
public interface AI {
	public int MiniMax(char[][] currentGrid , int depth);
	
	//Al tocar la interfaz para incluir la funcionalidad de introducir
    //dificultad y algoritmo, se ha incluido esta funcion auxiliar en la interfaz
	public Player getComputer();
}
