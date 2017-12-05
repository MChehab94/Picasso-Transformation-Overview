package mchehab.com.picassotransformationoverview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by muhammadchehab on 12/5/17.
 */

public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<ImageTransform> listImageTransform;

    public ListViewAdapter(Context context, List<ImageTransform> listImageTransform){
        this.context = context;
        this.listImageTransform = listImageTransform;
    }

    @Override
    public int getCount() {
        return listImageTransform.size();
    }

    @Override
    public Object getItem(int position) {
        return listImageTransform.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_row, null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.imageView);

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ImageTransform imageTransform = listImageTransform.get(position);
        Picasso.with(context)
                .load(imageTransform.getImageURL())
                .transform(imageTransform.getTransformation())
                .into(viewHolder.imageView);

        return convertView;
    }

    class ViewHolder{
        ImageView imageView;
    }
}