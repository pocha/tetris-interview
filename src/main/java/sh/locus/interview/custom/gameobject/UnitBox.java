package sh.locus.interview.custom.gameobject;

import java.util.Arrays;

import sh.locus.interview.game.engine.gameobject.GameObject;

public class UnitBox extends GameObject {

    private char[][] drawable;
    private int[][] structure = new int[][] { { 1 } };

    @Override
    public int getMaxWidth() {
        return Arrays.stream(structure).map(row -> row.length).max(Integer::compare).orElse(0) * 5;
    }

    public void constructDrawable() {

        char[][] box = new char[structure.length * 3][getMaxWidth()];

        char[][] drawable = new char[3][5];
        drawable[0] = "+---+".toCharArray();
        drawable[1] = "|[X]|".toCharArray();
        drawable[2] = "+---+".toCharArray();

        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                if (structure[i][j] == 1) {
                    for (int k = 0; k < 5; k++) {
                        box[i * 3][j * 5 + k] = drawable[0][k];
                        box[(i * 3) + 1][j * 5 + k] = drawable[1][k];
                        box[(i * 3) + 2][j * 5 + k] = drawable[2][k];
                    }
                }
            }
        }

        this.drawable = box;

    }

    public char[][] getDrawable() {
        return drawable;
    }

}
