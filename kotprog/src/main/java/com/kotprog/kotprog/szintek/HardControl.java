package com.kotprog.kotprog.szintek;
import com.kotprog.kotprog.controlok.GameControl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
/**
 * Nehéz osztály, itt a kiválasztott szint --> nehéz kezelése zajlik
 * Ami azt jelenti, hogy 700 golddal rendelkezik a játékos, és ezt tudja elkölteni kedvére
 * Majd itt küldjük el az adatokat is a GameControlnak, persze csak a nehéz résznek
 */
public class HardControl {

    @FXML
    //Labels
    public Label t;
    public Label tudas;
    public Label d;
    public Label v;
    public Label m;
    public Label sz;
    public Label penz;
    public Label fold_db;
    public Label ijasz_db;
    public Label griff_db;
    public Label lovag_db;
    public Label sarkany_db;
    public Label vill_db;
    public Label tuz_db;
    public Label fel_db;
    public Label foldreng_db;
    public Label felperzs_db;
    //Változók

    public long kerul = 5;
    public int penz_ertek = 700;

    public int fold_ertek = 2;
    public int ijasz_ertek = 6;
    public int griff_ertek = 15;
    public int lovag_ertek = 40;
    public int sarkany_ertek = 120;
    public int vill_ertek = 60;
    public int tuz_ertek = 120;
    public int fel_ertek = 120;
    public int foldreng_ertek = 100;
    public int felperzs_ertek = 120;
    //db
    public int tudas_ertek=1;
    public int t_ertek = 1;
    public int d_ertek = 1;
    public int v_ertek = 1;
    public int m_ertek = 1;
    public int sz_ertek = 1;
    public int fold = 0;
    public int ijasz = 0;
    public int griff = 0;
    public int lovag = 0;
    public int sarkany = 0;
    public int vill = 0;
    public int tuz = 0;
    public int fel = 0;
    public int foldreng = 0;
    public int felperzs = 0;
    //ai
    public int aiTudas_ertek=1;
    public int aiT_ertek = 1;
    public int aiD_ertek = 1;
    public int aiV_ertek = 1;
    public int aiM_ertek = 1;
    public int aiSz_ertek = 1;
    public int aiFold = 0;
    public int aiIjasz = 0;
    public int aiGriff = 0;
    public int aiLovag = 0;
    public int aiSarkany = 0;
    public int aiVill = 0;
    public int aiTuz = 0;
    public int aiFel = 0;
    public int aiFoldreng = 0;
    public int aiFelperzs = 0;
    //jatek
    private Stage stage;
    private Scene scene;
    private Parent root;

    public int egyseg=0;
    public void startGame(ActionEvent e) throws IOException {
        if(egyseg>0){
            aiVasarol();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/kotprog/kotprog/Game.fxml"));
            root = loader.load();
            GameControl gameControl = loader.getController();
            gameControl.tamadas_get(t_ertek);
            gameControl.varazslat_get(v_ertek);
            gameControl.moral_get(m_ertek);
            gameControl.defense_get(d_ertek);
            gameControl.szerencse_get(sz_ertek);
            gameControl.tudas_get(tudas_ertek);
            gameControl.foldmuvesdb_get(fold);
            gameControl.ijaszdb_get(ijasz);
            gameControl.griffdb_get(griff);
            gameControl.lovagdb_get(lovag);
            gameControl.sarkanydb_get(sarkany);
            gameControl.villam_get(vill);
            gameControl.tuzgolyo_get(tuz);
            gameControl.felperzsel_get(felperzs);
            gameControl.foldreng_get(foldreng);
            gameControl.feltamaszt_get(fel);

            gameControl.aiT_get(aiT_ertek);
            gameControl.aiTud_get(aiTudas_ertek);
            gameControl.aiDef_get(aiD_ertek);
            gameControl.aiV_get(aiV_ertek);
            gameControl.aiM_get(aiM_ertek);
            gameControl.aiSZ_get(aiSz_ertek);
            gameControl.aiF_get(aiFold);
            gameControl.aiI_get(aiIjasz);
            gameControl.aiG_get(aiGriff);
            gameControl.aiL_get(aiLovag);
            gameControl.aiS_get(aiSarkany);
            gameControl.aiVill_get(aiVill);
            gameControl.aiTuz_get(aiTuz);
            gameControl.aiFel_get(aiFel);
            gameControl.aiFoldreng_get(aiFoldreng);
            gameControl.aiFelperzs_get(aiFelperzs);

            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();}

    }

