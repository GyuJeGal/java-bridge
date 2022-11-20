package bridge.exception;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputExceptionTest {
    @DisplayName("입력값이 숫자가 아닌 경우 예외가 발생한다.")
    @Test
    void checkBridgeSize_예외_테스트1() {
        assertThatThrownBy(() -> new InputException().checkBridgeSize("s"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 정해진 범위에 포함되지 않는 경우 예외가 발생한다.")
    @Test
    void checkBridgeSize_예외_테스트2() {
        assertThatThrownBy(() -> new InputException().checkBridgeSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 U 또는 D가 아닌 경우 예외가 발생한다.")
    @Test
    void checkMoving_예외_테스트() {
        assertThatThrownBy(() -> new InputException().checkMoving("I"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 Q 또는 R이 아닌 경우 경우 예외가 발생한다.")
    @Test
    void checkGameCommand_예외_테스트() {
        assertThatThrownBy(() -> new InputException().checkGameCommand("I"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}