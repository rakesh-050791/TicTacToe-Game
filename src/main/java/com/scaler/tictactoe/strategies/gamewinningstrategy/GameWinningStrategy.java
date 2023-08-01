package com.scaler.tictactoe.strategies.gamewinningstrategy;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Player;
import com.scaler.tictactoe.models.Cell;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;


public interface GameWinningStrategy {
    boolean checkWinner(Board board, Player player, Cell cell);
}
