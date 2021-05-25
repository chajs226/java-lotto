package lotto;

public class ResultView {
    public void printPurchasedCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(LottoNumbersList lottoNumbersList) {
        for (int i = 0; i < lottoNumbersList.count(); i++) {
            System.out.println(lottoNumbersList.get(i).getLottoNumbers());
        }
    }

    public void printLottoGameResult(ResultAll resultAll, int inputPurchaseAmount) {
        System.out.println("당첨 통계");
        System.out.println("--------");
        ResultScoreEnum resultScoreEnum[] = ResultScoreEnum.values();
        for (ResultScoreEnum state : resultScoreEnum) {
            state.printResult(resultAll.getResult().get(state));
        }

        printYield(resultAll, inputPurchaseAmount);
    }

    private void printYield(ResultAll resultAll, int inputPurchaseAmount) {
        float yield = resultAll.yield(inputPurchaseAmount);
        System.out.println("총 수익률은 " + String.format("%.2f", yield) + "입니다.");
    }

}
