package Library;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime; 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentBrow {
//This Class is for Maintain Student Data
 static final int  sid=0;
String sname;
String issuebook;
String issuedate;
String returndate;
int fine;
int Nofbook;
public void Input() {
	Scanner t= new Scanner(System.in);
	System.out.println("Enter Student Name");
	sname= t.nextLine();
	if(count(sname)==0) {
	File Std = new File("Borrow books Records "+sname+".txt");
	BooksRecord book = new BooksRecord();
	String title;
	int aval;
	do{
		System.out.println("Enter Book Name");
		title=t.nextLine();
		issuebook =book.Search(book.File(),title);
		aval=book.update(book.File(), title, -1);
		aval++;
		if(aval<=0)
			System.out.println("BUT NOT AVAILABLE");
	}while(issuebook.isBlank()|| aval<=0 );

	issuedate=Fine.getdate();
	returndate=null;
	Nofbook=1;
	fine =0;
	try {
		FileWriter Fr = new FileWriter(Std,true);
		Fr.write(sname+"#"+issuebook+"#"+issuedate  +"#"+Nofbook);
		
		Fr.close();
		StudentB(sname, issuebook, issuedate,  Nofbook);
	}catch(IOException e) {
		
	}
	}
	else
		System.out.println("You Have Already Taken A Book , Return Previous Book To Get New Book");
}
public int count1(String n) {
	File record = new File(n+".txt");
    int z = 0;

    try {
// create an object of Scanner associated with the file
      Scanner sc = new Scanner(record);

      // read each line and  count number of lines
      while(sc.hasNextLine()) {
        sc.nextLine();
        z++;
      }
      // close scanner
      sc.close();
    } catch (Exception e) {
      
    }
	return z;
  
	}

public int count(String n) {
	File record = new File("Borrow books Records "+n+".txt");
    int z = 0;

    try {
// create an object of Scanner associated with the file
      Scanner sc = new Scanner(record);

      // read each line and  count number of lines
      while(sc.hasNextLine()) {
        sc.nextLine();
        z++;
      }
      // close scanner
      sc.close();
    } catch (Exception e) {
      
    }
	return z;
  
	}
public void Breturn() {
	BooksRecord book = new BooksRecord();
	Scanner t= new Scanner(System.in);
	System.out.println("Enter Student Name");
	sname= t.nextLine();//input Student Name
	if(count(sname)==1)//if Student Name is Valid
		{
	File Std = new File("Borrow books Records "+sname+".txt"); // Make file of student name
	try {
		Scanner sc = new Scanner (Std);//scanner of file
		String z = null;
		while(sc.hasNextLine())
		z= sc.nextLine();
		String [] bro = z.split("#");//convert line into string and split
		sc.close();//file scanner close
		sc= new Scanner(System.in);// assign scanner to get input from user
		
		int ret;
		do {
			ret=0;
		System.out.println("Enter Book Name");
		String x = sc.nextLine();
	int	aval=book.update(book.File(), x,1);
		
		if(bro[1].equalsIgnoreCase(x)) {
		long days=	Fine.Comparison(bro[2]);
		if(days>10)
			{
			Fine.fine();
			ret++;
			FileWriter wr= new FileWriter (Std);//file writer of scanner
			wr.write("");
			wr.close();
			}
		else {
		ret++;
		FileWriter wr= new FileWriter (Std);//file writer of scanner
		wr.write("");
		wr.close();
		}
		}
		else
			System.out.print("Incorrect Book Name Re");
		
		}while(ret==0);
	}catch (IOException e) {
		
	}
}else
	System.out.println("You Didn't borrow Any Book");
}
public void StudentB(String s,String i,String id, int N) {
	File studentBrow = new File("StudentRecord.txt");
	try {
		FileWriter Fr =new FileWriter(studentBrow,true);
		int Sid=count1("StudentRecord");
		++Sid;
		Fr.write(Sid+"#"+s+"#"+i+"#"+id +"#"+N+ "\n");
		Fr.close();
	}catch(IOException e){
		
	}
}
public void StudentBDisplay() {
	File studentBrow = new File("StudentRecord.txt");
	try {
		Scanner file= new Scanner (studentBrow);
		while(file.hasNextLine())
		{
			String z=file.nextLine();
			String [] record =z.split("#");
			System.out.println("SID = "+record[0]
					+"\tSName= "+record[1]
							+"\tIssueBook= "+record[2]
									+"\tIssueDate= "+record[3]
											+"\tNofbook = " +record[4]
															);
		}
		file.close();
	}catch(IOException e) {
		
	}
}

}
