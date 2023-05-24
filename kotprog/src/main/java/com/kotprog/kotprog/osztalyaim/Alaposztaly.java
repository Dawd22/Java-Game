package com.kotprog.kotprog.osztalyaim;

public class Alaposztaly {
    public int sebzes;
    public int eletero;
    public int sebesseg;
    public int kezdemenyezes;

    public Alaposztaly(int sebzes, int eletero, int sebesseg, int kezdemenyezes) {
        this.sebzes = sebzes;
        this.eletero = eletero;
        this.sebesseg = sebesseg;
        this.kezdemenyezes = kezdemenyezes;
    }
    public int tamad(){
        return sebzes;
    }

}
