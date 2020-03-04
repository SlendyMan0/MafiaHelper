package pl.unfunny.jester.mafiahelper.utility;

import java.util.Random;

public class ScrambleId {

    private int[] array;

    public ScrambleId(int n) {
        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }

        Random rng = new Random();
        for (int i = 0; i < n; i++) {
            int newId = rng.nextInt(i+1);
            int val = array[newId];

            array[newId] = array[i];
            array[i] = val;
        }
    }

    public String get(int i) {
        return Integer.toString(array[i]);
    }
}
