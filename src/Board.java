
public class Board{
	
	private int x;
	private int y;
	private String mark;
	private String[][] matrix = new String [3][3];
	
	public Board(){
		super();
		int counter =0;
		for(int y = 0; y <= 2; y++){
			for(int x = 0; x <= 2; x++){
				matrix[x][y] = null;
				counter++;
				//System.out.println("X: " + x + " Y: " + y + " Wert: " + matrix[x][y] + counter);
			}
		} 
	}
	
	public void setMark(String mark, int x, int y) throws InvalidPositionException {
		

		if ((mark == "X" || mark == "O") && (x >= 0 && x <= 2) && (y >= 0 && y <= 2)){		
			this.mark = mark;
			this.x = x;
			this.y = y;
			
			matrix[x][y] = mark;
		}
		else{
			throw new InvalidPositionException();
		}
		
	}
	
	public boolean hasWinner(){
		boolean result = false;
		int counterX = 0;
		int counterO = 0;

		//Durchlauf für y Achse
		for(int y = 0; y <= 2; y++){
			//Durchlauf für x Achse
			for(int x = 0; x <= 2; x++){
				if (matrix[x][y] == "X"){
					counterX++;
					System.out.println("X: " + x + " Y: " + y + " Wert: " + matrix[x][y]);
					System.out.println("CounterX: " + counterX);
				}
				else if (matrix[x][y] == "O"){
					counterO++;
					System.out.println("X: " + x + " Y: " + y + " Wert: " + matrix[x][y]);
					System.out.println("CounterO: " + counterO);
				}
				else{
					//Nichts tun
				}
				
				//Überprüfen ob irgendeine Reihe 3 richtige hat
				if (counterX == 3 || counterO == 3){
					System.out.println("Gewonnen: " + "CounterO: " + counterO + " ,CounterX: " + counterX);
					result = true;

					break; //Schleife beenden da ein Sieger gefunden wurde
				}
				
			}
			counterO = 0;	//Zurücksetzen für nächste Runde
			counterX = 0;
		}
		
			
			

		return result;
	}
}