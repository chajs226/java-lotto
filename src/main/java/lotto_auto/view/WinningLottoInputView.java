package lotto_auto.view;

import lotto_auto.model.LottoNumber;
import lotto_auto.model.LottoNumbers;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class WinningLottoInputView {

    private static final String MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String COMMA = ",";

    public static LottoNumbers enter() {
        System.out.println(MESSAGE);
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        return new LottoNumbers(
                Arrays.stream(next.split(COMMA))
                        .mapToInt(Integer::parseInt)
                        .mapToObj(LottoNumber::new)
                        .collect(Collectors.toList())
        );
    }
}