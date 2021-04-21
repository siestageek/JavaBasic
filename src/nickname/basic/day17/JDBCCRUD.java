package nickname.basic.day17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCCRUD {
    public static void main(String[] args) throws ClassNotFoundException {
        // ex) playground 데이터베이스에 books 테이블을
        // 생성하고 새로운 도서정보를 입력하는 프로그램을 작성
        // 컬럼정보 : bookid, bookname, publish, price
        // 입력방법은 Scanner 클래스 이용

        // JDBC 접속정보
        String drv = "org.mariadb.jdbc.Driver";
        String amz = "bigdata.csv7boydpoeg.ap-northeast-2.rds.amazonaws.com";
        String url = "jdbc:mariadb://"+amz+":3306/playground";
        String usr = "playground";
        String pwd = "bigdata2020";

        // JDBC 관련 sql 정의
        String books = "create table books (bookid int," +
                "bookname varchar(30), publish varchar(30)," +
                "price int)";
        String newbooksql = " insert into books " +
            " values (99999,'hello, java','oracle',10000) ";
        String newbooksql2 = " insert into books " +
                " values (%d, '%s', '%s', %d) ";


        // JDBC 작업 시작
        Class.forName(drv); // JDBC드라이버 메모리에 적재

        try (
            Connection conn =
                 DriverManager.getConnection(url,usr,pwd);
            // 드라이버 매니저를 이용해서
            // DBMS에 접속하고 세션을 하나 가져옴

            Statement stmt = conn.createStatement();
            // 연결된 세션을 통해 SQL을 실행할 수 있도록
            // statement 객체 생성
        ){
            boolean isOk = stmt.execute(books);
            // 지정한 SQL을 실행하고 결과를 받아옴
            // 단, insert, update, delete 실행시 사용!

            if (isOk) System.out.println("도서 테이블 생성!");
            // 정상적으로 실행되었다면 적절한 메세지 출력
        } catch(Exception ex) {
            //ex.printStackTrace();
            System.out.println("테이블이 이미 존재하거나 시스템 오류!");
        }


        try (
            Connection conn =
                    DriverManager.getConnection(url,usr,pwd);
            Statement stmt = conn.createStatement();
        ){
             boolean isOK = stmt.execute(newbooksql);
             if (isOK) System.out.println("데이터 저장 성공!");
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        // Scanner로 데이터 입력받아 테이블에 저장
        Scanner sc = new Scanner(System.in);
        System.out.println("도서번호 도서명 출판사 가격");
        int bookid = Integer.parseInt(sc.next());
        String bookname = sc.next();
        String publish = sc.next();
        int price = Integer.parseInt(sc.next());

        String sql = String.format(newbooksql2,
                bookid,bookname,publish,price);
        System.out.println(sql);
        // 입력받은 값을 이용해서 완전히 sql문으로 작성

        try (
            Connection conn =
                DriverManager.getConnection(url,usr,pwd);
            Statement stmt = conn.createStatement();
        ){
            boolean isOK = stmt.execute(sql);
            if (isOK) System.out.println("데이터 저장 성공!");
        } catch(Exception ex) {
            ex.printStackTrace();
        }

    }
}
