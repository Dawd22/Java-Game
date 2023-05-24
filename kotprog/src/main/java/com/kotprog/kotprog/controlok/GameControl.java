package com.kotprog.kotprog.controlok;

import com.kotprog.kotprog.vege.*;
import com.kotprog.kotprog.osztalyaim.Ijasz;
import com.kotprog.kotprog.osztalyaim.*;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.*;

/**
 * Az az osztály az egésznak az agya. Itt fut a játék, és itt lesz vége mindennek.
 * Maga a játék folyamatot is innen tudjuk elindítani, és ide áramol be az összes adat amit
 * vagy az könnyű/közepes/nehéz osztályokból gyűjtünk.
 */
public class GameControl {
    //Elérési útvonal a képekheu
    private final String gridem = "file:src/main/resources/com/kotprog/kotprog/img/game.jpg";
    private final String foldem = "file:src/main/resources/com/kotprog/kotprog/img/foldmuves.png";
    private final String ijaszom = "file:src/main/resources/com/kotprog/kotprog/img/archer.png";
    private final String griffem = "file:src/main/resources/com/kotprog/kotprog/img/griff.png";
    private final String lovagom = "file:src/main/resources/com/kotprog/kotprog/img/knight.png";
    private final String sarkanyom = "file:src/main/resources/com/kotprog/kotprog/img/dragon.png";
    private final String fireball = "file:src/main/resources/com/kotprog/kotprog/img/fireball.png";
    private final String lightning = "file:src/main/resources/com/kotprog/kotprog/img/lightning.png";
    private final String earthq = "file:src/main/resources/com/kotprog/kotprog/img/earth.png";
    private final String feltamaszt = "file:src/main/resources/com/kotprog/kotprog/img/jesus.png";
    private final String feleget = "file:src/main/resources/com/kotprog/kotprog/img/fire.png";
    private final String lock = "file:src/main/resources/com/kotprog/kotprog/img/lock.png";
    private final String kard = "file:src/main/resources/com/kotprog/kotprog/img/sword.png";
    @FXML
    //Kövi oldalak
    private Stage stage;
    private Scene scene;
    private Parent root;


    //Image
    Image gridre = new Image(gridem);
    Image foldesre = new Image(foldem);
    Image ijaszra = new Image(ijaszom);
    Image griffre = new Image(griffem);
    Image lovagra = new Image(lovagom);
    Image sarkanyra = new Image(sarkanyom);
    Image fireB = new Image(fireball);
    Image ligthn= new Image(lightning);
    Image earthquake = new Image(earthq);
    Image feltamasztom = new Image(feltamaszt);
    Image felegetem = new Image(feleget);
    Image lockScreen= new Image(lock);
    Image sword= new Image(kard);


    // circle
    public Circle circle_foldmuves;
    public Circle circle_ijasz;
    public Circle circle_griff;
    public Circle circle_lovag;
    public Circle circle_sarkany;
    public Circle kovetkezoEgyseg;
    public Circle realcircle_foldmuves;
    public Circle realcircle_ijasz;
    public Circle realcircle_griff;
    public Circle realcircle_lovag;
    public Circle realcircle_sarkany;
    public Circle AIcircle_foldmuves;
    public Circle AIcircle_ijasz;
    public Circle AIcircle_griff;
    public Circle AIcircle_lovag;
    public Circle AIcircle_sarkany;
    public Circle circle_tuzgolyo;
    public Circle circle_villamcsapas;
    public Circle circle_feltamasztas;
    public Circle circle_foldrenges;
    public Circle circle_felperzsel;
    public Circle hos_tamad;

    //table
    public GridPane grid;

    //button
    public Button elhelyez;
    public Button start;
    public Button win;
    public Button draw;
    public Button lose;
    //valtozo-k az elozo sceneből
    public int tamadas;
    public int tudas;
    public int defense;
    public int varazslat;
    public int moral;
    public int szerencse;
    public int foldmuvesdb;
    public int ijaszdb;
    public int griffdb;
    public int lovagdb;
    public int sarkanydb;
    public int villamdb;
    public int tuzgolyodb;
    public int felperzseldb;
    public int foldrengdb;
    public int feltamasztdb;
    public int mana;
    //AI

    public int aiTamadas;
    public int aiTudas;
    public int aiDefense;
    public int aiVarazslat;
    public int aiMoral;
    public int aiSzerencse;
    public int aiFoldmuvesdb;
    public int aiIjaszdb;
    public int aiGriffdb;
    public int aiLovagdb;
    public int aiSarkanydb;
    public int aiVillamdb;
    public int aiTuzgolyodb;
    public int aiFelperzseldb;
    public int aiFoldrengdb;
    public int aiFeltamasztdb;
    public int aiMana;
    //LABELS

    public Label kritel;
    public Label hosSebez;
    public Label aiSebez;
    public Label lable_tudas;
    public Label label_tamadas;
    public Label label_defense;
    public Label label_varazslat;
    public Label label_moral;
    public Label label_szerencse;
    public Label label_foldmuves;
    public Label label_ijasz;
    public Label label_griff;
    public Label label_lovag;
    public Label label_sarkany;
    public Label label_villam;
    public Label label_tuzgolyo;
    public Label label_felprezsel;
    public Label label_foldreng;
    public Label label_feltamaszt;
    public Label label_mana;
    public Label label_foldmuvesEletero;
    public Label label_ijaszEletero;
    public Label label_lovagEletero;
    public Label label_griffEletero;
    public Label label_sarkanyEletero;
    public Label label_AIfoldmuvesEletero;
    public Label label_AIijaszEletero;
    public Label label_AIlovagEletero;
    public Label label_AIgriffEletero;
    public Label label_AIsarkanyEletero;
    public Label kor; //Hanyadik körban vagyunk
    public Label aiLabeltudas;
    public Label aiLabeltamadas;
    public Label aiLabeldefense;
    public Label aiLabelvarazslat;
    public Label aiLabelmoral;
    public Label aiLabelszerencse;
    public Label aiLabelfoldmuves;
    public Label aiLabelijasz;
    public Label aiLabelgriff;
    public Label aiLabellovag;
    public Label aiLabelsarkany;
    public Label aiLabelvillam;
    public Label aiLabeltuzgolyo;
    public Label aiLabelfelprezsel;
    public Label aiLabelfoldreng;
    public Label aiLabelfeltamaszt;
    public Label aiLabelmana;

    //Kordinátákai
    int foldX;
    int foldY;
    int ijaszX;
    int ijaszY;
    int griffX;
    int griffY;
    int lovagX;
    int lovagY;
    int sarkanyX;
    int sarkanyY;
    //SEGÉD VÁLTOZÓK
    int aieredetifoldmuves;
    int aieredetiijasz;
    int aieredetigriff;
    int aieredetilovag;
    int aieredetisarkany;
    int eredetifoldmuves;
    int eredetiijasz;
    int eredetigriff;
    int eredetilovag;
    int eredetisarkany;

    //Előző oldalból való értékek megszerzése

    public void aiT_get(int x) {
        //Játék elején előkészülés
        circle_tuzgolyo.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_villamcsapas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_felperzsel.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_feltamasztas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        hos_tamad.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        grid.setBackground(new Background((new BackgroundImage(gridre, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(1220, 420, false, false, false, false)))));

        aiTamadas = x;
        aiLabeltamadas.setText("" + aiTamadas);

    }

    public void aiTud_get(int x) {
        aiTudas = x;
        aiLabeltudas.setText("" + aiTudas);
        aiLabelmana.setText("" + aiTudas * 10);
        aiMana = aiTudas * 10;
    }

    public void aiDef_get(int x) {
        aiDefense = x;
        aiLabeldefense.setText("" + aiDefense);
    }

    public void aiV_get(int x) {
        aiVarazslat = x;
        aiLabelvarazslat.setText("" + aiVarazslat);
    }

    public void aiM_get(int x) {
        aiMoral = x;
        aiLabelmoral.setText("" + aiMoral);
    }

    public void aiSZ_get(int x) {
        aiSzerencse = x;
        aiLabelszerencse.setText("" + aiSzerencse);
    }

    public void aiF_get(int x) {
        aiFoldmuvesdb = x;
        aieredetifoldmuves=aiFoldmuvesdb*3;
        aiLabelfoldmuves.setText("" + aiFoldmuvesdb);
    }

    public void aiI_get(int x) {
        aiIjaszdb = x;
        aieredetiijasz=aiIjaszdb*7;
        aiLabelijasz.setText("" + aiIjaszdb);
    }

    public void aiG_get(int x) {
        aiGriffdb = x;
        aieredetigriff=aiGriffdb*30;
        aiLabelgriff.setText("" + aiGriffdb);
    }

    public void aiL_get(int x) {
        aiLovagdb = x;
        aieredetilovag= aiLovagdb*15;
        aiLabellovag.setText("" + aiLovagdb);
    }

    public void aiS_get(int x) {
        aiSarkanydb = x;
        aieredetisarkany=aiSarkanydb*20;
        aiLabelsarkany.setText("" + aiSarkanydb);
    }

    public void aiVill_get(int x) {
        aiVillamdb = x;
        aiLabelvillam.setText("" + aiVillamdb);
    }

    public void aiTuz_get(int x) {
        aiTuzgolyodb = x;
        aiLabeltuzgolyo.setText("" + aiTuzgolyodb);
    }

    public void aiFel_get(int x) {
        aiFeltamasztdb = x;
        aiLabelfeltamaszt.setText("" + aiFeltamasztdb);
    }

    public void aiFoldreng_get(int x) {
        aiFoldrengdb = x;
        aiLabelfoldreng.setText("" + aiFoldrengdb);
    }

    public void aiFelperzs_get(int x) {
        aiFelperzseldb = x;
        aiLabelfelprezsel.setText("" + aiFelperzseldb);
    }

    int[][] aiCordinate = new int[5][2];
    //ai elhelyez
    Random szam = new Random();
    Random szam2 = new Random();

    public int randomoszlop() {
        return szam.nextInt(2);
    }

    public int randomsor() {
        return szam2.nextInt(8);
    }

