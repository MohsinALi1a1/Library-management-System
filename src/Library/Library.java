package Library;


import java.util.Scanner;

public class Library {
	//Main class
	public static void main(String[] args) {
		Library Biit = new Library();
	Biit.Welcome();//Welcome Interface
		
	}
	public void Welcome() {
		System.out.println("***************** WELCOME TO *****************");
		System.out.println("********BIIT Library Management System********");
		System.out.println("**********************************************");
	int status;
	status=	Login.login();
	if (status==1)
		Menu.menu();
	
	}
	}
