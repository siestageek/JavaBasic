package nickname.basic.day12;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Generics {
    public static void main(String[] args) {
        // 제네릭Generic
        // 다양한 데이터 타입의 객체를 다루는 메서드나
        // 컬렉션 클래스를 컴파일할때 자료형검사를 해주는 기능

        // 즉, 클래스에 사용할 타입의 정보를 동적으로 넘겨줄수 있고
        // 실행할때 발생할 수 있는 타입간 오류를 컴파일할때
        // 발견할 수 있도록 해주는 기능
        // JDK 1.5에서 부터 추가된 기능

        // 야생동물 3마리를 동물원에 가둡시다!
        Lion lion1 = new Lion();
        Tiger tiger1 = new Tiger();
        Zebra zebra1 = new Zebra();

        // Object형으로 배열을 선언하면
        // 어떤 데이터타입의 객체든지간에 모두 저장 가능
        Object[] zoo1 = new Object[3];
        zoo1[0] = lion1;
        zoo1[1] = tiger1;
        zoo1[2] = zebra1;

        // 단, 배열에서 객체를 빼낼때는 그 데이터타입에 맞는
        // 적절한 형변환이 필요함
        ((Lion) zoo1[0]).sayName();
        ((Tiger) zoo1[1]).sayName();
        ((Zebra) zoo1[2]).sayName();

        // 배열에서 꺼낸 객체를 적절히 변환하려니 귀찮다!
        // 그냥 하나의 타입으로 일괄적으로 변환하자@!@
        //((Tiger) zoo1[0]).sayName();
        //((Tiger) zoo1[1]).sayName();
        //((Tiger) zoo1[2]).sayName();

        // object배열에 정수를 저장해보기
        Object[] numbers1 = new Object[5];
        numbers1[0] = 123;
        numbers1[1] = 456;
        numbers1[2] = 789;

        // 적절한 형변환을 통해 연산이 잘 수행됨
        System.out.println( (int)numbers1[0] +
                (int)numbers1[1] + (int)numbers1[2] );

        // 이번에는 object배열에 문자열을 저장해보기
        Object[] numbers2 = new Object[5];
        numbers2[0] = "123";
        numbers2[1] = "456";
        numbers2[2] = "789";

        // 적절한 형변환을 이용하면 연산이 잘 수행될까?
        //System.out.println( (int)numbers2[0] +
        //        (int)numbers2[1] + (int)numbers2[2] );
        // 오류발생 -> 비정상 형변환이 원인
        // 그런데, 컴파일할때는 아무런 오류가 없었음!

        //System.out.println( Integer.parseInt(numbers2[0]) +
        //        Integer.parseInt(numbers2[1]) +
        //        Integer.parseInt(numbers2[2]) );
        // 오류발생 -> 비정상 형변환이 원인
        // 컴파일할때 잘못되었다고 오류를 띄워줌
        // => Object타입은 바로 정수로 변환 불가라서

        // JDK1.5이전에서는 여러 타입을 사용하는 대부분의 클래스나
        // 메서드에서 인수나 반환값으로 Object타입을 사용했었음
        // 이런 경우, 반환된 Object 객체를 다시 원하는 타입으로 변환해야 하고
        // 운이 나쁜 경우, 실행시 오류가 발생할 수도 있었음
        Object[] numbers3 = new Object[5];
        numbers3[0] = 123;
        numbers3[1] = "456";
        numbers3[2] = 789;

        //System.out.println( (int)numbers3[0] +
        //        (int)numbers3[1] + (int)numbers3[2] );
        // 컴파일할때는 아무 오류 없다가
        // 실행할때서야 비로소 오류가 출력됨

        // JDK1.5에서 도입한 제네릭을 활용하면
        // 컴파일할때 타입이 정해지므로
        // 타입검사나 타입변환과 같은 번거로움이 사라짐
        // <>기호 안에 타입변수를 지정해서 사용

        // 야생동물 3마리를 동물원에 가둡시다!
        //ArrayList<Lion> zoo2 = new ArrayList<Lion>();
        ArrayList<Lion> zoo2 = new ArrayList<>();
        ArrayList<Tiger> zoo3 = new ArrayList<>();
        ArrayList<Zebra> zoo4 = new ArrayList<>();
        
        zoo2.add(new Lion());
        // zoo2.add(new Tiger());
        // 컴파일할때 타입체크 가능
        //          - zoo2에는 tiger 객체를 추가못함

        Lion l = zoo2.get(0);
        zoo2.get(0).sayName();
        // 동적배열에서 객체를 추출할때도 객체변환이 필요없음

        // 동적배열에 정수/문자열 저장해보기
        ArrayList<Integer> nums1 = new ArrayList<>();
        nums1.add(123);
        nums1.add(456);
        nums1.add(789);
        System.out.println( nums1.get(0)
                + nums1.get(1) + nums1.get(2) );

        // nums2라는 배열변수에는 String타입 값만 저장할 수 있음
        ArrayList<String> nums2 = new ArrayList<>();
        nums2.add("123");
        nums2.add("456");
        nums2.add("789");
        // nums2.add(123);   // 오류발생!

        //System.out.println( (int)nums2.get(0)
        //        + (int)nums2.get(1) + (int)nums2.get(2) );
        // 컴파일할때 타입검사를 해서 오류를 바로 알려줌

        System.out.println( Integer.parseInt( nums2.get(0) )
               + Integer.parseInt( nums2.get(1) )
               + Integer.parseInt( nums2.get(2) ) );

    }
}

class Lion {
    public void sayName() {
        System.out.println("저는 사자입니다!");
    }
}
class Tiger {
    public void sayName() {
        System.out.println("저는 호랑이입니다!");
    }
}
class Zebra {
    public void sayName() {
        System.out.println("저는 얼룩말입니다!");
    }
}

