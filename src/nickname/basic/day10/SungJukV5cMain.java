package nickname.basic.day10;

import nickname.basic.sungjuk.SungJukService;
import nickname.basic.sungjuk.SungJukServiceImpl;
import nickname.basic.sungjuk.SungJukVO;

import java.util.Scanner;

public class SungJukV5cMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SungJukService sjsrv = new SungJukServiceImpl();
        String menu = "";
        SungJukVO sj = null;

        while(true) {
            sjsrv.displayMenu();
            menu = sc.next();

            switch(menu) {
                case "1": sj = sjsrv.readSungJuk();
                          sjsrv.computeSungJuk(sj); break;
                case "2": break;
                case "3": sjsrv.printSungJuk(sj); break;
                case "4": break;
                case "5": break;
                case "0": System.exit(0); break;
                default:
                    System.out.println("잘못 입력하셨습니다!!");
            }
        }

    }
}
