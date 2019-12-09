package com.freend.algorithm.modern.ch3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
public class FunctionalInterfaceTests {
    @Before
    public void setUp() {
    }
    // interface 를 정의한다.
    @FunctionalInterface
    public interface Predicate<T> {
        boolean isRight(T t);
    }

    // 정재하는 함수의 내용이다.
    private <T>List<T> filter(List<T> list, Predicate<T> p) {
        List<T> res = new ArrayList<>();
        for (T t:list) {
            if (p.isRight(t)) {
                res.add(t);
            }
        }

        return res;
    }

    @Test
    public void 문자열_Predicate() {
        List<String> input = new ArrayList<>();
        // Predicate 할 조건을 만들어준다.
        Predicate<String> nonEmptyStringPredicate = (String::isEmpty);
        // list 와 조건을 넣는다.
        List<String> result = filter(input, nonEmptyStringPredicate);
    }

    @FunctionalInterface
    public interface consumer<T> {
        void accept(T t);
    }

    private <T> void  forEach(List<T> list, consumer<T> c) {
        for(T t : list) {
            c.accept(t);
        }
    }

    @Test
    public void 해당내용을_출력하라() {
        List<String> inputList = Arrays.asList("a", "b", "c", "d", "e");
        forEach(inputList, (String txt) -> System.out.println(txt));
    }
}
