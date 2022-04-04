package com.test;

// import 중략.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Member{
    private String userid;
    private String username;
    private int age;

    Member(String userid,String username, int age){
        this.userid = userid;
        this.username =username;
        this.age= age;
    }

		//getter setter 중략.
        public void setUserId(String userid){
            this.userid = userid;
        }
    
        public void setUserName(String username){
            this.username = username;
        }
    
        public void setAge(int age){
            this.age = age;
        }
    
        public String getUserId(){
            return userid; 
        }
    
        public String getUserName(){
            return username; 
        }
        
        public int getAge(){
            return age;
        }
    static class Builder{  // 내부 클래스
        private String userid;
        private String username;
        private int age;


				//setter를 만든 것.
        public Builder userid(String userid){
            this.userid = userid;
            return this;
        }
        public Builder username(String username){
            this.username = username;
            return this;
        }
				public Builder age(int age){
            this.age = age;
            return this;
        }
        
        public Member build(){
            if(userid == null || username ==null || age == 0){
                throw new IllegalStateException("화면에 나오는 출력문 : 멤버 클래스가 생성이 안됩니다."); // 예외처리
            }
            return new Member(userid,username,age);
        }
    }
}


public class JDBCTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mariadb://127.0.0.1:3306/webdev"; // 규칙임. jdbc:mariadb://ip주소(??):포트/db이름
        String userid = "webmaster";
        String userpw = "1234";
        String query = "select userid, username, age from tbl_test"; // SQL문을 사용해서 한 줄 뽑아오는 코드
        //이 SQL문이 정상동작하는 지 Heid를 이용하여 확인 가능.

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        //or.mariadb.jdbc는 자바와 DB를 연결해주는 드라이버와 같은 역할
        Class.forName("org.mariadb.jdbc.Driver"); 
        
        con = DriverManager.getConnection(url,userid,userpw); //1 0;
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);

        List<Member> list = new ArrayList<>();

        while(rs.next()){ // 다음데이터가 있는지 True or False 
            //list.add(new Member(rs.getString("userid"),rs.getString("username"),rs.getInt("age"))); // list에 각각 추가할 건데, query로부터 받아온 table에서 column name에 따라 한셋트로 묶는 것
            list.add(new Member.Builder()
                .userid(rs.getString("userid"))
                .username(rs.getString("username"))
                .age(rs.getInt("age"))
                .build()
            );


        }
        
        for(Member meber: list){ // list에 담긴 클래스들을 불러와서 getter를 통해 값 받아오기.
            System.out.println("아이디 = " + meber.getUserId() + "  이름 = " + meber.getUserName() + "  나이 = " + meber.getAge());         
        }
        
        if(rs !=null) rs.close(); // 안정성을 위해서 닫아주는 거
        if(stmt != null) stmt.close(); // 안정
        if(con != null) con.close();
        
    }
}