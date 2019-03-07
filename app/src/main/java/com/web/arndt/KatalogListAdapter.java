package com.web.arndt;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class KatalogListAdapter extends BaseAdapter {

    private ArrayList<Katalog> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public KatalogListAdapter(Context aContext, ArrayList<Katalog> listData) {
        this.context = aContext;
        this.listData = listData;
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

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_kat_layout, null);
            holder = new ViewHolder();
            holder.katView = (ImageView) convertView.findViewById(R.id.imageView_kat);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Katalog katalog = this.listData.get(position);
        //holder.countryNameView.setText(katalog.getKatGrupText());

        int imageId = this.getMipmapResIdByName(katalog.getImgName());

        holder.katView.setImageResource(imageId);

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
        ImageView katView;
    }

}