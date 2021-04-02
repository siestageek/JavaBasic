package nickname.basic.day14;

import java.util.Scanner;

public class EX07 {
    public static void main(String[] args) {
        //두수를 입력받아 두 사이의 모든 값의
        //총합을 구하는 코드를 작성하세요
        //ex) 10, 3  => 3,4,5,6,7,8,9,10에 대한 총합
        //ex) 3, 10  => 3,4,5,6,7,8,9,10에 대한 총합

        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 숫자는? ");
        int num1 = sc.nextInt();   // 1  // 10
        System.out.print("두번째 숫자는? ");
        int num2 = sc.nextInt();   // 10 // 1

        // num1 < num2 인 경우
        //int sum = 0;
        //for(int i = num1; i <= num2; ++i)
        //     sum += i;

        //String fmt = "%d와 %d 사이의 합은 %d";
        //System.out.printf(fmt, num1, num2, sum);

        // num1 > num2 인 경우
        //int sum = 0;
        //for(int i = num2; i <= num1; ++i)
        //    sum += i;

        //String fmt = "%d와 %d 사이의 합은 %d";
        //System.out.printf(fmt, num1, num2, sum);

        int begin = num1;
        int end = num2;
        if (num1 > num2) {
            begin = num2; end = num1;
        }

        int sum = 0;
        for(int i = begin; i <= end; ++i)
            sum += i;

        String fmt = "%d와 %d 사이의 합은 %d";
        System.out.printf(fmt, num1, num2, sum);
        System.out.println("");

        // 가우스 덧셈을 이용하면 간단히 계산 가능
        // (i + j) x (j - i + 1) / 2   // i < j
        sum = (num1 + num2) *
                    (Math.abs(num2 - num1) + 1) / 2;
        System.out.println(sum);

    }
}
