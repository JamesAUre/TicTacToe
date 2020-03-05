//Imports
import java.util.Scanner;

//Main
public class Main {
	public static void main(String args[]) {
		game(); //don't want to keep code in main
	}
	
	//Game backbone function
	static void game(){
		Board board = new Board();
		Location insert_loc = new Location();
		
		//game loop for turns
		while (!board.checkGameOver()) {
			if(board.getPlayer()) {
				System.out.println("O turn");
				insert_loc = getMove(board);
				board.insertPiece(insert_loc.getX(), insert_loc.getY(), 0);
	
			}
			else {
				System.out.println("X turn");
				insert_loc = getMove(board);
				board.insertPiece(insert_loc.getX(), insert_loc.getY(), 1);
			}
			
			//both players interface
			board.displayBoard();
			board.switchPlayer();
		}
		
		//exit interface
		System.out.println("GAME FINISHED!");
		System.out.println("Winner is: " + board.checkWinner());
	}
	
	//Handles each turn of the user
	static Location getMove(Board currentboard) {
		
		//all the data I need
		Location loc = new Location();
		Scanner user_piece = new Scanner(System.in);
		int x=0;
		int y=0;
		
		//getting x and y coordinate until coordinate is empty
		do {
			System.out.print("enter x: ");
			x = user_piece.nextInt() - 1;
			System.out.print("enter y: ");
			y = user_piece.nextInt() - 1;
		} while(!currentboard.validMove(x, y));
		
		//storing it as a location and returning
		loc.set(x, y);
		return loc;
	}
}