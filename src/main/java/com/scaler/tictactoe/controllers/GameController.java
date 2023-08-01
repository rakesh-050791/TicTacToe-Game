package com.scaler.tictactoe.controllers;

import com.scaler.tictactoe.models.Game;
import com.scaler.tictactoe.models.GameStatus;
import com.scaler.tictactoe.models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        try {
            return Game.getBuilder()
                    .setPlayers(players)
                    .setDimension(dimension)
                    .build();
        } catch (Exception e){
            return null;
        }
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void executeNextMove(Game game){
        game.makeNextMove();
    }

    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
}
