
public class Board {
	Piece[][] tiles = new Piece[3][3];
	boolean playerturn;
	
	Board() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = new Piece(2);
			}
		}
		playerturn = true;
	}
	
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
	
	public void clearBoard() {
		System.out.flush();
	}
	
	public void insertPiece(int x, int y, int player) {
		tiles[y][x].set(player);
	}
	
	public char getPiece(int x, int y) {
		return tiles[y][x].get();
	}
	
	public boolean checkGameOver() {
		return (checkWin() || checkDraw());
	}
	
	boolean checkWin() {
		for (int x = 0; x < 3; x++) {
			if (tiles[x][0].get() == tiles[x][1].get() && tiles[x][1].get() == tiles[x][2].get()
					&& !tiles[x][0].is_empty()) {
				return true;
			}
		}
		for (int y = 0; y < 3; y++) {
			if (tiles[0][y].get() == tiles[1][y].get() && tiles[1][y].get() == tiles[2][y].get()
					&& !tiles[0][y].is_empty()) {
				return true;
			}
		}
		if (tiles[0][0].get() == tiles[1][1].get() && tiles[1][1].get() == tiles[2][2].get()
				&& !tiles[0][0].is_empty()) {
			return true;
		}
		if (tiles[2][0].get() == tiles[1][1].get() && tiles[1][1].get() == tiles[0][2].get()
				&& !tiles[2][0].is_empty()) {
			return true;
		}
		return false;
	}
	
	char checkWinner() {
		for (int x = 0; x < 3; x++) {
			if (tiles[x][0].get() == tiles[x][1].get() && tiles[x][1].get() == tiles[x][2].get()
					&& !tiles[x][0].is_empty()) {
				return tiles[x][0].get();
			}
		}
		for (int y = 0; y < 3; y++) {
			if (tiles[0][y].get() == tiles[1][y].get() && tiles[1][y].get() == tiles[2][y].get()
					&& !tiles[0][y].is_empty()) {
				return tiles[0][y].get();
			}
		}
		if (tiles[0][0].get() == tiles[1][1].get() && tiles[1][1].get() == tiles[2][2].get()
				&& !tiles[0][0].is_empty()) {
			return tiles[0][0].get();
		}
		if (tiles[2][0].get() == tiles[1][1].get() && tiles[1][1].get() == tiles[0][2].get()
				&& !tiles[2][0].is_empty()) {
			return tiles[2][0].get();
		}
		return 'n';
	}
	
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
	public boolean getPlayer() {
		return playerturn;
	}
	
	public void switchPlayer() {
		if(playerturn) {
			playerturn = false;
		}
		else playerturn = true;
	}
	
	public boolean validMove(int x, int y) {
		if (tiles[y][x].is_empty()) {
			return true;
		}
		else {
			System.out.println("Piece already taken!");
			return false;
		}
	}
	
}
