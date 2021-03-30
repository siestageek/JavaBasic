package nickname.basic.day11;

import java.util.StringTokenizer;

public class StringToken {
    public static void main(String[] args) {
        // StringTokenizer
        // 문자열을 지정한 문자로 쪼개주는 메서드
        // 이렇게 쪼개진 각 문자들을 token이라 부름
        // 단순한 문자열을 나눌때는 StringTokenizer가 유리
        // 북잡한 문자열을 정규식을 이용해서 나눌때는 split가 유리
        String str = "this string include default delims";

        String words1[] = str.split(" ");
        for(int i = 0; i < words1.length; ++i)
            System.out.print(words1[i] + " ");
        System.out.println("");

        //StringTokenizer st = new StringTokenizer(str);
        // 기본구분자에 의해 문자열을 적절히 쪼갬
        StringTokenizer st = new StringTokenizer(str, " ");
        // 지정한 구분자로 문자열을 적절히 쪼갬

        System.out.println(st.countTokens());
        while(st.hasMoreTokens()) {
            System.out.print(st.nextToken() + " ");
        }
        // StringTokenizer는 iterable 자료구조임
        // 즉, 배열의 세련된 객체형식이라 보면 됨 (컬렉션)
        // 따라서, 분리된 토큰들은 차례대로 하나씩 순회해가면서
        // 처리할 수 있음
        
        System.out.println("");

    }
}
