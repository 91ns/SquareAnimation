package com.nourshalabi.lightwall;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;
import java.util.Random;

public class LightWallAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> colors;
    private int height;

    public LightWallAdapter(Context c, List<String> colors, int height) {
        mContext = c;
        this.colors = colors;
        this.height = height;
    }

    public int getCount() {
        return colors.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        final ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(height, height));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        } else {
            imageView = (ImageView) convertView;
        }
        final Random random = new Random();
        animateColor(imageView, random);
        return imageView;
    }


    private void animateColor(final ImageView imageView, final Random random) {
        imageView.setAlpha(0f);
        imageView.setBackgroundColor(Color.parseColor(colors.get(random.nextInt(colors.size()))));

        final int delay = random.nextInt(10);
        imageView.animate().alpha(1).setDuration(500).setStartDelay(100 * delay)
                .withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        final int delay2 = random.nextInt(10);
                        imageView.animate().alpha(0).setDuration(500).setStartDelay(100 * delay + delay2)
                                .withEndAction(new Runnable() {
                                    @Override
                                    public void run() {
                                        int delay3 = random.nextInt(10);
                                        imageView.animate().alpha(1).setDuration(500).setStartDelay(100 * delay + delay2 + delay3).start();
                                        animateColor(imageView, random);
                                    }
                                })
                                .start();
                    }
                }).start();
    }


}
