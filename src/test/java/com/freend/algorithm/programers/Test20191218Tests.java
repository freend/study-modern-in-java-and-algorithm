package com.freend.algorithm.programers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.LinkedList;
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
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int i = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int[] car_d = new int[truck_weights.length];

        while(true) {
            answer++;
            //while문이므로 i를 직접 설정해서 새로운 트럭이 다리를 지나가면 증가시켜준다.
            if(i<truck_weights.length && sum + truck_weights[i] <= weight) {
                q.add(truck_weights[i]);
                sum += truck_weights[i];

                i++;
            }
            // -1은 다리를 이미 건넜다는 표시이다.
            for(int j=0; j<i; j++) {
                if(car_d[j] != -1) {
                    car_d[j]++;
                }
            }
            //시간이 길이와 같으면 나오면서 전체 무게를 빼주고 시간 배열을 -1로 바꿔준다.
            for(int j=0; j<i; j++) {
                if(car_d[j] == bridge_length) {
                    int complete = q.poll();
                    arr.add(complete);
                    sum -= complete;
                    car_d[j] = -1;
                }
            }
            //마지막에는 시간 추가가 안되므로 나오면서 answer++을 해준다.
            if(arr.size() == truck_weights.length) {
                answer++;
                break;
            }

        }

        return answer;
    }
}
