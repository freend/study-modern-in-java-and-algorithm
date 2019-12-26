package com.freend.algorithm.programers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
public class RamenFactoryTest {
    /**
     * 문제 설명
     * 라면 공장에서는 하루에 밀가루를 1톤씩 사용합니다. 원래 밀가루를 공급받던 공장의 고장으로 앞으로 k일 이후에야 밀가루를 공급받을 수 있기 때문에
     * 해외 공장에서 밀가루를 수입해야 합니다.
     *
     * 해외 공장에서는 향후 밀가루를 공급할 수 있는 날짜와 수량을 알려주었고, 라면 공장에서는 운송비를 줄이기 위해 최소한의 횟수로 밀가루를
     * 공급받고 싶습니다.
     *
     * 현재 공장에 남아있는 밀가루 수량 stock, 밀가루 공급 일정(dates)과 해당 시점에 공급 가능한 밀가루 수량(supplies), 원래 공장으로부터
     * 공급받을 수 있는 시점 k가 주어질 때, 밀가루가 떨어지지 않고 공장을 운영하기 위해서 최소한 몇 번 해외 공장으로부터
     * 밀가루를 공급받아야 하는지를 return 하도록 solution 함수를 완성하세요.
     *
     * dates[i]에는 i번째 공급 가능일이 들어있으며, supplies[i]에는 dates[i] 날짜에 공급 가능한 밀가루 수량이 들어 있습니다.
     *
     * 제한사항
     * stock에 있는 밀가루는 오늘(0일 이후)부터 사용됩니다.
     * stock과 k는 2 이상 100,000 이하입니다.
     * dates의 각 원소는 1 이상 k 이하입니다.
     * supplies의 각 원소는 1 이상 1,000 이하입니다.
     * dates와 supplies의 길이는 1 이상 20,000 이하입니다.
     * k일 째에는 밀가루가 충분히 공급되기 때문에 k-1일에 사용할 수량까지만 확보하면 됩니다.
     * dates에 들어있는 날짜는 오름차순 정렬되어 있습니다.
     * dates에 들어있는 날짜에 공급되는 밀가루는 작업 시작 전 새벽에 공급되는 것을 기준으로 합니다. 예를 들어 9일째에 밀가루가 바닥나더라도,
     * 10일째에 공급받으면 10일째에는 공장을 운영할 수 있습니다.
     * 밀가루가 바닥나는 경우는 주어지지 않습니다.
     * 입출력 예
     * stock	dates	supplies	k	result
     * 4	[4,10,15]	[20,5,10]	30	2
     * 입출력 예 설명
     * 현재 밀가루가 4톤 남아 있기 때문에 오늘과 1일 후~3일 후까지 사용하고 나면 모든 밀가루를 다 사용합니다. 따라서 4일 후에는 반드시 밀가루를
     * 공급받아야 합니다.
     * 4일째 공급받고 나면 16일째 아침에는 9톤의 밀가루가 남아있게 되고, 이때 10톤을 더 공급받으면 19톤이 남아있게 됩니다.
     * 15일 이후부터 29일 이후까지 필요한 밀가루는 15톤이므로 더 이상의 공급은 필요 없습니다.

     * 즉 공급없이 3일
     * 4일째에 20을 공급하면 23일 6일이 부족하다.
     * 4일째와 10일째 25를 공급하면 28일 하루가 부족하다
     * 4일째와 15일째 30을 공급하면 33일이다
     * 4일째 공급을 안받으면 안된다.
     * 그리고 공급이 끊어지는 경우는 없다.
     * 난 여기서 공급이 끊어지는 경우는 없다는게 전체를 다 받으면 공급이 안끊어지지만 한번 안받으면 끊어지는 경우도 생각해 보았다.
     * 근데 열심히 했는데 오류가 너무 많다.
     */
    @Test
    public void 밀가루공장() {
        this.quizType1();
        this.quizType2();
        this.quizType3();
    }
    private void quizType1() {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {20, 5, 10};
        int k = 30;
        int result = 2;
        assertThat(result + " 번만 공급받음 된다.", this.solutionUseWhile(stock, dates, supplies, k)
                , equalTo(result));
    }

    private void quizType2() {
        int stock = 5;
        int[] dates = {1, 2, 3, 4, 5};
        int[] supplies = {1, 1, 1, 1, 25};
        int k = 30;
        int result = 1;
        assertThat(result + " 번만 공급받음 된다.", this.solutionUseWhile(stock, dates, supplies, k)
                , equalTo(result));
    }

    private void quizType3() {
        int stock = 4;
        int[] dates = {4, 10, 15};
        int[] supplies = {8, 4, 22};
        int k = 30;
        int result = 3;
        assertThat(result + " 번만 공급받음 된다.", this.solutionUseWhile(stock, dates, supplies, k)
                , equalTo(result));
    }

    public int solutionUseWhile(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Stack<Integer> suppliesStack = new Stack<>();
        Queue<Integer> datesQueue = new LinkedList<>();
        for (int i = 0; i < dates.length; i++) {
            datesQueue.add(dates[i]);
        }
        // dates의 날에 이벤트가 발생한다.
        // 재고가 떨어진 날에 이벤트가 발생했다.
        int currentDate = 0;
        while (currentDate + stock < k) {
            // get stock zero day
            currentDate += stock;
            System.out.println("current day : " + currentDate);
            stock = 0;
            // 공급받는 날 입니다.
            while (!datesQueue.isEmpty() && datesQueue.peek() <= currentDate) {
                int supplyIdx = supplies.length - datesQueue.size();
                suppliesStack.add(supplies[supplyIdx]);
                System.out.println("arrive cargo day : " + datesQueue.peek() + ", amount : " + supplies[supplyIdx]);
                datesQueue.poll();
            }
            int supply = suppliesStack.pop();
            stock = supply;
            answer ++;
            System.out.println("empty day : " + currentDate);
        }

        return answer;
    }

    private int solutionFor(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        Stack<Integer> suppliesStack = new Stack<>();
        Queue<Integer> datesQueue = new LinkedList<>();
        for (int i = 0; i < dates.length; i++) {
            datesQueue.add(dates[i]);
        }
        for (int i = 0; i < k; i++) {
            if (!datesQueue.isEmpty() && i == datesQueue.peek()) {
                int supplyIdx = supplies.length - datesQueue.size();
                suppliesStack.add(supplies[supplyIdx]);
                datesQueue.poll();
                System.out.println("arrive cargo day : " + i + ", amount : " + supplies[supplyIdx]);
            }
            if (stock == 0) {
                if (!suppliesStack.isEmpty()) {
                    System.out.println("empty day : " + i);
                    int supply = suppliesStack.pop();
                    stock = supply;
                    answer ++;
                }
            }
            stock --;
        }

        return answer;
    }
}
