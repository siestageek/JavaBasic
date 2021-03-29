package nickname.basic.day10;

import nickname.basic.sungjuk.SungJukVO;

import java.util.Scanner;

// 인터페이스를 이용해서 성적프로그램 작성
public class SungJukV5 {
    
    public static void main(String[] args) {
        
    }

}

// 성적처리와 관련된 메서드를 따로 뽑아 인터페이스로 구현
// 보통 인터페이스의 명명법은 이름끝에 Service를 추가함
interface SungJukV5Service {
    SungJukVO readSungJuk();
    void computeSungJuk(SungJukVO sj);
    void printSungJuk(SungJukVO sj);
}

// 인터페이스를 구현한 클래스는
// 클래스 이름끝에 Impl 접미사를 추가해줌
class SungJukV5ServiceImpl implements SungJukV5Service {

    @Override
    public SungJukVO readSungJuk() {
        Scanner sc = new Scanner(System.in);

        System.out.print("이름은?");
        String name = sc.next();
        System.out.print("국어는?");
        int kor = sc.nextInt();
        System.out.print("영어는?");
        int eng = sc.nextInt();
        System.out.print("수학은?");
        int mat = sc.nextInt();

        return new SungJukVO(name,kor,eng,mat);
    }

    @Override
    public void computeSungJuk(SungJukVO sj) {
        sj.setTot( sj.getKor() + sj.getEng() + sj.getMat() );
        sj.setAvg( (double)sj.getTot() / 3);

        switch((int)sj.getAvg() / 10) {
            case 10: case 9: sj.setGrd('수'); break;
            case 8:  sj.setGrd('우'); break;
            case 7:  sj.setGrd('미'); break;
            case 6:  sj.setGrd('양'); break;
            default: sj.setGrd('가'); break;
        }
    }

    @Override
    public void printSungJuk(SungJukVO sj) {
        String fmt = "%s %d %d %d\n%d %.1f %c\n";
        System.out.printf(fmt,
            sj.getName(), sj.getKor(), sj.getEng(), sj.getMat(),
            sj.getTot(), sj.getAvg(), sj.getGrd());
    }
}
