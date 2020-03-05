
public class Board {
	//Board attributes
	Piece[][] tiles = new Piece[3][3];
	boolean playerturn;
	
	//Constructor
	Board() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				//Set all pieces to blank
				tiles[i][j] = new Piece(2);
			}
		}
		
		//set player turn
		playerturn = true;
	}
	
	//Various print statements for user interface
	public void displayBoard(){
		System.out.println("----------");
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print("| " + tiles[i][j].get());
			}
			System.out.println("|");
			System.out.println("----------");
		}
	}
	
	//Sets all tiles on board to blank
	public void clearBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j].set(2);
			}
		}
	}
	
	//Inserts piece value onto board
	public void insertPiece(Location loc, int player) {
		tiles[loc.y][loc.x].set(player);
	}
	
	//Gets piece value from board
	public char getPiece(Location loc) {
		return tiles[loc.y][loc.x].get();
	}
	
	//Checks to see if game must stop
	public boolean checkGameOver() {
		return (checkWin() || checkDraw());
	}
	
	//Checks to see if player won
	boolean checkWin() {
		
		//horizontal
		for (int x = 0; x < 3; x++) {
			if (tiles[x][0].get() == tiles[x][1].get() && tiles[x][1].get() == tiles[x][2].get()
					&& !tiles[x][0].is_empty()) {
				return true;
			}
		}
		
		//vertical
		for (int y = 0; y < 3; y++) {
			if (tiles[0][y].get() == tiles[1][y].get() && tiles[1][y].get() == tiles[2][y].get()
					&& !tiles[0][y].is_empty()) {
				return true;
			}
		}
		
		//diagonal
		if (tiles[0][0].get() == tiles[1][1].get() && tiles[1][1].get() == tiles[2][2].get()
				&& !tiles[0][0].is_empty()) {
			return true;
		}
		if (tiles[2][0].get() == tiles[1][1].get() && tiles[1][1].get() == tiles[0][2].get()
				&& !tiles[2][0].is_empty()) {
			return true;
		}
		
		//no win condition met
		return false;
	}
	
	//Checks to see which player won
	char checkWinner() {
		
		//horizontal
		for (int x = 0; x < 3; x++) {
			if (tiles[x][0].get() == tiles[x][1].get() && tiles[x][1].get() == tiles[x][2].get()
					&& !tiles[x][0].is_empty()) {
				return tiles[x][0].get();
			}
		}
		
		//vertical
		for (int y = 0; y < 3; y++) {
			if (tiles[0][y].get() == tiles[1][y].get() && tiles[1][y].get() == tiles[2][y].get()
					&& !tiles[0][y].is_empty()) {
				return tiles[0][y].get();
			}
		}
		
		//diagonal
		if (tiles[0][0].get() == tiles[1][1].get() && tiles[1][1].get() == tiles[2][2].get()
				&& !tiles[0][0].is_empty()) {
			return tiles[0][0].get();
		}
		if (tiles[2][0].get() == tiles[1][1].get() && tiles[1][1].get() == tiles[0][2].get()
				&& !tiles[2][0].is_empty()) {
			return tiles[2][0].get();
		}
		
		//should only return if function was called with no winner
		return 'n';
	}
	
	//Checks to see if all pieces are occupied by a player
	boolean checkDraw() {
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y ++) {
				if (tiles[y][x].is_empty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	//Accessor for current player
	public boolean getPlayer() {
		return playerturn;
	}
	
	//Switches current player for turns
	public void switchPlayer() {
		if(playerturn) {
			playerturn = false;
		}
		else playerturn = true;
	}
	
	//Checks to see if a piece may be occupied by player
	public boolean validMove(Location loc) {
		if (tiles[loc.y][loc.x].is_empty()) {
			return true;
		}
		else {
			System.out.println("Piece already taken!");
			return false;
		}
	}
	
}
