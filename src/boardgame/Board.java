package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece [][] pieces;
	
	public Board(int rows, int columns) {
		if (rows<1 || columns<1) {
			throw new BoardException("ERRO!!! O tabuleiro deve ter pelo menos 1 linha e 1 coluna");
			
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece [rows][columns];
		
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece (int row, int column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Esta posi��o n�o existe no tabuleiro");
		}
		return pieces [row][column];
	}
	
	
	public Piece piece(Position position) {
		
		if (!positionExists (position)) {
			throw new BoardException("Esta posi��o n�o existe no tabuleiro");
		}
		
		return pieces [position.getRow()][position.getColumn()];
	}
	
	public void placePiece (Piece piece, Position position) {
		if(therIsAPiece(position)) {
			throw new BoardException("J� existe uma pe�a nessa posi��o (" + position +")");
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
		
	}
	
	private boolean positionExists(int row, int column) {
		return row >= 0 && row < rows && column >= 0 && column < columns;
		
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean therIsAPiece (Position position) {
		if (!positionExists (position)) {
			throw new BoardException("Esta posi��o n�o existe no tabuleiro");
		}		
		return piece(position) !=null;
	}
	

}