    public void back(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/com/kotprog/kotprog/Single.fxml"));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }
    public long vasarlas(long x) {
        if (penz_ertek - kerul >= 0) {
            penz_ertek -= kerul;
            penz.setText("" + penz_ertek);
            kerul = Math.round(x * 1.10);
            return kerul;
        }
        return penz_ertek;
    }

    public long vissza(long x) {
        if (penz_ertek + kerul <= 700) {
            penz_ertek += kerul;
            penz.setText("" + penz_ertek);
            kerul = Math.round(x * 0.90);
            return kerul;
        }
        return penz_ertek;
    }

    //t-támadás d-védekezés v-varázslat m-morla sz-szerencse
    //novel növekszik az érték
    //csokkent csökken az érték
    public void novel_t()  {
        if (t_ertek + 1 <= 10 && penz_ertek - kerul >= 0) {
            t_ertek++;
            t.setText("" + t_ertek);
            vasarlas(kerul);
        }
    }
    public void novel_tudas() {
        if (tudas_ertek + 1 <= 10 && penz_ertek - kerul >= 0) {
            tudas_ertek++;
            tudas.setText("" + tudas_ertek);
            vasarlas(kerul);
        }
    }
    public void novel_d()  {
        if (d_ertek + 1 <= 10 && penz_ertek - kerul >= 0) {
            d_ertek++;
            d.setText("" + d_ertek);
            vasarlas(kerul);
        }
    }

    public void novel_v()  {
        if (v_ertek + 1 <= 10 && penz_ertek - kerul >= 0) {
            v_ertek++;
            v.setText("" + v_ertek);
            vasarlas(kerul);
        }
    }

    public void novel_m()  {
        if (m_ertek + 1 <= 10 && penz_ertek - kerul >= 0) {
            m_ertek++;
            m.setText("" + m_ertek);
            vasarlas(kerul);
        }
    }

    public void novel_sz()  {
        if (sz_ertek + 1 <= 10 && penz_ertek - kerul >= 0) {
            sz_ertek++;
            sz.setText("" + sz_ertek);
            vasarlas(kerul);
        }
    }

    public void csok_t()  {
        if (t_ertek - 1 >= 1) {
            t_ertek--;
            t.setText("" + t_ertek);
            vissza(kerul);
        }
    }
    public void csok_tudas()  {
        if (tudas_ertek - 1 >= 1) {
            tudas_ertek--;
            tudas.setText("" + tudas_ertek);
            vissza(kerul);
        }
    }
    public void csok_d()  {
        if (d_ertek - 1 >= 1) {
            d_ertek--;
            d.setText("" + d_ertek);
            vissza(kerul);
        }
    }

    public void csok_v()  {
        if (v_ertek - 1 >= 1) {
            v_ertek--;
            v.setText("" + v_ertek);
            vissza(kerul);
        }
    }

    public void csok_m()  {
        if (m_ertek - 1 >= 1) {
            m_ertek--;
            m.setText("" + m_ertek);
            vissza(kerul);
        }
    }

    public void csok_sz()  {
        if (sz_ertek - 1 >= 1) {
            sz_ertek--;
            sz.setText("" + sz_ertek);
            vissza(kerul);
        }
    }

    public void fold_vet()  {

        if (penz_ertek - fold_ertek >= 0) {
            fold++;
            fold_db.setText("" + fold);
            penz_ertek -= fold_ertek;
            penz.setText("" + penz_ertek);
            egyseg++;
        }

    }

    public void ijasz_vet()  {
        if (penz_ertek - ijasz_ertek >= 0) {
            ijasz++;
            ijasz_db.setText("" + ijasz);
            penz_ertek -= ijasz_ertek;
            penz.setText("" + penz_ertek);
            egyseg++;

        }
    }

    public void griff_vet()  {
        if (penz_ertek - griff_ertek >= 0) {
            griff++;
            griff_db.setText("" + griff);
            penz_ertek -= griff_ertek;
            penz.setText("" + penz_ertek);
            egyseg++;

        }
    }

    public void lovag_vet()  {
        if (penz_ertek - lovag_ertek >= 0) {
            lovag++;
            lovag_db.setText("" + lovag);
            penz_ertek -= lovag_ertek;
            penz.setText("" + penz_ertek);
            egyseg++;

        }
    }

    public void sarkany_vet()  {
        if (penz_ertek - sarkany_ertek >= 0) {
            sarkany++;
            sarkany_db.setText("" + sarkany);
            penz_ertek -= sarkany_ertek;
            penz.setText("" + penz_ertek);
            egyseg++;

        }
    }

    public void fold_el()  {
        if (fold - 1 >= 0) {
            fold--;
            fold_db.setText("" + fold);
            penz_ertek += fold_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
                egyseg--;
            }
        }
    }

