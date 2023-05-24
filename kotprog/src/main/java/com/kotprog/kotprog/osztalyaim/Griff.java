package com.kotprog.kotprog.osztalyaim;

public class Griff extends Alaposztaly{
    public String specialisKepesseg;


    public Griff(int sebzes, int eletero, int sebesseg, int kezdemenyezes, String specialisKepesseg) {
        super(sebzes, eletero, sebesseg, kezdemenyezes);
        this.specialisKepesseg=specialisKepesseg;
    }

    @Override
    public int tamad() {
        return super.tamad();
    }
}
