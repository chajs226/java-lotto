package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LottoNumbersList_ref {
    private List<LottoNumbers_ref> lottoNumbersRefList;

    public LottoNumbersList_ref() {
        lottoNumbersRefList = new ArrayList<LottoNumbers_ref>();
    }

    public void appendLottoNumber(LottoNumbers_ref numbers) {
        lottoNumbersRefList.add(numbers);
    }

    public int count() {
        return lottoNumbersRefList.size();
    }

    public void foreach(Consumer<LottoNumbers_ref> lamda) {
        lottoNumbersRefList.forEach(lamda);
    }

    public ResultAllLottoScores countMatchedNumbersList(LastWonLottoNumber_ref lastWonLottoNumberRef) {
        ResultAllLottoScores resultAllLottoScores = new ResultAllLottoScores();
        MatchStatusOfALotto matchStatusOfALotto = null;
        for (int i = 0; i < lottoNumbersRefList.size(); i++) {
            matchStatusOfALotto = lottoNumbersRefList.get(i).countMatchedNumbers(lastWonLottoNumberRef);
            resultAllLottoScores.updateResult(matchStatusOfALotto);
        }
        return resultAllLottoScores;
    }
}
