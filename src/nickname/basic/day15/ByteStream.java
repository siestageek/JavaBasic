package nickname.basic.day15;

import java.io.*;

public class ByteStream {
    public static void main(String[] args) {
        // 바이트단위 스트림 - 스트림을 바이트로 처리함
        // 파일을 바이트 단위로 입출력하려면
        // InputStream 또는 OutputStream 클래스를 사용함

        // 바이트기반으로 스트림을 읽거나 씀 : 바이트 기반(1byte)
        // 주로 바이너리 기반 테이터(이미지,동영상등)를 처리할때 사용
        // 기계가 읽고 쓸 수 있는 데이터를 대상으로 함

        // 자신의 이름, 몸무게, 키를 파일에 저장하기
        String name = "홍길동";
        int weight = 55;
        double height = 173.5;

        // 파일에 쓰기 1
        String fpath = "c:/Java/info2.txt";

        // FileOutputStream 객체 초기화
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        OutputStreamWriter osw = null;

        try {
            fos = new FileOutputStream(fpath);
            bos = new BufferedOutputStream(fos);
            osw = new OutputStreamWriter(bos);
            // 바이트 기반 스트림에서 문자를 저장하려면
            // OutputStreamWriter 또는
            // PrintWriter 클래스를 사용해야 함

            osw.write(name + "\n");
            osw.write(weight + "\n");
            osw.write(height + "\n");

            osw.close();   // 닫는 순서는 LIFO
            bos.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 파일에 쓰기 2
        String fpath2 = "c:/Java/info3.dat";

        // PrintWriter 객체 초기화
        PrintWriter pw = null;

        try {
            fos = new FileOutputStream(fpath2);
            bos = new BufferedOutputStream(fos);
            pw = new PrintWriter(bos);
            // 바이트스트림으로 저장하되
            // 좀더 문자스럽게 다룸

            pw.println(name);
            pw.println(weight);
            pw.println(height);

            pw.close();
            bos.close();
            fos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 파일 읽기 1: 파일로 부터 한 바이트씩 읽어 화면에 출력
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        InputStreamReader isr = null;

        try {
            fis = new FileInputStream(fpath);
            bis = new BufferedInputStream(fis);
            isr = new InputStreamReader(bis);  // 한글처리

            int ch = 0;
            String result = "";

            // 한 바이트씩 읽어 문자로 적절히 변환한 후
            // result 변수에 담아 한꺼번에 출력함
            while ((ch = isr.read()) != -1) {
                result += (char)ch;
            }

            isr.close();
            bis.close();
            fis.close();

            System.out.println(result);
            // InputStreamReader 덕택에 한글은 제대로 출력
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 파일 읽기 2: 버퍼를 활용해서 화면에 출력
        try {
            fis = new FileInputStream(fpath);
            bis = new BufferedInputStream(fis); // 기본 버퍼크기는 512

            // 버퍼를 활용해 한번에 읽어들일 바이트 크기 지정
            byte readData[] = new byte[512];

            bis.read(readData); 
            // bis를 이용해서 512바이트의 데이터를 읽어서
            // readData 변수에 저장함

            String result = "";
            for(int i = 0; i < readData.length; ++i) {
                result += (char)readData[i];
            } // readData에 저장된 바이트를 하나씩 꺼내 문자로 변환
            System.out.println(result);
            // 한글처리 기능이 없으므로 한글이 깨짐
            // 데이터가 채워지지 않은 자리에는 빈값으로 저장됨

            bis.close();
            fis.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
