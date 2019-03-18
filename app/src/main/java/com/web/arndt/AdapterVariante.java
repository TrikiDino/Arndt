package com.web.arndt;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterVariante  extends RecyclerView.Adapter<AdapterVariante.ViewHolder>{

    private static final String TAG = AdapterVariante.class.getSimpleName();

    private ArrayList<CreateList.Variante> varList;
    private Context context;

    public AdapterVariante(Context context, ArrayList<CreateList.Variante> varList) {
        this.varList = varList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterVariante.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_art_varianten_wsd,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVariante.ViewHolder viewHolder, int i) {
        viewHolder.tvMass.setText(varList.get(i).getT_mass());
        viewHolder.tvAbm.setText(varList.get(i).getT_abm());
        viewHolder.tvVerp.setText(String.valueOf(varList.get(i).getT_verp()));
        viewHolder.tvGew.setText(String.valueOf(varList.get(i).getT_gew()));
        viewHolder.tvNo1.setText(varList.get(i).getT_no1());
        viewHolder.tvNo2.setText(varList.get(i).getT_no2());
    }

    @Override
    public int getItemCount() {
        return varList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMass;
        public TextView tvAbm;
        public TextView tvVerp;
        public TextView tvGew;
        public TextView tvNo1;
        public TextView tvNo2;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMass = itemView.findViewById(R.id.tvMass);
            tvAbm = itemView.findViewById(R.id.tvAbm);
            tvVerp = itemView.findViewById(R.id.tvVerp);
            tvGew = itemView.findViewById(R.id.tvGew);
            tvNo1 = itemView.findViewById(R.id.tvNo1);
            tvNo2 = itemView.findViewById(R.id.tvNo2);

        }
    }
}
