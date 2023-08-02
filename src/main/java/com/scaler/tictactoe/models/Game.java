package com.scaler.tictactoe.models;

import java.util.List;
import java.util.ArrayList;
import com.scaler.tictactoe.exceptions.InvalidGameBuildException;
import com.scaler.tictactoe.strategies.gamewinningstrategy.GameWinningStrategy;
import com.scaler.tictactoe.strategies.gamewinningstrategy.OrderOneWinningStrategy;

public class Game {
    private Board board;
    private List<Player> players;
    private GameStatus gameStatus;
    private List<Move> moves;
    private int nextPlayerIndex;
    private Player winner;
    private GameWinningStrategy gameWinningStrategy;

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public void displayBoard(){
        this.board.display();
    }

    public void makeNextMove(){
        Player playerToMove = players.get(nextPlayerIndex);

        System.out.println("It is" + playerToMove.getName() + "'s turn.");

        Move move = playerToMove.decideMove(this.board);

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        System.out.println("Player is playing a move at (" + row +", " + col + ")");

        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(playerToMove);

        // Add the current move to the list of moves.
        this.moves.add(move);

        // Check for winner
        if (gameWinningStrategy.checkWinner(board, playerToMove, move.getCell())){
            this.setGameStatus(GameStatus.ENDED);
            winner = playerToMove;
        }

        // Check for draw
        // TBD

        // Go to next player
        nextPlayerIndex += 1;
        nextPlayerIndex %= players.size();
    }

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        int dimension;
        List<Player> players;

        public int getDimension() {
            return dimension;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }


        public Game build() throws InvalidGameBuildException{
            Game game = new Game();
            game.setBoard(new Board(dimension));
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOneWinningStrategy(dimension));
            return game;
        }
    }
}

