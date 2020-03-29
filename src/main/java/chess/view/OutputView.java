package chess.view;

import chess.domain.game.Board;
import chess.domain.position.PositionFactory;
import chess.domain.position.Column;
import chess.domain.position.Position;
import chess.domain.position.Row;
import chess.domain.game.ScoreResult;
import chess.domain.piece.Color;

public class OutputView {
	private static final String OPERATIONS_MESSAGE = String.join("\n",
			"> 체스 게임을 시작합니다. ",
			"> 게임 시작 : start",
			"> 게임 종료 : end",
			"> 게임 이동 : move source위치 target위치 - 예. move b2 b3",
			"> 점수 확인 : status");

	public static void printOperationsFormat() {
		System.out.println(OPERATIONS_MESSAGE);
	}

	public static void printBoard(Board board) {
		printEmptyLine();
		for (Column column : Column.values()) {
			System.out.println(printRowLine(board, column));
		}
		printEmptyLine();
	}

	private static String printRowLine(Board board, Column column) {
		StringBuilder rowLineStringBuilder = new StringBuilder();

		for (Row row : Row.values()) {
			Position position = PositionFactory.of(row, column);
			rowLineStringBuilder.append(board.getPieceBy(position).getResource());
		}
		return rowLineStringBuilder.toString();
	}

	public static void printFinishByKingDead(Color color) {
		System.out.println(color + "가 승리하였습니다.");
	}

	private static void printEmptyLine() {
		System.out.println("");
	}

	public static void printFinish() {
		System.out.println("체스 게임을 종료합니다.");
	}

	public static void printScore(ScoreResult scores) {
		printEmptyLine();
		for (Color color : scores.keySet()) {
			System.out.println(color + "의 점수는 " + scores.getScoreBy(color) + "점 입니다.");
		}
	}
}
