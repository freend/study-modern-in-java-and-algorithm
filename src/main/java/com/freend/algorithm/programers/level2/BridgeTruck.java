package com.freend.algorithm.programers.level2;

import java.util.LinkedList;

public class BridgeTruck {
    public int bridgeTruck(int bridge_length, int weight, int[] truck_weights) {
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
}
