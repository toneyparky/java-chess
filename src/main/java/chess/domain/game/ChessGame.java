package chess.domain.game;

import chess.domain.position.Position;
import chess.domain.piece.Color;
import chess.domain.piece.pieces.Pieces;
import chess.domain.piece.pieces.PiecesFactory;

public class ChessGame {
	private final Pieces pieces;
	private Turn turn;

	public ChessGame() {
		pieces = PiecesFactory.of();
		turn = new Turn(Color.WHITE);
	}

	public void move(Position start, Position end) {
		pieces.move(start, end, turn.getColor());
		turn = turn.change();
	}

	public ScoreResult calculateScore() {
		return new ScoreResult(pieces);
	}

	public boolean isKingDead() {
		return pieces.isKingDead();
	}

	public Color getAliveKingColor() {
		return pieces.getAliveKingColor();
	}

	public Board createBoard() {
		return new Board(pieces);
	}
}
