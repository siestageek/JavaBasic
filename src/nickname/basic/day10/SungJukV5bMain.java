package nickname.basic.day10;

import nickname.basic.sungjuk.SungJukService;
import nickname.basic.sungjuk.SungJukServiceImpl;
import nickname.basic.sungjuk.SungJukVO;

public class SungJukV5bMain {
    public static void main(String[] args) {
        SungJukService sjsrv = new SungJukServiceImpl();

        SungJukVO sj = sjsrv.readSungJuk();
        sjsrv.computeSungJuk(sj);
        sjsrv.printSungJuk(sj);
    }
}
