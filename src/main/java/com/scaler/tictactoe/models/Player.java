package com.scaler.tictactoe.models;

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
}
