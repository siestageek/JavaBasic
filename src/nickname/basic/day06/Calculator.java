package nickname.basic.day06;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        // 간단한 계산 프로그램 작성
        // ex) 두수를 입력받아 더하기를 수행하는 프로그램 작성 1
//        int a, b;
//        int sum = 0;
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("두수를 입력받습니다");
//        System.out.print("첫번째 숫자는? ");
//        a = sc.nextInt();
//        System.out.print("두번째 숫자는? ");
//        b = sc.nextInt();
//
//        sum = a + b;
//
//        String fmt = "입력받은 수는 각각 %d,%d이고요 \n" +
//                     "두 수의 총합은 %d입니다";
//        System.out.printf(fmt, a, b, sum);


        // ex) 두수를 입력받아 더하기를 수행하는 프로그램 작성 2
        plusTwo1();

    }

    // 두수를 입력받아 더하기를 수행하는 메서드
    public static void plusTwo1() {
        int a, b;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("두수를 입력받습니다");
        System.out.print("첫번째 숫자는? ");
        a = sc.nextInt();
        System.out.print("두번째 숫자는? ");
        b = sc.nextInt();

        sum = a + b;

        String fmt = "입력받은 수는 각각 %d,%d이고요 \n" +
                "두 수의 총합은 %d입니다";
        System.out.printf(fmt, a, b, sum);
    }

}
