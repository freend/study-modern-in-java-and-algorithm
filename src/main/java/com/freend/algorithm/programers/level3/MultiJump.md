## 멀리뛰기

###### 문제 설명

효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
(1칸, 1칸, 1칸, 1칸)
(1칸, 2칸, 1칸)
(1칸, 1칸, 2칸)
(2칸, 1칸, 1칸)
(2칸, 2칸)
의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.

##### 제한 사항

- n은 1 이상, 2000 이하인 정수입니다.

##### 입출력 예

| n    | result |
| ---- | ------ |
| 4    | 5      |
| 3    | 3      |

##### 입출력 예 설명

입출력 예 #1
위에서 설명한 내용과 같습니다.

입출력 예 #2
(2칸, 1칸)
(1칸, 2칸)
(1칸, 1칸, 1칸)
총 3가지 방법으로 멀리 뛸 수 있습니다.

### 나의풀이

- 우선은 그냥 제일 무식하게 했다

  | n    | 경우의 수                                                    |
  | ---- | ------------------------------------------------------------ |
  | 1    | [1]                                                          |
  | 2    | [1,1], [2]                                                   |
  | 3    | [1,1,1], [1, 2], [2, 1]                                      |
  | 4    | [1,1,1,1],[2,1,1],[1,2,1],[1,1,2],[2,2]                      |
  | 5    | [1,1,1,1,1],[2,1,1,1],[1,2,1,1],[1,1,2,1],[1,1,1,2],[2,2,1],[2,1,2],[1,2,2] |

- 역시 이렇게 만들고 나니 규칙이 보였다. n = (n - 1) + (n - 2)

- 이렇게 해놓고 보니 피보나치수열이였다.

- 그런데 딱 하고 보니 테스트 7번 이후가 다 실패라고 나왔다. 엥? 뭐지?? 그럼 코드에 입력값을 2000(문제의 최대값)을 넣어볼까? 하고 보니 결과가 -1117119로 나왔다. 범위를 벗어나므로 n에 1234567로 나눈 나머지를 넣는다. 그럼 정상적으로 통과된다.