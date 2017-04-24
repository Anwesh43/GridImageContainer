package com.anwesome.ui.gridimagecontainer;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 24/04/17.
 */
public class ImageContainerView extends View{
    private List<ImageElement> imageElements = new ArrayList<>();
    public ImageContainerView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {

    }
    public boolean onTouchEvent(MotionEvent event) {
        return true;
    }
}
