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
		Scanner userPiece = new Scanner(System.in);
		int x=0;
		int y=0;
		
		//game loop for turns
		while (!board.checkGameOver()) {
			if(board.getPlayer()) {
				do {
					//player1 interface
					System.out.println("O turn");
					System.out.print("enter x: ");
					x = userPiece.nextInt() - 1;
					System.out.print("enter y: ");
					y = userPiece.nextInt() - 1;
				} while (!board.validMove(x, y));
				board.insertPiece(x, y, 0);
			}
			else {
				do {
					//player2 interface
					System.out.println("X turn");
					System.out.print("enter x: ");
					x = userPiece.nextInt() - 1;
					System.out.print("enter y: ");
					y = userPiece.nextInt() - 1;
				} while (!board.validMove(x, y));
				board.insertPiece(x, y, 1);
			}
			
			//both players interface
			board.displayBoard();
			board.switchPlayer();
		}
		
		//exit interface
		System.out.println("GAME FINISHED!");
		System.out.println("Winner is: " + board.checkWinner());
	}
}