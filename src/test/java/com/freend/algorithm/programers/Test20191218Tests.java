package com.freend.algorithm.programers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@RunWith(SpringJUnit4ClassRunner.class)
public class Test20191218Tests {
    /**
     * 트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
     * 트럭은 1초에 1만큼 움직이며, 다리 길이는
     * bridge_length이고 다리는 무게 weight까지 견딥니다.
     * ※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.
     *
     * 예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과
     * 같이 건너야 합니다.
     *
     * 경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
     * 0	[]	[]	[7,4,5,6]
     * 1~2	[]	[7]	[4,5,6]
     * 3	[7]	[4]	[5,6]
     * 4	[7]	[4,5]	[6]
     * 5	[7,4]	[5]	[6]
     * 6~7	[7,4,5]	[6]	[]
     * 8	[7,4,5,6]	[]	[]
     * 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.
     *
     * solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다.
     * 이때 모든 트럭이 다리를 건너려면
     * 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
     *
     * 제한 조건
     * bridge_length는 1 이상 10,000 이하입니다.
     * weight는 1 이상 10,000 이하입니다.
     * truck_weights의 길이는 1 이상 10,000 이하입니다.
     * 모든 트럭의 무게는 1 이상 weight 이하입니다.
     * 입출력 예
     * bridge_length	weight	truck_weights	return
     * 2	10	[7,4,5,6]	8
     * 100	100	[10]	101
     * 100	100	[10,10,10,10,10,10,10,10,10,10]	110
     */
    @Test
    public void 다리를_지나는_트럭() {
        System.out.println("result : " + this.bridgeTruck(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println("result : " + this.bridgeTruck(100, 100, new int[]{10}));
        System.out.println("result : " + this.bridgeTruck(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));

        System.out.println("result : " + this.bridgeTruck(1, 2, new int[]{1, 1, 1}));
        System.out.println("result : " + this.bridgeTruck(1, 1, new int[]{1, 1, 1}));
        System.out.println("result : " + this.bridgeTruck(4, 2, new int[]{1, 1, 1, 1}));
        System.out.println("result : " + this.bridgeTruck(3, 3, new int[]{1, 1, 1}));
        System.out.println("result : " + this.bridgeTruck(3, 1, new int[]{1, 1, 1}));
        System.out.println("result : " + this.bridgeTruck(5, 5, new int[]{1, 1, 1, 1, 1, 2, 2}));
        System.out.println("result : " + this.bridgeTruck(7, 7, new int[]{1, 1, 1, 1, 1, 3, 3}));
        System.out.println("result : " + this.bridgeTruck(5, 5, new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2}));
        System.out.println("result : " + this.bridgeTruck(5, 5, new int[]{2, 2, 2, 2, 2, 1, 1, 1, 1}));
    }

    private int bridgeTruck(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int bridgeWeight = 0;
        LinkedList<Integer> queueBridge = new LinkedList<>();
        LinkedList<Integer> queueReady = new LinkedList<>();
        LinkedList<Integer> queueArrive = new LinkedList<>();
        // 다리큐와 준비큐를 만들어서 준비큐에 트럭정보를 넣는다.
        for (int i = 0; i < truck_weights.length; i++) {
            queueReady.add(truck_weights[i]);
        }
        while (queueArrive.size() != truck_weights.length) {
            answer ++;
//            System.out.println("시간이 변경됨." + answer + ", 교각의 차와 입장시간은 : " + queueBridge + ", 대기중인 차량은 : " + queueReady);
            // 현재시간과 도착시간이 동일하면 트럭은 도착한 것이다.
            if (queueBridge.size() != 0 && answer == queueBridge.peek()) {
                int arriveCar = queueBridge.poll();
                queueArrive.add(arriveCar);
                bridgeWeight -= truck_weights[queueArrive.size() - 1];
//                System.out.println(answer + " 초에 내려가고 무게는 " + truck_weights[queueArrive.size() - 1] + ", 교량에 차량수는 " + queueBridge.size() + " 교량의 무게는 : " + bridgeWeight);
            }
            // 다리에 올라가는 경우.
            if (queueReady.size() != 0 && bridgeWeight + queueReady.element() <= weight) {
                queueBridge.add(answer + bridge_length);
                int car_weight = queueReady.poll();
                bridgeWeight += car_weight;
//                System.out.println(answer + " 초에 올라가고 무게는 " + car_weight + ", 교량에 차량수는 " + queueBridge.size() + " 교량의 무게는 : " + bridgeWeight);
            } else {
                // 다리에 못올라가니 위치정보의 이동만이 생긴다. 시간을 나가는 차 직전으로 옮긴다..
                answer = (queueBridge.peek() != null) ? queueBridge.peek() - 1 : answer;
            }
        }
        return answer;
    }
    /**
     * 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
     *
     * 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될
     * 때 함께 배포됩니다.
     *
     * 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다
     * 몇 개의 기능이 배포되는지를
     * return 하도록 solution 함수를 완성하세요.
     *
     * 제한 사항
     * 작업의 개수(progresses, speeds배열의 길이)는 100개 이하입니다.
     * 작업 진도는 100 미만의 자연수입니다.
     * 작업 속도는 100 이하의 자연수입니다.
     * 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는
     * 2일 뒤에 이루어집니다.
     * 입출력 예
     * progresses	speeds	return
     * [93,30,55]	[1,30,5]	[2,1]
     * 입출력 예 설명
     * 첫 번째 기능은 93% 완료되어 있고 하루에 1%씩 작업이 가능하므로 7일간 작업 후 배포가 가능합니다.
     * 두 번째 기능은 30%가 완료되어 있고 하루에 30%씩 작업이 가능하므로 3일간 작업 후 배포가 가능합니다. 하지만 이전 첫 번째 기능이 아직 완성된
     * 상태가 아니기 때문에 첫 번째 기능이 배포되는
     * 7일째 배포됩니다.
     * 세 번째 기능은 55%가 완료되어 있고 하루에 5%씩 작업이 가능하므로 9일간 작업 후 배포가 가능합니다.
     *
     * 따라서 7일째에 2개의 기능, 9일째에 1개의 기능이 배포됩니다.
     */
    @Test
    public void 작업완료_배열() {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(this.completeProcess(progresses, speeds));
    }

    private int[] completeProcess(int[] progresses, int[] speeds) {
        LinkedList<Integer> successDate = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            double remainDate = (100 - progresses[i]) / (double) speeds[i];
            int endDate = (int) Math.ceil(remainDate);
            successDate.add(Integer.valueOf(String.valueOf(endDate)));
        }
        while (successDate.size() != 0) {
            int indexDate = successDate.poll();
            int completeSum = 1;
            while (successDate.size() != 0 && indexDate >= successDate.peek()) {
                successDate.poll();
                completeSum ++;
            }
            answerList.add(completeSum);
        }
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
