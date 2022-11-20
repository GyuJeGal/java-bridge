package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class InGame {
    private final BridgeMaker bridgeMaker;
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    private static int count = 1;
    private static boolean isSuccess = true;
    private static List<String> bridge;

    private boolean keepGoing = true;

    public InGame() {
        this.bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(this.bridgeNumberGenerator);
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    private boolean isRestart(String gameCommand) {
        // 게임 재시작
        if (gameCommand.equals("R")) {
            bridgeGame.retry(this);
            return true;
        }
        return false;
    }

    public void increaseCount() {
        count++;
    }
}
