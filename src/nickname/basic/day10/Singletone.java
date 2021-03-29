package nickname.basic.day10;

public class Singletone {
    // 싱글톤 클래스 : 어떤 클래스를 최초 한번만 메모리에 생성되고
    //               객체로 만들어 사용하는 디자인 패턴
    //               생성자의 호출이 반복적으로 이루어져도
    //               최초 생성된 객체만을 반환해 줌
    //       하나의 객체를 재사용하므로 메모리 낭비를 방지
    //   private 생성자, static 변수 사용, 객체에 대한 getter 정의
    public static void main(String[] args) {
        ServiceOne so1 = new ServiceOne();
        so1.name = "첫번째";

        ServiceOne so2 = new ServiceOne();
        so2.name = "두번째";

        System.out.println(so1.name + "/" + so2.name);
        // so1과 so2의 name 변수 값은 서로 다름 - 인스턴스 변수

        //ServiceTwo sw1 = new ServiceTwo();
        //private 생성자이므로 new 키워드로 객체생성은 불가능

        ServiceTwo sw1 = ServiceTwo.getInstance();
        sw1.name = "첫번째";
        System.out.println(sw1.name);

        ServiceTwo sw2 = ServiceTwo.getInstance();
        System.out.println(sw2.name);

    }
}

class ServiceOne {
    String name;
    public ServiceOne() {
    }
}

class ServiceTwo {
    private static ServiceTwo stwo = null;

    String name;

    private ServiceTwo() { }  // private

    public static ServiceTwo getInstance() {
        if (stwo == null) stwo = new ServiceTwo();
        // stwo 객체가 한번도 생성되지않았다면 객체를 생성함
        return stwo;
    }
}

