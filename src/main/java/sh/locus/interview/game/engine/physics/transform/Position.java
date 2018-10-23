package sh.locus.interview.game.engine.physics.transform;

public class Position {

    private double x;
    private double y;

    private Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position DEFAULT_POSITION() {
        return new Position(15, 0);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
