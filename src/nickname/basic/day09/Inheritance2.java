package nickname.basic.day09;

public class Inheritance2 {

    public static void main(String[] args) {
        // 자바의 조상 클래스
        // 자바에서 사용하는 모든 클래스는
        // 기본적으로 Object라는 클래스를 상속받고 있음
        // 따라서, Object 클래스내에 미리 정의된
        // equals, hashcode, notify, wait,
        // toString 등의 메서드를 사용할 수 있음
        
        Student2 s = new Student2();
        
        s.study();     // 개발자가 추가한 메서드

        A a = new A();
        a.toString(); // 조상클래스에서 물러받은것!
    }

}

class A { }

class Student {
    public void speak() { }
    public void eat() { }
    public void walk() { }
    public void sleep() { }
    public void study() { }
}

class StudentWorker {
    public void speak() { }
    public void eat() { }
    public void walk() { }
    public void sleep() { }
    public void study() { }
    public void work() { }
}

class Researcher {
    public void speak() { }
    public void eat() { }
    public void walk() { }
    public void sleep() { }
    public void research() { }
}

class Professor {
    public void speak() { }
    public void eat() { }
    public void walk() { }
    public void sleep() { }
    public void research() { }
    public void teach() { }
}

// 상속을 이용한 정의
class People {
    public void speak() { }
    public void eat() { }
    public void walk() { }
    public void sleep() { }
}

class Student2 extends People {
    public void study() { }
}

//class StudentWorker2 extends People {
//    public void study() { }
//    public void work() { }
//}

class StudentWorker2 extends Student2 {
    public void work() { }
}

class Researcher2 extends People {
    public void research() { }
}

class Professor2 extends Researcher2 {
    public void teach() { }
}