public class Piece {
	char piece_value;
	Piece(int piece){
		set(piece);
	}
	
	void set(int piece) {
		if(piece == 0) {
			piece_value = 'O';
		}
		else if(piece == 1) {
			piece_value = 'X';
		}
		else piece_value = ' ';
	}
	char get() {
		return piece_value;
	}
	boolean is_empty() {
		if (piece_value == ' ') {
			return true;
		}
		else return false;
	}
}
