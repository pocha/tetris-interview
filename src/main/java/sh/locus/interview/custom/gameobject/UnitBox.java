package sh.locus.interview.custom.gameobject;

import java.util.Arrays;

import sh.locus.interview.game.engine.gameobject.GameObject;

public class UnitBox extends GameObject {

    private char[][] drawable;
    private int[][] skeleton = new int[][] { { 1 } };

    @Override
    public int getMaxWidth() {
        return Arrays.stream(skeleton).map(row -> row.length).max(Integer::compare).orElse(0) * 5;
    }

    public void constructDrawable() {

        char[][] _drawable = new char[skeleton.length * 3][getMaxWidth()];

        char[][] buildingBlock = new char[3][5];
        buildingBlock[0] = "+---+".toCharArray();
        buildingBlock[1] = "|[X]|".toCharArray();
        buildingBlock[2] = "+---+".toCharArray();

        for (int i = 0; i < skeleton.length; i++) {
            for (int j = 0; j < skeleton[i].length; j++) {
                if (skeleton[i][j] == 1) {
                    for (int k = 0; k < 5; k++) {
                        _drawable[i * 3][j * 5 + k] = buildingBlock[0][k];
                        _drawable[(i * 3) + 1][j * 5 + k] = buildingBlock[1][k];
                        _drawable[(i * 3) + 2][j * 5 + k] = buildingBlock[2][k];
                    }
                }
            }
        }

        this.drawable = _drawable;

    }

    public char[][] getDrawable() {
        return drawable;
    }

}
