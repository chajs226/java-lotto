package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LottoNumbersList {
    private List<LottoNumbers> lottoNumbersList;

    public LottoNumbersList() {
        lottoNumbersList = new ArrayList<LottoNumbers>();
    }

    public void appendLottoNumber(LottoNumbers numbers) {
        lottoNumbersList.add(numbers);
    }

    public int count() {
        return lottoNumbersList.size();
    }

    public void foreach(Consumer<LottoNumbers> lamda) {
        lottoNumbersList.forEach(lamda);
    }

/*    public ResultAllLottoScores countMatchedNumbersList(LastWonLottoNumber lastWonLottoNumber) {
        ResultAllLottoScores resultAllLottoScores = new ResultAllLottoScores();
        MatchStatusOfALotto matchStatusOfALotto = null;
        for (int i = 0; i < lottoNumbersList.size(); i++) {
            matchStatusOfALotto = lottoNumbersList.get(i).countMatchedNumbers(lastWonLottoNumber);
            resultAllLottoScores.updateResult(matchStatusOfALotto);
        }
        return resultAllLottoScores;
    }*/
}
