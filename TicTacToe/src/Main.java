import java.util.Scanner;
public class Main {
	public static void main(String args[]) {
		game();
	}
	
	static void game(){
		Board board = new Board();
		Scanner userPiece = new Scanner(System.in);
		int x=0;
		int y=0;
		while (!board.checkGameOver()) {
			if(board.getPlayer()) {
				do {
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
					System.out.println("X turn");
					System.out.print("enter x: ");
					x = userPiece.nextInt() - 1;
					System.out.print("enter y: ");
					y = userPiece.nextInt() - 1;
				} while (!board.validMove(x, y));
				board.insertPiece(x, y, 1);
			}
			
			board.displayBoard();
			board.switchPlayer();
		}
		System.out.println("GAME FINISHED!");
		System.out.println("Winner is: " + board.checkWinner());
	}
	
	static void turn(boolean turn) {
		if(turn) {
			
		}
	}
}