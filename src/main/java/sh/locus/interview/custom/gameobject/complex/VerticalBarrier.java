package sh.locus.interview.custom.gameobject.complex;

import sh.locus.interview.game.engine.gameobject.GameObject;

public class VerticalBarrier extends GameObject {

    private char[][] drawable;
    private int UNIT_WIDTH = 50;

    @Override
    public int getMaxWidth() {
        return UNIT_WIDTH;
    }

    @Override
    public void constructDrawable() {

        int UNIT_HEIGHT = 42;
        char[][] box = new char[UNIT_HEIGHT][UNIT_WIDTH];

        box[0] = "+---+".toCharArray();
        box[1] = "|[X]|".toCharArray();
        box[2] = "+---+".toCharArray();
        box[3] = "+---+".toCharArray();
        box[4] = "|[X]|".toCharArray();
        box[5] = "+---+".toCharArray();
        box[6] = "+---+".toCharArray();
        box[7] = "|[X]|".toCharArray();
        box[8] = "+---+".toCharArray();
        box[9] = "+---+".toCharArray();
        box[10] = "|[X]|".toCharArray();
        box[11] = "+---+".toCharArray();
        box[12] = "+---+".toCharArray();
        box[13] = "|[X]|".toCharArray();
        box[14] = "+---+".toCharArray();
        box[15] = "+---+".toCharArray();
        box[16] = "|[X]|".toCharArray();
        box[17] = "+---+".toCharArray();
        box[18] = "+---+".toCharArray();
        box[19] = "|[X]|".toCharArray();
        box[20] = "+---+".toCharArray();
        box[21] = "+---+".toCharArray();
        box[22] = "|[X]|".toCharArray();
        box[23] = "+---+".toCharArray();
        box[24] = "+---+".toCharArray();
        box[25] = "|[X]|".toCharArray();
        box[26] = "+---+".toCharArray();
        box[27] = "+---+".toCharArray();
        box[28] = "|[X]|".toCharArray();
        box[29] = "+---+".toCharArray();
        box[30] = "+---+".toCharArray();
        box[31] = "|[X]|".toCharArray();
        box[32] = "+---+".toCharArray();
        box[33] = "+---+".toCharArray();
        box[34] = "|[X]|".toCharArray();
        box[35] = "+---+".toCharArray();
        box[36] = "+---+".toCharArray();
        box[37] = "|[X]|".toCharArray();
        box[38] = "+---+".toCharArray();
        box[39] = "+---+".toCharArray();
        box[40] = "|[X]|".toCharArray();
        box[41] = "+---+".toCharArray();

        drawable = box;
    }

    @Override
    public char[][] getDrawable() {
        return drawable;
    }
}
