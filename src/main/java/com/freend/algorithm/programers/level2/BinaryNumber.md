## 다음 큰 숫자

###### 문제 설명

자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

- 조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
- 조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
- 조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.

예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

##### 제한 사항

- n은 1,000,000 이하의 자연수 입니다.

------

##### 입출력 예

| n    | result |
| ---- | ------ |
| 78   | 83     |
| 15   | 23     |

##### 입출력 예 설명

입출력 예#1
문제 예시와 같습니다.
입출력 예#2
15(1111)의 다음 큰 숫자는 23(10111)입니다.

### 오늘 배운 것.

이건 풀이보다 다른사람 풀이에서 배울게 많았던거 같다.

- 우선 나는 10진수를 2진수로 바꾼후 정렬을 해서 길이를 구한후  "1"의 시작지점을 찾고 두개를 뺀 수를 카운팅했다. 
  (소스의 getCounter부분) 그런데 이 과정이 하나의 과정으로 들어있었다. 바로 **Integer.bitCount(n)** 있지 않을까해서 찾다가 그냥 풀어봤는데.. 찾아서 적어놓으면 나중에 쓰지 않을까 싶다.
- 그런데 비트연산자로 만든 소스를 보다가 정신이 혼미해졌다. Test파일에 추가해놨다.

### 참고사이트

- [자바 Integer 클래스의 메서드](https://kutar37.tistory.com/entry/%EC%9E%90%EB%B0%94-Integer-%ED%81%B4%EB%9E%98%EC%8A%A4%EC%9D%98-%EB%A9%94%EC%86%8C%EB%93%9C)
