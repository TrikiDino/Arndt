package com.web.arndt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterSucherg extends RecyclerView.Adapter<AdapterSucherg.ViewHolder> {

    private static final String TAG = AdapterSucherg.class.getSimpleName();

    private ArrayList<ActivitySucherg.CreateList> kapitelList;
    private Context context;
    private View.OnClickListener mOnItemClickListener;

    public AdapterSucherg(Context context, ArrayList<ActivitySucherg.CreateList> galleryList) {
        this.kapitelList = galleryList;
        this.context = context;
    }

    @Override
    public AdapterSucherg.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_sucherg, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterSucherg.ViewHolder viewHolder, int i) {
        viewHolder.tvArt.setText(kapitelList.get(i).getT_artikel());
        viewHolder.tvMass.setText(kapitelList.get(i).getT_mass());
        viewHolder.ivArt.setImageResource((kapitelList.get(i).getI_artikel()));
        viewHolder.ivSymbol.setImageResource((kapitelList.get(i).getI_symbol()));
    }

    @Override
    public int getItemCount() {

        return kapitelList.size();

    }


    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvArt;
        public TextView tvMass;
        public ImageView lo;
        public ImageView lu;
        public ImageView ro;
        public ImageView ru;
        public ImageView ivArt;
        public ImageView ivSymbol;

        public ViewHolder(View itemView) {
            super(itemView);
            tvArt = itemView.findViewById(R.id.tvArt);
            tvMass = itemView.findViewById(R.id.tvMass);
            lo = itemView.findViewById(R.id.lo);
            lu = itemView.findViewById(R.id.lu);
            ro = itemView.findViewById(R.id.ro);
            ru = itemView.findViewById(R.id.ru);
            ivArt = itemView.findViewById(R.id.ivArt);
            ivSymbol = itemView.findViewById(R.id.ivSymbol);

            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }

}

