package nickname.basic.day10;

public class Polymoph {
    public static void main(String[] args) {
        // 클래스/인터페이스 간의 형type변환
        // 캐스팅이란 형변환을 의미함
        // 기본 자료형에서는 데이터의 크기에 따라 변환가능
        // 정수와 정수 연산 => 정수
        // 정수와 실수 연산 => 실수 (자동형변환)
        
        // 상속관계에 있는 부모/자식 클래스/인터페이스간에도
        // 서로 형변환이 가능
        // 이러한 형변환을 업캐스팅/다운캐스팅이라 함
        // 자식클래스의 타입이 부모클래스의 타입으로 바뀌는 것을
        // '업캐스팅'이라 하고, 부모클래스의 타입이
        // 자식클래스의 타입으로 바뀌는 것을 '다운캐스팅'이라 함
        
        // draw 메서드 호출시 각각의 클래스 타입 사용
        Line l = new Line();
        l.draw();

        Circle c = new Circle();
        c.draw();

        Triangle t = new Triangle();
        t.draw();

        // paint메서드로 구현해서 draw호출을 수월하게 바꿔봄
        // 여전히, draw메서드 호출시 동일한 클래스 타입을 사용해야 함
        // 새로운 도형이 추가되면 paint메서드도 추가해야 함
        paint(new Line());
        paint(new Circle());
        paint(new Triangle());

        // 동적바인딩을 이용함
        // 자동 업캐스팅으로 코드를 단순하게 작성할 수 있음
        paint2(new Line());
        paint2(new Circle());
        paint2(new Triangle());

        // 배열변수에 각 도형 저장해보기
        // 도형에 맞게 변수를 개별적으로 선언해야 함
        Line[] lines = new Line[3];
        Circle[] circles = new Circle[3];
        Triangle[] triangles = new Triangle[3];

        lines[0] = new Line();
        lines[0].draw();

        circles[0] = new Circle();
        circles[0].draw();

        triangles[0] = new Triangle();
        triangles[0].draw();

        // 동적 바인딩을 이용해서 하나의 배열변수에
        // Line, Circle, Triangle을 저장
        Shape[] shapes = new Shape[10];

        shapes[0] = new Line();
        shapes[1] = new Circle();
        shapes[2] = new Triangle();

        //shapes[0].draw();
        //shapes[1].draw();
        //shapes[2].draw();

        for(int i=0; i<shapes.length;++i)
            shapes[i].draw();

        //binding
        //프로그램에 사용된 구성요소의 실제 값 또는 속성을 결정하는 행위
        //즉, 변수에 값이 저장될때나, 함수 호출시
        //실제 함수가 위치한 메모리상의 주소와 연결하는 것을 의미

        // 바인딩에는 정적/동적 바인딩이 존재하는데
        // 정적바인딩은 컴파일시 변수의 타입이나 함수의 위치가 정해짐
        // 실행전에 많은 정보들이 미리 결정되기 때문에 실행효율 증가
        
        // 반면, 동적바인딩은 실행시 변수의 타입이나 함수의 위치가 결정
        // 실행시 자유롭게 변수의 성격이 바뀌므로 적응성 증가
        

    }
    public static void paint(Line l) { l.draw(); }
    public static void paint(Circle c) { c.draw(); }
    public static void paint(Triangle t) { t.draw(); }

    public static void paint2(Shape s) { s.draw(); }
}

class Shape {
    public void draw() {
        System.out.println("도형을 그립니다");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("원을 그려요");
    }
}

class Line extends Shape {
    @Override
    public void draw() {
        System.out.println("선을 그려요");
    }
}

class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("삼각형을 그려요");
    }
}