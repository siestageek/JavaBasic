package nickname.basic.day14;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Lotto645V2 {
    public static void main(String[] args) {
        // 로또 645 프로그램 만들기
        // Set를 이용해서 1~45사이 임의의 6개의 숫자 생성
        // 중복은 허용하지 않음
        // Random - nextInt, while
        //Random rnd = new Random();

        //for(int i = 1;i <= 6; ++i) {
        //    int key = rnd.nextInt(45) + 1;
        //    System.out.print(key + " ");
        //}  // 중복 발생

        //Set<Integer> lotto = new HashSet<>();

        //for(int i = 1;i <= 6; ++i) {
        //    int key = rnd.nextInt(45) + 1;
        //    lotto.add(key);
        //}

        //for(Integer k:lotto)
        //    System.out.print(k + " ");
        // 중복이 한번 발생시 lotto 변수의 갯수가 하나씩 줄어듬

        Set<Integer> lotto = new HashSet<>();

        while(lotto.size() < 6) {
            Random rnd = new Random();
            int key = rnd.nextInt(45) + 1;
            lotto.add(key);
        } // 중복이 나오지 않을때까지 뽑기를 계속 무한 반복
        // 복원 추출 - 한번 뽑은 것을 다시 뽑을 수 있음

        for(Integer k:lotto)
            System.out.print(k + " ");
    }
}
