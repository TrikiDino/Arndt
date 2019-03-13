package com.web.arndt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdapterKatalogGruppeList extends RecyclerView.Adapter<AdapterKatalogGruppeList.ViewHolder> {

    private ArrayList<ActivitySucherg.CreateList> kapitelList;
    private Context context;

    private static final String TAG = AdapterKatalogGruppeList.class.getSimpleName();

    public AdapterKatalogGruppeList(Context context, ArrayList<ActivitySucherg.CreateList> galleryList) {
        this.kapitelList = galleryList;
        this.context = context;
    }

    @Override
    public AdapterKatalogGruppeList.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterKatalogGruppeList.ViewHolder viewHolder, int i) {
        viewHolder.tvArt.setText(kapitelList.get(i).getT_artikel());
        viewHolder.tvMass.setText(kapitelList.get(i).getT_mass());
        //viewHolder.ivArt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.ivArt.setImageResource((kapitelList.get(i).getI_artikel()));
        //viewHolder.ivSymbol.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.ivSymbol.setImageResource((kapitelList.get(i).getI_symbol()));
    }

    @Override
    public int getItemCount() {

        Log.d(TAG, "##getItemCount: " + kapitelList.size());
        return kapitelList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tvArt;
        private TextView tvMass;
        private ImageView ivArt;
        private ImageView ivSymbol;
        public ViewHolder(View view) {
            super(view);

            tvArt = (TextView) view.findViewById(R.id.tvArt);
            tvMass = (TextView) view.findViewById(R.id.tvMass);
            ivArt = (ImageView) view.findViewById(R.id.ivArt);
            ivSymbol = (ImageView) view.findViewById(R.id.ivSymbol);
        }
    }


    //    private List<String> listData;
//    private LayoutInflater layoutInflater;
//    private Context context;
//
//    public AdapterKatalogGruppeList(Context aContext, String katInd) {
//        this.context = aContext;
//        //this.listData = Arrays.asList(new TblKatalogGruppe(katInd).getGruppe());
//        layoutInflater = LayoutInflater.from(aContext);
//    }
//
//    @Override
//    public int getCount() {
//        return listData.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return listData.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        AdapterKatalogGruppeList.ViewHolder holder;
//        if (convertView == null) {
//            convertView = layoutInflater.inflate(R.layout.activity_kapitel, null);
//            holder = new AdapterKatalogGruppeList.ViewHolder();
//            holder.grupLeftView = (ImageView) convertView.findViewById(R.id.imageView_left);
//            holder.grupMidView = (ImageView) convertView.findViewById(R.id.imageView_mid);
//            holder.grupRightView = (ImageView) convertView.findViewById(R.id.imageView_right);
//            convertView.setTag(holder);
//        } else {
//            holder = (AdapterKatalogGruppeList.ViewHolder) convertView.getTag();
//        }
//
//        String katGruppeLeft = this.listData.get(position);
//        int imageId = this.getMipmapResIdByName(katGruppeLeft);
//        holder.grupLeftView.setImageResource(imageId);
//        if(position+1 < listData.size()) {
//            position++;
//            String katGruppeMid = this.listData.get(position);
//            imageId = this.getMipmapResIdByName(katGruppeMid);
//            holder.grupMidView.setImageResource(imageId);
//            if(position+1 < listData.size()) {
//                position++;
//                String katGruppeRight = this.listData.get(position);
//                imageId = this.getMipmapResIdByName(katGruppeRight);
//                holder.grupRightView.setImageResource(imageId);
//            }
//        }
//        //holder.countryNameView.setText(katalog.getKatGrupText());
//
//
//
//        return convertView;
//    }
//
//    // Find Image ID corresponding to the name of the image (in the directory mipmap).
//    public int getMipmapResIdByName(String resName)  {
//        String pkgName = context.getPackageName();
//        // Return 0 if not found.
//        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
//        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
//        return resID;
//    }
//
//    static class ViewHolder {
//        ImageView grupLeftView;
//        ImageView grupMidView;
//        ImageView grupRightView;
//    }
}
