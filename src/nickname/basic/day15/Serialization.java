package nickname.basic.day15;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Serialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 직렬화
        // 문자단위 파일 입출력시 저장된 데이터들은 모두 문자처럼 다뤄짐
        // 문자:혜교, 숫자:87 => 파일로저장 =>  문자:혜교, 문자:87

        // numbers.txt에 저장된 정수를 읽어 더한 후 출력
        String fpath = "c:/Java/numbers.txt";
        FileReader fr = new FileReader(fpath);
        BufferedReader br = new BufferedReader(fr);

        String nums = br.readLine();
        System.out.println(nums);

        String num[] = nums.split(" ");
        // 빈칸 구분자로 입력값을 2개의 문자로 분리하고
        
        int sum = Integer.parseInt(num[0]) +
                  Integer.parseInt(num[1]);
        // 형변환을 통해 숫자로 바꾼후 모두 더함

        System.out.println(sum);

        br.close();
        fr.close();
        
        // 반면, 데이터의 고유속성을 그대로 유지하면서
        // 파일형태로 저장하고 싶은 경우, 직렬화를 이용해야 함
        // 직렬화 : 데이터/객체를 바이트형태로 저장함
        // ObjectOutputStream, ObjectInputStream 클래스 사용

        // 직렬화
        String fpath2 = "c:/Java/serialize.dat";

        FileOutputStream fos = new FileOutputStream(fpath2);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        ObjectOutputStream oos = new ObjectOutputStream(bos);

        ArrayList data = new ArrayList<>();
        data.add("혜교");
        data.add(87);
        data.add(90);
        data.add(88);
        // 직렬화할 데이터를 준비함

        oos.writeObject(data);
        // 준비된 데이터를 직렬화함

        oos.close();
        bos.close();
        fos.close();

        // 역직렬화 : 바이트형태로 저장된 객체를 데이터로 변환
        FileInputStream fis = new FileInputStream(fpath2);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ObjectInputStream ois = new ObjectInputStream(bis);

        ArrayList data2 = (ArrayList) ois.readObject();
        String name = (String) data2.get(0);
        int kor = (int) data2.get(1);
        int eng = (int) data2.get(2);
        int mat = (int) data2.get(3);

        System.out.println(name);
        System.out.println(kor + eng + mat);

        ois.close();
        bis.close();
        fis.close();

    }
}
