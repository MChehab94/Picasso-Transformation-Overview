package mchehab.com.picassotransformationoverview;

import com.squareup.picasso.Transformation;

/**
 * Created by muhammadchehab on 12/5/17.
 */

public class ImageTransform {

    private String imageURL;
    private Transformation transformation;

    public ImageTransform(String imageURL, Transformation transformation) {
        this.imageURL = imageURL;
        this.transformation = transformation;
    }

    public Transformation getTransformation() {
        return transformation;
    }

    public void setTransformation(Transformation transformation) {
        this.transformation = transformation;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}