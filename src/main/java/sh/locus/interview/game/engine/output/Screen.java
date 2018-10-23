package sh.locus.interview.game.engine.output;

import java.util.Arrays;

import sh.locus.interview.game.engine.world.World;

public class Screen {

    private final int SCREEN_HEIGHT = 40;
    private final int SCREEN_WIDTH = 50;

    private final int BOUNDARY_OFFSET = 5;

    private World world;

    private String horizontalBoundary;

    public Screen() {

        char[] horizontalBoundaryPoints = new char[SCREEN_WIDTH];
        Arrays.fill(horizontalBoundaryPoints, '.');
        world = World.getInstance();
        horizontalBoundary = new String(horizontalBoundaryPoints);
    }

    public void render() {

        System.out.print("\033[H\033[2J");

        System.out.println("..." + horizontalBoundary + "...");
        System.out.println("..." + horizontalBoundary + "...");

        for (int i = 0; i < SCREEN_HEIGHT; i++) {
            System.out.print("...");
            for (int j = BOUNDARY_OFFSET; j < SCREEN_WIDTH + BOUNDARY_OFFSET; j++) {
                System.out.print(world.points[i][j]);
            }
            System.out.println("...");
        }

        System.out.println("..." + horizontalBoundary + "...");
        System.out.println("..." + horizontalBoundary + "...");
    }

}
