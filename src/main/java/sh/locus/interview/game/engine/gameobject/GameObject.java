package sh.locus.interview.game.engine.gameobject;

import java.util.Arrays;

import sh.locus.interview.game.engine.physics.transform.Position;
import sh.locus.interview.game.engine.world.World;

public abstract class GameObject {

    private Position position;

    public GameObject() {
        position = Position.DEFAULT_POSITION();
    }

    public abstract int getMaxWidth();

    public abstract void constructDrawable();

    public Position getPosition() {
        return position;
    }

    public abstract char[][] getDrawable();

    public void translateX(double deltaX) {

        if (deltaX == 0) {
            return;
        }

        char[][] drawable = getDrawable();

        if (deltaX < 0) {
            int posX = (int) position.getX();
            int posY = (int) position.getY();
            int possibleX = posX;

            for (int y = posY; y < drawable.length + posY; y++) {

                int innerPossibleX = posX;
                for (int x = posX - 1; x >= posX + deltaX; x--) {
                    if (World.getInstance().points[y][x] == ' ') {
                        innerPossibleX = x;
                        continue;
                    }
                    break;
                }
                possibleX = Integer.min(possibleX, innerPossibleX);
            }
            position.setX(possibleX);
        }

        if (deltaX > 0) {
            int posX = (int) position.getX();
            int posY = (int) position.getY();
            int possibleX = posX + drawable[0].length - 1;

            for (int y = posY; y < drawable.length + posY; y++) {

                int innerPossibleX = posX + drawable[0].length - 1;
                for (int x = posX + drawable[0].length; x < posX + deltaX + drawable[0].length; x++) {
                    if (World.getInstance().points[y][x] == ' ') {
                        innerPossibleX = x;
                        continue;
                    }
                    break;
                }
                possibleX = Integer.max(possibleX, innerPossibleX);
            }
            position.setX(possibleX - drawable[0].length + 1);
        }
    }

    public boolean translateY(double deltaY) {

        int initialPositionY = (int) position.getY();

        int posX = (int) position.getX();
        double posY = position.getY();

        double destinationY = position.getY() + deltaY;

        char[][] drawable = getDrawable();

        int[] columnWiseHeight = new int[getMaxWidth()];
        Arrays.fill(columnWiseHeight, 0);

        for (char[] row : drawable) {
            for (int j = 0; j < row.length; j++) {
                if (row[j] != ' ') {
                    columnWiseHeight[j]++;
                }
            }
        }

        boolean collision = false;

        for (double y = posY; y <= destinationY; y += 0.5) {
            for (int i = 0; i < columnWiseHeight.length; i++) {
                if (World.getInstance().points[columnWiseHeight[i] + (int) y][posX + i] != ' ') {
                    collision = true;
                    break;
                }
            }
            position.setY(y);
            if (collision) {
                break;
            }
        }

        return initialPositionY == position.getY();
    }
}
