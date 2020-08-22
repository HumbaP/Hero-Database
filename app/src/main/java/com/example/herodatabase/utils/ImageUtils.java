package com.example.herodatabase.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

public class ImageUtils {




    public static RoundedBitmapDrawable RoundImage(ImageView image){
        Bitmap imageBitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(image.getResources(), imageBitmap);
        imageDrawable.setCircular(true);
        imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
        return imageDrawable;
    }
}
