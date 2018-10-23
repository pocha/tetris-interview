package sh.locus.interview.custom.gameobject.complex;

import sh.locus.interview.game.engine.gameobject.GameObject;

public class Barrier extends GameObject {

    private char[][] drawable;
    private int UNIT_WIDTH = 50;

    @Override
    public int getMaxWidth() {
        return UNIT_WIDTH;
    }

    public void constructDrawable() {

        int UNIT_HEIGHT = 3;
        char[][] box = new char[UNIT_HEIGHT][UNIT_WIDTH];
        box[0] = "+---++---++---++---++---++---++---++---++---++---+".toCharArray();
        box[1] = "|[X]||[X]||[X]||[X]||[X]||[X]||[X]||[X]||[X]||[X]|".toCharArray();
        box[2] = "+---++---++---++---++---++---++---++---++---++---+".toCharArray();

        drawable = box;

    }

    public char[][] getDrawable() {
        return drawable;
    }
}
