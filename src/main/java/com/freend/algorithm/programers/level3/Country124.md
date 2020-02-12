## 124 나라의 숫자

###### 문제 설명

124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.

1. 124 나라에는 자연수만 존재합니다.
2. 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.

예를 들어서 124 나라에서 사용하는 숫자는 다음과 같이 변환됩니다.

| 10진법 | 124 나라 | 10진법 | 124 나라 |
| ------ | -------- | ------ | -------- |
| 1      | 1        | 6      | 14       |
| 2      | 2        | 7      | 21       |
| 3      | 4        | 8      | 22       |
| 4      | 11       | 9      | 24       |
| 5      | 12       | 10     | 41       |

자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.

##### 제한사항

- n은 500,000,000이하의 자연수 입니다.

------

##### 입출력 예

| n    | result |
| ---- | ------ |
| 1    | 1      |
| 2    | 2      |
| 3    | 4      |
| 4    | 11     |

### 나의 풀이

괜히 4라는 놈한태 붙잡혀 있었다. 안되겠다 싶어서 봤는데 답은 의외로 간단했다. 4를 0으로 바꾼다..

저거만 알면 나머지는 3진법과 동일했다.

또 나머지가 0(4)인 경우 즉 3, 6, 9 에 보면 

- 3: 4 -> 10
- 6 : 14 -> 20
- 9 : 24 -> 100

등 의 부분이 나타나는데 여기서 1을 빼줘야 한다.