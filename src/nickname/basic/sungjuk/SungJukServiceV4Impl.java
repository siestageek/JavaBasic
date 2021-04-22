package nickname.basic.sungjuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SungJukServiceV4Impl implements SungJukServiceV4 {

    // 싱글톤 패턴 시작
    private static SungJukServiceV4 sjsrv = null;
    private static SungJukV4DAO sjdao = null;

    private SungJukServiceV4Impl() {
        sjdao = new SungJukV4DAOImpl();
    }

    public static SungJukServiceV4 getInstance() {
        if (sjsrv == null) sjsrv = new SungJukServiceV4Impl();
        return sjsrv;
    }
    // 싱글톤 패턴 끝

    @Override
    public void displayMenu() {
        String displaymenu =
                "--------------------- \n" +
                "    성적 프로그램 v8     \n" +
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

    @Override
    public void newSungJuk() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("이름은?");
            String name = sc.next();
            System.out.print("국어는?");
            int kor = sc.nextInt();
            System.out.print("영어는?");
            int eng = sc.nextInt();
            System.out.print("수학은?");
            int mat = sc.nextInt();

            SungJukVO sj = new SungJukVO(name, kor, eng, mat);
            // 입력받은 성적데이터를 객체화함
            computeSungJuk(sj);
            // 성적데이터 처리

            int cnt = sjdao.insertSungJuk(sj);
            if (cnt > 0) System.out.println("성적 데이터 추가 완료!");

        } catch (Exception ex) {
            System.out.println("잘못입력하셨습니다!");
            return;  // 오류발생시 실행중단하고 main으로 복귀
        }
    }


    @Override
    public void showSungJuk() {
        String fmt = "%s, %s, %d, %d, %d, %s\n";
        ArrayList<SungJukVO> sjlist =
            (ArrayList<SungJukVO>) sjdao.selectSungJuk();

        StringBuffer sb = new StringBuffer();
        for (SungJukVO sj : sjlist) {
            String result = String.format(fmt,
              sj.getSjno(), sj.getName(), sj.getKor(),
              sj.getEng(), sj.getMat(), sj.getRegdate());
            sb.append(result);
        }
        System.out.println(sb.toString());
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
    public void showOneSungJuk() {
        String fmt = "%s, %s, %d, %d, %d \n"
                + "%d, %.1f, %c, %s \n";

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 학생의 번호는? ");
        int sjno = sc.nextInt();
        SungJukVO sj = sjdao.selectOneSungJuk(sjno);

        String result = String.format(fmt, sj.getSjno(),
                sj.getName(), sj.getKor(), sj.getEng(),
                sj.getMat(), sj.getTot(), sj.getAvg(),
                sj.getGrd(), sj.getRegdate());

        System.out.println(result);
    }

    @Override
    public void modifySungJuk() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("수정할 학생번호는?");
            String sjno = sc.next();
            System.out.println("수정할 성적데이터를 입력하세요!");
            System.out.println("입력순서는 '이름 국어 영어 수학' 입니다");
            String name = sc.next();
            int kor = Integer.parseInt(sc.next());
            int eng = Integer.parseInt(sc.next());
            int mat = Integer.parseInt(sc.next());

            SungJukVO sj = new SungJukVO(name, kor, eng, mat);
            sj.setSjno(sjno);
            computeSungJuk(sj);  // 수정된 정보 다시 성적처리

            int cnt = sjdao.updateSungJuk(sj);
            if (cnt > 0) System.out.println("성적데이터 수정완료!!");
        } catch (Exception ex) {
            System.out.println("잘못입력하셨습니다!");
            return;
        }
    }

    @Override
    public void removeSungJuk() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("수정할 학생번호는?");
            int sjno = Integer.parseInt(sc.next());

            int cnt = sjdao.deleteSungJuk(sjno);
            if (cnt > 0) System.out.println("성적 데이터 삭제 완료!");

        } catch (Exception ex) {
            System.out.println("잘못입력하셨습니다!");
            return;
        }

    }
}
