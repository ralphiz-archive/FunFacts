package com.ralphiz.funfacts;

import java.util.Random;

/**
 * Created by Ralph Cacho on 10/18/2014.
 */
public class FactBook {
    public static String[] mFacts = {
            "Ants stretch when they wake up in the morning.",
            "Ostriches can run faster than horses.",
            "Olympic gold medals are actually made mostly of silver.",
            "You are born with 300 bones; by the time you are an adult you will have 206.",
            "It takes about 8 minutes for light from the Sun to reach Earth.",
            "Some bamboo plants can grow almost a meter in just one day.",
            "The state of Florida is bigger than England.",
            "Some penguins can leap 2-3 meters out of the water.",
            "On average, it takes 66 days to form a new habit.",
            "Mammoths still walked the earth when the Great Pyramid was being built." };
    private static int[] mIndex = {0,0,0,0,0,0,0,0,0,0};
    private static int mFactsShown = 0;

    public static int getmFactsShown() {
        return mFactsShown;
    }

    public static String getFact() {
        String fact = "";
        Random randomGenerator = new Random();
        int index;

        if (mFactsShown != 10) {
            do {
                index = randomGenerator.nextInt(10);
            } while (mIndex[index] == 1);

            mIndex[index] = 1;
            ++mFactsShown;

            fact = mFacts[index];
            return fact;
        } else {
            fact = "You've read all the facts! Don't forget to check out Treehouse by clicking on the button below!";
            return fact;
        }
    }
}
