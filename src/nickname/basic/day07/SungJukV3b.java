package nickname.basic.day07;

import java.util.Scanner;

public class SungJukV3b {

	// 성적처리프로그램을 체계적으로 만들려고 함
	// 배열과 메서드로 효율적으로 코드를 재작성함
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu = "";

		while(true) {
			displayMenu();     // 프로그램 메뉴 표시
			menu = sc.next();
			
			switch(menu) {   // JDK 7부터는 switch문에 문자형 사용가능  
				case "1": addSungJuk(); break;
				case "2": System.out.println("성적데이터 조회"); break; 
				case "3": System.out.println("성적데이터 상세조회"); break; 
				case "4": System.out.println("성적데이터 수정"); break; 
				case "5": System.out.println("성적데이터 삭제"); break; 
				case "0": System.exit(0); break;  // 프로그램 종료
				default: System.out.println("잘못입력!!");
			} // switch
		} // while
		
	} // main

	// 메뉴 출력하는 메서드 - displayMenu
	public static void displayMenu() {
		String displaymenu =
			"--------------------- \n" +
			"    성적 프로그램 v3     \n" +
			"--------------------- \n" +
			" 1. 성적데이터 입력       \n" +
			" 2. 성적데이터 조회       \n" +
			" 3. 성적데이터 상세조회    \n" +
			" 4. 성적데이터 수정       \n" +
			" 5. 성적데이터 삭제       \n" +
			" 0. 프로그램 종료        \n" +
			"--------------------- \n" +
			" 작업을 선택하세요 : ";

		System.out.print(displaymenu);
	}

	// 성적 입력 및 처리 결과 출력
	public static void addSungJuk() {
		String name;
		int kor, eng, mat, tot;
		double avg;
		char grd;
		Scanner sc = new Scanner(System.in);

		System.out.print("이름은?");
		name = sc.next();
		System.out.print("국어는?");
		kor = sc.nextInt();
		System.out.print("영어는?");
		eng = sc.nextInt();
		System.out.print("수학은?");
		mat = sc.nextInt();
		
		tot = kor + eng + mat;
		avg = (double)tot / 3;
		switch ((int)avg/10) {
			case 10: case 9: grd = '수'; break;
			case 8:  grd = '우'; break;
			case 7:  grd = '미'; break;
			case 6:  grd = '양'; break;
			default:  grd = '가'; break;
		}

		String fmt = "%s %d %d %d\n%d %.1f %c\n\n";
		System.out.printf(fmt, name, kor, eng, mat,
						tot, avg, grd);

	}

}




