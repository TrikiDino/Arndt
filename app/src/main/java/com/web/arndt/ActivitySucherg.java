package com.web.arndt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

// ToDo Anzeige des Suchergebnisses und Auswählmöglichkeit
// händelt die Anzeige eines Suchergebnisses oder eines Katalogkapitels

public class ActivitySucherg extends AppCompatActivity {

    private static final String TAG = ActivitySucherg.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kapitel);

        String para = getIntent().getExtras().getString("para","");
        Log.d(TAG, "##onCreate: " + para);

        try {
            TblKatalogGruppe[] katGruppe = UtilDaten.get_Kapitel(para);
            Log.d(TAG, "##onCreate: " + katGruppe.toString());
            String t_artikel[] = new String[katGruppe.length];
            String t_mass[] = new String[katGruppe.length];
            Integer i_artikel[] = new Integer[katGruppe.length];
            Integer i_symbol[] = new Integer[katGruppe.length];

            for(int i = 0;i<katGruppe.length;i++){
                i_artikel[i] = (Integer) this.getResources().getIdentifier("p"+ katGruppe[i].getKuerzel(),"drawable",this.getPackageName());
                i_symbol[i] = (Integer) this.getResources().getIdentifier("p"+ katGruppe[i].getSymbol_grafik_1(),"drawable",this.getPackageName());
                t_artikel[i] = katGruppe[i].getKuerzel();
                t_mass[i] =katGruppe[i].getMasseinheit();
            }
            Log.d(TAG, "##i_artikel: " + i_artikel.toString());
            Log.d(TAG, "##i_symbol: " + i_symbol.toString());
            Log.d(TAG, "##t_artikel: " + t_artikel.toString());
            Log.d(TAG, "##t_mass: " + t_mass.toString());

            RecyclerView recyclerView = (RecyclerView)findViewById(R.id.katGruppe);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);
            recyclerView.setLayoutManager(layoutManager);
            ArrayList<CreateList> katalogGruppes = prepareData(t_artikel, t_mass, i_artikel, i_symbol);
            AdapterKatalogGruppeList adapter = new AdapterKatalogGruppeList(getApplicationContext(), katalogGruppes);
            recyclerView.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
    public class CreateList {

        private String t_artikel;
        private String t_mass;
        private Integer i_artikel;
        private Integer i_symbol;

        public String getT_artikel() {
            return t_artikel;
        }

        public void setT_artikel(String t_artikel) {
            this.t_artikel = t_artikel;
        }

        public String getT_mass() {
            return t_mass;
        }

        public void setT_mass(String t_mass) {
            this.t_mass = t_mass;
        }

        public Integer getI_artikel() {
            return i_artikel;
        }

        public void setI_artikel(Integer i_artikel) {
            this.i_artikel = i_artikel;
        }

        public Integer getI_symbol() {
            return i_symbol;
        }

        public void setI_symbol(Integer i_symbol) {
            this.i_symbol = i_symbol;
        }
    }

    private ArrayList<CreateList> prepareData(String[] t_artikel, String[] t_mass, Integer[] i_artikel, Integer[] i_symbol){

        ArrayList<CreateList> imgArtikel = new ArrayList<>();
        for(int i = 0; i< t_artikel.length; i++){
            CreateList createList = new CreateList();
            createList.setT_artikel(t_artikel[i]);
            createList.setT_mass(t_mass[i]);
            createList.setI_artikel(i_artikel[i]);
            createList.setI_symbol(i_symbol[i]);
            imgArtikel.add(createList);
        }
        return imgArtikel;
    }
}

