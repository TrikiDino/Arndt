package com.web.arndt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

public class KatalogGruppeListAdapter extends BaseAdapter {

    private List<String> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public KatalogGruppeListAdapter(Context aContext, String katInd) {
        this.context = aContext;
        this.listData = Arrays.asList(new KatalogGruppe(katInd).getGruppe());
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        KatalogGruppeListAdapter.ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_katalog, null);
            holder = new KatalogGruppeListAdapter.ViewHolder();
            holder.grupLeftView = (ImageView) convertView.findViewById(R.id.imageView_left);
            holder.grupMidView = (ImageView) convertView.findViewById(R.id.imageView_mid);
            holder.grupRightView = (ImageView) convertView.findViewById(R.id.imageView_right);
            convertView.setTag(holder);
        } else {
            holder = (KatalogGruppeListAdapter.ViewHolder) convertView.getTag();
        }

        String katGruppeLeft = this.listData.get(position);
        int imageId = this.getMipmapResIdByName(katGruppeLeft);
        holder.grupLeftView.setImageResource(imageId);
        if(position+1 < listData.size()) {
            position++;
            String katGruppeMid = this.listData.get(position);
            imageId = this.getMipmapResIdByName(katGruppeMid);
            holder.grupMidView.setImageResource(imageId);
            if(position+1 < listData.size()) {
                position++;
                String katGruppeRight = this.listData.get(position);
                imageId = this.getMipmapResIdByName(katGruppeRight);
                holder.grupRightView.setImageResource(imageId);
            }
        }
        //holder.countryNameView.setText(katalog.getKatGrupText());



        return convertView;
    }

    // Find Image ID corresponding to the name of the image (in the directory mipmap).
    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }

    static class ViewHolder {
        ImageView grupLeftView;
        ImageView grupMidView;
        ImageView grupRightView;
    }
}
