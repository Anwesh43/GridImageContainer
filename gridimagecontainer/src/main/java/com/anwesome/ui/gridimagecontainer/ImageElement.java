package com.anwesome.ui.gridimagecontainer;

import android.graphics.*;

/**
 * Created by anweshmishra on 24/04/17.
 */
public class ImageElement {
    private float x,y,deg=0,size,dir = 0;
    private Bitmap bitmap;
    public ImageElement(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    public void setDimension(float x,float y,float size) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.bitmap = Bitmap.createScaledBitmap(bitmap,(int)size/2,(int)size/2,true);
    }
    public void draw(Canvas canvas, Paint paint) {
        canvas.save();
        canvas.translate(x,y);
        canvas.rotate(deg);
        canvas.drawBitmap(bitmap,-size/2,-size/2,paint);
        canvas.restore();
    }
    public void update() {
        deg+=dir*20;
    }
    public boolean handleTap(float x,float y) {
        if(x>=this.x-this.size/2 && x<=this.x+this.size/2 && y>=this.y-size/2 && y<=this.y+size/2 && dir == 0) {
            dir = 1;
        }
        return false;
    }
}
