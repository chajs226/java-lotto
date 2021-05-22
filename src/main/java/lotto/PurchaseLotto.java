package lotto;
import java.util.List;

public class PurchaseLotto {
    private static final int LOTTO_PRICE = 1000;
    private LottoNumber lottoNumber;
    private LottoNumberList lottoNumberList;
    private LastWonLottoNumber lastWonLottoNumber;
    private ResultAll resultAll;
    private InputView inputView;
    private ResultView resultView;

    public PurchaseLotto() {
        inputView = new InputView();
        resultView = new ResultView();
    }

    public void LottoStart() {
        inputView.inputPurchaseAmount();
        int lottoCount = availablePurchaseLottoCount(inputView.getInputAmount());
        resultView.printPurchasedCount(lottoCount);
        purchaseAvailableLotto(lottoCount);
        resultView.printPurchasedLottos(lottoNumberList);
        inputView.inputLastWonLottoNumbers();
        resultLottoGame(inputView.getInputLastWonLottoNumbers());
        resultView.printLottoGameResult(resultAll, inputView.getInputAmount());
    }

    public int availablePurchaseLottoCount(int amount) {
        return amount/LOTTO_PRICE;
    }

    public void purchaseAvailableLotto(int lottoCount) {
        lottoNumberList = new LottoNumberList();
        for (int i=0; i<lottoCount; i++) {
            lottoNumberList.appendLottoNumber(purchaseOneLotto());
        }
    }

    public LottoNumber purchaseOneLotto() {
        lottoNumber = new LottoNumber();
        return lottoNumber;
    }

    public LottoNumberList getLottoNumberList() {
        return this.lottoNumberList;
    }

    public void resultLottoGame(String lastWonLottoNumbers) {
        setLastWonLottoNumbers(lastWonLottoNumbers);
        resultAll = new ResultAll();

        int wonCountForOneLotto = 0;
        for(int i=0; i<lottoNumberList.count(); i++) {
            wonCountForOneLotto = countWonNumbers(lottoNumberList.get(i).getLottoNumbers(), lastWonLottoNumber.getLastWonLottoNumbers());
            updateResultLotto(wonCountForOneLotto);
        }
    }

    private void updateResultLotto(int wonCountForOneLotto) {
        if(wonCountForOneLotto == 3)
            resultAll.getResultThreeWon().won();
        if(wonCountForOneLotto == 4)
            resultAll.getResultFourWon().won();
        if(wonCountForOneLotto == 5)
            resultAll.getResultFiveWon().won();
        if(wonCountForOneLotto == 6)
            resultAll.getResultSixWon().won();
    }

    public void setLastWonLottoNumbers(String lastWonLottoNumbers) {
        this.lastWonLottoNumber = new LastWonLottoNumber(lastWonLottoNumbers);
    }

    public int countWonNumbers(List<Integer> generateLottoNumber, List<Integer> lastWonLottoNumbers) {
        WonCount wonCount = new WonCount();
        for ( int oneLottoNumber : generateLottoNumber) {
            wonCount.updateCount(isSameNumber(oneLottoNumber, lastWonLottoNumbers));
        }
        return wonCount.getWonCount();
    }

    private boolean isSameNumber(int oneLottoNumber, List<Integer> lastWonLottoNumbers) {
        return lastWonLottoNumbers.contains(oneLottoNumber);
    }
}