    public void foldmuvesHelyezes(int x, int y) {
        grid.add(AIcircle_foldmuves, x, y);
        AIcircle_foldmuves.setFill(new ImagePattern(foldesre, 0, 1.1, 1.3, 1.2, true));
        AIcircle_foldmuves.setOpacity(1);
        AIcircle_foldmuves.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));
        AIcircle_foldmuves.setDisable(true);
    }

    public void ijaszHelyezes(int x, int y) {
        grid.add(AIcircle_ijasz, x, y);
        AIcircle_ijasz.setOpacity(1);
        AIcircle_ijasz.setFill(new ImagePattern(ijaszra, 0, 1.1, 1, 1.2, true));
        AIcircle_ijasz.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));
        AIcircle_ijasz.setDisable(true);
    }

    public void griffHelyezes(int x, int y) {
        grid.add(AIcircle_griff, x, y);
        AIcircle_griff.setOpacity(1);
        AIcircle_griff.setFill(new ImagePattern(griffre, 0, 1.1, 0.7, 1, true));
        AIcircle_griff.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));
        AIcircle_griff.setDisable(true);
    }

    public void lovagHelyezes(int x, int y) {
        grid.add(AIcircle_lovag, x, y);
        AIcircle_lovag.setOpacity(1);
        AIcircle_lovag.setFill(new ImagePattern(lovagra, 0, 1, 1.2, 1.2, true));
        AIcircle_lovag.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));
        AIcircle_lovag.setDisable(true);
    }

    public void sarkanyHelyezes(int x, int y) {
        grid.add(AIcircle_sarkany, x, y);
        AIcircle_sarkany.setOpacity(1);
        AIcircle_sarkany.setFill(new ImagePattern(sarkanyra, 1, 0, 1.3, 1.2, true));
        AIcircle_sarkany.setEffect(new DropShadow(+30d, 2d, +5d, Color.RED));
        AIcircle_sarkany.setDisable(true);
    }

    /**
     * ai pontos elhelyezése a grid-en, ha tobb, mint 0 van az egysgéből
     */
    public void aiElhelyez() {

        int x, y;

        if (aiFoldmuvesdb != 0) {

            x = randomoszlop() + 10;
            y = randomsor();


            aiCordinate[0][0] = x;
            aiCordinate[0][1] = y;
            foldmuvesHelyezes(x, y);


        }

        if (aiIjaszdb != 0) {
            x = randomoszlop() + 10;
            y = randomsor();

            while (!elhelyezhetoEAira(x, y)) {

                x = randomoszlop() + 10;
                y = randomsor();

            }
            aiCordinate[1][0] = x;
            aiCordinate[1][1] = y;
            ijaszHelyezes(x, y);
        }

        if (aiGriffdb != 0) {
            x = randomoszlop() + 10;
            y = randomsor();

            while (!elhelyezhetoEAira(x, y)) {
                x = randomoszlop() + 10;
                y = randomsor();

            }
            aiCordinate[2][0] = x;
            aiCordinate[2][1] = y;
            griffHelyezes(x, y);
        }


        if (aiLovagdb != 0) {
            x = randomoszlop() + 10;
            y = randomsor();

            while (!elhelyezhetoEAira(x, y)) {
                x = randomoszlop() + 10;
                y = randomsor();

            }
            aiCordinate[3][0] = x;
            aiCordinate[3][1] = y;
            lovagHelyezes(x, y);
        }
        if (aiSarkanydb != 0) {
            x = randomoszlop() + 10;
            y = randomsor();

            while (!elhelyezhetoEAira(x, y)) {
                x = randomoszlop() + 10;
                y = randomsor();

            }
            aiCordinate[4][0] = x;
            aiCordinate[4][1] = y;
            sarkanyHelyezes(x, y);
        }

    }

    public void aiMegmutatas() {
        aiElhelyez();
        elhelyez.setOpacity(0);
        elhelyez.setDisable(true);
    }

    public void tamadas_get(int x) {
        tamadas = x;
        label_tamadas.setText("" + tamadas);

    }

    public void tudas_get(int x) {
        tudas = x;
        lable_tudas.setText("" + tudas);
        label_mana.setText("" + tudas * 10);
        mana = tudas * 10;
    }

    public void defense_get(int x) {
        defense = x;
        label_defense.setText("" + defense);

    }

    public void varazslat_get(int x) {
        varazslat = x;
        label_varazslat.setText("" + varazslat);

    }

    public void moral_get(int x) {
        moral = x;
        label_moral.setText("" + moral);

    }

    public void szerencse_get(int x) {
        szerencse = x;
        label_szerencse.setText("" + szerencse);

    }

    public void foldmuvesdb_get(int x) {
        foldmuvesdb = x;
        label_foldmuves.setText("" + foldmuvesdb);
        eredetifoldmuves = foldmuvesdb * 3;

        if (foldmuvesdb == 0) {
            circle_foldmuves.setDisable(true);
            circle_foldmuves.setOpacity(0.5);

        }
    }

    public void ijaszdb_get(int x) {
        ijaszdb = x;
        label_ijasz.setText("" + ijaszdb);
        eredetiijasz = ijaszdb * 7;
        if (ijaszdb == 0) {
            circle_ijasz.setDisable(true);
            circle_ijasz.setOpacity(0.5);

        }
    }

    public void griffdb_get(int x) {
        griffdb = x;
        label_griff.setText("" + griffdb);
        eredetigriff = griffdb * 30;
        if (griffdb == 0) {
            circle_griff.setDisable(true);
            circle_griff.setOpacity(0.5);

        }
    }

    public void lovagdb_get(int x) {
        lovagdb = x;
        label_lovag.setText("" + lovagdb);
        eredetilovag = lovagdb * 15;
        if (lovagdb == 0) {
            circle_lovag.setDisable(true);
            circle_lovag.setOpacity(0.5);

        }
    }

    public void sarkanydb_get(int x) {
        sarkanydb = x;
        label_sarkany.setText("" + sarkanydb);
        eredetisarkany = sarkanydb * 20;
        if (sarkanydb == 0) {
            circle_sarkany.setDisable(true);
            circle_sarkany.setOpacity(0.5);

        }
    }

    public void villam_get(int x) {
        villamdb = x;
        label_villam.setText("" + villamdb);
    }

    public void tuzgolyo_get(int x) {
        tuzgolyodb = x;
        label_tuzgolyo.setText("" + tuzgolyodb);

    }

    public void felperzsel_get(int x) {
        felperzseldb = x;
        label_felprezsel.setText("" + felperzseldb);

    }

    public void foldreng_get(int x) {
        foldrengdb = x;
        label_foldreng.setText("" + foldrengdb);

    }

    public void feltamaszt_get(int x) {
        feltamasztdb = x;
        label_feltamaszt.setText("" + feltamasztdb);

    }

    //Körök kijelőlése(adott egységek)
    public void foldJelol() {
        circle_foldmuves.requestFocus();
        circle_foldmuves.setFill(Color.DARKBLUE);
    }

    public void ijaszJelol() {
        circle_ijasz.requestFocus();
        circle_ijasz.setFill(Color.DARKBLUE);
    }

    public void griffJelol() {
        circle_griff.requestFocus();
        circle_griff.setFill(Color.DARKBLUE);
    }

    public void lovagJelol() {
        circle_lovag.requestFocus();
        circle_lovag.setFill(Color.DARKBLUE);
    }

    public void sarkanyJelol() {
        circle_sarkany.requestFocus();
        circle_sarkany.setFill(Color.DARKBLUE);
    }

    public int[][] jatekosCordinate = new int[5][2];

    /**
     * @param x Grid X pozíciója
     * @param y Grid Y pozíciója
     * @return Vissza add egy TRUE értéket, ha nem a hőseinkre kattintunk/vagy kap x,y kordinátát
     */
    public boolean elhelyezheto(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if ((x == jatekosCordinate[i][0] && y == jatekosCordinate[i][1])) {
                return false;
            }
        }

        return true;
    }
    /**
     * @param x Grid X pozíciója
     * @param y Grid Y pozíciója
     * @return Vissza add egy TRUE értéket, ha nem az ai-ra kattintunk/vagy kap x,y kordinátát
     */
    public boolean elhelyezhetoEAira(int x, int y) {
        for (int i = 0; i < 5; i++) {
            if ((x == aiCordinate[i][0] && y == aiCordinate[i][1])) {
                return false;
            }
        }

        return true;
    }

    public int mennyiegyseg() {
        int egysegszam = 0;
        if (foldmuvesdb > 0) egysegszam++;
        if (lovagdb > 0) egysegszam++;
        if (griffdb > 0) egysegszam++;
        if (ijaszdb > 0) egysegszam++;
        if (sarkanydb > 0) egysegszam++;

        return egysegszam;
    }

    public int lehelyezett = 0;

    public void elhelyez(MouseEvent e) {

        if (foldmuvesdb != 0) {
            if (circle_foldmuves.isFocused()) {
                int x = (int) e.getX() / 80;
                int y = (int) e.getY() / 42;
                if (elhelyezheto(x, y)) {
                    jatekosCordinate[0][0] = foldX = x;
                    jatekosCordinate[0][1] = foldY = y;
                    if (x <= 1) {
                        grid.add(circle_foldmuves, x, y);
                        circle_foldmuves.setFill(new ImagePattern(foldesre, 0, 1.1, 1.3, 1.2, true));
                        circle_foldmuves.setDisable(true);
                        lehelyezett++;
                    }
                }
            }
        }
        if (ijaszdb != 0) {
            if (circle_ijasz.isFocused()) {
                int x = (int) e.getX() / 80;
                int y = (int) e.getY() / 42;
                if (elhelyezheto(x, y)) {
                    jatekosCordinate[1][0] = ijaszX = x;
                    jatekosCordinate[1][1] = ijaszY = y;
                    if (x <= 1) {
                        grid.add(circle_ijasz, x, y);
                        circle_ijasz.setFill(new ImagePattern(ijaszra, 0, 1.1, 1, 1.2, true));
                        circle_ijasz.setDisable(true);
                        lehelyezett++;

                    }
                }
            }
        }
        if (griffdb != 0) {
            if (circle_griff.isFocused()) {
                int x = (int) e.getX() / 80;
                int y = (int) e.getY() / 42;
                if (elhelyezheto(x, y)) {
                    jatekosCordinate[2][0] = griffX = x;
                    jatekosCordinate[2][1] = griffY = y;
                    if (x <= 1) {
                        grid.add(circle_griff, x, y);
                        circle_griff.setFill(new ImagePattern(griffre, 0, 1.1, 0.7, 1, true));
                        circle_griff.setDisable(true);
                        lehelyezett++;

                    }
                }
            }
        }
        if (sarkanydb != 0) {
            if (circle_sarkany.isFocused()) {
                int x = (int) e.getX() / 80;
                int y = (int) e.getY() / 42;
                if (elhelyezheto(x, y)) {
                    jatekosCordinate[4][0] = sarkanyX = x;
                    jatekosCordinate[4][1] = sarkanyY = y;
                    if (x <= 1) {
                        grid.add(circle_sarkany, x, y);
                        circle_sarkany.setFill(new ImagePattern(sarkanyra, 1, 0, 1.3, 1.2, true));
                        circle_sarkany.setDisable(true);
                        lehelyezett++;

                    }
                }
            }
        }
        if (lovagdb != 0) {
            if (circle_lovag.isFocused()) {
                int x = (int) e.getX() / 80;
                int y = (int) e.getY() / 42;
                if (elhelyezheto(x, y)) {
                    jatekosCordinate[3][0] = lovagX = x;
                    jatekosCordinate[3][1] = lovagY = y;
                    if (x <= 1) {
                        grid.add(circle_lovag, x, y);
                        circle_lovag.setFill(new ImagePattern(lovagra, 0, 1, 1.2, 1.2, true));
                        circle_lovag.setDisable(true);
                        lehelyezett++;

                    }
                }

            }
        }
    }
    //Egységek sebzése/élete/Sebesség/kezdeményezése
    Foldmuves hosFoldmuves = new Foldmuves(1, 3, 4, 8);
    Ijasz hosIjasz = new Ijasz(2, 7, 4, 9, "loves"); //osztályban kezeli a sebzest
    Griff hosGriff = new Griff(5, 30, 7, 15, "Vegtelen visszatamadas");//osztályban kezeli a sebzest
    Lovag hosLovag = new Lovag(8, 15, 5, 13, "Plusz páncéllal rendelkezik(25% védelem), varázslatokra is érvényes");//osztályban kezeli a sebzest
    Sarkany hosSarkany = new Sarkany(10, 20, 6, 14, "Bárhonnan tud támadni és kritel");//osztályban kezeli a sebzest
    Foldmuves aiFoldmuves = new Foldmuves(1, 3, 4, 8);
    Ijasz aiIjasz = new Ijasz(2, 7, 4, 8, "loves"); //osztályban kezeli a sebzest
    Griff aiGriff = new Griff(5, 30, 7, 15, "Vegtelen visszatamadas");//osztályban kezeli a sebzest
    Lovag aiLovag = new Lovag(8, 15, 5, 13, "Plusz páncéllal rendelkezik(25% védelem)+varázslatokra is érvényes");//osztályban kezeli a sebzest
    Sarkany aiSarkany = new Sarkany(10, 20, 6, 14, "Bárhonnan tud támadni, és kritel");//osztályban kezeli a sebzest
    //Speciális képességek külön függvényben vannak megvalósítva --> eletAtiras
    Alaposztaly[] tomb = new Alaposztaly[10];

    public int mennyiVan = 0;

    /**
     * Feltölti az alaptömbünket, és mellékesen az életerőt kiszámolja a Hős egységeinek
     */
    public int[] hosEletek = new int[5];

    public void eloegysegek() {

        if (foldmuvesdb > 0) {
            label_foldmuvesEletero.setText("" + hosFoldmuves.eletero * foldmuvesdb);
            hosEletek[0] = hosFoldmuves.eletero * foldmuvesdb;
            realcircle_foldmuves.setFill(new ImagePattern(foldesre, 0, 1.1, 1.3, 1.2, true));
            realcircle_foldmuves.setEffect(new DropShadow(+20d, 0d, +2d, Color.DARKGREEN));
            realcircle_foldmuves.setOpacity(1);
            grid.add(realcircle_foldmuves, jatekosCordinate[0][0], jatekosCordinate[0][1]);
            circle_foldmuves.setOpacity(0);
            mennyiVan++;
            tomb[0] = hosFoldmuves;
            hosFoldmuves.kezdemenyezes += moral;
        }

        if (ijaszdb > 0) {
            label_ijaszEletero.setText("" + hosIjasz.eletero * ijaszdb);
            hosEletek[1] = hosIjasz.eletero * ijaszdb;
            realcircle_ijasz.setOpacity(1);
            realcircle_ijasz.setFill(new ImagePattern(ijaszra, 0, 1.1, 1, 1.2, true));
            realcircle_ijasz.setEffect(new DropShadow(+20d, 0d, +2d, Color.DARKGREEN));

            grid.add(realcircle_ijasz, jatekosCordinate[1][0], jatekosCordinate[1][1]);
            circle_ijasz.setOpacity(0);
            mennyiVan++;

            tomb[1] = hosIjasz;
            hosIjasz.kezdemenyezes += moral;
        }

        if (griffdb > 0) {
            label_griffEletero.setText("" + hosGriff.eletero * griffdb);
            hosEletek[2] = hosGriff.eletero * griffdb;
            realcircle_griff.setOpacity(1);
            realcircle_griff.setEffect(new DropShadow(+20d, 0d, +2d, Color.DARKGREEN));
            realcircle_griff.setFill(new ImagePattern(griffre, 0, 1.1, 0.7, 1, true));
            grid.add(realcircle_griff, jatekosCordinate[2][0], jatekosCordinate[2][1]);
            circle_griff.setOpacity(0);
            mennyiVan++;

            tomb[2] = hosGriff;
            hosGriff.kezdemenyezes += moral;
        }

        if (lovagdb > 0) {
            realcircle_lovag.setOpacity(1);
            label_lovagEletero.setText("" + hosLovag.eletero * lovagdb);
            hosEletek[3] = hosLovag.eletero * lovagdb;
            realcircle_lovag.setFill(new ImagePattern(lovagra, 0, 1, 1.2, 1.2, true));
            realcircle_lovag.setEffect(new DropShadow(+20d, 0d, +2d, Color.DARKGREEN));
            grid.add(realcircle_lovag, jatekosCordinate[3][0], jatekosCordinate[3][1]);
            circle_lovag.setOpacity(0);
            mennyiVan++;
            tomb[3] = hosLovag;
            hosLovag.kezdemenyezes += moral;
        }

        if (sarkanydb > 0) {
            realcircle_sarkany.setOpacity(1);
            label_sarkanyEletero.setText("" + hosSarkany.eletero * sarkanydb);
            realcircle_sarkany.setEffect(new DropShadow(+20d, 0d, +2d, Color.DARKGREEN));
            realcircle_sarkany.setFill(new ImagePattern(sarkanyra, 1, 0, 1.3, 1.2, true));
            hosEletek[4] = hosSarkany.eletero * sarkanydb;
            grid.add(realcircle_sarkany, jatekosCordinate[4][0], jatekosCordinate[4][1]);
            circle_sarkany.setOpacity(0);
            mennyiVan++;

            tomb[4] = hosSarkany;
            hosSarkany.kezdemenyezes += moral;
        }

    }

    public int[] aiEletTomb = new int[5];

    /**
     * Feltölti az alaptömbünket, és mellékesen az életerőt kiszámolja az AI egységeinek
     */
    public void aieloegysegek() {
        if (aiFoldmuvesdb > 0) {
            label_AIfoldmuvesEletero.setText("" + aiFoldmuves.eletero * aiFoldmuvesdb);
            aiEletTomb[0] = aiFoldmuves.eletero * aiFoldmuvesdb;
            tomb[5] = aiFoldmuves;
            mennyiVan++;

            aiFoldmuves.kezdemenyezes += aiMoral;
        }

        if (aiIjaszdb > 0) {
            label_AIijaszEletero.setText("" + aiIjasz.eletero * aiIjaszdb);
            aiEletTomb[1] = aiIjasz.eletero * aiIjaszdb;
            tomb[6] = aiIjasz;
            mennyiVan++;

            aiIjasz.kezdemenyezes += aiMoral;
        }

        if (aiGriffdb > 0) {
            label_AIgriffEletero.setText("" + aiGriff.eletero * aiGriffdb);
            aiEletTomb[2] = aiGriff.eletero * aiGriffdb;
            tomb[7] = aiGriff;
            mennyiVan++;

            aiGriff.kezdemenyezes += aiMoral;
        }

        if (aiLovagdb > 0) {
            label_AIlovagEletero.setText("" + aiLovag.eletero * aiLovagdb);
            aiEletTomb[3] = aiLovag.eletero * aiLovagdb;
            tomb[8] = aiLovag;
            mennyiVan++;

            aiLovag.kezdemenyezes += aiMoral;
        }

        if (aiSarkanydb > 0) {
            label_AIsarkanyEletero.setText("" + aiSarkany.eletero * aiSarkanydb);
            aiEletTomb[4] = aiSarkany.eletero * aiSarkanydb;
            tomb[9] = aiSarkany;
            mennyiVan++;
            aiSarkany.kezdemenyezes += aiMoral;
        }

    }

    public void realfoldJelol() {
        realcircle_foldmuves.requestFocus();
        realcircle_foldmuves.setDisable(false);
        realcircle_foldmuves.setFill(Color.DARKBLUE);

    }

    public void realijaszJelol() {
        realcircle_ijasz.requestFocus();
        realcircle_ijasz.setFill(Color.DARKBLUE);
        realcircle_ijasz.setDisable(false);

    }

    public void realgriffJelol() {
        realcircle_griff.requestFocus();
        realcircle_griff.setFill(Color.DARKBLUE);
        realcircle_griff.setDisable(false);

    }

    public void reallovagJelol() {
        realcircle_lovag.requestFocus();
        realcircle_lovag.setFill(Color.DARKBLUE);
        realcircle_lovag.setDisable(false);
    }

    public void realsarkanyJelol() {
        realcircle_sarkany.requestFocus();
        realcircle_sarkany.setFill(Color.DARKBLUE);
        realcircle_sarkany.setDisable(false);
    }

    Alaposztaly[] uj_tomb;

    List<Alaposztaly> listam = new ArrayList<>();

    public void kivalogat() {
        uj_tomb = new Alaposztaly[mennyiVan];
        int ind = 0;
        for (Alaposztaly alaposztaly : tomb) {

            if (alaposztaly != null) {
                uj_tomb[ind] = alaposztaly;
                ind++;
            }

        }

    }

    PauseTransition pause = new PauseTransition(Duration.seconds(1.8)); //Kör meghívás késleltetésére

    /**
     * Szimpla Buborék rendezés, és uj tomb feltöltése az eredetiből. Annyi a lényeg, hogy kiszedtük azokat az egységeket belőle aminek a db száma 0 és a kezdeményezés alapján sorrendbe van állítva
     */
    public void sorba() {
        kivalogat();
        for (int i = uj_tomb.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (uj_tomb[j] != null && uj_tomb[j + 1] != null) {
                    if (uj_tomb[j].kezdemenyezes < uj_tomb[j + 1].kezdemenyezes) {
                        Alaposztaly tmp = uj_tomb[j];
                        uj_tomb[j] = uj_tomb[j + 1];
                        uj_tomb[j + 1] = tmp;
                    }
                }
            }
        }
        Collections.addAll(listam, uj_tomb);

    }

    public int index = 0;
    public void kikovetkezik(int x){
        if (x > listam.size() - 1){
            x=0;
        }

        Alaposztaly y = listam.get(x);
        if (y == hosFoldmuves) {

            kovetkezoEgyseg.setFill(new ImagePattern(foldesre, 0, 1.1, 1.3, 1.2, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
        }
        if (y == hosIjasz) {

            kovetkezoEgyseg.setFill(new ImagePattern(ijaszra, 0, 1.1, 1, 1.2, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
        }

        if (y == hosGriff) {

            kovetkezoEgyseg.setFill(new ImagePattern(griffre, 0, 1.1, 0.7, 1, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
        }
        if (y == hosLovag) {

            kovetkezoEgyseg.setFill(new ImagePattern(lovagra, 0, 1, 1.2, 1.2, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
        }
        if (y == hosSarkany) {

            kovetkezoEgyseg.setFill(new ImagePattern(sarkanyra, 1, 0, 1.3, 1.2, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
        }
        if (y == aiFoldmuves) {
           kovetkezoEgyseg.setFill(new ImagePattern(foldesre, 0, 1.1, 1.3, 1.2, true));
           kovetkezoEgyseg.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));

        }

        if (y == aiIjasz) {
            kovetkezoEgyseg.setFill(new ImagePattern(ijaszra, 0, 1.1, 1, 1.2, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));

        }
        if (y == aiGriff) {

            kovetkezoEgyseg.setFill(new ImagePattern(griffre, 0, 1.1, 0.7, 1, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));
        }
        if (y == aiLovag) {

            kovetkezoEgyseg.setFill(new ImagePattern(lovagra, 0, 1, 1.2, 1.2, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));
        }
        if (y == aiSarkany) {

            kovetkezoEgyseg.setFill(new ImagePattern(sarkanyra, 1, 0, 1.3, 1.2, true));
            kovetkezoEgyseg.setEffect(new DropShadow(+30d, 2d, +3d, Color.RED));
        }
    }
    int aitamadotVagyVarazsolt=0;
    int varazsolt=0;
    /**
     * @param x Itt mindig megkapja a következő listabeli indexet
     *          Ha netán már kifutnánk az indexekből, akkor lenullázza a függvény,
     *          így egy ciklust generálva, addig fog menni, míg a feltétel nem teljesül, hogy vkinek elfogyott az összes egysége vagy döntetlen nem lett
     */
    public void kiMozoghat(int x) {
        if(win()||lose()||draw()){
            elDont();
        }
        if (x > listam.size() - 1) {
            aiF=0;
            aiL=0;
            aiG=0;
            G=0;
            F=0;
            L=0;
            varazsolt=0;
            aitamadotVagyVarazsolt=0;
            index = 0;
            hanyadikKor++;
            kor.setText(hanyadikKor + ".");
            kor(index);
        } else {


            kikovetkezik(index);
            Alaposztaly y = listam.get(x);
            if (y == hosFoldmuves) {
                if(varazsolt==0){
                    vanVarazslat();
                }
                if (varazsSelect()) {
                }
                realfoldJelol();

            }
            if (y == hosIjasz) {
                if(varazsolt==0){
                    vanVarazslat();
                }
                if (varazsSelect()) {
                }
                realijaszJelol();

            }

            if (y == hosGriff) {
                if(varazsolt==0){
                    vanVarazslat();
                }
                if (varazsSelect()) {

                }
                realgriffJelol();

            }
            if (y == hosLovag) {
                if(varazsolt==0){
                    vanVarazslat();
                }
                if (varazsSelect()) {

                }
                reallovagJelol();

            }
            if (y == hosSarkany) {
                if(varazsolt==0){
                    vanVarazslat();
                }
                if (varazsSelect()) {

                }

                realsarkanyJelol();

            }
            if (y == aiFoldmuves) {
                varazslatokDis();
               int k= szam.nextInt(2);
                if(aitamadotVagyVarazsolt==0 && k==1){
                    int n= szam.nextInt(5);
                    vanAiVarazslat(n);
                    aitamadotVagyVarazsolt++;
                }
                aiFoldmuvesMozog();
                kor(index++);

            }

            if (y == aiIjasz) {
                varazslatokDis();
                int k= szam.nextInt(2);
                if(aitamadotVagyVarazsolt==0 && k==1){
                    int n= szam.nextInt(5);
                    vanAiVarazslat(n);
                    aitamadotVagyVarazsolt++;
                }
                aiIjaszMozog();
                kor(index++);

            }
            if (y == aiGriff) {
                varazslatokDis();
                int k= szam.nextInt(2);
                if(aitamadotVagyVarazsolt==0 && k==1){
                    int n= szam.nextInt(5);
                    vanAiVarazslat(n);
                    aitamadotVagyVarazsolt++;
                }
                aiGriffMozog();
                kor(index++);

            }
            if (y == aiLovag) {
                varazslatokDis();
                int k= szam.nextInt(2);
                if(aitamadotVagyVarazsolt==0 && k==1){
                    int n= szam.nextInt(5);
                    vanAiVarazslat(n);
                    aitamadotVagyVarazsolt++;
                }
                aiLovagMozog();
                kor(index++);

            }
            if (y == aiSarkany) {
                varazslatokDis();
                int k= szam.nextInt(2);
                if(aitamadotVagyVarazsolt==0 && k==1){
                    int n= szam.nextInt(5);
                    vanAiVarazslat(n);
                    aitamadotVagyVarazsolt++;
                }
                aiSarkanyMozog();
                kor(index++);

            }
        }
    }

    public void kor(int x) {
        pause.setOnFinished(event -> kiMozoghat(x));
        pause.play();
    }
    //ai mozgás

    public boolean aiLephet(int xpoz, int ypoz) {

        for (int i = 0; i < 5; i++) {
            if (xpoz == aiCordinate[i][0] && ypoz == aiCordinate[i][1]) {
                return false;
            }
        }
        return true;
    }

    //Ijasznak, meg 1-et a harcosoknak
    // Harcos kap egy x,y cordinátát amin éppen van, megnézi, hogy 1-es körzetben van-e ellenség, mert ha van, akkor támad, ami megnézi, hogy sebességének megfelelően van-e ellenfel a közelében, és ha van, akkor odalép
    //Ha nincs, akkor random lép
    public int ellensegX;
    public int ellensegY;

    public boolean vanEKozeleben(int x, int y) {
        for (int i = x; i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == jatekosCordinate[k][l] && j == jatekosCordinate[k][l + 1]) {

                            ellensegX = i;
                            ellensegY = j;
                            return true;

                        }
                    }
                }
            }
            for (int j = y; j >= y - 1; j--) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == jatekosCordinate[k][l] && j == jatekosCordinate[k][l + 1]) {

                            ellensegX = i;
                            ellensegY = j;
                            return true;
                        }
                    }
                }
            }
        }
        for (int i = x; i >= x - 1; i--) {
            for (int j = y; j <= y + 1; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == jatekosCordinate[k][l] && j == jatekosCordinate[k][l + 1]) {

                            ellensegX = i;
                            ellensegY = j;
                            return true;
                        }
                    }
                }
            }
            for (int j = y; j >= y - 1; j--) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == jatekosCordinate[k][l] && j == jatekosCordinate[k][l + 1]) {

                            ellensegX = i;
                            ellensegY = j;
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public int kereses(int x, int y) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                if (x == jatekosCordinate[i][j] && y == jatekosCordinate[i][j + 1]) {
                    return i;
                }
            }
        }
        return 0;
    }

    public boolean ugrashoz(int x, int y) {
        for (int i = x; i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i != aiCordinate[k][l] && j != aiCordinate[k][l + 1] && i != jatekosCordinate[k][l] && j != jatekosCordinate[k][l + 1]) {
                            ugroX = i;
                            ugroY = j;
                            return true;
                        }
                    }
                }
            }
            for (int j = y; j >= y - 1; j--) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == aiCordinate[k][l] && j == aiCordinate[k][l + 1]) {
                            ugroX = i;
                            ugroY = j;
                            return true;

                        }
                    }
                }
            }
        }
        for (int i = x; i >= x - 1; i--) {
            for (int j = y; j <= y + 1; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == aiCordinate[k][l] && j == aiCordinate[k][l + 1]) {
                            ugroX = i;
                            ugroY = j;
                            return true;

                        }
                    }
                }
            }
            for (int j = y; j >= y - 1; j--) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == aiCordinate[k][l] && j == aiCordinate[k][l + 1]) {
                            ugroX = i;
                            ugroY = j;
                            return true;

                        }
                    }
                }
            }
        }
        return false;
    }

    public int ugroX;
    public int ugroY;
    int aiF=0;
    int aiG=0;
    int aiL=0;
    int F=0;
    int G=0;
    int L=0;
    //ai visszatámadása
    public void visszatamadAi(int sebzes, int x, int y, int hos, int tamado) {

        int seb = sebzes / 2;
        if (hos == 0) {
            if (visszatamadhato(x, y, aiCordinate[0][0], aiCordinate[0][1])&&hosvissza(tamado)) {
                aiEletTomb[0] -= seb;
                hosSebez.setText("AI-földműves: "+seb+" szenved el visszatámadásból");
                if (aiEletTomb[0] % 3 == 0) {

                    label_AIfoldmuvesEletero.setText("" + aiEletTomb[0]);
                    aiLabelfoldmuves.setText("" + aiEletTomb[0] / 3);
                    aiFoldmuvesdb = aiEletTomb[0] / 3;
                    if (aiEletTomb[0] <= 0) {
                        aiCordinate[0][0]=0;
                        aiCordinate[0][1]=0;
                        listam.remove(aiFoldmuves);
                        aiLabelfoldmuves.setText("0");
                        label_AIfoldmuvesEletero.setText("0");
                        grid.getChildren().remove(AIcircle_foldmuves);
                        AIcircle_foldmuves.setDisable(true);
                        AIcircle_foldmuves.setOpacity(0);
                    }
                } else {
                    label_AIfoldmuvesEletero.setText("" + aiEletTomb[0]);
                    aiLabelfoldmuves.setText("" + ((aiEletTomb[0] / 3) + 1));
                    aiFoldmuvesdb = (aiEletTomb[0] / 3) + 1;

                    if (aiEletTomb[0] <= 0) {
                        aiCordinate[0][0]=0;
                        aiCordinate[0][1]=0;
                        listam.remove(aiFoldmuves);
                        label_AIfoldmuvesEletero.setText("0");
                        aiLabelfoldmuves.setText("0");
                        grid.getChildren().remove(AIcircle_foldmuves);
                        AIcircle_foldmuves.setDisable(true);
                        AIcircle_foldmuves.setOpacity(0);
                    }
                }
            } else {
                hosSebez.setText("Nem támadhat vissza");

            }
        } else if (hos == 1) {
            hosSebez.setText("Nem támadhat vissza");

        } else if (hos == 2) {
            if (visszatamadhato(x, y, aiCordinate[2][0], aiCordinate[2][1])&&hosvissza(tamado)) {
                hosSebez.setText("AI-Griff: "+seb+" szenved el visszatámadásból");

                aiEletTomb[2] -= seb;
                if (aiEletTomb[2] % 30 == 0) {
                    label_AIgriffEletero.setText("" + aiEletTomb[2]);
                    aiLabelgriff.setText("" + aiEletTomb[2] / 30);
                    aiGriffdb = aiEletTomb[2] / 30;
                    if (aiEletTomb[2] <= 0) {
                        aiCordinate[2][0]=0;
                        aiCordinate[2][1]=0;
                        listam.remove(aiGriff);
                        label_AIgriffEletero.setText("0");
                        aiLabelgriff.setText("0");
                        grid.getChildren().remove(AIcircle_griff);
                        AIcircle_griff.setDisable(true);
                        AIcircle_griff.setOpacity(0);
                    }

                } else {
                    label_AIgriffEletero.setText("" + aiEletTomb[2]);
                    aiLabelgriff.setText("" + ((aiEletTomb[2] / 30) + 1));
                    aiGriffdb = ((aiEletTomb[2] / 30) + 1);

                    if (aiEletTomb[2] <= 0) {
                        aiCordinate[2][0]=0;
                        aiCordinate[2][1]=0;
                        listam.remove(aiGriff);
                        label_AIgriffEletero.setText("0");
                        aiLabelgriff.setText("0");
                        grid.getChildren().remove(AIcircle_griff);
                        AIcircle_griff.setDisable(true);
                        AIcircle_griff.setOpacity(0);
                    }
                }

            } else {
                System.out.println("Nem támadhat vissza");
            }
        } else if (hos == 3) {
            if (visszatamadhato(x, y, aiCordinate[3][0], aiCordinate[3][1])&&hosvissza(tamado)) {
                hosSebez.setText("AI-Lovag: "+seb+" szenved el visszatámadásból");

                aiEletTomb[3] -= seb - seb * 0.25;
                if (aiEletTomb[3] % 15 == 0) {
                    label_AIlovagEletero.setText("" + aiEletTomb[3]);
                    aiLabellovag.setText("" + aiEletTomb[3] / 15);
                    aiLovagdb = aiEletTomb[3] / 15;
                    if (aiEletTomb[3] <= 0) {
                        aiCordinate[3][0]=0;
                        aiCordinate[3][1]=0;
                        listam.remove(aiLovag);
                        label_AIlovagEletero.setText("0");
                        aiLabellovag.setText("0");
                        grid.getChildren().remove(AIcircle_lovag);
                        AIcircle_lovag.setDisable(true);
                        AIcircle_lovag.setOpacity(0);
                    }

                } else {
                    label_AIlovagEletero.setText("" + aiEletTomb[3]);
                    aiLabellovag.setText("" + ((aiEletTomb[3] / 15) + 1));
                    aiLovagdb = ((aiEletTomb[3] / 15) + 1);
                    if (aiEletTomb[3] <= 0) {
                        aiCordinate[3][0]=0;
                        aiCordinate[3][1]=0;
                        listam.remove(aiLovag);
                        label_AIlovagEletero.setText("0");
                        aiLabellovag.setText("0");
                        grid.getChildren().remove(AIcircle_lovag);
                        AIcircle_lovag.setDisable(true);
                        AIcircle_lovag.setOpacity(0);

                    }

                }
            } else {
                hosSebez.setText("Nem támadhat vissza");

            }
        } else if (hos == 4) {
            if (visszatamadhato(x, y, aiCordinate[4][0], aiCordinate[4][1])&&hosvissza(tamado)) {
                hosSebez.setText("AI-Sárkány: "+seb+" szenved el visszatámadásból");

                aiEletTomb[4] -= seb;
                if (aiEletTomb[4] % 20 == 0) {
                    label_AIsarkanyEletero.setText("" + aiEletTomb[4]);
                    aiLabelsarkany.setText("" + aiEletTomb[4] / 20);
                    aiSarkanydb = aiEletTomb[4] / 20;
                    if (aiEletTomb[4] <= 0) {
                        aiCordinate[4][0]=0;
                        aiCordinate[4][1]=0;
                        listam.remove(aiSarkany);
                        label_AIsarkanyEletero.setText("0");
                        aiLabelsarkany.setText("0");
                        grid.getChildren().remove(AIcircle_sarkany);
                        AIcircle_sarkany.setDisable(true);
                        AIcircle_sarkany.setOpacity(0);
                    }

                } else {
                    label_AIsarkanyEletero.setText("" + aiEletTomb[4]);
                    aiLabelsarkany.setText("" + ((aiEletTomb[4] / 15) + 1));
                    aiSarkanydb = ((aiEletTomb[4] / 15) + 1);
                    if (aiEletTomb[4] <= 0) {
                        aiCordinate[4][0]=0;
                        aiCordinate[4][1]=0;
                        listam.remove(aiSarkany);
                        label_AIsarkanyEletero.setText("0");
                        aiLabelsarkany.setText("0");
                        grid.getChildren().remove(AIcircle_sarkany);
                        AIcircle_sarkany.setDisable(true);
                        AIcircle_sarkany.setOpacity(0);
                    }
                }
            } else {
                hosSebez.setText("Nem támadhat vissza");

            }
        }
    }

    public boolean felfedez(int mostX, int mostY, int sebesseg) {
        for (int i = mostX; i < mostX + sebesseg; i++) {
            for (int j = mostY; j < mostY + sebesseg; j++) {

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == jatekosCordinate[k][l] && j == jatekosCordinate[k][l + 1]&& (i!=0&&j!=0)) {
                            if (ugrashoz(i, j)) {
                                return true;

                            }

                        }
                    }
                }
            }
            for (int j = mostY; j > mostY - sebesseg; j--) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == jatekosCordinate[k][l] && j == jatekosCordinate[k][l + 1]&& (i!=0&&j!=0)) {

                            if (ugrashoz(i, j)) {
                                return true;

                            }
                        }
                    }
                }
            }
        }
        for (int i = mostX; i > mostX - sebesseg; i--) {
            for (int j = mostY; j < mostY + sebesseg; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == jatekosCordinate[k][l] && j == jatekosCordinate[k][l + 1]&& (i!=0&&j!=0)) {

                            if (ugrashoz(i, j)) {
                                return true;

                            }
                        }
                    }
                }
            }
            for (int j = mostY; j > mostY - sebesseg; j--) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == jatekosCordinate[k][l] && j == jatekosCordinate[k][l + 1]&& (i!=0&&j!=0)) {

                            if (ugrashoz(i, j)) {
                                return true;

                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public int sor;
    public int oszlop;
    Random random = new Random();

    public void randomLep(int sebesseget, int x,int y, int ai){
    int rndoszlop= random.nextInt(sebesseget);
    int rndsor=random.nextInt(sebesseget);
    int hova=random.nextInt(2);
    int tavolx=10;
    int tavoly=6;
    //elore 1;
    //hatra 0;
    //lefel 0;
    //felfele 1;
    int felfe=random.nextInt(2);
    if(hova==1){
        for (int i = x; i < x+rndoszlop; i++) {
            if(felfe==1){
            for (int j = y; j < y+rndsor; j++) {

                if((elhelyezhetoEAira(i,j)&&elhelyezheto(i,j))&&(i<12&& j<9)&&(i>0&& j>0))
                {

                    tavolx=i;
                    tavoly=j;

                }
            }
            }
            else{
                for (int j = y; j > y-rndsor; j--) {

                    if((elhelyezhetoEAira(i,j)&&elhelyezheto(i,j))&&(i<12&& j<9)&&(i>0&& j>0))
                    {

                        tavolx=i;
                        tavoly=j;

                    }
                }
            }
        }
    }
    else{
        for (int i = x; i > x-rndoszlop; i--) {
            if(felfe==1){
                for (int j = y; j < y+rndsor; j++) {

                    if((elhelyezhetoEAira(i,j)&&elhelyezheto(i,j))&&(i<12&& j<9)&&(i>0&& j>0))
                    {

                        tavolx=i;
                        tavoly=j;

                    }
                }
            }
            else{
                for (int j = y; j > y-rndsor; j--) {

                    if((elhelyezhetoEAira(i,j)&&elhelyezheto(i,j))&&(i<12&& j<9)&&(i>0&& j>0))
                    {

                        tavolx=i;
                        tavoly=j;

                    }
                }
            }
        }
    }

    if(ai==0){
        grid.getChildren().remove(AIcircle_foldmuves);
        aiCordinate[0][0] = tavolx;
        aiCordinate[0][1] = tavoly;
        foldmuvesHelyezes(aiCordinate[0][0], aiCordinate[0][1]);    }
    if(ai==2){ grid.getChildren().remove(AIcircle_griff);
        aiCordinate[2][0] = tavolx;
        aiCordinate[2][1] = tavoly;
        griffHelyezes(aiCordinate[2][0], aiCordinate[2][1]);     }
    if(ai==3){
        grid.getChildren().remove(AIcircle_lovag);
        aiCordinate[3][0] = tavolx;
        aiCordinate[3][1] = tavoly;
        lovagHelyezes(aiCordinate[3][0], aiCordinate[3][1]);     }
    if(ai==4){
        grid.getChildren().remove(AIcircle_sarkany);
        aiCordinate[4][0] = tavolx;
        aiCordinate[4][1] = tavoly;
        sarkanyHelyezes(aiCordinate[4][0], aiCordinate[4][1]);
    }

}

    /**
     * @param mostX Közelharcos X pozíciója
     * @param mostY Közelharcos Y pozíciója
     * @param sebesseg Közelharcos sebessége
     * @param sebzes    Közelharcos sebzése
     * @param ai    Közelharcos száma az AI tombben: 0/2/3
     */
    public void kozelHarcosLephet(int mostX, int mostY, int sebesseg, int sebzes, int ai) {
        int seb;
        if (kritel(aiSzerencse)) {
            kritel.setText("Igen!");
            seb = (sebzes - sebzes * (defense * 5 / 100)) * 2;

        } else {
            seb = (sebzes - sebzes * (defense * 5 / 100));
            kritel.setText("Nem!");
        }
        //Támadás
        if (vanEKozeleben(mostX, mostY)) {

            int index = kereses(ellensegX, ellensegY);
            if (index == 0) {
                aiSebez.setText("Játékos-Földműves: "+seb+" sebzést szenvedett el");
                hosEletek[0] -= seb;
                if (hosEletek[0] % 3 == 0) {
                    label_foldmuvesEletero.setText("" + aiEletTomb[0]);
                    label_foldmuves.setText("" + hosEletek[0] / 3);
                    foldmuvesdb = hosEletek[0] / 3;
                    if (hosEletek[0] <= 0) {
                        jatekosCordinate[0][0]=0;
                        jatekosCordinate[0][1]=0;
                        listam.remove(hosFoldmuves);
                        label_foldmuves.setText("0");
                        label_foldmuvesEletero.setText("0");
                        grid.getChildren().remove(realcircle_foldmuves);
                        realcircle_foldmuves.setDisable(true);
                        realcircle_foldmuves.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosFoldmuves.sebzes * foldmuvesdb) * (((float) tamadas + 10) / 10)), aiCordinate[0][0], aiCordinate[0][1], ai,0);
                    }
                } else {
                    label_foldmuvesEletero.setText("" + aiEletTomb[0]);
                    label_foldmuves.setText("" + ((hosEletek[0] / 3) + 1));
                    foldmuvesdb = ((hosEletek[0] / 3) + 1);
                    if (hosEletek[0] <= 0) {
                        jatekosCordinate[0][0]=0;
                        jatekosCordinate[0][1]=0;
                        listam.remove(hosFoldmuves);
                        label_foldmuves.setText("0");
                        label_foldmuvesEletero.setText("0");
                        grid.getChildren().remove(realcircle_foldmuves);
                        realcircle_foldmuves.setDisable(true);
                        realcircle_foldmuves.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosFoldmuves.sebzes * foldmuvesdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[0][0], jatekosCordinate[0][1], ai,0);
                    }
                }
            } else if (index == 1) {
                aiSebez.setText("Játékos-Ijasz: "+seb+" sebzést szenvedett el");

                hosEletek[1] -= seb;
                if (hosEletek[1] % 7 == 0) {
                    label_ijaszEletero.setText("" + hosEletek[1]);
                    label_ijasz.setText("" + hosEletek[1] / 7);
                    ijaszdb = hosEletek[1] / 7;
                    if (hosEletek[1] <= 0) {
                        jatekosCordinate[1][0]=0;
                        jatekosCordinate[1][1]=0;
                        listam.remove(hosIjasz);
                        ijaszdb = 0;
                        label_ijaszEletero.setText("0");
                        label_ijasz.setText("0");
                        grid.getChildren().remove(realcircle_ijasz);
                        realcircle_ijasz.setDisable(true);
                        realcircle_ijasz.setOpacity(0);
                    }

                } else {
                    label_ijaszEletero.setText("" + hosEletek[1]);
                    label_ijasz.setText("" + ((hosEletek[1] / 7) + 1));
                    ijaszdb = ((hosEletek[1] / 7) + 1);
                    if (hosEletek[1] <= 0) {
                        jatekosCordinate[1][0]=0;
                        jatekosCordinate[1][1]=0;
                        listam.remove(hosIjasz);
                        ijaszdb = 0;
                        label_ijaszEletero.setText("0");
                        label_ijasz.setText("0");
                        grid.getChildren().remove(realcircle_ijasz);
                        realcircle_ijasz.setDisable(true);
                        realcircle_ijasz.setOpacity(0);
                    }

                }

            } else if (index == 2) {
                aiSebez.setText("Játékos-Griff: "+seb+" sebzést szenvedett el");
                hosEletek[2] -= seb;
                if (hosEletek[2] % 30 == 0) {
                    label_griffEletero.setText("" + hosEletek[2]);
                    label_griff.setText("" + hosEletek[2] / 30);
                    griffdb = hosEletek[2] / 30;
                    if (hosEletek[2] <= 0) {
                        jatekosCordinate[2][0]=0;
                        jatekosCordinate[2][1]=0;
                        listam.remove(hosGriff);
                        griffdb = 0;
                        label_griffEletero.setText("0");
                        label_griff.setText("0");
                        grid.getChildren().remove(realcircle_griff);
                        realcircle_griff.setDisable(true);
                        realcircle_griff.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosGriff.sebzes * griffdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[2][0], jatekosCordinate[2][1], ai,2);
                    }

                } else {
                    label_griffEletero.setText("" + hosEletek[2]);
                    label_griff.setText("" + ((hosEletek[2] / 30) + 1));
                    griffdb = ((hosEletek[2] / 30) + 1);
                    if (hosEletek[2] <= 0) {
                        jatekosCordinate[2][0]=0;
                        jatekosCordinate[2][1]=0;
                        griffdb = 0;
                        listam.remove(hosGriff);
                        label_griffEletero.setText("0");
                        label_griff.setText("0");
                        grid.getChildren().remove(realcircle_griff);
                        realcircle_griff.setDisable(true);
                        realcircle_griff.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosGriff.sebzes * griffdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[2][0], jatekosCordinate[2][1], ai,2);
                    }
                }


            } else if (index == 3) {
                aiSebez.setText("Játékos-Lovag: "+seb+" sebzést szenvedett el");

                hosEletek[3] -= seb;
                if (hosEletek[3] % 15 == 0) {
                    label_lovagEletero.setText("" + hosEletek[3]);
                    label_lovag.setText("" + hosEletek[3] / 15);
                    lovagdb = hosEletek[3] / 15;
                    if (hosEletek[3] <= 0) {
                        jatekosCordinate[3][0]=0;
                        jatekosCordinate[3][1]=0;
                        listam.remove(hosLovag);
                        lovagdb = 0;
                        label_lovagEletero.setText("0");
                        label_lovag.setText("0");
                        grid.getChildren().remove(realcircle_lovag);
                        realcircle_lovag.setDisable(true);
                        realcircle_lovag.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosLovag.sebzes * lovagdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[3][0], jatekosCordinate[3][1], ai,3);
                    }

                } else {
                    label_lovagEletero.setText("" + hosEletek[3]);
                    label_lovag.setText("" + ((hosEletek[3] / 15) + 1));
                    lovagdb = ((hosEletek[3] / 15) + 1);
                    if (hosEletek[3] <= 0) {
                        jatekosCordinate[3][0]=0;
                        jatekosCordinate[3][1]=0;
                        listam.remove(hosLovag);
                        lovagdb = 0;
                        label_lovagEletero.setText("0");
                        label_lovag.setText("0");
                        grid.getChildren().remove(realcircle_lovag);
                        realcircle_lovag.setDisable(true);
                        realcircle_lovag.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosLovag.sebzes * lovagdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[3][0], jatekosCordinate[3][1], ai,3);
                    }

                }
            } else if (index == 4) {
                aiSebez.setText("Játékos-Sárkány: "+seb+" sebzést szenvedett el");

                hosEletek[4] -= seb;
                if (hosEletek[4] % 20 == 0) {
                    label_sarkanyEletero.setText("" + hosEletek[4]);
                    label_sarkany.setText("" + hosEletek[4] / 20);
                    sarkanydb = hosEletek[4] / 20;
                    if (hosEletek[4] <= 0) {
                        jatekosCordinate[4][0]=0;
                        jatekosCordinate[4][1]=0;
                        listam.remove(hosSarkany);
                        sarkanydb = 0;
                        label_sarkanyEletero.setText("0");
                        label_sarkany.setText("0");
                        grid.getChildren().remove(realcircle_sarkany);
                        realcircle_sarkany.setDisable(true);
                        realcircle_sarkany.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosSarkany.sebzes * sarkanydb) * (((float) tamadas + 10) / 10)), jatekosCordinate[4][0], jatekosCordinate[4][1], ai,4);
                    }

                } else {
                    label_sarkanyEletero.setText("" + hosEletek[4]);
                    label_sarkany.setText("" + ((hosEletek[4] / 20) + 1));
                    sarkanydb = ((hosEletek[4] / 20) + 1);
                    if (hosEletek[4] <= 0) {
                        jatekosCordinate[4][0]=0;
                        jatekosCordinate[4][1]=0;
                        sarkanydb = 0;
                        listam.remove(hosSarkany);
                        label_sarkanyEletero.setText("0");
                        label_sarkany.setText("0");
                        grid.getChildren().remove(realcircle_sarkany);
                        realcircle_sarkany.setDisable(true);
                        realcircle_sarkany.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosSarkany.sebzes * sarkanydb) * (((float) tamadas + 10) / 10)), jatekosCordinate[4][0], jatekosCordinate[4][1], ai,4);
                    }

                }

            }

        }
        // megnézi, hogy hatótávban van-e ember, ha van, akkor odalép
        else if (felfedez(mostX, mostY, sebesseg)) {
            if (ai == 0) {
                aiCordinate[0][0] = ugroX + 1;
                aiCordinate[0][1] = ugroY + 1;
                grid.getChildren().remove(AIcircle_foldmuves);
                foldmuvesHelyezes(aiCordinate[0][0], aiCordinate[0][1]);

            } else if (ai == 2) {
                aiCordinate[2][0] = ugroX;
                aiCordinate[2][1] = ugroY - 1;
                grid.getChildren().remove(AIcircle_griff);
                griffHelyezes(aiCordinate[2][0], aiCordinate[2][1]);

            } else if (ai == 3) {
                aiCordinate[3][0] = ugroX + 1;
                aiCordinate[3][1] = ugroY;
                grid.getChildren().remove(AIcircle_lovag);
                lovagHelyezes(aiCordinate[3][0], aiCordinate[3][1]);
            }

        }
        else {
            if (ai == 0) {
                randomLep(4,aiCordinate[0][0],aiCordinate[0][1],0);

            } else if (ai == 2) {
                randomLep(7,aiCordinate[2][0],aiCordinate[2][1],2);

            } else if (ai == 3) {
                randomLep(5,aiCordinate[3][0],aiCordinate[3][1],3);

            }
        }
    }

    /**
     * @param mostX Ijasz mostani x pozíció
     * @param mostY Ijasz mostani y pozíció
     * @param sebesseg Ijasz sebessége
     * @param ai Ijasz ai tombben való indexe: 1
     * @param sebzes    Ijasz sebzése
     */
    public void ijasznakLepnieKellE(int mostX, int mostY, int sebesseg, int ai, int sebzes) {

        if (vanEKozeleben(mostX, mostY)) {
            sor = random.nextInt(sebesseg);
            oszlop = random.nextInt(sebesseg);
            if (aiCordinate[1][0] + oszlop < 11 && aiCordinate[1][1] + sor < 9 && aiLephet(oszlop, sor)&& elhelyezheto(oszlop,sor)) {
                grid.getChildren().remove(AIcircle_ijasz);
                aiCordinate[1][0] += oszlop;
                aiCordinate[1][1] += sor;
                ijaszHelyezes(aiCordinate[1][0], aiCordinate[1][1]);

            } else if (aiCordinate[1][0] + oszlop < 11 && aiCordinate[1][1] - sor > 0 && aiLephet(oszlop, sor)&& elhelyezheto(oszlop,sor)) {
                grid.getChildren().remove(AIcircle_ijasz);
                aiCordinate[1][0] += oszlop;
                aiCordinate[1][1] -= sor;
                ijaszHelyezes(aiCordinate[1][0], aiCordinate[1][1]);
            } else if (aiCordinate[1][0] - oszlop > 0 && aiCordinate[1][1] + sor < 9 && aiLephet(oszlop, sor)&& elhelyezheto(oszlop,sor)) {
                grid.getChildren().remove(AIcircle_ijasz);
                aiCordinate[1][0] -= oszlop;
                aiCordinate[1][1] += sor;
                ijaszHelyezes(aiCordinate[1][0], aiCordinate[1][1]);
            } else if (aiCordinate[1][0] - oszlop > 0 && aiCordinate[1][1] - sor > 0 && aiLephet(oszlop, sor)&& elhelyezheto(oszlop,sor)) {
                aiCordinate[1][0] -= oszlop;
                aiCordinate[1][1] -= sor;
                grid.getChildren().remove(AIcircle_ijasz);
                ijaszHelyezes(aiCordinate[1][0], aiCordinate[1][1]);
            }

        } else {
            int seb;
            if (kritel(aiSzerencse)) {
                kritel.setText("Igen!");
                seb = (sebzes - sebzes * (defense * 5 / 100)) * 2;

            } else {
                seb = (sebzes - sebzes * (defense * 5 / 100));
                kritel.setText("Nem!");
            }
            //legnagyobb életerejűt támadja meg
            int elet = 0;
            int index = 0;

            for (int i = 0; i < 5; i++) {
                if (elet < hosEletek[i]) {
                    elet = hosEletek[i];
                    index = i;
                }
            }

            if (index == 0) {
                hosEletek[0] -= seb;
                aiSebez.setText("Játékos-Földműves: "+seb+" sebzést szenvedett el");
                if (hosEletek[0] % 3 == 0) {

                    label_foldmuvesEletero.setText("" + aiEletTomb[0]);
                    label_foldmuves.setText("" + hosEletek[0] / 3);
                    foldmuvesdb = hosEletek[0] / 3;
                    if (hosEletek[0] <= 0) {
                        jatekosCordinate[0][0]=0;
                        jatekosCordinate[0][1]=0;
                        listam.remove(hosFoldmuves);
                        label_foldmuves.setText("0");
                        label_foldmuvesEletero.setText("0");
                        grid.getChildren().remove(realcircle_foldmuves);
                        realcircle_foldmuves.setDisable(true);
                        realcircle_foldmuves.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosFoldmuves.sebzes * foldmuvesdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[0][0], jatekosCordinate[0][1], ai,0);
                    }
                } else {
                    label_foldmuvesEletero.setText("" + aiEletTomb[0]);
                    label_foldmuves.setText("" + ((hosEletek[0] / 3) + 1));
                    foldmuvesdb = ((hosEletek[0] / 3) + 1);
                    if (hosEletek[0] <= 0) {
                        jatekosCordinate[0][0]=0;
                        jatekosCordinate[0][1]=0;
                        listam.remove(hosFoldmuves);
                        label_foldmuves.setText("0");
                        label_foldmuvesEletero.setText("0");
                        grid.getChildren().remove(realcircle_foldmuves);
                        realcircle_foldmuves.setDisable(true);
                        realcircle_foldmuves.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosFoldmuves.sebzes * foldmuvesdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[0][0], jatekosCordinate[0][1], ai,0);
                    }
                }
            } else if (index == 1) {
                aiSebez.setText("Játékos-Ijász: "+seb+" sebzést szenvedett el");
                hosEletek[1] -= seb;
                if (hosEletek[1] % 7 == 0) {
                    label_ijaszEletero.setText("" + hosEletek[1]);
                    label_ijasz.setText("" + hosEletek[1] / 7);
                    ijaszdb = hosEletek[1] / 7;
                    if (hosEletek[1] <= 0) {
                        jatekosCordinate[1][0]=0;
                        jatekosCordinate[1][1]=0;
                        listam.remove(hosIjasz);
                        ijaszdb = 0;
                        label_ijaszEletero.setText("0");
                        label_ijasz.setText("0");
                        grid.getChildren().remove(realcircle_ijasz);
                        realcircle_ijasz.setDisable(true);
                        realcircle_ijasz.setOpacity(0);
                    }

                } else {
                    label_ijaszEletero.setText("" + hosEletek[1]);
                    label_ijasz.setText("" + ((hosEletek[1] / 7) + 1));
                    ijaszdb = ((hosEletek[1] / 7) + 1);
                    if (hosEletek[1] <= 0) {
                        jatekosCordinate[1][0]=0;
                        jatekosCordinate[1][1]=0;
                        listam.remove(hosIjasz);
                        ijaszdb = 0;
                        label_ijaszEletero.setText("0");
                        label_ijasz.setText("0");
                        grid.getChildren().remove(realcircle_ijasz);
                        realcircle_ijasz.setDisable(true);
                        realcircle_ijasz.setOpacity(0);
                    }

                }

            } else if (index == 2) {
                aiSebez.setText("Játékos-Griff: "+seb+" sebzést szenvedett el");
                hosEletek[2] -= seb;
                if (hosEletek[2] % 30 == 0) {
                    label_griffEletero.setText("" + hosEletek[2]);
                    label_griff.setText("" + hosEletek[2] / 30);
                    griffdb = hosEletek[2] / 30;
                    if (hosEletek[2] <= 0) {
                        jatekosCordinate[2][0]=0;
                        jatekosCordinate[2][1]=0;
                        listam.remove(hosGriff);
                        griffdb = 0;
                        label_griffEletero.setText("0");
                        label_griff.setText("0");
                        grid.getChildren().remove(realcircle_griff);
                        realcircle_griff.setDisable(true);
                        realcircle_griff.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosGriff.sebzes * griffdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[2][0], jatekosCordinate[2][1], ai,2);
                    }

                } else {
                    label_griffEletero.setText("" + hosEletek[2]);
                    label_griff.setText("" + ((hosEletek[2] / 30) + 1));
                    griffdb = ((hosEletek[2] / 30) + 1);
                    if (hosEletek[2] <= 0) {
                        jatekosCordinate[2][0]=0;
                        jatekosCordinate[2][1]=0;
                        griffdb = 0;
                        listam.remove(hosGriff);
                        label_griffEletero.setText("0");
                        label_griff.setText("0");
                        grid.getChildren().remove(realcircle_griff);
                        realcircle_griff.setDisable(true);
                        realcircle_griff.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosGriff.sebzes * griffdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[2][0], jatekosCordinate[2][1], ai,2);
                    }
                }


            } else if (index == 3) {
                aiSebez.setText("Játékos-Lovag: "+seb+" sebzést szenvedett el");
                hosEletek[3] -= seb;
                if (hosEletek[3] % 15 == 0) {
                    label_lovagEletero.setText("" + hosEletek[3]);
                    label_lovag.setText("" + hosEletek[3] / 15);
                    lovagdb = hosEletek[3] / 15;
                    if (hosEletek[3] <= 0) {
                        jatekosCordinate[3][0]=0;
                        jatekosCordinate[3][1]=0;
                        listam.remove(hosLovag);
                        lovagdb = 0;
                        label_lovagEletero.setText("0");
                        label_lovag.setText("0");
                        grid.getChildren().remove(realcircle_lovag);
                        realcircle_lovag.setDisable(true);
                        realcircle_lovag.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosLovag.sebzes * lovagdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[3][0], jatekosCordinate[3][1], ai,3);
                    }

                } else {
                    label_lovagEletero.setText("" + hosEletek[3]);
                    label_lovag.setText("" + ((hosEletek[3] / 15) + 1));
                    lovagdb = ((hosEletek[3] / 15) + 1);
                    if (hosEletek[3] <= 0) {
                        jatekosCordinate[3][0]=0;
                        jatekosCordinate[3][1]=0;
                        listam.remove(hosLovag);
                        lovagdb = 0;
                        label_lovagEletero.setText("0");
                        label_lovag.setText("0");
                        grid.getChildren().remove(realcircle_lovag);
                        realcircle_lovag.setDisable(true);
                        realcircle_lovag.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosLovag.sebzes * lovagdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[3][0], jatekosCordinate[3][1], ai,3);
                    }

                }
            } else if (index == 4) {
                aiSebez.setText("Játékos-Sárkány: "+seb+" sebzést szenvedett el");
                hosEletek[4] -= seb;

                if (hosEletek[4] % 20 == 0) {
                    label_sarkanyEletero.setText("" + hosEletek[4]);
                    label_sarkany.setText("" + hosEletek[4] / 20);
                    sarkanydb = hosEletek[4] / 20;
                    if (hosEletek[4] <= 0) {
                        jatekosCordinate[4][0]=0;
                        jatekosCordinate[4][1]=0;
                        listam.remove(hosSarkany);
                        sarkanydb = 0;
                        label_sarkanyEletero.setText("0");
                        label_sarkany.setText("0");
                        grid.getChildren().remove(realcircle_sarkany);
                        realcircle_sarkany.setDisable(true);
                        realcircle_sarkany.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosSarkany.sebzes * sarkanydb) * (((float) tamadas + 10) / 10)), jatekosCordinate[4][0], jatekosCordinate[4][1], ai,4);
                    }

                } else {
                    label_sarkanyEletero.setText("" + hosEletek[4]);
                    label_sarkany.setText("" + ((hosEletek[4] / 20) + 1));
                    sarkanydb = ((hosEletek[4] / 20) + 1);
                    if (hosEletek[4] <= 0) {
                        jatekosCordinate[4][0]=0;
                        jatekosCordinate[4][1]=0;
                        sarkanydb = 0;
                        listam.remove(hosSarkany);
                        label_sarkanyEletero.setText("0");
                        label_sarkany.setText("0");
                        grid.getChildren().remove(realcircle_sarkany);
                        realcircle_sarkany.setDisable(true);
                        realcircle_sarkany.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosSarkany.sebzes * sarkanydb) * (((float) tamadas + 10) / 10)), jatekosCordinate[4][0], jatekosCordinate[4][1], ai,4);
                    }

                }

            }

        }
    }

    /**
     * @param mostX Sarkany X pozíció
     * @param mostY Sarkany Y pozíció
     * @param sebesseg Sarkany sebessége
     * @param ai    Sarkany ai tombben való indexe: 4
     * @param sebzes Sarkany sebzése
     */
    public void sarkanynakKellE(int mostX, int mostY, int sebesseg, int ai, int sebzes) {

        if (vanEKozeleben(mostX, mostY)) {

            randomLep(6,aiCordinate[4][0],aiCordinate[4][1],4);

        } else {
            int seb;
            kritel.setText("Igen!");
            seb = (sebzes - sebzes * (defense * 5 / 100)) * 2;

            //legnagyobb életerejűt támadja meg
            int elet = 0;
            int index = 0;

            for (int i = 0; i < 5; i++) {
                if (elet < hosEletek[i]) {
                    elet = hosEletek[i];
                    index = i;
                }
            }

            if (index == 0) {
                hosEletek[0] -= seb;
                aiSebez.setText("Játékos-Földműves: "+seb+" sebzést szenvedett el");

                if (hosEletek[0] % 3 == 0) {

                    label_foldmuvesEletero.setText("" + aiEletTomb[0]);
                    label_foldmuves.setText("" + hosEletek[0] / 3);
                    foldmuvesdb = hosEletek[0] / 3;
                    if (hosEletek[0] <= 0) {
                        jatekosCordinate[0][0]=0;
                        jatekosCordinate[0][1]=0;
                        listam.remove(hosFoldmuves);
                        label_foldmuves.setText("0");
                        label_foldmuvesEletero.setText("0");
                        grid.getChildren().remove(realcircle_foldmuves);
                        realcircle_foldmuves.setDisable(true);
                        realcircle_foldmuves.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosFoldmuves.sebzes * foldmuvesdb) * (((float) tamadas + 10) / 10)), aiCordinate[0][0], aiCordinate[0][1], ai,0);
                    }
                } else {
                    label_foldmuvesEletero.setText("" + aiEletTomb[0]);
                    label_foldmuves.setText("" + ((hosEletek[0] / 3) + 1));
                    foldmuvesdb = ((hosEletek[0] / 3) + 1);
                    if (hosEletek[0] <= 0) {
                        jatekosCordinate[0][0]=0;
                        jatekosCordinate[0][1]=0;
                        listam.remove(hosFoldmuves);
                        label_foldmuves.setText("0");
                        label_foldmuvesEletero.setText("0");
                        grid.getChildren().remove(realcircle_foldmuves);
                        realcircle_foldmuves.setDisable(true);
                        realcircle_foldmuves.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosFoldmuves.sebzes * foldmuvesdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[0][0], jatekosCordinate[0][1], ai,0);
                    }
                }
            } else if (index == 1) {
                aiSebez.setText("Játékos-Ijász: "+seb+" sebzést szenvedett el");

                hosEletek[1] -= seb;
                if (hosEletek[1] % 7 == 0) {
                    label_ijaszEletero.setText("" + hosEletek[1]);
                    label_ijasz.setText("" + hosEletek[1] / 7);
                    ijaszdb = hosEletek[1] / 7;
                    if (hosEletek[1] <= 0) {
                        jatekosCordinate[1][0]=0;
                        jatekosCordinate[1][1]=0;
                        listam.remove(hosIjasz);
                        ijaszdb = 0;
                        label_ijaszEletero.setText("0");
                        label_ijasz.setText("0");
                        grid.getChildren().remove(realcircle_ijasz);
                        realcircle_ijasz.setDisable(true);
                        realcircle_ijasz.setOpacity(0);
                    }

                } else {
                    label_ijaszEletero.setText("" + hosEletek[1]);
                    label_ijasz.setText("" + ((hosEletek[1] / 7) + 1));
                    ijaszdb = ((hosEletek[1] / 7) + 1);
                    if (hosEletek[1] <= 0) {
                        jatekosCordinate[1][0]=0;
                        jatekosCordinate[1][1]=0;
                        listam.remove(hosIjasz);
                        ijaszdb = 0;
                        label_ijaszEletero.setText("0");
                        label_ijasz.setText("0");
                        grid.getChildren().remove(realcircle_ijasz);
                        realcircle_ijasz.setDisable(true);
                        realcircle_ijasz.setOpacity(0);
                    }

                }

            } else if (index == 2) {
                aiSebez.setText("Játékos-Griff: "+seb+" sebzést szenvedett el");
                hosEletek[2] -= seb;
                if (hosEletek[2] % 30 == 0) {
                    label_griffEletero.setText("" + hosEletek[2]);
                    label_griff.setText("" + hosEletek[2] / 30);
                    griffdb = hosEletek[2] / 30;
                    if (hosEletek[2] <= 0) {
                        jatekosCordinate[2][0]=0;
                        jatekosCordinate[2][1]=0;
                        listam.remove(hosGriff);
                        griffdb = 0;
                        label_griffEletero.setText("0");
                        label_griff.setText("0");
                        grid.getChildren().remove(realcircle_griff);
                        realcircle_griff.setDisable(true);
                        realcircle_griff.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosGriff.sebzes * griffdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[2][0], jatekosCordinate[2][1], ai,2);
                    }

                } else {
                    label_griffEletero.setText("" + hosEletek[2]);
                    label_griff.setText("" + ((hosEletek[2] / 30) + 1));
                    griffdb = ((hosEletek[2] / 30) + 1);
                    if (hosEletek[2] <= 0) {
                        jatekosCordinate[2][0]=0;
                        jatekosCordinate[2][1]=0;
                        griffdb = 0;
                        listam.remove(hosGriff);
                        label_griffEletero.setText("0");
                        label_griff.setText("0");
                        grid.getChildren().remove(realcircle_griff);
                        realcircle_griff.setDisable(true);
                        realcircle_griff.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosGriff.sebzes * griffdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[2][0], jatekosCordinate[2][1], ai,2);
                    }
                }


            } else if (index == 3) {
                aiSebez.setText("Játékos-Lovag: "+seb+" sebzést szenvedett el");
                hosEletek[3] -= seb;

                if (hosEletek[3] % 15 == 0) {
                    label_lovagEletero.setText("" + hosEletek[3]);
                    label_lovag.setText("" + hosEletek[3] / 15);
                    lovagdb = hosEletek[3] / 15;
                    if (hosEletek[3] <= 0) {
                        jatekosCordinate[3][0]=0;
                        jatekosCordinate[3][1]=0;
                        listam.remove(hosLovag);
                        lovagdb = 0;
                        label_lovagEletero.setText("0");
                        label_lovag.setText("0");
                        grid.getChildren().remove(realcircle_lovag);
                        realcircle_lovag.setDisable(true);
                        realcircle_lovag.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosLovag.sebzes * lovagdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[3][0], jatekosCordinate[3][1], ai,3);
                    }

                } else {
                    label_lovagEletero.setText("" + hosEletek[3]);
                    label_lovag.setText("" + ((hosEletek[3] / 15) + 1));
                    lovagdb = ((hosEletek[3] / 15) + 1);
                    if (hosEletek[3] <= 0) {
                        jatekosCordinate[3][0]=0;
                        jatekosCordinate[3][1]=0;
                        listam.remove(hosLovag);
                        lovagdb = 0;
                        label_lovagEletero.setText("0");
                        label_lovag.setText("0");
                        grid.getChildren().remove(realcircle_lovag);
                        realcircle_lovag.setDisable(true);
                        realcircle_lovag.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosLovag.sebzes * lovagdb) * (((float) tamadas + 10) / 10)), jatekosCordinate[3][0], jatekosCordinate[3][1], ai,3);
                    }

                }
            } else if (index == 4) {
                hosEletek[4] -= seb;
                aiSebez.setText("Játékos-Sárkány: "+seb+" sebzést szenvedett el");
                if (hosEletek[4] % 20 == 0) {
                    label_sarkanyEletero.setText("" + hosEletek[4]);
                    label_sarkany.setText("" + hosEletek[4] / 20);
                    sarkanydb = hosEletek[4] / 20;
                    if (hosEletek[4] <= 0) {
                        jatekosCordinate[4][0]=0;
                        jatekosCordinate[4][1]=0;
                        listam.remove(hosSarkany);
                        sarkanydb = 0;
                        label_sarkanyEletero.setText("0");
                        label_sarkany.setText("0");
                        grid.getChildren().remove(realcircle_sarkany);
                        realcircle_sarkany.setDisable(true);
                        realcircle_sarkany.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosSarkany.sebzes * sarkanydb) * (((float) tamadas + 10) / 10)), jatekosCordinate[4][0], jatekosCordinate[4][1], ai,4);
                    }

                } else {
                    label_sarkanyEletero.setText("" + hosEletek[4]);
                    label_sarkany.setText("" + ((hosEletek[4] / 20) + 1));
                    sarkanydb = ((hosEletek[4] / 20) + 1);
                    if (hosEletek[4] <= 0) {
                        jatekosCordinate[4][0]=0;
                        jatekosCordinate[4][1]=0;
                        sarkanydb = 0;
                        listam.remove(hosSarkany);
                        label_sarkanyEletero.setText("0");
                        label_sarkany.setText("0");
                        grid.getChildren().remove(realcircle_sarkany);
                        realcircle_sarkany.setDisable(true);
                        realcircle_sarkany.setOpacity(0);
                    } else {
                        visszatamadAi((int) Math.ceil((hosSarkany.sebzes * sarkanydb) * (((float) tamadas + 10) / 10)), jatekosCordinate[4][0], jatekosCordinate[4][1], ai,4);
                    }

                }

            }

        }
    }

    // Ai mozgatója/támadása
    public void aiFoldmuvesMozog() {

        kozelHarcosLephet(aiCordinate[0][0], aiCordinate[0][1], 4, (int) Math.ceil((aiFoldmuves.sebzes * aiFoldmuvesdb) * (((float) aiTamadas + 10) / 10)), 0);

    }

    public void aiIjaszMozog() {
        int sebzes = szam.nextInt(2, 5);
        aiIjasz.sebzes = sebzes;
        ijasznakLepnieKellE(aiCordinate[1][0], aiCordinate[1][1], 4, 1, (int) Math.ceil((aiIjasz.sebzes * aiIjaszdb) * (((float) aiTamadas + 10) / 10)));
    }

    public void aiGriffMozog() {
        int sebzes = szam.nextInt(5, 10);
        hosGriff.sebzes = sebzes;
        kozelHarcosLephet(aiCordinate[2][0], aiCordinate[2][1], 7, (int) Math.ceil((aiGriff.sebzes * aiGriffdb) * (((float) aiTamadas + 10) / 10)), 2);

    }

    public void aiLovagMozog() {
        int sebzes = szam.nextInt(6, 10);
        hosLovag.sebzes = sebzes;
        kozelHarcosLephet(aiCordinate[3][0], aiCordinate[3][1], 5, (int) Math.ceil((aiLovag.sebzes * aiLovagdb) * (((float) aiTamadas + 10) / 10)), 3);

    }

    public void aiSarkanyMozog() {
        int sebzes = szam.nextInt(6, 11);
        hosSarkany.sebzes = sebzes;

        sarkanynakKellE(aiCordinate[4][0], aiCordinate[4][1], aiSarkany.sebesseg, 4, (int) Math.ceil((aiSarkany.sebzes * aiSarkanydb) * (((float) aiTamadas + 10) / 10)));

    }

    /**
     * @param sebesseg = az adott egység sebességével
     * @param xpoz     =kattintás által generált x
     * @param ypoz     =kattintás által generált y
     * @param mostx    = aktuális x pozíció
     * @param mosty    = aktuális y pozíció
     * @return Ha helyesen akarunk lépni az adott egységgel, és minden specifikációnak megfelel, akkor TRUE értéket adnuk vissza, am FALSE-t
     */
    public boolean lephet(int sebesseg, int xpoz, int ypoz, int mostx, int mosty) {


        for (int i = mostx; i < mostx + sebesseg + 1; i++) {
            for (int j = mosty; j < mosty + sebesseg + 1; j++) {
                if (xpoz == i && ypoz == j) {
                    return true;
                }
            }
            for (int z = mosty; z > mosty - sebesseg - 1; z--) {
                if (xpoz == i && ypoz == z) {
                    return true;
                }
            }
        }
        for (int i = mostx; i > mostx - sebesseg - 1; i--) {
            for (int j = mosty; j < mosty + sebesseg + 1; j++) {
                if (xpoz == i && ypoz == j) {
                    return true;
                }
            }
            for (int z = mosty; z > mosty - sebesseg - 1; z--) {
                if (xpoz == i && ypoz == z) {
                    return true;
                }
            }
        }


        return false;
    }

    /**
     * @param x Aktuális grid X pozíció
     * @param y Aktuális grid Y pozíció
     * @return Megnézi, hogy körülötte van-e ellenség 1 távolságra, és ha van, akkor igazad ad vissza ellenkező esetben pedig hamisat
     */
    public boolean korulotte(int x, int y) {
        for (int i = x; i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == aiCordinate[k][l] && j == aiCordinate[k][l + 1]) {
                            return true;
                        }
                    }
                }
            }
            for (int j = y; j >= y - 1; j--) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == aiCordinate[k][l] && j == aiCordinate[k][l + 1]) {
                            return true;
                        }
                    }
                }
            }
        }
        for (int i = x; i >= x - 1; i--) {
            for (int j = y; j <= y + 1; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == aiCordinate[k][l] && j == aiCordinate[k][l + 1]) {
                            return true;
                        }
                    }
                }
            }
            for (int j = y; j >= y - 1; j--) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1; l++) {
                        if (i == aiCordinate[k][l] && j == aiCordinate[k][l + 1]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public int keres(int x, int y) {
        int hanyadik = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 1; j++) {
                if (x == aiCordinate[i][j] && y == aiCordinate[i][j + 1]) {
                    return hanyadik;
                }
                hanyadik++;
            }
        }

        return hanyadik;

    }

    /**
     * @param x Aktuális x poz
     * @param y Aktuális Y poz
     * @param hosX aki támadta x poz
     * @param hosY aki támadta y poz
     * @return Visszaadja, hogy 1 blockkal körülötte támadta-e meg
     */
    public boolean visszatamadhato(int x, int y, int hosX, int hosY) {
        for (int i = x; i <= x + 1; i++) {
            for (int j = y; j <= y + 1; j++) {

                if (i == hosX && j == hosY) {
                    return true;
                }
            }
            for (int j = y; j >= y - 1; j--) {
                if (i == hosX && j == hosY) {
                    return true;
                }
            }
        }
        for (int i = x; i >= x - 1; i--) {
            for (int j = y; j <= y + 1; j++) {
                if (i == hosX && j == hosY) {
                    return true;
                }
            }
            for (int j = y; j >= y - 1; j--) {
                if (i == hosX && j == hosY) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean hosvissza(int hos){
        if(hos==0){if(F==0){F++; return true;}}
        if(hos==2){if(G==0){G++; return true;}}
        if(hos==3){if(L==0){L++; return true;}}
        if(hos==4){return true;}
        return false;
        }

    public boolean aivissza(int hos){
        if(hos==0){if(aiF==0){aiF++; return true;}}
        if(hos==2){if(aiG==0){aiG++; return true;}}
        if(hos==3){if(aiL==0){aiL++; return true;}}
        if(hos==4){return true;}
        return false;
    }

    public void visszatamad(int sebzes, int x, int y, int hos,int ai) {
        if (hos == 0) {
            if (visszatamadhato(x, y, jatekosCordinate[0][0], jatekosCordinate[0][1])&&aivissza(ai)) {
                hosEletek[0] -= sebzes / 2;
                aiSebez.setText("Játékos-Földmüves: "+(sebzes / 2)+"sebzést szenvedett el visszatámadásból");
                if (hosEletek[0] % 3 == 0) {
                    label_foldmuvesEletero.setText("" + hosEletek[0]);
                    label_foldmuves.setText("" + hosEletek[0] / 3);
                    foldmuvesdb = hosEletek[0] / 3;
                    if (hosEletek[0] <= 0) {
                        jatekosCordinate[0][0]=0;
                        jatekosCordinate[0][1]=0;
                        listam.remove(hosFoldmuves);
                        foldmuvesdb = 0;
                        label_foldmuvesEletero.setText("0");
                        label_foldmuves.setText("0");
                        grid.getChildren().remove(realcircle_foldmuves);
                        realcircle_foldmuves.setDisable(true);
                        realcircle_foldmuves.setOpacity(0);
                    }
                } else {
                    label_foldmuvesEletero.setText("" + hosEletek[0]);
                    label_foldmuves.setText("" + ((hosEletek[0] / 3) + 1));
                    foldmuvesdb = ((hosEletek[0] / 3) + 1);
                    if (hosEletek[0] <= 0) {
                        jatekosCordinate[0][0]=0;
                        jatekosCordinate[0][1]=0;
                        listam.remove(hosFoldmuves);
                        foldmuvesdb = 0;
                        label_foldmuvesEletero.setText("0");
                        label_foldmuves.setText("0");
                        grid.getChildren().remove(realcircle_foldmuves);
                        realcircle_foldmuves.setDisable(true);
                        realcircle_foldmuves.setOpacity(0);
                    }
                }
            } else {
                aiSebez.setText("Nem támadhat vissza");
            }

        } else if (hos == 1) { /* Nem támadhat vissza*/
           aiSebez.setText("Nem támadhat vissza");
        } else if (hos == 2) {
            if (visszatamadhato(x, y, jatekosCordinate[2][0], jatekosCordinate[2][1])&&aivissza(ai)) {
                hosEletek[2] -= sebzes / 2;
                aiSebez.setText("Játékos-Griff: "+(sebzes / 2)+"sebzést szenvedett el visszatámadásból");

                if (hosEletek[2] % 30 == 0) {
                    label_griffEletero.setText("" + hosEletek[2]);
                    label_griff.setText("" + hosEletek[2] / 30);
                    griffdb = hosEletek[2] / 30;
                    if (hosEletek[2] <= 0) {
                        jatekosCordinate[2][0]=0;
                        jatekosCordinate[2][1]=0;
                        listam.remove(hosGriff);
                        griffdb = 0;
                        label_griffEletero.setText("0");
                        label_griff.setText("0");
                        grid.getChildren().remove(realcircle_griff);
                        realcircle_griff.setDisable(true);
                        realcircle_griff.setOpacity(0);
                    }

                } else {
                    label_griffEletero.setText("" + hosEletek[2]);
                    label_griff.setText("" + ((hosEletek[2] / 30) + 1));
                    griffdb = ((hosEletek[2] / 30) + 1);
                    if (hosEletek[2] <= 0) {
                        jatekosCordinate[2][0]=0;
                        jatekosCordinate[2][1]=0;
                        griffdb = 0;
                        listam.remove(hosGriff);
                        label_griffEletero.setText("0");
                        label_griff.setText("0");
                        grid.getChildren().remove(realcircle_griff);
                        realcircle_griff.setDisable(true);
                        realcircle_griff.setOpacity(0);
                    }

                }

            } else {
                aiSebez.setText("Nem támadhat vissza");

            }
        } else if (hos == 3) {
            if (visszatamadhato(x, y, jatekosCordinate[3][0], jatekosCordinate[3][1])&&aivissza(ai)) {
                hosEletek[3] -= sebzes / 2;
                aiSebez.setText("Játékos-Lovag: "+(sebzes / 2)+"sebzést szenvedett el visszatámadásból");

                if (hosEletek[3] % 15 == 0) {
                    label_lovagEletero.setText("" + hosEletek[3]);
                    label_lovag.setText("" + hosEletek[3] / 15);
                    lovagdb = hosEletek[3] / 15;
                    if (hosEletek[3] <= 0) {
                        jatekosCordinate[3][0]=0;
                        jatekosCordinate[3][1]=0;
                        listam.remove(hosLovag);
                        lovagdb = 0;
                        label_lovagEletero.setText("0");
                        label_lovag.setText("0");
                        grid.getChildren().remove(realcircle_lovag);
                        realcircle_lovag.setDisable(true);
                        realcircle_lovag.setOpacity(0);
                    }

                } else {
                    label_lovagEletero.setText("" + hosEletek[3]);
                    label_lovag.setText("" + ((hosEletek[3] / 15) + 1));
                    lovagdb = ((hosEletek[3] / 15) + 1);
                    if (hosEletek[3] <= 0) {
                        jatekosCordinate[3][0]=0;
                        jatekosCordinate[3][1]=0;
                        listam.remove(hosLovag);
                        lovagdb = 0;
                        label_lovagEletero.setText("0");
                        label_lovag.setText("0");
                        grid.getChildren().remove(realcircle_lovag);
                        realcircle_lovag.setDisable(true);
                        realcircle_lovag.setOpacity(0);
                    }

                }

            } else {
                aiSebez.setText("Nem támadhat vissza");

            }

        } else if (hos == 4) {
            if (visszatamadhato(x, y, jatekosCordinate[4][0], jatekosCordinate[4][1])&&aivissza(ai)) {
                hosEletek[4] -= sebzes / 2;
                aiSebez.setText("Játékos-Sárkány: "+(sebzes / 2)+"sebzést szenvedett el visszatámadásból");
                if (hosEletek[4] % 20 == 0) {
                    label_sarkanyEletero.setText("" + hosEletek[4]);
                    label_sarkany.setText("" + hosEletek[4] / 20);
                    sarkanydb = hosEletek[4] / 20;
                    if (hosEletek[4] <= 0) {
                        jatekosCordinate[4][0]=0;
                        jatekosCordinate[4][1]=0;
                        listam.remove(hosSarkany);
                        sarkanydb = 0;
                        label_sarkanyEletero.setText("0");
                        label_sarkany.setText("0");
                        grid.getChildren().remove(realcircle_sarkany);
                        realcircle_sarkany.setDisable(true);
                        realcircle_sarkany.setOpacity(0);
                    }

                } else {

                    label_sarkanyEletero.setText("" + hosEletek[4]);
                    label_sarkany.setText("" + ((hosEletek[4] / 20) + 1));
                    sarkanydb = ((hosEletek[4] / 20) + 1);
                    if (hosEletek[4] <= 0) {
                        jatekosCordinate[4][0]=0;
                        jatekosCordinate[4][1]=0;
                        sarkanydb = 0;
                        listam.remove(hosSarkany);
                        label_sarkanyEletero.setText("0");
                        label_sarkany.setText("0");
                        grid.getChildren().remove(realcircle_sarkany);
                        realcircle_sarkany.setDisable(true);
                        realcircle_sarkany.setOpacity(0);
                    }

                }
            } else {
                aiSebez.setText("Nem támadhat vissza");

            }
        }

    }

    Random krit = new Random();

    /**
     * @param szerencs Az hős vagy az AI szerencséje
     * @return Vissza ad igaz értéket, ha a random szám az adott százaléknak megfelelő érték alatt van. am meg hamisat
     */
    public boolean kritel(int szerencs) {
        int szamom = krit.nextInt(1, 101);

        return 5 * szerencs >= szamom;
    }

    /**
     * @param hanyadik Hanyadik helyen helyezkedik el a tömben az élet, ez által lehet tudni, hogy melyik egységről van szó
     * @param sebzes   Alapsebzés az adott egyégre a támadás tulajdonságot beleértve
     */
    public void eletAtiras(int hanyadik, int sebzes, int hos) {
        int seb;
        if (hos == 4) {
            kritel.setText("Igen!");
            seb = (sebzes - sebzes * (aiDefense * 5 / 100)) * 2;
        } else if (kritel(szerencse)) {
            kritel.setText("Igen!");
            seb = (sebzes - sebzes * (aiDefense * 5 / 100)) * 2;

        } else {
            kritel.setText("Nem!");
            seb = (sebzes - sebzes * (aiDefense * 5 / 100));
        }
        if (hanyadik == 0) {
            hosSebez.setText("AI-földmüves: " + seb+" sebzést szenvedett el");
            aiEletTomb[0] -= seb;
            if (aiEletTomb[0] % 3 == 0) {
                label_AIfoldmuvesEletero.setText("" + aiEletTomb[0]);
                aiLabelfoldmuves.setText("" + aiEletTomb[0] / 3);
                aiFoldmuvesdb = aiEletTomb[0] / 3;
                if (aiEletTomb[0] <= 0) {
                    aiCordinate[0][0]=0;
                    aiCordinate[0][1]=0;

                    listam.remove(aiFoldmuves);
                    aiLabelfoldmuves.setText("0");
                    label_AIfoldmuvesEletero.setText("0");
                    grid.getChildren().remove(AIcircle_foldmuves);
                    AIcircle_foldmuves.setDisable(true);
                    AIcircle_foldmuves.setOpacity(0);
                } else {
                    visszatamad((int) Math.ceil((aiFoldmuves.sebzes * aiFoldmuvesdb) * (((float) aiTamadas + 10) / 10)), aiCordinate[0][0], aiCordinate[0][1], hos,0);
                }
            } else {
                label_AIfoldmuvesEletero.setText("" + aiEletTomb[0]);
                aiLabelfoldmuves.setText("" + ((aiEletTomb[0] / 3) + 1));
                aiFoldmuvesdb = (aiEletTomb[0] / 3) + 1;

                if (aiEletTomb[0] <= 0) {
                    aiCordinate[0][0]=0;
                    aiCordinate[0][1]=0;
                    listam.remove(aiFoldmuves);
                    label_AIfoldmuvesEletero.setText("0");
                    aiLabelfoldmuves.setText("0");
                    grid.getChildren().remove(AIcircle_foldmuves);
                    AIcircle_foldmuves.setDisable(true);
                    AIcircle_foldmuves.setOpacity(0);
                } else {
                    visszatamad((int) Math.ceil((aiFoldmuves.sebzes * aiFoldmuvesdb) * (((float) aiTamadas + 10) / 10)), aiCordinate[0][0], aiCordinate[0][1], hos,0);
                }
            }
        } else if (hanyadik == 1) {
            hosSebez.setText("AI-Ijász: " + seb+" sebzést szenvedett el");
            aiEletTomb[1] -= seb;

            if (aiEletTomb[1] % 7 == 0) {
                label_AIijaszEletero.setText("" + aiEletTomb[1]);
                aiLabelijasz.setText("" + aiEletTomb[1] / 7);
                aiIjaszdb = (aiEletTomb[1] / 7);
                if (aiEletTomb[1] <= 0) {
                    aiCordinate[1][0]=0;
                    aiCordinate[1][1]=0;
                    listam.remove(aiIjasz);
                    label_AIijaszEletero.setText("0");
                    aiLabelijasz.setText("0");
                    grid.getChildren().remove(AIcircle_ijasz);
                    AIcircle_ijasz.setDisable(true);
                    AIcircle_ijasz.setOpacity(0);
                }

            } else {
                label_AIijaszEletero.setText("" + aiEletTomb[1]);
                aiLabelijasz.setText("" + ((aiEletTomb[1] / 7) + 1));
                aiIjaszdb = ((aiEletTomb[1] / 7) + 1);
                if (aiEletTomb[1] <= 0) {
                    aiCordinate[1][0]=0;
                    aiCordinate[1][1]=0;
                    listam.remove(aiIjasz);
                    label_AIijaszEletero.setText("0");
                    aiLabelijasz.setText("0");
                    grid.getChildren().remove(AIcircle_ijasz);
                    AIcircle_ijasz.setDisable(true);
                    AIcircle_ijasz.setOpacity(0);
                }
            }

        } else if (hanyadik == 2) {
            hosSebez.setText("AI-Griff: " + seb+" sebzést szenvedett el");
            aiEletTomb[2] -= seb;
            if (aiEletTomb[2] % 30 == 0) {
                label_AIgriffEletero.setText("" + aiEletTomb[2]);
                aiLabelgriff.setText("" + aiEletTomb[2] / 30);
                aiGriffdb = aiEletTomb[2] / 30;
                if (aiEletTomb[2] <= 0) {
                    aiCordinate[2][0]=0;
                    aiCordinate[2][1]=0;
                    listam.remove(aiGriff);
                    label_AIgriffEletero.setText("0");
                    aiLabelgriff.setText("0");
                    grid.getChildren().remove(AIcircle_griff);
                    AIcircle_griff.setDisable(true);
                    AIcircle_griff.setOpacity(0);
                } else {
                    visszatamad((int) Math.ceil((aiGriff.sebzes * aiGriffdb) * (((float) aiTamadas + 10) / 10)), aiCordinate[2][0], aiCordinate[2][1], hos,2);
                }
            } else {
                label_AIgriffEletero.setText("" + aiEletTomb[2]);
                aiLabelgriff.setText("" + ((aiEletTomb[2] / 30) + 1));
                aiGriffdb = ((aiEletTomb[2] / 30) + 1);

                if (aiEletTomb[2] <= 0) {
                    aiCordinate[2][0]=0;
                    aiCordinate[2][1]=0;
                    listam.remove(aiGriff);
                    label_AIgriffEletero.setText("0");
                    aiLabelgriff.setText("0");
                    grid.getChildren().remove(AIcircle_griff);
                    AIcircle_griff.setDisable(true);
                    AIcircle_griff.setOpacity(0);
                } else {
                    visszatamad((int) Math.ceil((aiGriff.sebzes * aiGriffdb) * (((float) aiTamadas + 10) / 10)), aiCordinate[2][0], aiCordinate[2][1], hos,2);
                }
            }

        } else if (hanyadik == 3) {
            hosSebez.setText("AI-Lovag: " + (seb-(seb*0.25))+" sebzést szenvedett el");

            aiEletTomb[3] -= seb - (seb * 0.25);
            if (aiEletTomb[3] % 15 == 0) {
                label_AIlovagEletero.setText("" + aiEletTomb[3]);
                aiLabellovag.setText("" + aiEletTomb[3] / 15);
                aiLovagdb = aiEletTomb[3] / 15;
                if (aiEletTomb[3] <= 0) {
                    aiCordinate[3][0]=0;
                    aiCordinate[3][1]=0;
                    listam.remove(aiLovag);
                    label_AIlovagEletero.setText("0");
                    aiLabellovag.setText("0");
                    grid.getChildren().remove(AIcircle_lovag);
                    AIcircle_lovag.setDisable(true);
                    AIcircle_lovag.setOpacity(0);
                } else {
                    visszatamad((int) Math.ceil((aiLovag.sebzes * aiLovagdb) * (((float) aiTamadas + 10) / 10)), aiCordinate[3][0], aiCordinate[3][1], hos,3);
                }
            } else {
                label_AIlovagEletero.setText("" + aiEletTomb[3]);
                aiLabellovag.setText("" + ((aiEletTomb[3] / 15) + 1));
                aiLovagdb = ((aiEletTomb[3] / 15) + 1);
                if (aiEletTomb[3] <= 0) {
                    aiCordinate[3][0]=0;
                    aiCordinate[3][1]=0;
                    listam.remove(aiLovag);
                    label_AIlovagEletero.setText("0");
                    aiLabellovag.setText("0");
                    grid.getChildren().remove(AIcircle_lovag);
                    AIcircle_lovag.setDisable(true);
                    AIcircle_lovag.setOpacity(0);
                } else {
                    visszatamad((int) Math.ceil((aiLovag.sebzes * aiLovagdb) * (((float) aiTamadas + 10) / 10)), aiCordinate[3][0], aiCordinate[3][1], hos,3);
                }
            }

        } else if (hanyadik == 4) {

            hosSebez.setText("AI-Sárkány: " + seb+" sebzést szenvedett el");
            aiEletTomb[4] -= seb;
            if (aiEletTomb[4] % 20 == 0) {
                label_AIsarkanyEletero.setText("" + aiEletTomb[4]);
                aiLabelsarkany.setText("" + aiEletTomb[4] / 20);
                aiSarkanydb = aiEletTomb[4] / 20;
                if (aiEletTomb[4] <= 0) {
                    aiCordinate[4][0]=0;
                    aiCordinate[4][1]=0;
                    listam.remove(aiSarkany);
                    label_AIsarkanyEletero.setText("0");
                    aiLabelsarkany.setText("0");
                    grid.getChildren().remove(AIcircle_sarkany);
                    AIcircle_sarkany.setDisable(true);
                    AIcircle_sarkany.setOpacity(0);
                } else {
                    visszatamad((int) Math.ceil((aiSarkany.sebzes * aiSarkanydb) * (((float) aiTamadas + 10) / 10)), aiCordinate[4][0], aiCordinate[4][1], hos,4);
                }
            } else {
                label_AIsarkanyEletero.setText("" + aiEletTomb[4]);
                aiLabelsarkany.setText("" + ((aiEletTomb[4] / 15) + 1));
                aiSarkanydb = ((aiEletTomb[4] / 15) + 1);
                if (aiEletTomb[4] <= 0) {
                    aiCordinate[4][0]=0;
                    aiCordinate[4][1]=0;
                    listam.remove(aiSarkany);
                    label_AIsarkanyEletero.setText("0");
                    aiLabelsarkany.setText("0");
                    grid.getChildren().remove(AIcircle_sarkany);
                    AIcircle_sarkany.setDisable(true);
                    AIcircle_sarkany.setOpacity(0);
                } else {
                    visszatamad((int) Math.ceil((aiSarkany.sebzes * aiSarkanydb) * (((float) aiTamadas + 10) / 10)), aiCordinate[4][0], aiCordinate[4][1], hos,4);
                }
            }
        }
    }

    public boolean benneVanAKorben(int x, int y, int xmost, int ymost) {
        for (int i = xmost; i <= xmost + 1; i++) {
            for (int j = ymost; j >= ymost - 1; j--) {
                if (i == x && j == y) {
                    return true;
                }
            }
            for (int k = ymost; k <= ymost + 1; k++) {
                if (i == x && k == y) {
                    return true;
                }
            }
        }
        for (int i = xmost; i >= xmost - 1; i--) {
            for (int j = ymost; j >= ymost - 1; j--) {
                if (i == x && j == y) {
                    return true;
                }
            }
            for (int k = ymost; k <= ymost + 1; k++) {
                if (i == x && k == y) {
                    return true;
                }
            }
        }
        return false;
    }

    Random szamom = new Random();

    /**
     * @param e Egér kattintás-ra használandó, ami lekéri a grid x és y értékét
     *          A függvény elhelyezi az adott egységet a feltételeknek megfelelő pozícióra vagy támad
     */
    //Mozgás
    public void mozgas(MouseEvent e) {
        if (realcircle_foldmuves.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            if ((elhelyezheto(x, y) && elhelyezhetoEAira(x, y) && lephet(hosFoldmuves.sebesseg, x, y, jatekosCordinate[0][0], jatekosCordinate[0][1])) || x == jatekosCordinate[0][0] && y == jatekosCordinate[0][1]) {
                jatekosCordinate[0][0] = foldX = x;
                jatekosCordinate[0][1] = foldY = y;
                grid.getChildren().remove(realcircle_foldmuves);
                grid.add(realcircle_foldmuves, x, y);
                realcircle_foldmuves.setFill(new ImagePattern(foldesre, 0, 1.1, 1.3, 1.2, true));
                realcircle_foldmuves.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
                realcircle_foldmuves.setDisable(true);
                kor(index++);
            } else if (!elhelyezhetoEAira(x, y) && benneVanAKorben(x, y, jatekosCordinate[0][0], jatekosCordinate[0][1])) {
                hosFoldmuves.sebzes = 1;
                int hany = keres(x, y);
                eletAtiras(hany, (int) Math.ceil((hosFoldmuves.sebzes * foldmuvesdb) * (((float) tamadas + 10) / 10)), 0);
                realcircle_foldmuves.setFill(new ImagePattern(foldesre, 0, 1.1, 1.3, 1.2, true));
                realcircle_foldmuves.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKSEAGREEN));
                realcircle_foldmuves.setDisable(true);
                kor(index++);
            }
        }
        if (realcircle_ijasz.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            if ((elhelyezheto(x, y) && elhelyezhetoEAira(x, y) && lephet(hosIjasz.sebesseg, x, y, jatekosCordinate[1][0], jatekosCordinate[1][1])) || x == jatekosCordinate[1][0] && y == jatekosCordinate[1][1]) {

                jatekosCordinate[1][0] = ijaszX = x;
                jatekosCordinate[1][1] = ijaszY = y;
                grid.getChildren().remove(realcircle_ijasz);
                grid.add(realcircle_ijasz, x, y);
                realcircle_ijasz.setFill(new ImagePattern(ijaszra, 0, 1.1, 1, 1.2, true));
                realcircle_ijasz.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
                realcircle_ijasz.setDisable(true);
                kor(index++);
            } else if (!elhelyezhetoEAira(x, y) && !korulotte(jatekosCordinate[1][0], jatekosCordinate[1][1])) {
                int sebzes = szam.nextInt(2, 5);
                hosIjasz.sebzes = sebzes;
                int hany = keres(x, y);
                eletAtiras(hany, (int) Math.ceil((hosIjasz.sebzes * ijaszdb) * (((float) tamadas + 10) / 10)), 1);
                realcircle_ijasz.setFill(new ImagePattern(ijaszra, 0, 1.1, 1, 1.2, true));
                realcircle_ijasz.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
                realcircle_ijasz.setDisable(true);
                kor(index++);
            }

        }
        if (realcircle_griff.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;

            if ((elhelyezheto(x, y) && elhelyezhetoEAira(x, y) && lephet(hosGriff.sebesseg, x, y, jatekosCordinate[2][0], jatekosCordinate[2][1])) || x == jatekosCordinate[2][0] && y == jatekosCordinate[2][1]) {
                jatekosCordinate[2][0] = griffX = x;
                jatekosCordinate[2][1] = griffY = y;
                grid.getChildren().remove(realcircle_griff);
                grid.add(realcircle_griff, x, y);
                realcircle_griff.setEffect(new DropShadow(+20d, 2d, +2d, Color.DARKGREEN));
                realcircle_griff.setFill(new ImagePattern(griffre, 0, 1.1, 0.7, 1, true));
                realcircle_griff.setDisable(true);
                kor(index++);
            } else if (!elhelyezhetoEAira(x, y) && benneVanAKorben(x, y, jatekosCordinate[2][0], jatekosCordinate[2][1])) {
                int sebzes = szam.nextInt(5, 10);
                hosGriff.sebzes = sebzes;
                int hany = keres(x, y);
                eletAtiras(hany, (int) Math.ceil((hosGriff.sebzes * griffdb) * (((float) tamadas + 10) / 10)), 2);
                realcircle_griff.setEffect(new DropShadow(+30d, 2d, +2d, Color.DARKGREEN));
                realcircle_griff.setFill(new ImagePattern(griffre, 0, 1, 1.5, 1, true));
                realcircle_griff.setDisable(true);
                kor(index++);
            }
        }

        if (realcircle_lovag.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            if ((elhelyezheto(x, y) && elhelyezhetoEAira(x, y) && lephet(hosLovag.sebesseg, x, y, jatekosCordinate[3][0], jatekosCordinate[3][1])) || x == jatekosCordinate[3][0] && y == jatekosCordinate[3][1]) {
                jatekosCordinate[3][0] = lovagX = x;
                jatekosCordinate[3][1] = lovagY = y;
                grid.getChildren().remove(realcircle_lovag);
                grid.add(realcircle_lovag, x, y);
                realcircle_lovag.setFill(new ImagePattern(lovagra, 0, 1, 1.2, 1.2, true));
                realcircle_lovag.setEffect(new DropShadow(+30d, 2d, +2d, Color.DARKGREEN));
                realcircle_lovag.setDisable(true);
                kor(index++);
            } else if (!elhelyezhetoEAira(x, y) && benneVanAKorben(x, y, jatekosCordinate[3][0], jatekosCordinate[3][1])) {
                int sebzes = szam.nextInt(6, 10);
                hosLovag.sebzes = sebzes;
                int hany = keres(x, y);
                eletAtiras(hany, (int) Math.ceil((hosLovag.sebzes * lovagdb) * (((float) tamadas + 10) / 10)), 3);
                realcircle_lovag.setFill(new ImagePattern(lovagra, 0, 1, 1.2, 1.2, true));
                realcircle_lovag.setEffect(new DropShadow(+30d, 2d, +2d, Color.DARKGREEN));
                realcircle_lovag.setDisable(true);
                kor(index++);
            }
        }
        if (realcircle_sarkany.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            if ((elhelyezheto(x, y) && elhelyezhetoEAira(x, y) && lephet(hosSarkany.sebesseg, x, y, jatekosCordinate[4][0], jatekosCordinate[4][1])) || x == jatekosCordinate[4][0] && y == jatekosCordinate[4][1]) {

                jatekosCordinate[4][0] = sarkanyX = x;
                jatekosCordinate[4][1] = sarkanyY = y;
                grid.getChildren().remove(realcircle_sarkany);
                grid.add(realcircle_sarkany, x, y);
                realcircle_sarkany.setEffect(new DropShadow(+30d, 2d, +2d, Color.DARKGREEN));
                realcircle_sarkany.setFill(new ImagePattern(sarkanyra, 1, 0, 1.3, 1.2, true));
                realcircle_sarkany.setDisable(true);
                kor(index++);
            } else if (!elhelyezhetoEAira(x, y)) {
                int sebzes = szam.nextInt(5, 11);
                hosSarkany.sebzes = sebzes;
                int hany = keres(x, y);
                eletAtiras(hany, (int) Math.ceil((hosSarkany.sebzes * sarkanydb) * (((float) tamadas + 10) / 10)), 4);
                realcircle_sarkany.setEffect(new DropShadow(+30d, 2d, +2d, Color.DARKGREEN));
                realcircle_sarkany.setFill(new ImagePattern(sarkanyra, 1, 0, 1.3, 1.2, true));
                realcircle_sarkany.setDisable(true);
                kor(index++);
            }
        }


    }
    //Varázslatok     \  AI-JATEKOS  /     Tűzgolyó/villam/feltamasztas(Sajategyseg)/foldrenges/felperzsel
            //Ai varázslat
    public boolean vanAiVarazslat(int x) {
        if (x==0&&aiTuzgolyodb > 0 && aiMana >= 9) {
            tuzgolyoAi();
        return true;
        }
       else if (x==1&&aiVillamdb > 0 && aiMana >= 5) {
           villamcsapasAi();
            return true;

        }
       else if (x==2&&aiFeltamasztdb > 0 && aiMana >= 6) {
            int legkisebb=400;
            int szam=0;
            if(foldmuvesdb<legkisebb){legkisebb=foldmuvesdb; szam=0;}
            if(ijaszdb>legkisebb){legkisebb=ijaszdb; szam=1;}
            if(griffdb>legkisebb){legkisebb=griffdb; szam=2;}
            if(lovagdb>legkisebb){legkisebb=lovagdb; szam=3;}
            if(sarkanydb>legkisebb){legkisebb=sarkanydb; szam=4;}
           feltamasztasAi(szam);
            return true;

        }
       else if (x==3&&aiFoldrengdb > 0 && aiMana >= 6) {
           foldrendgAi();
            return true;

        }
       else if (x==4&&aiFelperzseldb > 0 && aiMana >= 9) {
            int legnagyobb=0;
            int l=0;
            int y=0;
            if(foldmuvesdb>legnagyobb){legnagyobb=foldmuvesdb; l=jatekosCordinate[0][0]; y=jatekosCordinate[0][1];}
            if(ijaszdb>legnagyobb){legnagyobb=ijaszdb; l=jatekosCordinate[1][0]; y=jatekosCordinate[1][1];}
            if(griffdb>legnagyobb){legnagyobb=griffdb; l=jatekosCordinate[2][0]; y=jatekosCordinate[2][1];}
            if(lovagdb>legnagyobb){legnagyobb=lovagdb; l=jatekosCordinate[3][0]; y=jatekosCordinate[3][1];}
            if(sarkanydb>legnagyobb){legnagyobb=sarkanydb; l=jatekosCordinate[4][0]; y=jatekosCordinate[4][1];}
            felperzselHatarAi(l,y);

            return true;

        }
       else{
           aiUt();
           return true;
        }
    }

    public void varazslatokDis(){
        circle_tuzgolyo.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_felperzsel.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_feltamasztas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        hos_tamad.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setDisable(true);
        circle_felperzsel.setDisable(true);
        circle_feltamasztas.setDisable(true);
        circle_tuzgolyo.setDisable(true);
        hos_tamad.setDisable(true);
        circle_villamcsapas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_villamcsapas.setDisable(true);

    }

    public void tuzgolyoAi(){
        int sebzes=aiVarazslat*30;
        int legnagyobb=0;
        int x=0;
        int y=0;
        if(foldmuvesdb>legnagyobb){legnagyobb=foldmuvesdb; x=jatekosCordinate[0][0]; y=jatekosCordinate[0][1];}
        if(ijaszdb>legnagyobb){legnagyobb=ijaszdb; x=jatekosCordinate[1][0]; y=jatekosCordinate[1][1];}
        if(griffdb>legnagyobb){legnagyobb=griffdb; x=jatekosCordinate[2][0]; y=jatekosCordinate[2][1];}
        if(lovagdb>legnagyobb){legnagyobb=lovagdb; x=jatekosCordinate[3][0]; y=jatekosCordinate[3][1];}
        if(sarkanydb>legnagyobb){legnagyobb=sarkanydb; x=jatekosCordinate[4][0]; y=jatekosCordinate[4][1];}
        tuzgolyoHatar(x,y,sebzes);
        aitamadotVagyVarazsolt++;
        aiTuzgolyodb--;
        aiMana -= 9;
        elDont();
        aiLabeltuzgolyo.setText(""+aiTuzgolyodb);
        aiLabelmana.setText("" + aiMana);
    }

    public void villamcsapasAi(){
        int sebzes=aiVarazslat*30;
        int legnagyobb=0;
        int szam=0;
        if(foldmuvesdb>legnagyobb){legnagyobb=foldmuvesdb; szam=0;}
        if(ijaszdb>legnagyobb){legnagyobb=ijaszdb; szam=1;}
        if(griffdb>legnagyobb){legnagyobb=griffdb; szam=2;}
        if(lovagdb>legnagyobb){legnagyobb=lovagdb; szam=3;}
        if(sarkanydb>legnagyobb){legnagyobb=sarkanydb; szam=4;}
        varazstamadaHos(szam,sebzes,"AI villámcsapás-->");
        aitamadotVagyVarazsolt++;
        aiMana -= 5;
        aiVillamdb--;
        elDont();
        aiLabelvillam.setText(""+aiVillamdb);
        aiLabelmana.setText("" + aiMana);
    }

    public void feltamasztasAi(int hanyadik) {
        int pluszElet=50*aiVarazslat;
        aiSebez.setText("AI varázsolhatott --> Feltámasztás");
        if (hanyadik==0) {
            if (aiEletTomb[0] + pluszElet > aieredetifoldmuves) {
                aiEletTomb[0] = aieredetifoldmuves;
                aiFoldmuvesdb = aiEletTomb[0] / 3;
                aiLabelfoldmuves.setText("" + aiFoldmuvesdb);
                label_AIfoldmuvesEletero.setText("" + aiEletTomb[0]);
            } else {
                aiEletTomb[0] += pluszElet;

            }

            if (aiEletTomb[0] % 3 == 0) {
                aiFoldmuvesdb = aiEletTomb[0] / 3;
            } else {

                aiFoldmuvesdb = ((aiEletTomb[0] / 3) + 1);
            }
            aiLabelfoldmuves.setText("" + aiFoldmuvesdb);
            label_AIfoldmuvesEletero.setText("" + aiEletTomb[0]);
        } else if (hanyadik==1) {

            if (aiEletTomb[1] + pluszElet > aieredetiijasz) {
                aiEletTomb[1] = aieredetiijasz;
                aiIjaszdb = aiEletTomb[1] / 7;
                aiLabelijasz.setText("" + aiIjaszdb);
                label_AIijaszEletero.setText("" + aiEletTomb[1]);
            } else {
                aiEletTomb[1] += pluszElet;

            }

            if (aiEletTomb[1] % 7 == 0) {
                aiIjaszdb = aiEletTomb[1] / 7;
            } else {

                aiIjaszdb = ((aiEletTomb[1] / 7) + 1);
            }
            aiLabelijasz.setText("" + aiIjaszdb);
            label_AIijaszEletero.setText("" + aiEletTomb[1]);

        } else if (hanyadik==2) {

            if (aiEletTomb[2] + pluszElet > aieredetigriff) {
                aiEletTomb[2] = aieredetigriff;
                aiGriffdb = aiEletTomb[2] / 30;
                aiLabelgriff.setText("" + aiGriffdb);
                label_AIgriffEletero.setText("" + aiEletTomb[2]);
            } else {
                aiEletTomb[2] += pluszElet;
            }

            if (aiEletTomb[2] % 30 == 0) {
                aiGriffdb = aiEletTomb[2] / 30;
            } else {

                aiGriffdb = ((aiEletTomb[2] / 30) + 1);
            }
            aiLabelgriff.setText("" + aiGriffdb);
            label_AIgriffEletero.setText("" + aiEletTomb[2]);

        } else if (hanyadik==3) {

            if (aiEletTomb[3] + pluszElet > aieredetilovag) {
                aiEletTomb[3] = aieredetilovag;
                aiLovagdb = aiEletTomb[3] / 15;
                aiLabellovag.setText("" +   aiLovagdb);
                label_AIlovagEletero.setText("" + aiEletTomb[3]);
            } else {
                aiEletTomb[3] += pluszElet;

            }

            if (aiEletTomb[3] % 15 == 0) {
                aiLovagdb = aiEletTomb[3] / 15;
            } else {

                aiLovagdb = ((aiEletTomb[3] / 15) + 1);
            }
            aiLabellovag.setText("" +   aiLovagdb);
            label_AIlovagEletero.setText("" + aiEletTomb[3]);

        } else if (hanyadik==4) {

            if (aiEletTomb[4] + pluszElet > aieredetisarkany) {
                aiEletTomb[4] = aieredetisarkany;
                aiSarkanydb = aiEletTomb[4] / 20;
                aiLabelsarkany.setText("" +     aiSarkanydb );
                label_AIsarkanyEletero.setText("" + aiEletTomb[4]);
            } else {
                aiEletTomb[4] += pluszElet;

            }

            if (aiEletTomb[4] % 20 == 0) {
                aiSarkanydb  = aiEletTomb[4] / 20;
            } else {

                aiSarkanydb  = ((aiEletTomb[4] / 20) + 1);
            }
            aiLabelsarkany.setText("" +     aiSarkanydb );
            label_AIsarkanyEletero.setText("" + aiEletTomb[4]);
        }
        aiFeltamasztdb--;
        aiMana -= 6;
        aitamadotVagyVarazsolt++;
        aiLabelfeltamaszt.setText(""+aiFeltamasztdb);
        aiLabelmana.setText("" + aiMana);
    }

    public void felperzselHatarAi(int x, int y) {
        int sebzes=aiVarazslat*10;
        for (int i = x; i <= x + 3; i++) {
            for (int j = y; j >= y - 3; j--) {
                for (int k = 0; k < 5; k++) {
                    if (i == jatekosCordinate[k][0] && j == jatekosCordinate[k][1]) {
                        varazstamadaHos(k, sebzes,"AI Felperzsel-->");
                    }

                }
            }
            for (int l = y; l <= y + 3; l++) {
                for (int k = 0; k < 5; k++) {
                    if (i == jatekosCordinate[k][0] && l == jatekosCordinate[k][1]) {
                        varazstamadaHos(k, sebzes,"AI Felperzsel-->");

                    }

                }
            }
        }
        for (int i = x; i >= x - 3; i--) {
            for (int j = y; j >= y - 3; j--) {
                for (int k = 0; k < 5; k++) {
                    if (i == jatekosCordinate[k][0] && j == jatekosCordinate[k][1]) {
                        varazstamadaHos(k, sebzes,"AI Felperzsel-->");

                    }

                }
            }
            for (int l = y; l <= y + 3; l++) {
                for (int k = 0; k < 5; k++) {
                    if (i == jatekosCordinate[k][0] && l == jatekosCordinate[k][1]) {
                        varazstamadaHos(k, sebzes,"AI Felperzsel-->");


                    }

                }
            }
        }
        aiMana -= 9;
        aiFelperzseldb--;
        aiLabelfelprezsel.setText("" + aiFelperzseldb);
        aiLabelmana.setText("" + aiMana);
        elDont();
        aitamadotVagyVarazsolt++;
    }

    public void foldrendgAi(){

        if (foldmuvesdb > 0) {
            varazstamadaHos(0, 10 * varazslat,"AI Földrend-->");
        }
        if (ijaszdb > 0) {
            varazstamadaHos(1, 10 * varazslat,"AI Földrend-->");
        }
        if (griffdb > 0) {
            varazstamadaHos(2, 10 * varazslat,"AI Földrend-->");
        }
        if (lovagdb > 0) {
            varazstamadaHos(3, 10 * varazslat,"AI Földrend-->");
        }
        if (sarkanydb > 0) {
            varazstamadaHos(4, 10 * varazslat,"AI Földrend-->");
        }
        if (aiFoldmuvesdb > 0) {
            varazstamadasAI(0, 10 * varazslat);
        }
        if (aiIjaszdb > 0) {
            varazstamadasAI(1, 10 * varazslat);
        }
        if (aiGriffdb > 0) {
            varazstamadasAI(2, 10 * varazslat);
        }
        if (aiLovagdb > 0) {
            varazstamadasAI(3, 10 * varazslat);
        }
        if (aiSarkanydb > 0) {
            varazstamadasAI(4, 10 * varazslat);
        }
        elDont();
        aiFoldrengdb--;
        aiMana -= 6;
        aiLabelmana.setText("" + aiMana);
        aiLabelfoldreng.setText("" + aiFoldrengdb);
        elDont();
        aitamadotVagyVarazsolt++;
    }
    public void varazstamadasAI(int hanyadik, int sebzes) {
        int seb = sebzes;
        hosSebez.setText("Hős  varázstámadása/támadása:" + seb);
        if (hanyadik == 0) {
            aiEletTomb[0] -= seb;
            if (aiEletTomb[0] % 3 == 0) {
                label_AIfoldmuvesEletero.setText("" + aiEletTomb[0]);
                aiLabelfoldmuves.setText("" + aiEletTomb[0] / 3);
                aiFoldmuvesdb = aiEletTomb[0] / 3;
                if (aiEletTomb[0] <= 0) {
                    aiCordinate[0][0]=0;
                    aiCordinate[0][1]=0;
                    listam.remove(aiFoldmuves);
                    aiLabelfoldmuves.setText("0");
                    label_AIfoldmuvesEletero.setText("0");
                    grid.getChildren().remove(AIcircle_foldmuves);
                    AIcircle_foldmuves.setDisable(true);
                    AIcircle_foldmuves.setOpacity(0);
                    kor(index);
                }
            } else {
                label_AIfoldmuvesEletero.setText("" + aiEletTomb[0]);
                aiLabelfoldmuves.setText("" + ((aiEletTomb[0] / 3) + 1));
                aiFoldmuvesdb = (aiEletTomb[0] / 3) + 1;

                if (aiEletTomb[0] <= 0) {
                    aiCordinate[0][0]=0;
                    aiCordinate[0][1]=0;
                    listam.remove(aiFoldmuves);
                    label_AIfoldmuvesEletero.setText("0");
                    aiLabelfoldmuves.setText("0");
                    grid.getChildren().remove(AIcircle_foldmuves);
                    AIcircle_foldmuves.setDisable(true);
                    AIcircle_foldmuves.setOpacity(0);
                    kor(index);

                }
            }
        } else if (hanyadik == 1) {
            aiEletTomb[1] -= seb;
            if (aiEletTomb[1] % 7 == 0) {
                label_AIijaszEletero.setText("" + aiEletTomb[1]);
                aiLabelijasz.setText("" + aiEletTomb[1] / 7);
                aiIjaszdb = (aiEletTomb[1] / 7);
                if (aiEletTomb[1] <= 0) {
                    aiCordinate[1][0]=0;
                    aiCordinate[1][1]=0;
                    listam.remove(aiIjasz);
                    label_AIijaszEletero.setText("0");
                    aiLabelijasz.setText("0");
                    grid.getChildren().remove(AIcircle_ijasz);
                    AIcircle_ijasz.setDisable(true);
                    AIcircle_ijasz.setOpacity(0);
                    kor(index);

                }

            } else {
                label_AIijaszEletero.setText("" + aiEletTomb[1]);
                aiLabelijasz.setText("" + ((aiEletTomb[1] / 7) + 1));
                aiIjaszdb = ((aiEletTomb[1] / 7) + 1);
                if (aiEletTomb[1] <= 0) {
                    aiCordinate[1][0]=0;
                    aiCordinate[1][1]=0;
                    listam.remove(aiIjasz);
                    label_AIijaszEletero.setText("0");
                    aiLabelijasz.setText("0");
                    grid.getChildren().remove(AIcircle_ijasz);
                    AIcircle_ijasz.setDisable(true);
                    AIcircle_ijasz.setOpacity(0);
                    kor(index);
                }
            }
        } else if (hanyadik == 2) {
            aiEletTomb[2] -= seb;
            if (aiEletTomb[2] % 30 == 0) {
                label_AIgriffEletero.setText("" + aiEletTomb[2]);
                aiLabelgriff.setText("" + aiEletTomb[2] / 30);
                aiGriffdb = aiEletTomb[2] / 30;
                if (aiEletTomb[2] <= 0) {
                    aiCordinate[2][0]=0;
                    aiCordinate[2][1]=0;
                    listam.remove(aiGriff);
                    label_AIgriffEletero.setText("0");
                    aiLabelgriff.setText("0");
                    grid.getChildren().remove(AIcircle_griff);
                    AIcircle_griff.setDisable(true);
                    AIcircle_griff.setOpacity(0);
                    kor(index);

                }
            } else {
                label_AIgriffEletero.setText("" + aiEletTomb[2]);
                aiLabelgriff.setText("" + ((aiEletTomb[2] / 30) + 1));
                aiGriffdb = ((aiEletTomb[2] / 30) + 1);

                if (aiEletTomb[2] <= 0) {
                    aiCordinate[2][0]=0;
                    aiCordinate[2][1]=0;
                    listam.remove(aiGriff);
                    label_AIgriffEletero.setText("0");
                    aiLabelgriff.setText("0");
                    grid.getChildren().remove(AIcircle_griff);
                    AIcircle_griff.setDisable(true);
                    AIcircle_griff.setOpacity(0);
                    kor(index);
                }
            }

        } else if (hanyadik == 3) {

            aiEletTomb[3] -= seb - seb * 0.25;
            if (aiEletTomb[3] % 15 == 0) {
                label_AIlovagEletero.setText("" + aiEletTomb[3]);
                aiLabellovag.setText("" + aiEletTomb[3] / 15);
                aiLovagdb = aiEletTomb[3] / 15;
                if (aiEletTomb[3] <= 0) {
                    aiCordinate[3][0]=0;
                    aiCordinate[3][1]=0;
                    listam.remove(aiLovag);
                    label_AIlovagEletero.setText("0");
                    aiLabellovag.setText("0");
                    grid.getChildren().remove(AIcircle_lovag);
                    AIcircle_lovag.setDisable(true);
                    AIcircle_lovag.setOpacity(0);
                    kor(index);

                }
            } else {
                label_AIlovagEletero.setText("" + aiEletTomb[3]);
                aiLabellovag.setText("" + ((aiEletTomb[3] / 15) + 1));
                aiLovagdb = ((aiEletTomb[3] / 15) + 1);
                if (aiEletTomb[3] <= 0) {
                    aiCordinate[3][0]=0;
                    aiCordinate[3][1]=0;
                    listam.remove(aiLovag);
                    label_AIlovagEletero.setText("0");
                    aiLabellovag.setText("0");
                    grid.getChildren().remove(AIcircle_lovag);
                    AIcircle_lovag.setDisable(true);
                    AIcircle_lovag.setOpacity(0);
                    kor(index);
                }
            }

        } else if (hanyadik == 4) {
            aiEletTomb[4] -= seb;
            if (aiEletTomb[4] % 20 == 0) {
                label_AIsarkanyEletero.setText("" + aiEletTomb[4]);
                aiLabelsarkany.setText("" + aiEletTomb[4] / 20);
                aiSarkanydb = aiEletTomb[4] / 20;
                if (aiEletTomb[4] <= 0) {
                    aiCordinate[4][0]=0;
                    aiCordinate[4][1]=0;
                    listam.remove(aiSarkany);
                    label_AIsarkanyEletero.setText("0");
                    aiLabelsarkany.setText("0");
                    grid.getChildren().remove(AIcircle_sarkany);
                    AIcircle_sarkany.setDisable(true);
                    AIcircle_sarkany.setOpacity(0);
                    kor(index);

                }
            } else {
                label_AIsarkanyEletero.setText("" + aiEletTomb[4]);
                aiLabelsarkany.setText("" + ((aiEletTomb[4] / 15) + 1));
                aiSarkanydb = ((aiEletTomb[4] / 15) + 1);
                if (aiEletTomb[4] <= 0) {
                    aiCordinate[4][0]=0;
                    aiCordinate[4][1]=0;
                    listam.remove(aiSarkany);
                    label_AIsarkanyEletero.setText("0");
                    aiLabelsarkany.setText("0");
                    grid.getChildren().remove(AIcircle_sarkany);
                    AIcircle_sarkany.setDisable(true);
                    AIcircle_sarkany.setOpacity(0);
                    kor(index);

                }
            }
        }
    }

    public void aiUt(){
        int sebzes=aiTamadas*10;
        int legnagyobb=0;
        int szam=0;
        if(foldmuvesdb>legnagyobb){legnagyobb=foldmuvesdb; szam=0;}
        if(ijaszdb>legnagyobb){legnagyobb=ijaszdb; szam=1;}
        if(griffdb>legnagyobb){legnagyobb=griffdb; szam=2;}
        if(lovagdb>legnagyobb){legnagyobb=lovagdb; szam=3;}
        if(sarkanydb>legnagyobb){legnagyobb=sarkanydb; szam=4;}
        varazstamadaHos(szam,sebzes,"AI-hőstámadás");
        elDont();
        aitamadotVagyVarazsolt++;

}
    //hős varázslatai
    public void vanVarazslat() {
        if (tuzgolyodb > 0 && mana >= 9) {
            circle_tuzgolyo.setDisable(false);
            circle_tuzgolyo.setFill(new ImagePattern(fireB, 0, 1.1, 1.3, 1.2, true));
            circle_tuzgolyo.setOpacity(1);
        }
        if (villamdb > 0 && mana >= 5) {
            circle_villamcsapas.setDisable(false);
            circle_villamcsapas.setFill(new ImagePattern(ligthn, 0, 1.1, 1.3, 1.2, true));
            circle_villamcsapas.setOpacity(1);
        }
        if (feltamasztdb > 0 && mana >= 6) {
            circle_feltamasztas.setDisable(false);
            circle_feltamasztas.setFill(new ImagePattern(feltamasztom, 0, 1.1, 1.3, 1.2, true));
            circle_feltamasztas.setOpacity(1);
        }
        if (foldrengdb > 0 && mana >= 6) {
            circle_foldrenges.setDisable(false);
            circle_foldrenges.setFill(new ImagePattern(earthquake, 0, 1.1, 1.3, 1.2, true));
            circle_foldrenges.setOpacity(1);
        }
        if (felperzseldb > 0 && mana >= 9) {
            circle_felperzsel.setDisable(false);
            circle_felperzsel.setFill(new ImagePattern(felegetem, 0, 1.1, 1.3, 1.2, true));
            circle_felperzsel.setOpacity(1);
        }
        hos_tamad.setDisable(false);
        hos_tamad.setOpacity(1);
        hos_tamad.setFill(new ImagePattern(sword, 0, 1.1, 1.3, 1.2, true));
    }

    public void tuzgolyoJelol() {
        circle_tuzgolyo.requestFocus();
        circle_foldrenges.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_felperzsel.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_feltamasztas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_villamcsapas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setDisable(true);
        circle_felperzsel.setDisable(true);
        circle_feltamasztas.setDisable(true);
        circle_villamcsapas.setDisable(true);
        hos_tamad.setDisable(true);
        hos_tamad.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));

    }

    public void villamJelol() {
        circle_villamcsapas.requestFocus();
        circle_tuzgolyo.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_felperzsel.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_feltamasztas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setDisable(true);
        circle_felperzsel.setDisable(true);
        circle_feltamasztas.setDisable(true);
        circle_tuzgolyo.setDisable(true);
        hos_tamad.setDisable(true);
        hos_tamad.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
    }

    public void feltamasztasJelol() {
        aiSebez.setText("Ai varázsolt --> Feltamasztas");
        circle_feltamasztas.requestFocus();
        circle_tuzgolyo.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_felperzsel.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_villamcsapas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setDisable(true);
        circle_felperzsel.setDisable(true);
        circle_tuzgolyo.setDisable(true);
        circle_villamcsapas.setDisable(true);
        hos_tamad.setDisable(true);
        hos_tamad.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
    }

    public void foldrendJelol() {
        aiSebez.setText("Ai varázsolt --> Földrengés");
        circle_foldrenges.requestFocus();
        circle_tuzgolyo.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_felperzsel.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_feltamasztas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_villamcsapas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_tuzgolyo.setDisable(true);
        circle_felperzsel.setDisable(true);
        circle_feltamasztas.setDisable(true);
        circle_villamcsapas.setDisable(true);
        hos_tamad.setDisable(true);
        hos_tamad.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
    }

    public void felperzselJelol() {
        circle_felperzsel.requestFocus();
        circle_tuzgolyo.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_feltamasztas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_villamcsapas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        hos_tamad.setDisable(true);
        hos_tamad.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setDisable(true);
        circle_tuzgolyo.setDisable(true);
        circle_feltamasztas.setDisable(true);
        circle_villamcsapas.setDisable(true);
    }

    public void hosTamadJelol() {
        hos_tamad.requestFocus();
        circle_tuzgolyo.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_foldrenges.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_feltamasztas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_villamcsapas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_felperzsel.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
        circle_tuzgolyo.setDisable(true);
        circle_foldrenges.setDisable(true);
        circle_felperzsel.setDisable(true);
        circle_feltamasztas.setDisable(true);
        circle_villamcsapas.setDisable(true);

    }

    public boolean varazsSelect() {
        if (circle_tuzgolyo.isFocused()) {
            return true;
        } else if (circle_villamcsapas.isFocused()) {
            return true;
        } else if (circle_feltamasztas.isFocused()) {
            return true;
        } else if (circle_foldrenges.isFocused()) {
            return true;
        } else if (circle_felperzsel.isFocused()) {
            return true;
        }
        return false;
    }

    public void varazstamadaHos(int hanyadik, int sebzes,String szoveg) {
        int seb = sebzes;
        aiSebez.setText(szoveg + seb);
        if (hanyadik == 0) {
            hosEletek[0] -= seb;
            if (hosEletek[0] % 3 == 0) {
                label_foldmuvesEletero.setText("" + aiEletTomb[0]);
                label_foldmuves.setText("" + hosEletek[0] / 3);
                foldmuvesdb = hosEletek[0] / 3;
                if (hosEletek[0] <= 0) {
                    jatekosCordinate[0][0]=0;
                    jatekosCordinate[0][1]=0;
                    listam.remove(hosFoldmuves);
                    label_foldmuves.setText("0");
                    label_foldmuvesEletero.setText("0");
                    grid.getChildren().remove(realcircle_foldmuves);
                    realcircle_foldmuves.setDisable(true);
                    realcircle_foldmuves.setOpacity(0);
                    kor(index);
                }
            } else {
                label_foldmuvesEletero.setText("" + aiEletTomb[0]);
                label_foldmuves.setText("" + ((hosEletek[0] / 3) + 1));
                foldmuvesdb = ((hosEletek[0] / 3) + 1);
                if (hosEletek[0] <= 0) {
                    jatekosCordinate[0][0]=0;
                    jatekosCordinate[0][1]=0;
                    listam.remove(hosFoldmuves);
                    label_foldmuves.setText("0");
                    label_foldmuvesEletero.setText("0");
                    grid.getChildren().remove(realcircle_foldmuves);
                    realcircle_foldmuves.setDisable(true);
                    realcircle_foldmuves.setOpacity(0);
                    kor(index);

                }
            }
        } else if (hanyadik == 1) {
            hosEletek[1] -= sebzes;
            if (hosEletek[1] % 7 == 0) {
                label_ijaszEletero.setText("" + hosEletek[1]);
                label_ijasz.setText("" + hosEletek[1] / 7);
                ijaszdb = hosEletek[1] / 7;
                if (hosEletek[1] <= 0) {
                    jatekosCordinate[1][0]=0;
                    jatekosCordinate[1][1]=0;
                    listam.remove(hosIjasz);
                    ijaszdb = 0;
                    label_ijaszEletero.setText("0");
                    label_ijasz.setText("0");
                    grid.getChildren().remove(realcircle_ijasz);
                    realcircle_ijasz.setDisable(true);
                    realcircle_ijasz.setOpacity(0);
                    kor(index);
                }

            } else {
                label_ijaszEletero.setText("" + hosEletek[1]);
                label_ijasz.setText("" + ((hosEletek[1] / 7) + 1));
                ijaszdb = ((hosEletek[1] / 7) + 1);
                if (hosEletek[1] <= 0) {
                    jatekosCordinate[1][0]=0;
                    jatekosCordinate[1][1]=0;
                    listam.remove(hosIjasz);
                    ijaszdb = 0;
                    label_ijaszEletero.setText("0");
                    label_ijasz.setText("0");
                    grid.getChildren().remove(realcircle_ijasz);
                    realcircle_ijasz.setDisable(true);
                    realcircle_ijasz.setOpacity(0);
                    kor(index);
                }

            }
        } else if (hanyadik == 2) {
            hosEletek[2] -= seb;
            if (hosEletek[2] % 30 == 0) {
                label_griffEletero.setText("" + hosEletek[2]);
                label_griff.setText("" + hosEletek[2] / 30);
                griffdb = hosEletek[2] / 30;
                if (hosEletek[2] <= 0) {
                    jatekosCordinate[2][0]=0;
                    jatekosCordinate[2][1]=0;
                    listam.remove(hosGriff);
                    griffdb = 0;
                    label_griffEletero.setText("0");
                    label_griff.setText("0");
                    grid.getChildren().remove(realcircle_griff);
                    realcircle_griff.setDisable(true);
                    realcircle_griff.setOpacity(0);
                    kor(index);
                }


            } else {
                label_griffEletero.setText("" + hosEletek[2]);
                label_griff.setText("" + ((hosEletek[2] / 30) + 1));
                griffdb = ((hosEletek[2] / 30) + 1);
                if (hosEletek[2] <= 0) {
                    jatekosCordinate[2][0]=0;
                    jatekosCordinate[2][1]=0;
                    griffdb = 0;
                    listam.remove(hosGriff);
                    label_griffEletero.setText("0");
                    label_griff.setText("0");
                    grid.getChildren().remove(realcircle_griff);
                    realcircle_griff.setDisable(true);
                    realcircle_griff.setOpacity(0);
                    kor(index);

                }

            }
        } else if (hanyadik == 3) {
            hosEletek[3] -= seb;
            if (hosEletek[3] % 15 == 0) {
                label_lovagEletero.setText("" + hosEletek[3]);
                label_lovag.setText("" + hosEletek[3] / 15);
                lovagdb = hosEletek[3] / 15;
                if (hosEletek[3] <= 0) {
                    jatekosCordinate[3][0]=0;
                    jatekosCordinate[3][1]=0;
                    listam.remove(hosLovag);
                    lovagdb = 0;
                    label_lovagEletero.setText("0");
                    label_lovag.setText("0");
                    grid.getChildren().remove(realcircle_lovag);
                    realcircle_lovag.setDisable(true);
                    realcircle_lovag.setOpacity(0);
                    kor(index);
                }


            } else {
                label_lovagEletero.setText("" + hosEletek[3]);
                label_lovag.setText("" + ((hosEletek[3] / 15) + 1));
                lovagdb = ((hosEletek[3] / 15) + 1);
                if (hosEletek[3] <= 0) {
                    jatekosCordinate[3][0]=0;
                    jatekosCordinate[3][1]=0;
                    listam.remove(hosLovag);
                    lovagdb = 0;
                    label_lovagEletero.setText("0");
                    label_lovag.setText("0");
                    grid.getChildren().remove(realcircle_lovag);
                    realcircle_lovag.setDisable(true);
                    realcircle_lovag.setOpacity(0);
                    kor(index);
                }


            }
        } else if (hanyadik == 4) {
            hosEletek[4] -= seb;
            if (hosEletek[4] % 20 == 0) {
                label_sarkanyEletero.setText("" + hosEletek[4]);
                label_sarkany.setText("" + hosEletek[4] / 20);
                sarkanydb = hosEletek[4] / 20;
                if (hosEletek[4] <= 0) {
                    jatekosCordinate[4][0]=0;
                    jatekosCordinate[4][1]=0;
                    listam.remove(hosSarkany);
                    sarkanydb = 0;
                    label_sarkanyEletero.setText("0");
                    label_sarkany.setText("0");
                    grid.getChildren().remove(realcircle_sarkany);
                    realcircle_sarkany.setDisable(true);
                    realcircle_sarkany.setOpacity(0);
                    kor(index);
                }

            } else {
                label_sarkanyEletero.setText("" + hosEletek[4]);
                label_sarkany.setText("" + ((hosEletek[4] / 20) + 1));
                sarkanydb = ((hosEletek[4] / 20) + 1);
                if (hosEletek[4] <= 0) {
                    jatekosCordinate[4][0]=0;
                    jatekosCordinate[4][1]=0;
                    sarkanydb = 0;
                    listam.remove(hosSarkany);
                    label_sarkanyEletero.setText("0");
                    label_sarkany.setText("0");
                    grid.getChildren().remove(realcircle_sarkany);
                    realcircle_sarkany.setDisable(true);
                    realcircle_sarkany.setOpacity(0);
                    kor(index);
                }

            }
        }

    }

    public void tuzgolyoHatar(int x, int y, int sebzes) {

        for (int i = x; i <= x + 1; i++) {
            for (int j = y; j >= y - 1; j--) {
                for (int k = 0; k < 5; k++) {
                    if (i == aiCordinate[k][0] && j == aiCordinate[k][1]) {
                        varazstamadasAI(k, sebzes);
                    } else if (i == jatekosCordinate[k][0] && j == jatekosCordinate[k][1]) {
                        varazstamadaHos(k, sebzes,"AI túzgolyó -->");
                    }
                }
            }
            for (int l = y; l <= y + 1; l++) {
                for (int k = 0; k < 5; k++) {
                    if (i == aiCordinate[k][0] && l == aiCordinate[k][1]) {
                        varazstamadasAI(k, sebzes);
                    } else if (i == jatekosCordinate[k][0] && l == jatekosCordinate[k][1]) {
                        varazstamadaHos(k, sebzes,"AI túzgolyó -->");

                    }
                }
            }
        }
        for (int i = x; i >= x - 1; i--) {
            for (int j = y; j >= y - 1; j--) {
                for (int k = 0; k < 5; k++) {
                    if (i == aiCordinate[k][0] && j == aiCordinate[k][1]) {
                        varazstamadasAI(k, sebzes);
                    } else if (i == jatekosCordinate[k][0] && j == jatekosCordinate[k][1]) {
                        varazstamadaHos(k, sebzes,"AI túzgolyó -->");
                    }
                }
            }
            for (int l = y; l <= y + 1; l++) {
                for (int k = 0; k < 5; k++) {
                    if (i == aiCordinate[k][0] && l == aiCordinate[k][1]) {
                        varazstamadasAI(k, sebzes);

                    } else if (i == jatekosCordinate[k][0] && l == jatekosCordinate[k][1]) {
                        varazstamadaHos(k, sebzes,"AI túzgolyó -->");

                    }
                }
            }
        }
    }

    public void feltamasztashos(int x, int y, int pluszElet) {
        if (x == jatekosCordinate[0][0] && y == jatekosCordinate[0][1]) {
            if (hosEletek[0] + pluszElet > eredetifoldmuves) {
                hosEletek[0] = eredetifoldmuves;
                foldmuvesdb = hosEletek[0] / 3;
                label_foldmuves.setText("" + foldmuvesdb);
                label_foldmuvesEletero.setText("" + hosEletek[0]);
            } else {
                hosEletek[0] += pluszElet;

            }

            if (hosEletek[0] % 3 == 0) {
                foldmuvesdb = hosEletek[1] / 3;
            } else {

                foldmuvesdb = ((hosEletek[0] / 3) + 1);
            }
            label_foldmuves.setText("" + foldmuvesdb);
            label_foldmuvesEletero.setText("" + hosEletek[0]);
        } else if (x == jatekosCordinate[1][0] && y == jatekosCordinate[1][1]) {

            if (hosEletek[1] + pluszElet > eredetiijasz) {
                hosEletek[1] = eredetiijasz;
                ijaszdb = hosEletek[1] / 7;
                label_ijasz.setText("" + ijaszdb);
                label_ijaszEletero.setText("" + hosEletek[1]);
            } else {
                hosEletek[1] += pluszElet;

            }

            if (hosEletek[1] % 7 == 0) {
                ijaszdb = hosEletek[1] / 7;
            } else {

                ijaszdb = ((hosEletek[1] / 7) + 1);
            }
            label_ijasz.setText("" + ijaszdb);
            label_ijaszEletero.setText("" + hosEletek[1]);

        } else if (x == jatekosCordinate[2][0] && y == jatekosCordinate[2][1]) {

            if (hosEletek[2] + pluszElet > eredetigriff) {
                hosEletek[2] = eredetigriff;
                griffdb = hosEletek[2] / 30;
                label_griff.setText("" + griffdb);
                label_griffEletero.setText("" + hosEletek[2]);
            } else {
                hosEletek[2] += pluszElet;
            }

            if (hosEletek[2] % 30 == 0) {
                griffdb = hosEletek[2] / 30;
            } else {

                griffdb = ((hosEletek[2] / 30) + 1);
            }
            label_griff.setText("" + griffdb);
            label_griffEletero.setText("" + hosEletek[2]);

        } else if (x == jatekosCordinate[3][0] && y == jatekosCordinate[3][1]) {

            if (hosEletek[3] + pluszElet > eredetilovag) {
                hosEletek[3] = eredetilovag;
                lovagdb = hosEletek[3] / 15;
                label_lovag.setText("" + lovagdb);
                label_lovagEletero.setText("" + hosEletek[3]);
            } else {
                hosEletek[3] += pluszElet;

            }

            if (hosEletek[3] % 15 == 0) {
                lovagdb = hosEletek[3] / 15;
            } else {

                lovagdb = ((hosEletek[3] / 15) + 1);
            }
            label_lovag.setText("" + lovagdb);
            label_lovagEletero.setText("" + hosEletek[3]);

        } else if (x == jatekosCordinate[4][0] && y == jatekosCordinate[4][1]) {

            if (hosEletek[4] + pluszElet > eredetisarkany) {
                hosEletek[4] = eredetisarkany;
                sarkanydb = hosEletek[4] / 20;
                label_sarkany.setText("" + sarkanydb);
                label_sarkany.setText("" + hosEletek[4]);
            } else {
                hosEletek[4] += pluszElet;

            }

            if (hosEletek[4] % 20 == 0) {
                sarkanydb = hosEletek[4] / 20;
            } else {

                sarkanydb = ((hosEletek[4] / 20) + 1);
            }
            label_sarkany.setText("" + sarkanydb);
            label_sarkanyEletero.setText("" + hosEletek[4]);
        }

    }

    public void felperzselHatar(int x, int y, int sebzes) {

        for (int i = x; i <= x + 3; i++) {
            for (int j = y; j >= y - 3; j--) {
                for (int k = 0; k < 5; k++) {
                    if (i == aiCordinate[k][0] && j == aiCordinate[k][1]) {
                        varazstamadasAI(k, sebzes);
                    }

                }
            }
            for (int l = y; l <= y + 3; l++) {
                for (int k = 0; k < 5; k++) {
                    if (i == aiCordinate[k][0] && l == aiCordinate[k][1]) {
                        varazstamadasAI(k, sebzes);
                    }

                }
            }
        }
        for (int i = x; i >= x - 3; i--) {
            for (int j = y; j >= y - 3; j--) {
                for (int k = 0; k < 5; k++) {
                    if (i == aiCordinate[k][0] && j == aiCordinate[k][1]) {
                        varazstamadasAI(k, sebzes);
                    }

                }
            }
            for (int l = y; l <= y + 3; l++) {
                for (int k = 0; k < 5; k++) {
                    if (i == aiCordinate[k][0] && l == aiCordinate[k][1]) {
                        varazstamadasAI(k, sebzes);

                    }

                }
            }
        }

    }

    public void Varazslatok(MouseEvent e) {
        if (circle_tuzgolyo.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            varazsolt=1;

            tuzgolyoHatar(x, y, varazslat * 20);
            circle_tuzgolyo.setDisable(true);
            circle_tuzgolyo.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
            mana -= 9;
            elDont();
            label_mana.setText("" + mana);
            tuzgolyodb--;
            label_tuzgolyo.setText("" + tuzgolyodb);

        } else if (circle_villamcsapas.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;

            if (!elhelyezhetoEAira(x, y)) {
                int hany = keres(x, y);
                varazsolt=1;
                varazstamadasAI(hany, varazslat * 30);
                circle_villamcsapas.setDisable(true);
                circle_villamcsapas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
                villamdb--;
                mana -= 5;
                elDont();
                label_mana.setText("" + mana);
                label_villam.setText("" + villamdb);
            }

        } else if (circle_feltamasztas.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            if (elhelyezhetoEAira(x, y) && !elhelyezheto(x, y)) {
                feltamasztashos(x, y, varazslat * 50);
                varazsolt=1;
                hosSebez.setText("Varazsolhatott --> Feltamasztas");
                circle_feltamasztas.setDisable(true);
                circle_feltamasztas.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
                feltamasztdb--;
                mana -= 6;
                elDont();
                label_mana.setText("" + mana);
                label_feltamaszt.setText("" + feltamasztdb);
            }
        } else if (circle_foldrenges.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            if (elhelyezhetoEAira(x, y) && elhelyezheto(x, y)) {
               hosSebez.setText("Varazsolhatott --> Foldrenges");

                if (foldmuvesdb > 0) {
                    varazstamadaHos(0, 10 * varazslat,"Foldrengés-->");
                }
                if (ijaszdb > 0) {
                    varazstamadaHos(1, 10 * varazslat,"Foldrengés-->");
                }
                if (griffdb > 0) {
                    varazstamadaHos(2, 10 * varazslat,"Foldrengés-->");
                }
                if (lovagdb > 0) {
                    varazstamadaHos(3, 10 * varazslat,"Foldrengés-->");
                }
                if (sarkanydb > 0) {
                    varazstamadaHos(4, 10 * varazslat,"Foldrengés-->");
                }
                if (aiFoldmuvesdb > 0) {
                    varazstamadasAI(0, 10 * varazslat);
                }
                if (aiIjaszdb > 0) {
                    varazstamadasAI(1, 10 * varazslat);
                }
                if (aiGriffdb > 0) {
                    varazstamadasAI(2, 10 * varazslat);
                }
                if (aiLovagdb > 0) {
                    varazstamadasAI(3, 10 * varazslat);
                }
                if (aiSarkanydb > 0) {
                    varazstamadasAI(4, 10 * varazslat);
                }
                varazsolt=1;
                circle_foldrenges.setDisable(true);
                circle_foldrenges.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
                foldrengdb--;
                mana -= 6;
                elDont();
                label_mana.setText("" + mana);
                label_foldreng.setText("" + foldrengdb);
            }
        } else if (circle_felperzsel.isFocused()) {
            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            varazsolt=1;
            felperzselHatar(x, y, 15 * varazslat);
            circle_felperzsel.setDisable(true);
            circle_felperzsel.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
            felperzseldb--;
            mana -= 9;
            label_mana.setText("" + mana);
            elDont();
            label_felprezsel.setText("" + felperzseldb);

        }
        else if(hos_tamad.isFocused()){

            int x = (int) e.getX() / 80;
            int y = (int) e.getY() / 42;
            varazsolt=1;
            if (!elhelyezhetoEAira(x, y)) {
                int hany = keres(x, y);
                varazstamadasAI(hany, tamadas*10);
                hos_tamad.setDisable(true);
                hos_tamad.setFill(new ImagePattern(lockScreen, 0, 1.1, 1.3, 1.2, true));
                elDont();

            }

        }
    }

    //Win,Lose,Draw kezelése
    public boolean win(){
        for (int j : aiEletTomb) {
            if (j > 0) {
                return false;
            }
        }
        return true;
    }
    public boolean lose(){
        for (int j : hosEletek) {
            if (j > 0) {
                return false;
            }
        }
        return true;
    }
    public boolean draw(){
        for (int i = 0; i < aiEletTomb.length; i++) {
        if(aiEletTomb[i]>0||hosEletek[i]>0)
        {
            return false;
        }
    }
        return true;
    }
    public void elDont(){
        if(draw()){draw.setDisable(false); draw.setOpacity(1); draw.setLayoutX(400); draw.setLayoutY(250);}
        else if(win()){  win.setDisable(false); win.setOpacity(1); win.setLayoutX(400); win.setLayoutY(250); }
        else if(lose()){lose.setDisable(false); lose.setOpacity(1); lose.setLayoutX(400); lose.setLayoutY(250);}
    }
    public void Winre(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/kotprog/kotprog/Win.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void Drawra(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/kotprog/kotprog/Draw.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void Losera(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/kotprog/kotprog/Lose.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public int hanyadikKor = 1;
    //Játék indítása
    public void Start() {
        if (elhelyez.getOpacity() == 0 && mennyiegyseg() == lehelyezett) {
            start.setOpacity(0);
            start.setDisable(true);
            vanVarazslat();
            eloegysegek();
            aieloegysegek();
            kovetkezoEgyseg.setOpacity(1);
            sorba();
            //Kezdődik a játék
            hosSebez.setOpacity(1);
            aiSebez.setOpacity(1);
            kor.setText(hanyadikKor + ".");
            kor(index);


        }
    }

}
