package bridge.exception;

import bridge.utils.InputUtil;
import java.util.regex.Pattern;

public class InputException {
    private static final String BRIDGE_SIZE_PATTERN = "^[0-9]*$";
    private static final String MOVING_PATTERN = "[UD]";
    private static final String GAME_COMMAND_PATTERN = "[QR]";
    private static final String ERROR = "[ERROR] ";

    private final InputUtil inputUtil;

    public InputException() {
        this.inputUtil = new InputUtil();
    }

    public void checkBridgeSizePattern(String input) {
        Pattern pattern = Pattern.compile(BRIDGE_SIZE_PATTERN);
        if (!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException(ERROR + "다리 길이는 3 이상 20 이하의 숫자입니다.");
        }
    }


}
