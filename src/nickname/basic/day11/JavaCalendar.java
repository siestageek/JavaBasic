package nickname.basic.day11;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class JavaCalendar {
    public static void main(String[] args) {
        // 자바로 시간,날짜 다루기
        // JDK 1에서 제공한 Date 클래스를 이용해서 
        // 날짜,시간에 대한 처리를 할 수 있지만,
        // JDK 1.1에 나온 Calendar 클래스를 이용해서
        // 날짜,시간에 대한 처리를 수행하는 것을 권장함

        // 하지만, 날짜 처리시 윤초를 고려하지 않거나 (정확도 낮음)
        // 월을 표시할 때 1부터 표시하지 않고 0부터 표시하는 문제 존재
        // 따라서, 더 나은 성능의 Joda-Time이라는 라이브러리가
        // JDK8에서 추가됨

        Date d = new Date();
        System.out.println(d.toString());

        String fmt = "%d년 %d월 %d일 %d시 %d분 %d초 \n";
        System.out.printf(fmt, d.getYear() + 1900,
                d.getMonth() + 1, d.getDate(), d.getHours(),
                d.getMinutes(), d.getSeconds());

        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());

        System.out.printf(fmt, c.get(Calendar.YEAR),
            c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH),
            c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),
            c.get(Calendar.SECOND));

        System.out.println(
            "오늘은 " + c.get(Calendar.DAY_OF_WEEK) + " 요일 입니다");
        // 일요일 : 1, 월요일 : 2, ..., 토요일 : 7

        System.out.println("오늘은 2021년중 "
                + c.get(Calendar.DAY_OF_YEAR)  + "일째 날입니다");

        // 오늘 기준 5일 후 날짜는? (add 메서드 이용)
        c.add( Calendar.DATE, 5 );
        System.out.println( c.getTime() );

        // 오늘부터 100일은 언제?
        c = Calendar.getInstance();
        c.add( Calendar.DATE, 100 );
        System.out.println( c.getTime() );

        // 오늘부터 11일전은 언제?
        c = Calendar.getInstance();
        c.add( Calendar.DATE, -11 - 4 );
        System.out.println( c.getTime() );

        // 오늘 아내가 아이를 가졌어요, 10개월후는 언제?
        c = Calendar.getInstance();
        c.add( Calendar.MONTH, 10 );
        System.out.println( c.getTime() );

        // SimpleDateFormat
        // 날짜,시간 출력을 원하는 형태대로 다양하게 출력
        fmt = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        System.out.println( sdf.format(d) );

        c = Calendar.getInstance();
        System.out.println( sdf.format(c.getTime()) );


        // JDK8에서 추가된 jodatime 사용하기
        // java.time 패키지
        // 날짜를 표현할 때는 LocalDate
        // 시간을 표현할 때는 LocalTime
        // 둘다 표현할 때는 LocalDateTime
        LocalTime time = LocalTime.now();
        LocalDate date = LocalDate.now();

        System.out.println(time);
        System.out.println(date);

    }
}
