package sh.locus.interview.game.engine.world;

import sh.locus.interview.custom.gameobject.complex.Barrier;
import sh.locus.interview.custom.gameobject.complex.VerticalBarrier;
import sh.locus.interview.game.engine.input.InputController;
import sh.locus.interview.game.engine.logic.GameController;
import sh.locus.interview.game.engine.output.Screen;
import sh.locus.interview.custom.gameobject.UnitBox;
import sh.locus.interview.custom.script.movement.FallingPieceScript;

public class Scene {

    private GameController gameController;

    public Scene(InputController inputController, Screen screen) {
        this.gameController = new GameController(inputController, screen);
    }

    public void build() throws InstantiationException, IllegalAccessException {

        Barrier barrier = GameController.GlobalState.getInstance().createGameObject(Barrier.class);
        barrier.getPosition().setX(5);
        barrier.getPosition().setY(40);

        VerticalBarrier leftBarrier = GameController.GlobalState.getInstance().createGameObject(VerticalBarrier.class);
        leftBarrier.getPosition().setX(0);

        VerticalBarrier rightBarrier = GameController.GlobalState.getInstance().createGameObject(VerticalBarrier.class);
        rightBarrier.getPosition().setX(55);

        UnitBox unitBox = GameController.GlobalState.getInstance().createGameObject(UnitBox.class);

        GameController.GlobalState.getInstance().addScript(new FallingPieceScript(unitBox));

    }

    public void start() {
        gameController.start();
    }
}
