package ulpayproject;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**class that writes users to the csv file and puts them in the right format*/
public class user {
private String id;//input
private String usertype;//set
private Scanner s;
PrintWriter writer;


user(String id,String u) throws IOException{
	u.toLowerCase();
	String x=id+","+u;
	writetolistofusers(x);
}
/**
 * writes the user to a list of users
 * @param x user and their usertype to be written into users.csv
 * @throws IOException if users.csv not found
 * */
public void writetolistofusers(String x) throws IOException {
	//find a new line
	writer=new PrintWriter(new FileWriter("../group/src/users.csv",true));
	
	writer.println(x);
	writer.close();
	}
}