    public void ijasz_el()  {
        if (ijasz - 1 >= 0) {
            ijasz--;
            ijasz_db.setText("" + ijasz);
            penz_ertek += ijasz_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
                egyseg--;
            }
        }
    }

    public void griff_el()  {
        if (griff - 1 >= 0) {
            griff--;
            griff_db.setText("" + griff);
            penz_ertek += griff_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
                egyseg--;
            }
        }
    }

    public void lovag_el()  {
        if (lovag - 1 >= 0) {
            lovag--;
            lovag_db.setText("" + lovag);
            penz_ertek += lovag_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
                egyseg--;
            }
        }
    }

    public void sarkany_el()  {
        if (sarkany - 1 >= 0) {
            sarkany--;
            sarkany_db.setText("" + sarkany);
            penz_ertek += sarkany_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
                egyseg--;
            }
        }
    }

    public void vill_vet()  {

        if (penz_ertek - vill_ertek >= 0) {
            vill++;
            vill_db.setText("" + vill);
            penz_ertek -= vill_ertek;
            penz.setText("" + penz_ertek);
        }
    }

    public void tuz_vet()  {

        if (penz_ertek - tuz_ertek >= 0) {
            tuz++;
            tuz_db.setText("" + tuz);
            penz_ertek -= tuz_ertek;
            penz.setText("" + penz_ertek);
        }
    }

    public void fel_vet()  {

        if (penz_ertek - fel_ertek >= 0) {
            fel++;
            fel_db.setText("" + fel);
            penz_ertek -= fel_ertek;
            penz.setText("" + penz_ertek);
        }
    }

    public void foldreng_vet()  {

        if (penz_ertek - foldreng_ertek >= 0) {
            foldreng++;
            foldreng_db.setText("" + foldreng);
            penz_ertek -= foldreng_ertek;
            penz.setText("" + penz_ertek);

        }
    }

    public void felperzs_vet()  {

        if (penz_ertek - felperzs_ertek >= 0) {
            felperzs++;
            felperzs_db.setText("" + felperzs);
            penz_ertek -= felperzs_ertek;
            penz.setText("" + penz_ertek);
        }
    }

    public void vill_el()  {

        if (vill - 1 >= 0) {
            vill--;
            vill_db.setText("" + vill);
            penz_ertek += vill_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
            }
        }
    }

    public void tuz_el()  {

        if (tuz - 1 >= 0) {
            tuz--;
            tuz_db.setText("" + tuz);
            penz_ertek += tuz_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
            }
        }
    }

    public void fel_el()  {

        if (fel - 1 >= 0) {
            fel--;
            fel_db.setText("" + fel);
            penz_ertek += fel_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
            }
        }
    }

    public void foldreng_el()  {

        if (foldreng - 1 >= 0) {
            foldreng--;
            foldreng_db.setText("" + foldreng);
            penz_ertek += foldreng_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
            }
        }
    }

    public void felperzs_el()  {

        if (felperzs - 1 >= 0) {
            felperzs--;
            felperzs_db.setText("" + felperzs);
            penz_ertek += felperzs_ertek;
            penz.setText("" + penz_ertek);
            if (penz_ertek > 700) {
                penz_ertek = 700;
                penz.setText("700");
            }
        }
    }
    int szam;
    public int randomCucc(int meddig){
        Random x= new Random();
        szam = x.nextInt(1, meddig+1);
        return szam;
    }

    public int aiArany=1000;
    public long aiKerul=5;
    public void aiKoltes(){
        aiArany-=aiKerul;
        aiKerul = Math.round(aiKerul * 1.10);
    }
    public void aiVasarol(){

        //Max 15 hős tulajdonság
        for (int i=0; i<15;i++){
            int index = randomCucc(6);
            switch (index) {
                case 1 -> {
                    aiT_ertek++;
                    aiKoltes();
                }
                case 2 -> {
                    aiD_ertek++;
                    aiKoltes();
                }
                case 3 -> {
                    aiV_ertek++;
                    aiKoltes();
                }
                case 4 -> {
                    aiM_ertek++;
                    aiKoltes();
                }
                case 5 -> {
                    aiSz_ertek++;
                    aiKoltes();
                }
                case 6 -> {
                    aiTudas_ertek++;
                    aiKoltes();
                }
            }
        }

        //Max 3 db varázslat

        for (int i = 0; i < 3; i++) {
            int index = randomCucc(5);
            switch (index) {
                case 1 -> {
                    aiVill++; aiArany-=vill_ertek;
                }
                case 2 -> {
                    aiTuz++; aiArany-=tuz_ertek;
                }
                case 3 -> {
                    aiFel++; aiArany-=fel_ertek;
                }
                case 4 -> {
                    aiFoldreng++; aiArany-=foldreng_ertek;
                }
                case 5 -> {
                    aiFelperzs++; aiArany-=felperzs_ertek;
                }

            }
        }
        //350 arany marad ez lesz az egységekre leosztva
        //Vizsgálat, hogy van-e elég pénze

        while (aiArany != 0) {
            int index = randomCucc(5);

            switch (index) {
                case 1 -> {
                    if (aiArany - fold_ertek >= 0) {
                        aiArany -= fold_ertek;
                        aiFold++;
                    }

                }
                case 2 -> {
                    if (aiArany - ijasz_ertek >= 0) {
                        aiArany -= ijasz_ertek;
                        aiIjasz++;
                    }
                }
                case 3 -> {
                    if (aiArany - griff_ertek >= 0) {
                        aiArany -= griff_ertek;
                        aiGriff++;
                    }
                }
                case 4 -> {
                    if (aiArany - lovag_ertek >= 0) {
                        aiArany -= lovag_ertek;
                        aiLovag++;
                    }
                }
                case 5 -> {
                    if (aiArany - sarkany_ertek >= 0) {
                        aiArany -= sarkany_ertek;
                        aiSarkany++;
                    }
                }

            }
            if(aiArany-fold_ertek<0&& aiArany-sarkany_ertek<0&& aiArany-lovag_ertek<0&& aiArany-griff_ertek<0&& aiArany-ijasz_ertek<0)
            {
                break;
            }
        }


    }
}
