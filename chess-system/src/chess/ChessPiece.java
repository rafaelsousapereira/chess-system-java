package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {

	private Color color;
	private int moveCount;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public int getMoveCount() {
		return moveCount;
	}
	
	/**
	 * incrementa o atributo moveCount
	 */
	public void increaseMoveCount() {
		moveCount++;
	}
	
	/**
	 * decrementa o atributo moveCount
	 */
	public void decreaseMoveCount() {
		moveCount--;
	}

	/**
	 * @return converte posi��o (position) de matriz para posi��o de xadrez
	 *         (ChessPosition)
	 */
	public ChessPosition getChessPosition() {
		return ChessPosition.fromPosition(position);
	}

	/**
	 * @param position verifica se existe uma pe�a adversaria na posi��o
	 * @return caso p (pe�a adversario) for nulo e p.getColor for diferente da cor
	 *         da pe�a do jogador
	 */
	protected boolean isThereOpponentPiece(Position position) {
		ChessPiece p = (ChessPiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

}
