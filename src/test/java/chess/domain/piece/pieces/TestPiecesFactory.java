package chess.domain.piece.pieces;

import chess.domain.piece.TestPieceFactory;
import chess.domain.position.Position;
import chess.domain.piece.Color;
import chess.domain.piece.Piece;

import java.util.ArrayList;
import java.util.List;

public class TestPiecesFactory {
	public static Pieces of(List<Position> positions) {
		List<Piece> pieces = new ArrayList<>();

		for (Position position : positions) {
			pieces.add(TestPieceFactory.createRook(position, Color.WHITE));
		}
		return new Pieces(pieces);
	}

	public static Pieces of(List<Position> positions, Color color) {
		List<Piece> pieces = new ArrayList<>();

		for (Position position : positions) {
			pieces.add(TestPieceFactory.createRook(position, color));
		}
		return new Pieces(pieces);
	}

	public static Pieces createBy(List<Piece> inputPieces) {
		List<Piece> pieces = new ArrayList<>(inputPieces);
		return new Pieces(pieces);
	}
}
