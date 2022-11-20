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

    private boolean checkRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = inputView.readGameCommand();
        if (isRestart(gameCommand)) {
            return true;
        }
        return false;
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

    private void quitGame(int i) {
        // 게임 종료
        isSuccess = false;
        keepGoing = false;
        System.out.println("최종 게임 결과");
        outputView.printMap(bridge, i, false);
    }
}
