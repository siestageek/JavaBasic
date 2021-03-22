package nickname.basic.day05;

import java.util.Scanner;

// 성적처리프로그램 v2b
// 성적처리시 학점계산을 switch문으로 작성
public class SungJukV2b {
	public static void main(String[] args) {
		// 변수선언
		String name;
		int kor, eng, mat;
		int tot;
		double avg;
		char grd;
		String fmt = "%s, %d, %d, %d \n" +
		             "%d, %.1f, %c \n";
		Scanner sc = new Scanner(System.in);
		
		// 성적처리
		int i = 0;
		while(i <= 3) {  // while문의 조건식을 true로 설정하면
			             // 끝없이unlimit 코드를 계속 실행함
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
			
			grd = '가';
			
			// 학점계산을 if문으로 작성한다면?
			//if (avg >= 90) grd = '수';
			//else if (avg >= 80) grd = '우';
			//else if (avg >= 70) grd = '미';
			//else if (avg >= 60) grd = '양';
			
			// 학점계산을 switch문으로 작성한다면?
			// avg : 99.9 => (int)avg : 99
			// => (int)avg / 10 : 9
			switch((int)avg / 10) {
				case 10:
				case 9: grd = '수'; break;
				case 8: grd = '우'; break;
				case 7: grd = '양'; break;
				case 6: grd = '미'; break;
				default: grd = '가';
			}			
			
			// 결과출력
			System.out.printf(fmt, 
				name, kor, eng, mat, tot, avg, grd);
			
			// 반복 증감식
			++i;
		} // while
		
	} // main
	
} // class




