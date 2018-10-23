package sh.locus.interview.custom.script.movement;

import static sh.locus.interview.game.engine.logic.GameController.GlobalState;

import sh.locus.interview.game.engine.gameobject.GameObject;
import sh.locus.interview.game.engine.input.InputKey;
import sh.locus.interview.game.engine.logic.script.Script;

public class FallingPieceScript implements Script {

    private GameObject gameObject;

    public FallingPieceScript(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    @Override
    public void update() {

        reInstantiateGameObjectIfNeeded();

        double downSpeed = 1;
        if (GlobalState.getInstance().getCurrentInput() == InputKey.DOWN_ARROW) {
            downSpeed = 4;
        }

        boolean collided = gameObject.translateY(downSpeed);

        if (collided) {
            gameObject = null;
            return;
        }

        if (GlobalState.getInstance().getCurrentInput() == InputKey.RIGHT_ARROW) {
            gameObject.translateX(5);
        }

        if (GlobalState.getInstance().getCurrentInput() == InputKey.LEFT_ARROW) {
            gameObject.translateX(-5);
        }
    }

    private void reInstantiateGameObjectIfNeeded() {

        try {
            if (gameObject == null) {
                gameObject = GlobalState.getInstance().createRandomFallingPiece();
            }
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}
