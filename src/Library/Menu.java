package Library;

import java.util.Scanner;

public class Menu {

	public static void menu() {
		System.out.println("*******************MAIN MENU***************************");
		System.out.println("PRESS 1 FOR ALL BOOK INFORMATION");
		System.out.println("PRESS 2 FOR INSERT A NEW BOOK");
		System.out.println("PRESS 3 FOR SEARCH INFORMATION OF BOOK");
		System.out.println("PRESS 4 FOR DELETE ");
		System.out.println("PRESS 5 FOR BOOK BOROWING");
		System.out.println("PRESS 6 FOR BOOK RETURN");
		System.out.println("PRESS 7 FOR SHOW DATA BOOK BOROW STUDENT");
		System.out.println("PRESS 8 FOR EXIT");
		System.out.println("*******************************************************");
		int a;
		Scanner t = new Scanner(System.in);
do {		
		System.out.print("Please Enter a  Number:");
		
		 a = t.nextInt();// for input a number
}while(a>8||a<0);
BooksRecord book = new BooksRecord();
StudentBrow Brow = new StudentBrow();
switch(a) {
case 1:
	System.out.println("****************************All BOOK DETAILS*************************************");
	book.display();
	System.out.println("******************Press Enter To Return in Main Menu***************************");
	t.nextLine();
	t.nextLine();
	menu ();
	break;
case 2:
	System.out.println("*********************ADD BOOK DETAILS*************************");
	do{
		book.addbook();
		System.out.println("Do you Want to Add More Books Press 1");
		a=t.nextInt();
	}while(a==1);
	System.out.println("******************Press Enter To Return in Main Menu***************************");
	t.nextLine();
	t.nextLine();
menu();
	break;

case 3:
	System.out.println("*********************Search BOOK DETAILS*************************");
	System.out.println("Enter Book Name");
	String title;
	
	do{title=t.nextLine();
		title=t.nextLine();
	book .Search(book.File(),title );
	System.out.println("Do you Want to Search  Book Again Press 1");
	a=t.nextInt();
}while(a==1);
	System.out.println("******************Press Enter To Return in Main Menu***************************");
	t.nextLine();
	t.nextLine();
	menu ();
	break;
case 4:
	System.out.println("*********************DELETE BOOK RECORDS*************************");
	book.delete(book.File());
	System.out.println("******************Press Enter To Return in Main Menu***************************");
	t.nextLine();
	t.nextLine();
	menu ();
	break;
case 5:
	System.out.println("***************ENTER YOUR DETAILS FOR BORROWING BOOK******************************");
	Brow.Input();
	
	System.out.println("******************Press Enter To Return in Main Menu***************************");
	t.nextLine();
	t.nextLine();
	menu ();
	break;
case 6:
	Brow.Breturn();
	System.out.println("******************Press Enter To Return in Main Menu***************************");
	t.nextLine();
	t.nextLine();
	menu ();
	break;
case 7:
	Brow.StudentBDisplay();
	System.out.println("******************Press Enter To Return in Main Menu***************************");
	t.nextLine();
	t.nextLine();
	menu ();
	break;
case 8:
	System.out.println("*************THANKS FOR USING ******************\n");
	break;

default:
	menu ();
	 break;
}
}
}
