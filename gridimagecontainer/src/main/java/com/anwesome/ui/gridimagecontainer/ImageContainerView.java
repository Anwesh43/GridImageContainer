package com.anwesome.ui.gridimagecontainer;

import android.content.Context;
import android.graphics.Bitmap;
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
    private float maxH = 0,h;
    private AnimationController animationController;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public ImageContainerView(Context context) {
        super(context);
    }
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.parseColor("#99616161"));
        int w = canvas.getWidth(),gap = w/7,x = 3*gap/2,y = 3*gap/2;
        h = canvas.getHeight();
        int i = 0;
        if(time == 0) {
            animationController = new AnimationController(this,imageElements);
            for(ImageElement imageElement:imageElements) {
                imageElement.setDimension(x,y,gap);
                i++;
                x += 2*gap;
                if(i == 3) {
                    i = 0;
                    x = 3*gap/2;
                    y+=3*gap/2;
                }
            }
        }
        for(ImageElement imageElement:imageElements) {
            imageElement.draw(canvas,paint);
        }
        time++;
        animationController.animate();
    }
    public void setImageElement(List<Bitmap> bitmaps) {
        for(Bitmap bitmap:bitmaps) {
            imageElements.add(new ImageElement(bitmap));
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN && animationController != null) {
            animationController.handleTap(event.getX(),event.getY());
        }
        return true;
    }
}
