package com.kotprog.kotprog.osztalyaim;

import com.kotprog.kotprog.osztalyaim.Alaposztaly;

public class Ijasz extends Alaposztaly {
    public String specialisKepesseg;


    public Ijasz(int sebzes, int eletero, int sebesseg, int kezdemenyezes, String specialisKepesseg) {
        super(sebzes, eletero, sebesseg, kezdemenyezes);
        this.specialisKepesseg=specialisKepesseg;

    }

    @Override

    public int tamad() {
        return super.tamad();
    }
}
