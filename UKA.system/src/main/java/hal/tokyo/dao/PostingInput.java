package hal.tokyo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PostingInput {

	// MySQLに接続
    Connection con;
	public PostingInput() {
		try {            InitialContext context;
        context = new InitialContext();
        DataSource ds;
        ds = (DataSource) context
                .lookup("java:comp/env/jdbc/ukasystem");
        con = ds.getConnection();
        } catch (NamingException e) {
        	e.printStackTrace();
        	} catch (SQLException e) {
        		e.printStackTrace();
        		}
	}

	public String selectCotent(int id) {
		String content = "";

		// ステートメント生成
    	Statement stmt;
		try {
			stmt = con.createStatement();


        // SQLを実行
        String sqlStr = "SELECT `POSTING_CONTENT_ID`, `POSTING_CONTENT` FROM `posting_content` WHERE `POSTING_CONTENT_ID` ="+id;
        ResultSet rs = stmt.executeQuery(sqlStr);

        // 結果行をループ
        while(rs.next()){
            // レコードの値
            content = rs.getString("POSTING_CONTENT");

            //表示
            System.out.println("content："+content);
            con.close();
        }

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return content;
	}

	public int insertSummary(String userId ,String htmlText ,String title ,int postingContentId ,int postingTypeId,int termId) {
		String msg = "";
        int id = 0;
        try {
	        // ステートメント生成
        	Statement stmt = con.createStatement();

            String postConIns = "INSERT INTO posting_content(POSTING_CONTENT) VALUES ('"+htmlText+"')";
            System.out.println(postConIns);
        	stmt.executeUpdate(postConIns);
        	con.commit();

            // SQLを実行
            String sqlStr = "SELECT MAX(POSTING_CONTENT_ID) FROM posting_content";
            ResultSet rs = stmt.executeQuery(sqlStr);

            // 結果行をループ
            while(rs.next()){
                // レコードの値
                id = rs.getInt("MAX(POSTING_CONTENT_ID)");

                //表示
                System.out.println("ID："+id);
            }

            String insPostings = "INSERT INTO postings(MAILADDRESS, POSSESSION_VOTE, POSTING_TYPE_ID, TERMS_ID,IS_PERMIT, STATUS, TITLE, POSTING_CONTENT_ID) VALUES ('"+userId+"',0,"+postingTypeId+","+termId+",0,1,'"+title+"',"+id+")";
            System.out.println(insPostings);

            try {
                stmt.executeUpdate(insPostings);
                con.commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

            // 接続を閉じる
            con.close();
            rs.close();
            stmt.close();

        }catch (Exception e){
            msg = "ドライバのロードに失敗しました";
            System.out.println(msg);
            e.printStackTrace();
        }
		return id;
	}

	public boolean insertDetail(String userId ,String htmlText ,String title ,int postingContentId ,int postingTypeId,int termId) {
		String msg = "";
        try {
	        // ステートメント生成
        	Statement stmt = con.createStatement();

        	//INSERT INTO product_content(POSTING_CONTENT) VALUES ('"+htmlText+"')

            String postConIns = "INSERT INTO posting_content(POSTING_CONTENT) VALUES ('"+htmlText+"')";
            System.out.println(postConIns);
        	stmt.executeUpdate(postConIns);
        	con.commit();
            // SQLを実行
            String sqlStr = "SELECT MAX(POSTING_CONTENT_ID) FROM posting_content";
            ResultSet rs = stmt.executeQuery(sqlStr);
            int id = 0;
            // 結果行をループ
            while(rs.next()){
                // レコードの値
                id = rs.getInt("MAX(POSTING_CONTENT_ID)");

                //表示
                System.out.println("ID："+id);
            }

	        //INSERT INTO postings(USER_ID, POSSESSION_VOTE, POSTING_TYPE_ID, TERMS_ID, STATUS, TITLE, POSTING_CONTENT_ID) VALUES ('"+userId+"',0,"+postingTypeId+","+termId+",1,'"+title+"',"+postingContentId+")

            String insPostings = "INSERT INTO postings(USER_ID, POSSESSION_VOTE, POSTING_TYPE_ID, TERMS_ID, STATUS, TITLE, POSTING_CONTENT_ID) VALUES ('"+userId+"',0,"+postingTypeId+","+termId+",1,'"+title+"',"+id+")";
            stmt.executeUpdate(insPostings);
            con.commit();
            // 接続を閉じる
            con.close();
            rs.close();
            stmt.close();

        }catch (Exception e){
            msg = "ドライバのロードに失敗しました";
            System.out.println(msg);
        }
		return true;
	}

	public void clos() {
        try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
