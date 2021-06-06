package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    public void Lotto_자동번호_개수_검증() {
        LottoGame lottoGame = new LottoGame();
        assertThat(lottoGame.getAutoBuyLottoCount(14500, 3)).isEqualTo(11);
    }

    @Test
    public void getAutoBuyLottoCount_로또자동개수가져오기() {
        LottoGame lottoGame = new LottoGame();
        assertThat(lottoGame.getAutoBuyLottoCount(3900, 1)).isEqualTo(2);
    }
}