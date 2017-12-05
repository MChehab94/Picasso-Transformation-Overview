package mchehab.com.picassotransformationoverview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.BlurTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;
import jp.wasabeef.picasso.transformations.CropSquareTransformation;
import jp.wasabeef.picasso.transformations.CropTransformation;
import jp.wasabeef.picasso.transformations.GrayscaleTransformation;
import jp.wasabeef.picasso.transformations.gpu.InvertFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.SwirlFilterTransformation;
import jp.wasabeef.picasso.transformations.gpu.ToonFilterTransformation;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Picasso.with(this).setLoggingEnabled(true);

        String IMAGE_URL = "http://wallpaper-gallery.net/images/image/image-19.jpg";

        List<ImageTransform> listImageTransform = new ArrayList<>();
        listImageTransform.add(new ImageTransform(IMAGE_URL, new CropCircleTransformation()));
        listImageTransform.add(new ImageTransform(IMAGE_URL, new CropSquareTransformation()));
        listImageTransform.add(new ImageTransform(IMAGE_URL, new CropTransformation(250, 250, 0, 0)));
        listImageTransform.add(new ImageTransform(IMAGE_URL, new BlurTransformation(this)));
        listImageTransform.add(new ImageTransform(IMAGE_URL, new ToonFilterTransformation(this)));
        listImageTransform.add(new ImageTransform(IMAGE_URL, new InvertFilterTransformation(this)));
        listImageTransform.add(new ImageTransform(IMAGE_URL, new PixelationFilterTransformation(this)));
        listImageTransform.add(new ImageTransform(IMAGE_URL, new GrayscaleTransformation()));
        listImageTransform.add(new ImageTransform(IMAGE_URL, new SwirlFilterTransformation(this)));

        ListView listView = findViewById(R.id.listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listImageTransform);

        listView.setAdapter(listViewAdapter);
    }
}