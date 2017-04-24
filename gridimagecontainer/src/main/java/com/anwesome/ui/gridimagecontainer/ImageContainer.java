package com.anwesome.ui.gridimagecontainer;

import android.graphics.Bitmap;

import java.util.List;

/**
 * Created by anweshmishra on 24/04/17.
 */
public class ImageContainer {
    private ImageContainerView imageContainerView;
    private float x,y,scale = 0.2f,initX,initY;
    public ImageContainer(ImageContainerView imageContainerView,float x,float y) {
        this.x = x;
        this.y = y;
        this.initX = x;
        this.initY = y;
        this.imageContainerView = imageContainerView;
    }

    public ImageContainerView getImageContainerView() {
        return imageContainerView;
    }
    public float getScale() {
        return scale;
    }
    public void updateScale(float factor) {
        this.scale = 0.2f+0.8f*factor;
        imageContainerView.setScaleX(scale);
        imageContainerView.setScaleY(scale);
    }
    public void updateXY(float factor) {
        x = initX*(1-factor);
        y = initY*(1-factor);
        imageContainerView.setX(x);
        imageContainerView.setY(y);
    }
    public static ImageContainer create(ImageContainerView imageContainerView, float x, float y) {
        return new ImageContainer(imageContainerView,x,y);
    }
}
