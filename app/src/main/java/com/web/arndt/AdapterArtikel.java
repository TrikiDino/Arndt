package com.web.arndt;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdapterArtikel extends RecyclerView.Adapter<AdapterArtikel.ViewHolder> {
    AppCompatActivity appCompatActivity = new AppCompatActivity();

    // TblArtikel
    private static final String TEILE = "Teile";
    private static final String WARENGRUPPE = "Warengruppe";
    private static final String ABMESSUNG = "Abmessung";
    private static final String MASS = "Mass";
    private static final String ARTIKELNUMMER = "Artikelnummer";
    private static final String GEWICHT = "Gewicht";
    private static final String GEWICHTEINH = "GewichtEinh";
    private static final String GROESSEINCH = "GroesseINCH";
    private static final String BESCHAFFUNG = "Beschaffung";
    private static final String VERPACKEINHTEXT = "VerpackEinhText";
    private static final String GROESSEINCHDEZ = "GroesseINCHdez";

    private static final String TAG = AdapterSucherg.class.getSimpleName();

    public RecyclerView rcDetails;
    public ArrayList<CreateList.Variante> artVarianten;

    List<TblArtikel> artGruppe = new ArrayList<TblArtikel>();
    Map<String, List<TblArtikel>> mapArtikel;

    private ArrayList<CreateList.ArtGruppe> gruppeList;
    private Context context;
    //ToDo Artikel anklickbar machen, um für Email zu verwenden
    private View.OnClickListener mOnItemClickListener;

    public AdapterArtikel(Context applicationContext, ArrayList<CreateList.ArtGruppe> artikelGruppes) {
        this.gruppeList = artikelGruppes;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterArtikel.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_artikel_wsd,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterArtikel.ViewHolder holder, int i) {
        holder.tvText.setText(gruppeList.get(i).getT_text());
        holder.tvZusatz.setText(gruppeList.get(i).getT_zusatz());
        holder.tvIso.setText(gruppeList.get(i).getT_iso());
        holder.ivArtikel.setImageResource(gruppeList.get(i).getI_artikel());
        holder.ivSymbol.setImageResource(gruppeList.get(i).getI_symbol());
        holder.tvNoArt1.setText(gruppeList.get(i).getT_noArt1());
        holder.tvAusfArt1.setText(gruppeList.get(i).getT_ausfArt1());
        holder.tvNoArt2.setText(gruppeList.get(i).getT_noArt2());
        holder.tvAusfArt2.setText(gruppeList.get(i).getT_ausfArt2());

        // Varianten zu Artikel laden
        new AdapterArtikel.get_Artikel().execute();

    }

    @Override
    public int getItemCount() {
        return gruppeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvText;
        public TextView tvZusatz;
        public TextView tvIso;
        public ImageView ivArtikel;
        public ImageView ivSymbol;
        public TextView tvNoArt1;
        public TextView tvAusfArt1;
        public TextView tvNoArt2;
        public TextView tvAusfArt2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvText = itemView.findViewById(R.id.tvText);
            tvZusatz = itemView.findViewById(R.id.tvZusatz);
            tvIso = itemView.findViewById(R.id.tvIso);
            ivArtikel = itemView.findViewById(R.id.ivArtikel);
            ivSymbol = itemView.findViewById(R.id.ivSymbol);
            tvNoArt1 = itemView.findViewById(R.id.tvNoArt1);
            tvAusfArt1 = itemView.findViewById(R.id.tvAusfArt1);
            tvNoArt2 = itemView.findViewById(R.id.tvNoArt2);
            tvAusfArt2 = itemView.findViewById(R.id.tvAusfArt2);

            rcDetails = itemView.findViewById(R.id.rcVarianten);

            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }

    private class get_Artikel extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            try {
                for (CreateList.ArtGruppe katalog : gruppeList) {
                    String url = "http://www.arndt-tool.de/app/php/json.php?artikel=" + katalog.getKuerzel();
                    JSONArray jsonArray = new JSONArray(UtilDaten.getFromServer(url));

                    TblArtikel artikel;

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int teile = 1;
                        int verp = 0;
                        Double gew = 0.0;
                        Double vk = 0.0;
                        Double gInchD = 0.0;
                        Log.d(TAG, "##doInBackground 136: " + jsonObject.getString(TEILE).toString());
                        if (jsonObject.has(TEILE) && (!(jsonObject.getString(TEILE).toString().equals("null")))) {
                                teile = jsonObject.getInt(TEILE);
                        }
                        String wg = jsonObject.has(WARENGRUPPE) ? jsonObject.getString(WARENGRUPPE) : katalog.getKuerzel();
                        String abm = jsonObject.has(ABMESSUNG) ? jsonObject.getString(ABMESSUNG) : "";
                        String mass = jsonObject.has(MASS) ? jsonObject.getString(MASS) : "";
                        String artNr = jsonObject.has(ARTIKELNUMMER) ? jsonObject.getString(ARTIKELNUMMER) : "";
                        String artNr2;
                        if(jsonObject.has(GEWICHT) && (!(jsonObject.getString(GEWICHT).toString().equals("null")))){
                            gew = jsonObject.getDouble(GEWICHT);
                        }
                        String gEinh = jsonObject.has(GEWICHTEINH) ? jsonObject.getString(GEWICHTEINH) : "";
                        String gInch = jsonObject.has(GROESSEINCH) ? jsonObject.getString(GROESSEINCH) : "";
                        String gMM = jsonObject.has("GroesseMM") ? jsonObject.getString("GroesseMM") : "";
                        String laenge = jsonObject.has("laenge") ? jsonObject.getString("laenge") : "";
                        String staerke = jsonObject.has("staerke") ? jsonObject.getString("staerke") : "";
                        String Beschaffung = jsonObject.has(BESCHAFFUNG) ? jsonObject.getString(BESCHAFFUNG) : "";
                        if (jsonObject.has("VerpackEinh") && (!(jsonObject.getString("VerpackEinh").toString().equals("null")))) {
                                verp = jsonObject.getInt("VerpackEinh");
                        }
                        String verpT = jsonObject.has(VERPACKEINHTEXT) ? jsonObject.getString(VERPACKEINHTEXT) : "";
                        if (jsonObject.has("VK")&& (!(jsonObject.getString("VK").toString().equals("null")))) {
                                vk = jsonObject.getDouble("VK");
                        }
                        if(jsonObject.has(GROESSEINCHDEZ)) {
                            if(jsonObject.getString(GROESSEINCHDEZ).toString().equals("null")) {
                                gInchD = 0.0;
                            } else {
                                gInchD = jsonObject.getDouble(GROESSEINCHDEZ);
                            }
                        }
                        if (katalog.getArtikel_zeile() == 2 && artNr.contains(katalog.kenn_art_2)) {
                            artNr2 = jsonObject.has(ARTIKELNUMMER) ? jsonObject.getString(ARTIKELNUMMER) : "";
                        } else {
                            artNr2 = "";
                        }

                        artikel = new TblArtikel(teile, wg, abm, mass, artNr, artNr2, gew, gEinh, gInch,
                                gMM, laenge, staerke, Beschaffung, verp, verpT, vk, gInchD);


                        Log.d(TAG, "##getKapitel 164: " + artikel.toString());

                        artGruppe.add(artikel);
                        // ToDo Artikel-Daten in SQLite oder Firebase ablegen, evtl Firebase <=> mySQL Verbindung
                    }
//                    mapArtikel.put(katalog.getKuerzel(), artGruppe);
                    Log.d(TAG, "doInBackground 188: " + artGruppe);
                }
                return "";
            } catch (IOException e) {
                Log.e(TAG, "doInBackground: ", e);
            } catch (JSONException e) {
                Log.e(TAG, "doInBackground: ", e);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            Log.d(TAG, "onPostExecute: " + artGruppe.toString());

            String t_mass[] = new String[artGruppe.size()];
            String t_abm[] = new String[artGruppe.size()];
            int t_verp[] = new int[artGruppe.size()];
            double t_gew[] = new double[artGruppe.size()];
            String t_no1[] = new String[artGruppe.size()];
            String t_no2[] = new String[artGruppe.size()];

            int i = 0;

            for (TblArtikel artikel : artGruppe) {
                t_mass[i] = artikel.getMass().equals("mm") ? artikel.getGroesseMM() : artikel.getGroesseINCH();
                t_abm[i] = artikel.getAbmessung();
                t_verp[i] = artikel.getVerpackEinh();
                t_gew[i] = artikel.getGewicht();
                t_no1[i] = artikel.getArtikelnummer();
                t_no2[i] = artikel.getArtikelnummer2();

                i++;
            }
            artVarianten = prepareVariante(t_mass, t_abm, t_verp, t_gew, t_no1, t_no2);

            RecyclerView.LayoutManager layoutManager;
            layoutManager = new LinearLayoutManager(context);
            ViewCompat.setNestedScrollingEnabled(rcDetails, false);
            rcDetails.setLayoutManager(layoutManager);

            AdapterVariante adapter = new AdapterVariante(context, artVarianten);
            rcDetails.setAdapter(adapter);

        }
    }

    private ArrayList<CreateList.Variante> prepareVariante(String[] t_mass, String[] t_abm,
                                                           int[] t_verp, double[] t_gew,
                                                           String[] t_no1, String[] t_no2) {

        ArrayList<CreateList.Variante> artVariante = new ArrayList<>();
        for (int i = 0; i < t_mass.length; i++) {
            CreateList.Variante createList = new CreateList.Variante();
            createList.setT_mass(t_mass[i]);
            createList.setT_abm(t_abm[i]);
            createList.setT_verp(t_verp[i]);
            createList.setT_gew(t_gew[i]);
            createList.setT_no1(t_no1[i]);
            createList.setT_no2(t_no2[i]);
            artVariante.add(createList);
        }
        return artVariante;
    }

}
