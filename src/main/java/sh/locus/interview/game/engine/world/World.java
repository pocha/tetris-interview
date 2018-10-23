package sh.locus.interview.game.engine.world;

import java.util.Arrays;

import sh.locus.interview.game.engine.gameobject.GameObject;
import sh.locus.interview.game.engine.physics.transform.Position;

public class World {

    private static World instance;

    private int WORLD_HEIGHT = 100;
    private int WORLD_WIDTH = 100;

    public char[][] points = new char[WORLD_HEIGHT][WORLD_WIDTH];

    private World() {
    }

    public static World getInstance() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }

    public void draw(GameObject object) {

        Position position = object.getPosition();

        char[][] drawable = object.getDrawable();

        for (int y = 0; y < drawable.length; y++) {
            for (int x = 0; x < drawable[y].length; x++) {

                if (drawable[y][x] == ' ') {
                    continue;
                }

                int worldPositionX = x + (int) position.getX();
                int worldPositionY = y + (int) position.getY();
                points[worldPositionY][worldPositionX] = drawable[y][x];
            }
        }
    }

    public void resetPoints() {

        for (int i = 0; i < WORLD_HEIGHT; i++) {
            Arrays.fill(points[i], ' ');
        }
    }
}
