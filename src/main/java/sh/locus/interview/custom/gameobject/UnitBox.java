package sh.locus.interview.custom.gameobject;

import static sh.locus.interview.custom.util.ArrayUtils.longestRow;

import sh.locus.interview.game.engine.gameobject.GameObject;

public class UnitBox extends GameObject {

    private char[][] drawable;
    private int[][] skeleton = new int[][] { { 1 } };
    private final int BUILDING_BLOCK_HEIGHT_CHARS = 3;
    private final int BUILDING_BLOCK_WIDTH_CHARS = 5;

    @Override
    public int getMaxWidth() {
        return longestRow(skeleton) * BUILDING_BLOCK_WIDTH_CHARS;
    }

    public void constructDrawable() {

        char[][] _drawable = new char[skeleton.length * BUILDING_BLOCK_HEIGHT_CHARS][getMaxWidth()];

        char[][] buildingBlock = new char[BUILDING_BLOCK_HEIGHT_CHARS][BUILDING_BLOCK_WIDTH_CHARS];
        buildingBlock[0] = "+---+".toCharArray();
        buildingBlock[1] = "|[X]|".toCharArray();
        buildingBlock[2] = "+---+".toCharArray();

        for (int i = 0; i < skeleton.length; i++) {
            for (int j = 0; j < skeleton[i].length; j++) {
                if (skeleton[i][j] == 1) {
                    int offsetHeight = i * BUILDING_BLOCK_HEIGHT_CHARS;
                    int offsetWidth = j * BUILDING_BLOCK_WIDTH_CHARS;
                    for (int h = 0; h < BUILDING_BLOCK_HEIGHT_CHARS; h++) {
                        for (int w = 0; w < BUILDING_BLOCK_WIDTH_CHARS; w++) {
                           _drawable[offsetHeight + h][offsetWidth + w] =
                                skeleton[i][j] == 1 ? buildingBlock[h][w] : ' ';
                        }
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
