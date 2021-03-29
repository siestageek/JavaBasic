package nickname.basic.day10;

public class Static {
   
    public static void main(String[] args) {
        // 클래스 변수
        // 클래스 내에 선언된 변수
        // 개별적이고 독립적인 값이 생성/저장되는 인스턴스변수와는 달리
        // 한번 값이 생성되어 저장되면 모든 영역에서 값을 공유하는 변수

        // 객체마다 값을 개별적으로 관리해야 할 필요가 없고
        // 모든 클래스가 공유해야 하는 값을 유지하기 위해 사용
        // static 이라는 키워드로 선언해야 함
        // 클래스변수는 객체의 생성 과정없이 바로 사용가능
        // 또한, 클래스가 메모리에 적재될때 미리 생성됨
        // 호출방법은 '클래스명.변수명'을 사용함

        // 보통, 인스턴스변수를 하나만 생성되도록 제한해서 사용하는 것을 추천!
        // 디자인 패턴 중 singleton 패턴 사용
        
        // main 메서드의 비밀

        Member m1 = new Member();
        m1.userid = "혜교";
        m1.passwd = "abc123";
        //Member.allOfMember = 1;  // 클래스변수 호출
        m1.allOfMember = 1;  // 클래스변수 호출

        System.out.println(m1.userid + "/" + m1.passwd + "/");
        System.out.println(Member.allOfMember + "/" + m1.allOfMember);

        Member m2 = new Member();
        m2.userid = "지현";
        m2.passwd = "987xyz";
        //Member.allOfMember = 2;
        m2.allOfMember = 2;

        System.out.println(m2.userid + "/" + m2.passwd + "/");
        System.out.println(Member.allOfMember + "/" + m2.allOfMember);
        System.out.println("m1의 allOfMember : " + m1.allOfMember);
        // m1의 allOfMember과 m2의 allOfMember는 같은 변수를 참조함
    }
    
}

class Member {
    static int allOfMember;    // 클래스변수

    String userid;             // 인스턴스변수
    String passwd;
}

