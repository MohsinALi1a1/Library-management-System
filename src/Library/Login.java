package Library;

import java.util.Scanner;

public class Login {
	private String username = "";//Username
	private String password = "";//password
	public String getUser() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public static int  login() {
		//Input User Name and Password
		System.out.println("*************ENTER LOGIN DETAILS**************");
		Login Admin = new Login();
		int result;
		 Scanner t= new Scanner(System.in);
		 do {
		String name,code;
		System.out.println("Enter Username");
		name = t.nextLine() ;//Input User Name
		 
		System.out.println("Enter Password");
		code = t.nextLine() ;//Input Password
		
		//matching both username and password
		result = Admin.match(name, code);
		
		}while(result!=1);
		
		 return 1;
	}
	
	public int match(String name,String code) {
	// Login Details matched or not	
		if(name.equals(username)) {
			if(code.equals(password)) {
				System.out.println("********************LOGIN SUCESSFULLY**************************");
				return 1;// if match
				}
			else
				
			{
				System.out.println("********************INVALID PASSWORD**************************");
				return 0;//if Not Matched
				}
		}
		else 
		{
			System.out.println("************************INVALID USERNAME**************************");
		return 0;//If Not Matched
	}
		
	}
}
