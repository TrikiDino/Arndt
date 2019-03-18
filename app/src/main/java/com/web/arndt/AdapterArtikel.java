package com.web.arndt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AdapterArtikel extends RecyclerView.Adapter<AdapterSucherg.ViewHolder> {

    private static final String TAG = AdapterSucherg.class.getSimpleName();

    private ArrayList<ActivityArtikel.CreateList> kapitelList;
    private Context context;

    public AdapterArtikel(Context applicationContext, ArrayList<ActivityArtikel.CreateList> artikelGruppes) {
        this.kapitelList = artikelGruppes;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterSucherg.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSucherg.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
