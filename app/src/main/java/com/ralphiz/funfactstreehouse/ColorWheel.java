package com.ralphiz.funfactstreehouse;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Ralph Cacho on 10/18/2014.
 */
public class ColorWheel {
    public static String mColors[] = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };
    public static int[] mColorsIndex = {0,0,0,0,0,0,0,0,0,0};
    private static int mColorsShown = 0;

    public static int getColor() {
        String color = "";
        Random randomGenerator = new Random();
        int index;


        if (mColorsShown < 10) {
            do {
                index = randomGenerator.nextInt(10);
            } while (mColorsIndex[index] == 1);

            mColorsIndex[index] = 1;
            ++mColorsShown;

            color = mColors[index];
            return Color.parseColor(color);
        } else {
            index = randomGenerator.nextInt(10);
            color = mColors[index];
            return Color.parseColor(color);
        }
    }
}