package com.nourshalabi.lightwall;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class LightWall extends GridView {
    Context context;

    public LightWall(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

    }


    public void animateLightWall(final int numColumns, final String[] lights){

        final LightWall lightWall = this;
        this.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                lightWall.getViewTreeObserver().removeOnGlobalLayoutListener(this);

                int height = lightWall.getHeight();
                int width = lightWall.getWidth();


               // Log.e("containerGrid", "Height: " + height);

               // Log.e("containerGrid", "Width: " + width);
                int count = (width * height) / ((width / numColumns) * (width / numColumns)) + numColumns; //countSquares(height, width);

               // Log.e("containerGrid", "countSquares: " + count);


                final List<String> colors = new ArrayList<>();
                for (int i = 0; i < count; i++) {
                    colors.add("#00ffffff");
                }

                lightWall.setNumColumns(numColumns);
                lightWall.setVerticalSpacing(3);
                lightWall.setVerticalSpacing(3);
                lightWall.setVerticalScrollBarEnabled(false);
                lightWall.setEnabled(false);

                final LightWallAdapter paletetAdapter = new LightWallAdapter(context, colors, (width / numColumns) - 2, lights);//178 106
                lightWall.setAdapter(paletetAdapter);

            }
        });


    }
}
