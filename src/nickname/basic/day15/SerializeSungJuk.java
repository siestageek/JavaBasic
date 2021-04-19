package nickname.basic.day15;

import nickname.basic.sungjuk.SungJukVO;

import java.io.*;
import java.util.Scanner;

public class SerializeSungJuk {
    //이름,국어,영어,수학을 키보드로 입력받아
    //sungjuk.bin에 저장하는 코드를 작성하세요
    //단, 입력받은 값들은 SungJukVO에 저장한 후
    //직렬화해서 저장함

    // 입력 데이터 : 혜교 97 98 95
    // 역직렬화 후 결과 : 혜교,97,98,95,290,96.7
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 성적 데이터 입력받기
        String name = "";
        int kor = 0;
        int eng = 0;
        int mat = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("성적은? ('이름 국어 영어 수학'순서로)");
        name = sc.next();
        kor = sc.nextInt();
        eng = sc.nextInt();
        mat = sc.nextInt();

        // 입력받은 데이터를 SungJukVO에 저장
        SungJukVO sj = new SungJukVO(name,kor,eng,mat);

        // 직렬화
        String fpath = "c:/Java/sungjuk.bin";

        FileOutputStream fos = new FileOutputStream(fpath);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        //oos.writeChars(name);
        //oos.writeInt(kor);
        //oos.writeInt(eng);
        //oos.writeInt(mat);
        
        oos.writeObject(sj);

        oos.close();
        bos.close();
        fos.close();
        
        // 역직렬화
        FileInputStream fis = new FileInputStream(fpath);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);

        SungJukVO sjvo = (SungJukVO) ois.readObject();

        ois.close(); bis.close(); fis.close();

        int tot = sjvo.getKor() + sjvo.getEng() + sjvo.getMat();
        double avg = (double)tot / 3;

        String fmt = "%s,%d,%d,%d,%d,%.1f\n";
        System.out.printf(fmt, sjvo.getName(), sjvo.getKor(),
                sjvo.getEng(), sjvo.getMat(), tot, avg);

    }
}
