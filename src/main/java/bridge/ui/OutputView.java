package bridge.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int index, boolean isMatch) {
    }

    public List<String> getFrame(int size) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (checkIndex(size, result, i)) {
                continue;
            }
            result.add(" ");
        }
        return result;
    }

    private boolean checkIndex(int size, List<String> result, int i) {
        if (i == 0) {
            result.add("[");
            return true;
        }
        if (i == size - 1) {
            result.add("]");
            return true;
        }
        if (i % 4 == 0) {
            result.add("|");
            return true;
        }
        return false;
    }

    private void setBridgeResult(List<String> bridge, int index, List<List<String>> bridgeResult) {
        for (int i = 0; i < index; i++) {
            int addIndex = (4 * i) + 2;
            // 다리 윗부분이 이동 가능할때
            if (bridge.get(i).equals("U")) {
                bridgeResult.get(0).set(addIndex, "O");
            }
            // 다리 아랫부분이 이동 가능할때
            if (bridge.get(i).equals("D")) {
                bridgeResult.get(1).set(addIndex, "O");
            }
        }
    }

    private void setBridgeResultToSuccess(List<String> bridge, int index, List<List<String>> bridgeResult) {
        int addIndex = (4 * index) + 2;
        // 다리 윗부분이 이동 가능할때
        if (bridge.get(index).equals("U")) {
            bridgeResult.get(0).set(addIndex, "O");
        }
        // 다리 아랫부분이 이동 가능할때
        if (bridge.get(index).equals("D")) {
            bridgeResult.get(1).set(addIndex, "O");
        }
    }

    private void setBridgeResultToFail(List<String> bridge, int index, List<List<String>> bridgeResult) {
        int addIndex = (4 * index) + 2;
        // 다리 윗부분이 이동 가능할때
        if (bridge.get(index).equals("U")) {
            bridgeResult.get(1).set(addIndex, "X");
        }
        // 다리 아랫부분이 이동 가능할때
        if (bridge.get(index).equals("D")) {
            bridgeResult.get(0).set(addIndex, "X");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int count) {
    }
}
