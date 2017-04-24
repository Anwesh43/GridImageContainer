package com.anwesome.ui.gridimagecontainer;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.anwesome.ui.gridimagecontainer.controller.ViewAnimationController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 24/04/17.
 */
public class GridImageContainer {
    private Activity activity;
    private ViewAnimationController currController = null;
    private RelativeLayout relativeLayout;
    private List<ImageContainer> imageContainers = new ArrayList<>();
    private boolean isShown = false;
    public GridImageContainer(Activity activity) {
        this.activity = activity;
        relativeLayout = new RelativeLayout(activity);
        activity.setContentView(relativeLayout);
    }
    public void setImageContainerViewAsMainView(ImageContainerView imageContainerView) {
        relativeLayout.removeView(imageContainerView);
        activity.setContentView(imageContainerView);
    }
    public void addImages(List<Bitmap> bitmaps,float x,float y) {
        ImageContainerView imageContainerView = new ImageContainerView(activity);
        imageContainerView.setPivotX(0);
        imageContainerView.setPivotY(0);
        imageContainerView.setX(x);
        imageContainerView.setY(y);
        imageContainerView.setScaleX(0.2f);
        imageContainerView.setScaleY(0.2f);
        imageContainerView.setImageElement(bitmaps);
        ImageContainer imageContainer = new ImageContainer(imageContainerView,x,y);
        final ViewAnimationController viewAnimationController = new ViewAnimationController(this,imageContainer);
        imageContainerView.setOnTouchShrinkListener(new ImageContainerView.OnTouchShrinkListener() {
            @Override
            public void onTouch() {
                if(currController == null) {
                    viewAnimationController.expand();
                    currController = viewAnimationController;
                }
            }
        });
        relativeLayout.addView(imageContainerView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        imageContainers.add(imageContainer);
    }
    public boolean handleShrink() {
        if(currController!=null) {
            currController.shrink();
            currController = null;
            return true;
        }
        return false;
    }
    public void makingTheParentLayoutMain(ImageContainerView imageContainerView) {
        imageContainerView.setShrinked();
        activity.setContentView(relativeLayout);
        relativeLayout.addView(imageContainerView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
