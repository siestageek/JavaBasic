package nickname.basic.sungjuk;

import nickname.basic.jdbc.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SungJukV4DAOImpl implements SungJukV4DAO {

    private JDBCUtil jdbc;

    private String insertSQL =
        " insert into sungjuk (name, kor, eng, mat, tot, mean, grd) " +
        " values (?,?,?,?, ?,?,?) ";

    private String selectSQL =
        " select sjno,name,kor,eng,mat,mid(regdate,1,10) regdate " +
        " from sungjuk order by sjno ";

    private String selectOneSQL = "select * from sungjuk where sjno = ?";

    private String updateSQL =
        " update sungjuk set name = ?, kor = ?, eng = ?, mat = ? " +
        " , tot = ?, mean = ?, grd = ?, regdate = current_timestamp " +
        " where sjno = ? ";

    private String deleteSQL = " delete from sungjuk where sjno = ? ";

    public SungJukV4DAOImpl() {
        jdbc = new JDBCUtil();
    }

    // Service에서 넘겨준 성적데이터를 sungjuk 테이블에 저장
    @Override
    public int insertSungJuk(SungJukVO sj) {
        int cnt = 0;
        try (
            Connection conn = jdbc.openConn();
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
        ) {
            pstmt.setString(1, sj.getName());
            pstmt.setInt(2, sj.getKor());
            pstmt.setInt(3, sj.getEng());
            pstmt.setInt(4, sj.getMat());
            pstmt.setInt(5, sj.getTot());
            pstmt.setDouble(6, sj.getAvg());
            pstmt.setString(7, sj.getGrd()+"");

            cnt = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cnt;
    }

    // sungjuk 테이블에서 '번호,이름,국어,영어,수학,등록일' 등을
    // 조회한 후 ArrayList에 담아서 Service로 넘김
    @Override
    public List<SungJukVO> selectSungJuk() {
        List<SungJukVO> sjlist = new ArrayList<>();
        try (
            Connection conn = jdbc.openConn();
            PreparedStatement pstmt = conn.prepareStatement(selectSQL);
            ResultSet rs = pstmt.executeQuery();
        ) {
            while(rs.next()) {
                SungJukVO sj = new SungJukVO(
                    rs.getString(2), rs.getInt(3),
                    rs.getInt(4), rs.getInt(5)
                );
                sj.setSjno(rs.getString(1));
                sj.setRegdate(rs.getString(6));
                sjlist.add(sj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sjlist;
    }

    // Service에서 넘겨준 학생번호로 sungjuk 테이블을 조회한후
    // 조회된 모든 결과를 SungJukVO에 담아서 Service로 넘김
    @Override
    public SungJukVO selectOneSungJuk(int sjno) {
        SungJukVO sj = null;

        try (
            Connection conn = jdbc.openConn();
            PreparedStatement pstmt = conn.prepareStatement(selectOneSQL);
        ) {
            pstmt.setInt(1, sjno);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                sj = new SungJukVO(rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
                sj.setSjno(rs.getString(1));
                sj.setTot(rs.getInt(6));
                sj.setAvg(rs.getDouble(7));
                sj.setGrd(rs.getString(8).charAt(0));
                sj.setRegdate(rs.getString(9));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return sj;
    }

    // Service에서 넘겨준 학생번호로 sungjuk 테이블을 조회한후
    // 수정할 성적데이터로 sungjuk 테이블을 수정함    
    @Override
    public int updateSungJuk(SungJukVO sj) {
        int cnt = 0;
        try (
            Connection conn = jdbc.openConn();
            PreparedStatement pstmt = conn.prepareStatement(updateSQL);
        ) {
            pstmt.setString(1, sj.getName());
            pstmt.setInt(2, sj.getKor());
            pstmt.setInt(3, sj.getEng());
            pstmt.setInt(4, sj.getMat());
            pstmt.setInt(5, sj.getTot());
            pstmt.setDouble(6, sj.getAvg());
            pstmt.setString(7, sj.getGrd()+"");
            pstmt.setString(8, sj.getSjno());

            cnt = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cnt;
    }

    // Service에서 넘겨준 학생번호로 sungjuk 테이블을 조회한후
    // 해당 성적데이터를 삭제함
    @Override
    public int deleteSungJuk(int sjno) {
        int cnt = 0;

        try (
            Connection conn = jdbc.openConn();
            PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
        ) {
            pstmt.setInt(1, sjno);
            cnt = pstmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cnt;
    }
}
