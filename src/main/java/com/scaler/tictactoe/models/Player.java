package com.scaler.tictactoe.models;

import java.util.Scanner;

public class Player {
   
    private String name;
    private char symbol;
    private PlayerType type;

    public Player(String name, char symbol, PlayerType type){
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public Move decideMove(Board board){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter row for the move : ");
        int row = scanner.nextInt();

        System.out.println("Please enter col for the move : ");
        int col = scanner.nextInt();

        return new Move(this, new Cell(this, row, col, CellState.FILLED));
    }
}
