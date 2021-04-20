package com.multisys.utilities;
public class TestConfig{


	
	public static String server="smtp.gmail.com";
	public static String from = "qa.daniella@gmail.com";
	public static String password = "XTQDBFRB:";
	public static String[] to ={"daniellaclmbrs@gmail.com","daniellaclmbrs@outlook.com"};
	public static String subject = "CTXPay Project Report";
	
	public static String messageBody ="TestMessage";
	public static String attachmentPath="C:\\Users\\Daniella\\Pictures\\05.jpg";
	public static String attachmentName="05.jpg";
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="jdbc:jtds:sqlserver://192.101.44.22;DatabaseName=monitor_eval"; 
	public static String dbUserName="sa"; 
	public static String dbPassword="$ql$!!1"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="com.mysql.jdbc.Driver";
	public static String mysqluserName = "root";
	public static String mysqlpassword = "selenium";
	public static String mysqlurl = "jdbc:mysql://localhost:3306/acs";
	
	
	
	
	
	
	
	
	
}
