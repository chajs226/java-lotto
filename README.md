# 로또
## 기능 목록
* 구입 금액을 입력한다.
  * 로또 1장의 가격은 1000원
* 로또 번호를 생성한다.
  * 1~45사이의 랜덤한 숫자 6개 생성(Collection.shuffle() 활용)
  * 로또 1장 내 중복된 번호를 가지지 않는다.
  * 로또 1장 내 번호는 오름차순 정렬된다. (Collection.sort() 활용)
* 입력된 구입 금액으로 구매 가능한 매수만큼 구매한다. 
* 지난주 당첨 번호를 입력한다.
* 구매한 로또와 당첨 번호를 비교한다. (ArrayList의 contains() 메소드 활용)
* 당첨 결과, 통계를 보여준다.
  * 일치 개수 표시
  * 수익률 표시

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)