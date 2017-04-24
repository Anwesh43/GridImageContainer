package com.anwesome.ui.gridimagecontainer.controller;

import android.view.View;

import com.anwesome.ui.gridimagecontainer.ImageElement;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 24/04/17.
 */
public class AnimationController {
    private boolean isAnimated = false;
    private View view;
    private ConcurrentLinkedQueue<ImageElement> tappedElements = new ConcurrentLinkedQueue<>();
    private List<ImageElement> imageElements = new ArrayList<>();
    public AnimationController(View view, List<ImageElement> imageElements) {
        this.imageElements = imageElements;
        this.view = view;
    }
    public void animate() {
        if(isAnimated) {
            for(ImageElement tappedElement:tappedElements) {
                tappedElement.update();
                if(tappedElement.stopped()) {
                    tappedElements.remove(tappedElement);
                    if(tappedElements.size() == 0) {
                        isAnimated = false;
                    }
                }
            }
            try {
                Thread.sleep(50);
                view.invalidate();
            }
            catch (Exception ex) {

            }
        }
    }
    public void handleTap(float x,float y) {
        if(!isAnimated) {

        }
    }
}
