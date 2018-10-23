package sh.locus.interview;

import sh.locus.interview.game.engine.input.AwtBasedInputController;
import sh.locus.interview.game.engine.output.Screen;
import sh.locus.interview.game.engine.world.Scene;

public class Application {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Scene scene = new Scene(new AwtBasedInputController(), new Screen());
        scene.build();
        scene.start();
    }
}
