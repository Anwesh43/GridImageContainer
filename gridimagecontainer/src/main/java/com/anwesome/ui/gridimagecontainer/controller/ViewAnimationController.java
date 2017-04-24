package com.anwesome.ui.gridimagecontainer.controller;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;

import com.anwesome.ui.gridimagecontainer.ImageContainer;
import com.anwesome.ui.gridimagecontainer.ImageContainerView;

/**
 * Created by anweshmishra on 24/04/17.
 */
public class ViewAnimationController implements Animator.AnimatorListener,ValueAnimator.AnimatorUpdateListener{
    private ImageContainer imageContainer;
    private ValueAnimator expandAnimator = ValueAnimator.ofFloat(0,1);
    private ValueAnimator shrinkAnimator = ValueAnimator.ofFloat(1,0);
    private int dir = 0;
    private Activity activity;
    public ViewAnimationController(Activity activity,ImageContainer imageContainer) {
        this.activity = activity;
        this.imageContainer = imageContainer;
        expandAnimator.setDuration(500);
        shrinkAnimator.setDuration(500);
        expandAnimator.addUpdateListener(this);
        expandAnimator.addListener(this);
        shrinkAnimator.addUpdateListener(this);
        shrinkAnimator.addListener(this);
    }
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        imageContainer.updateScale((float)valueAnimator.getAnimatedValue());
        imageContainer.updateXY((float)(valueAnimator.getAnimatedValue()));
    }
    public void onAnimationEnd(Animator animator) {
        if(dir == 1) {
            activity.setContentView(imageContainer.getImageContainerView());
        }
        dir = 0;
    }
    public void onAnimationRepeat(Animator animator) {

    }
    public void onAnimationStart(Animator animator) {

    }
    public void onAnimationCancel(Animator animator) {

    }
}
