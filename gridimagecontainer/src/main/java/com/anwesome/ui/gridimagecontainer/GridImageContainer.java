package com.anwesome.ui.gridimagecontainer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 24/04/17.
 */
public class GridImageContainer {
    private Activity activity;
    private RelativeLayout relativeLayout;
    private List<ImageContainer> imageContainers = new ArrayList<>();
    private boolean isShown = false;
    public GridImageContainer(Activity activity) {
        this.activity = activity;
        relativeLayout = new RelativeLayout(activity);
        activity.setContentView(relativeLayout);
    }
    public void addImages(List<Bitmap> bitmaps,float x,float y) {
        if(!isShown) {
            ImageContainerView imageContainerView = new ImageContainerView(activity);
            imageContainerView.setX(x);
            imageContainerView.setY(y);
            imageContainerView.setScaleX(0.2f);
            imageContainerView.setScaleY(0.2f);
            relativeLayout.addView(imageContainerView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            ImageContainer imageContainer = new ImageContainer(imageContainerView,x,y);
            imageContainers.add(imageContainer);
        }
    }

}
