package com.anwesome.ui.gridimagecontainer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import com.anwesome.ui.gridimagecontainer.controller.AnimationController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anweshmishra on 24/04/17.
 */
public class ImageContainerView extends View{
    private List<ImageElement> imageElements = new ArrayList<>();
    private int time = 0;
    private AnimationController animationController;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public ImageContainerView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#99616161"));
        if(time == 0) {
            animationController = new AnimationController(this,imageElements);
        }
        for(ImageElement imageElement:imageElements) {
            imageElement.draw(canvas,paint);
        }
        time++;
        animationController.animate();
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && animationController != null) {
            animationController.handleTap(event.getX(),event.getY());
        }
        return true;
    }
}
