package com.anwesome.ui.gridimagecontainerdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.anwesome.ui.gridimagecontainer.GridImageContainer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Bitmap> bitmaps = new ArrayList<>();
    private int resources[] = {R.drawable.bluetooth,R.drawable.sync,R.drawable.data,R.drawable.wifi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridImageContainer gridImageContainer = new GridImageContainer(this);
        for(int i=0;i<resources.length;i++) {
            bitmaps.add(BitmapFactory.decodeResource(getResources(),resources[i]));
        }
        gridImageContainer.addImages(bitmaps,0,0);
        gridImageContainer.addImages(bitmaps,300,0);
    }
}
