// ID: 314978412

import animation.AnimationRunner;
import gamesetting.GameFlow;
import interfaces.LevelInformation;
import levels.DirectHit;
import levels.FinalFour;
import levels.Green3;
import levels.WideEasy;

import java.util.ArrayList;
import java.util.List;

/**
 * The main class- Ass6Game.
 */
public class Ass6Game {
    /**
     * The entry point of application.
     *
     * @param args the input arguments- no input in this program.
     */
    public static void main(String[] args) {
        AnimationRunner ar = new AnimationRunner();
        GameFlow game = new GameFlow(ar, ar.getKeyboard());
        game.runLevels(addLevels(args));
    }

    /**
     * add the levels to the game..
     *
     * @param args the input arguments- no input in this program.
     * @return the level list.
     */
    private static List<LevelInformation> addLevels(String[] args) {
        boolean flag = false;
        List<LevelInformation> levels = new ArrayList<>();
        DirectHit dh = new DirectHit();
        WideEasy we = new WideEasy();
        Green3 g3 = new Green3();
        FinalFour ff = new FinalFour();
        if (args.length < 1) {
            flag = true;
        }
        for (String s : args) {
            switch (s) {
                case "1":
                    levels.add(dh);
                    break;
                case "2":
                    levels.add(we);
                    break;
                case "3":
                    levels.add(g3);
                    break;
                case "4":
                    levels.add(ff);
                    break;
                default:
                    break;
            }
        }
        if (levels.size() < 1 || (flag)) {
            levels.add(dh);
            levels.add(we);
            levels.add(g3);
            levels.add(ff);
        }
        return levels;
    }

}
