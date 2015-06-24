package hal.tokyo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PostingInput {

	// MySQLに接続
    Connection con;
	public PostingInput() {
		
		// ドライバロード
        try {
        	
			Class.forName("org.gjt.mm.mysql.Driver");

	        con = DriverManager.getConnection("jdbc:mysql://localhost/ukasystem?useUnicode=true&characterEncoding=utf8", "root", "");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public boolean insertSummary(String userId ,String htmlText ,String title ,int postingContentId ,int postingTypeId,int termId) {
		String msg = "";
        try {
	        // ステートメント生成
        	Statement stmt = con.createStatement();
        	
        	//INSERT INTO product_content(POSTING_CONTENT) VALUES ('"+htmlText+"')

            String postConIns = "INSERT INTO posting_content(POSTING_CONTENT) VALUES ('"+htmlText+"')";
        	stmt.executeUpdate(postConIns);
        	
            // SQLを実行
            String sqlStr = "SELECT MAX(POSTING_CONTENT_ID) FROM posting_content";
            ResultSet rs = stmt.executeQuery(sqlStr);

            // 結果行をループ
            while(rs.next()){
                // レコードの値
                int id = rs.getInt("MAX(POSTING_CONTENT_ID)");

                //表示
                System.out.println("ID："+id);
            }
            
	        //INSERT INTO postings(USER_ID, POSSESSION_VOTE, POSTING_TYPE_ID, TERMS_ID, STATUS, TITLE, POSTING_CONTENT_ID) VALUES ('"+userId+"',0,"+postingTypeId+","+termId+",1,'"+title+"',"+postingContentId+")
        
            String insPostings = "INSERT INTO postings(USER_ID, POSSESSION_VOTE, POSTING_TYPE_ID, TERMS_ID, STATUS, TITLE, POSTING_CONTENT_ID) VALUES ('"+userId+"',0,"+postingTypeId+","+termId+",1,'"+title+"',"+postingContentId+")";
            stmt.executeUpdate(insPostings);
            
            // 接続を閉じる
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
