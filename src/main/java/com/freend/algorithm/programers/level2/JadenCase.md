## Jaden Case문자열 만들기

###### 문제 설명

JadenCase란 모든 단어의 첫 문자가 대문자이고, 그 외의 알파벳은 소문자인 문자열입니다. 문자열 s가 주어졌을 때, s를 JadenCase로 바꾼 문자열을 리턴하는 함수, solution을 완성해주세요.

##### 제한 조건

- s는 길이 1 이상인 문자열입니다.
- s는 알파벳과 공백문자(" ")로 이루어져 있습니다.
- 첫 문자가 영문이 아닐때에는 이어지는 영문은 소문자로 씁니다. ( 첫번째 입출력 예 참고 )

##### 입출력 예

| s                     |        return         |
| --------------------- | :-------------------: |
| 3people unFollowed me | 3people Unfollowed Me |
| for the last week     |   For The Last Week   |

### 나의 풀이

- 문자열을 모두 소문자로 변환 0~9는 영향 안 받음.

- 전 Level1 풀이인 이상한 문자열과 비슷한 문제
- 단 첫글자만 대문자라 flag를 넣고 true일때만 대문자 그후에 flag변환시킴