package com.example.androidapp;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*Here we have the tips with images to work properly*/

public class ListAdapter extends BaseAdapter {

    Context context;
    private final String [] values;
    private final int [] images;

    public ListAdapter(Context context, String [] values,  int [] images){
        this.context = context;
        this.values = values;
        this.images = images;
    }

    //total items
    @Override
    public int getCount() {
        return values.length;
    }

    //data id
    @Override
    public Object getItem(int i) {
        return i;
    }

    //row id
    @Override
    public long getItemId(int i) {
        return i;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {

            // If there's no view to re-use, inflate a brand new view for row
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);

            //inflate the xml which gives us a view
            convertView = inflater.inflate(R.layout.activity_custom_tips, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.aNametxt);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.appIconIV);
            //the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        }
        else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Populate the data from the data object from the viewHolder object
        // into the view.
        viewHolder.txtName.setText(values[position]);
        viewHolder.icon.setImageResource(images[position]);

        // Return the completed view on screen
        return convertView;
    }

    private static class ViewHolder {
        TextView txtName;
        ImageView icon;
    }

}

