## 탑 문제풀이

문제는 동일 폴더의 Test20191214Tests.java에 보면 나와있다. 여기는 내가 생각한 설명만 적었다. 출제자의 의도는 모르지만 여기서는 개인적인 풀이를 작성한다.

적은 이유는 문제의 카테고리가 스택/큐 인데 for문으로 해결한 문제가 많았다.

### 풀이

우선 스택을 생성해서 탑을 넣는다.

```java
int[] answer = new int[heights.length];
Stack<Integer> stack = new Stack<>();
for (int i = 0; i < heights.length; i++) {
  stack.push(heights[i]);
}
```

그리고 제가 생각한 핵심은 다음의 두 가지이다.

1. 오른쪽에서 왼쪽으로 전파를 송신한다.
2. 마지막 원소를 뺀 후 스택을 전수 검수한다.
3. 더 큰게 있으면 해당 인덱스를 넣고 없으면 0을 넣는다.

```java
int receiveNum; // 더 큰 탑을 넣을 변수이다.
for (int i = 0; i < heights.length; i++) {
  int sendNum = stack.pop();// 맨 마지막 원소를 뺀다.
  receiveNum = 0; // 변수 초기화
  for (int j = stack.size() - 1; j >= 0 ; j--) {//스택의 사이즈 만큼 역검색을 한다.
    if (stack.get(j) > sendNum) {
      receiveNum = j + 1;// 더 높은 탑의 번호를 넣는다.
      break;
    }
  }
  answer[heights.length - (i + 1)] = receiveNum; // pop한 원소의 위치에 받은 인덱스를 넣어준다.
}
```
만약 더 좋은 방식을 알게 되면 다 같이 공유해 보면 좋겠다.