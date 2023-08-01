package com.scaler.tictactoe.strategies.gamewinningstrategy;

import com.scaler.tictactoe.models.Board;
import com.scaler.tictactoe.models.Player;
import com.scaler.tictactoe.models.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class OrderOneWinningStrategy implements GameWinningStrategy{

    @Override
    public boolean checkWinner(Board board, Player player, Cell cell) {
        return false;
    }
}
