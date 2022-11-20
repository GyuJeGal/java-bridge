package bridge;

import bridge.domain.InGame;

public class Application {

    public static void main(String[] args) {
        try {
            new InGame().startGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }

    }
}
