package sh.locus.interview.game.engine.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sh.locus.interview.custom.gameobject.UnitBox;
import sh.locus.interview.game.engine.gameobject.GameObject;
import sh.locus.interview.game.engine.input.InputController;
import sh.locus.interview.game.engine.input.InputKey;
import sh.locus.interview.game.engine.logic.script.Script;
import sh.locus.interview.game.engine.output.Screen;
import sh.locus.interview.game.engine.world.World;

public final class GameController {

    private InputController inputController;
    private Screen screen;

    public GameController(InputController inputController, Screen screen) {

        this.inputController = inputController;
        this.screen = screen;
    }

    public void start() {

        inputController.start();

        Runnable runnable = () -> {

            try {
                executeFrame();
            } catch (InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        };

        new Thread(runnable).start();
    }

    @SuppressWarnings("InfiniteLoopStatement")
    private void executeFrame() throws InterruptedException {

        while (true) {

            World.getInstance().resetPoints();
            GlobalState.getInstance().currentInput = inputController.consumeKeyStroke();
            GlobalState.getInstance().gameObjects.forEach(gameObject -> World.getInstance().draw(gameObject));
            GlobalState.getInstance().scripts.forEach(Script::update);

            screen.render();
            Thread.sleep(200);
        }
    }

    public static class GlobalState {

        private InputKey currentInput;
        private List<GameObject> gameObjects;
        private List<Script> scripts;

        private static GlobalState instance;

        private GlobalState() {

            this.gameObjects = new ArrayList<>();
            this.scripts = new ArrayList<>();
        }

        public InputKey getCurrentInput() {
            return currentInput;
        }

        public static GlobalState getInstance() {
            if (instance == null) {
                instance = new GlobalState();
            }
            return instance;
        }

        public <T extends GameObject> T createGameObject(Class<T> clazz) throws IllegalAccessException, InstantiationException {

            T instance = clazz.newInstance();
            instance.constructDrawable();
            gameObjects.add(instance);
            return instance;
        }

        public GameObject createRandomFallingPiece() throws IllegalAccessException, InstantiationException {

            List<Class<? extends GameObject>> classes = new ArrayList<>();
            classes.add(UnitBox.class);

            Class<? extends GameObject> clazz = classes.get(new Random().nextInt(classes.size()));

            return createGameObject(clazz);
        }

        public void addScript(Script script) {
            this.scripts.add(script);
        }
    }
}
