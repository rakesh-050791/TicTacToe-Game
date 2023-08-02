package com.scaler.tictactoe;

import java.util.Scanner;

import com.scaler.tictactoe.controllers.GameController;
import com.scaler.tictactoe.models.Game;
import com.scaler.tictactoe.models.GameStatus;
import com.scaler.tictactoe.models.Player;
import com.scaler.tictactoe.models.PlayerType;

import java.util.ArrayList;
import java.util.List;

public class TTTGame {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       System.out.println("Please enter the board dimensions");
       
       int dimension = scanner.nextInt();

       int noOfHumanPlayersAllowed = dimension - 1;

       List<Player> players = new ArrayList<>();

       for(int i = 0; i<noOfHumanPlayersAllowed; i++){
            System.out.println("Enter the name of the player: " + (i+1) );
            String name = scanner.next();

            System.out.println("Enter the symbol for player: " + (i+1));
            String symbol = scanner.next();

            Player player = new Player(name, symbol.charAt(0), PlayerType.HUMAN);
            players.add(player);
       }

       // System.out.println("List of Players = " + players.get(0).getName());

        GameController gameController = new GameController();
        Game game = gameController.createGame(dimension, players);

        // Players will start playing the game now

        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            System.out.println("This is the current board : ");
            gameController.displayBoard(game);

            gameController.executeNextMove(game);
        }

        System.out.println("Game has Ended");
        if (game.getGameStatus().equals(GameStatus.ENDED)){
            System.out.println("Winner is " + gameController.getWinner(game).getName());
        }

    }
}