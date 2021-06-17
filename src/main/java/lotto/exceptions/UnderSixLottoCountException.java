package lotto.exceptions;

import lotto.common.MessageCode;

public class UnderSixLottoCountException extends RuntimeException {
    public UnderSixLottoCountException() {
        this(MessageCode.INVALID_UNDER_LOTTO_NUMBER_COUNT.message());
    }

    public UnderSixLottoCountException(String message) {
        super(message);
    }
}
