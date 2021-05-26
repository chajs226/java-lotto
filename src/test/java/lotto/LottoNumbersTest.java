package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    private List<Integer> testLottoNumber;
    private List<Integer> lottoNumberRange;

    @BeforeEach
    public void setUp() {
        testLottoNumber = new ArrayList<Integer>();
        lottoNumberRange = new ArrayList<Integer>();
        for (int i = 1; i < 46; i++) {
            lottoNumberRange.add(i);
        }
    }

    @Test
    public void generateLottoNumber_로또번호1_45범위내생성확인() {
        LottoNumberGenerator lottoNumber = new LottoNumberGenerator();
        testLottoNumber = lottoNumber.generateLottoNumber();

        assertThat(lottoNumberRange.contains(testLottoNumber.get(0))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(1))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(2))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(3))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(4))).isTrue();
        assertThat(lottoNumberRange.contains(testLottoNumber.get(5))).isTrue();
    }

    @Test
    public void makeLottoNumber_로또번호생성확인() {
        LottoNumbers lottoNumbers = new LottoNumbers(new LottoNumberGeneratorStrategy() {
            @Override
            public List<Integer> generateLottoNumber() {
                List<Integer> lottoNumberList = new ArrayList<Integer>();
                lottoNumberList.add(1);
                lottoNumberList.add(3);
                lottoNumberList.add(5);
                lottoNumberList.add(7);
                lottoNumberList.add(9);
                lottoNumberList.add(11);
                return lottoNumberList;
            }
        });

        assertThat(lottoNumbers.getLottoNumbers().contains(1)).isTrue();
    }

    @Test
    public void LastWonValidateNumber_로또번호검증_문자입력() {
        assertThatThrownBy(() -> new LastWonLottoNumber("1,a,3,4,5,6", "7"))
                .isInstanceOf(RuntimeException.class).hasMessage("숫자만 입력 가능합니다.");
    }

    @Test
    public void LastWonValidateNumber_로또번호검증_45초과입력() {
        assertThatThrownBy(() -> new LastWonLottoNumber("1,2,3,4,5,56", "7"))
                .isInstanceOf(RuntimeException.class).hasMessage("1부터 45까지 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    public void lastWonLottoNumbers_지난당첨번호문자열파싱검증(int number) {
        LastWonLottoNumber lastWonLottoNumber = new LastWonLottoNumber("1,2,3,4,5,6", "7");
        assertThat(lastWonLottoNumber.containsMain(number)).isTrue();
    }

}