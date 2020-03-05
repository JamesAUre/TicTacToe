public class Piece {
	
	//Piece attribute
	char piece_value;
	
	//Constructor
	Piece(int piece){
		set(piece);
	}
	
	//Mutator for value attribute
	void set(int piece) {
		if(piece == 0) {
			piece_value = 'O';
		}
		else if(piece == 1) {
			piece_value = 'X';
		}
		else piece_value = ' ';
	}
	
	//Accessor for piece value
	char get() {
		return piece_value;
	}
	
	//Checks to see if piece has a player value
	boolean is_empty() {
		if (piece_value == ' ') {
			return true;
		}
		else return false;
	}
}
