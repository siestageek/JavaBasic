package nickname.basic.day02;

import java.util.Scanner;

/**
 * 
 * @author nickname
 * @category javabasic
 * @version 1.1
 * 자바기초프로그램 - 성적처리프로그램
 * 
 * 이름과 성적데이터를 키보드로 직접 입력받아 처리
 * 처리결과 출력시 printf 메서드 사용
 *
 */
public class SungJukV1b {
	public static void main(String[] args) {
		// 변수선언
		String name;      // 이름
		int kor;          // 국어점수
		int eng;          // 영어점수
		int mat;          // 수학점수
		int tot;          // 총점
		double avg;       // 평균
		char grd;         // 학점		
		
		// 처리
		Scanner sc = new Scanner(System.in);
		// 키보드를 이용해서 성적데이터를 입력받기 위해
		// Scanner 클래스를 초기화함
		
		System.out.print("이름은? ");
		name = sc.next();     
		// 키보드로 문자데이터를 입력받아 name 변수에 대입
		
		System.out.print("국어는? ");
		kor = sc.nextInt();
		// 키보드로 숫자데이터를 입력받아 kor 변수에 대입
		
		System.out.print("영어는? ");
		eng = sc.nextInt();
		
		System.out.print("수학은? ");
		mat = sc.nextInt();
		
		// 총점, 평균 처리
		tot = kor + eng + mat;
		avg = tot / 3;
		grd = '가';
		
		// 출력
		// 이름: ??, 국어: ??, 영어: ??, 수학: ??
		// 총점: ??, 평균: ??, 학점: ??
		String fmt = 
			"이름: %s, 국어: %d, 영어: %d, 수학: %d\n";
		System.out.printf(fmt, name,kor,eng,mat);
		
		fmt = "총점: %d, 평균: %.1f, 학점: %c";
		System.out.printf(fmt, tot,avg,grd);
	}
}



