package Library;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class BooksRecord {
	 static int id =0;
	String Bookname ,Authorsname;
	int quantity;
	String Pdate;
	
// Add Data in File
	public void addbook() {
		
	File record= new File ("Books record.txt");
	try {
		FileWriter Add= new FileWriter(record , true);
		Scanner t= new Scanner (System.in);
		System.out.println("Enter Book Name");
		Bookname = t.nextLine() ;
		
		System.out.println("Enter Authors Name");
		Authorsname = t.nextLine() ;
		
	  System.out.println("Enter Published Date (dd-mm-yy) ");
      Pdate = t.nextLine() ;
	
		System.out.println("Enter Quantity ");
		quantity = t.nextInt();
		id=count();
	
		Add.write((id+1)+"#"+Bookname +"#"+Authorsname+"#" + Pdate+ "#"	+ quantity +"\n");
		Add.close();
	
	}catch (IOException e) {
		
	}
	}
	// Display Data in File
	public void display() {
		
		File record= new File ("Books record.txt");
		try {
			Scanner file = new Scanner(record);
			String a;
			int lines =count();
			if(lines !=0)
			while(file.hasNextLine()) {
				a=file.nextLine();
				String z[]=a.split("#");
				System.out.println("Book ID"+z[0]+" \tBook Name ="+z[1] +" \tAuthorsname ="+z[2]+"\t Pdate ="+z[3]+" \t Quantity = "+z[4]);
			}
			else 
				System.out.println("********************NO BOOK EXIST***********************");
			file.close();
		}catch (IOException e) {
			
		}
	}
	
	// To Convert File Data in to Books Array
	public BooksRecord[]   File() {
		
		File record= new File ("Books record.txt");
		int size=count();
				BooksRecord [] book = new BooksRecord[size];
			try {
			Scanner File = new Scanner(record);
			String z;
			int i =0;
				while (File.hasNextLine())
				{
					z=File.nextLine();
					size++;
					String [] a= z.split("#");
					book[i] = new BooksRecord();					
					book[i].Bookname=a[1];
					book[i].Authorsname=a[2];
					book[i].Pdate=a[3];
					book[i].quantity=Integer.parseInt(a[4]);
					i++;
					}
				File.close();
	//	Search(book);
				
	}catch(IOException e) {
		
	}
			return book;}
	// For Count Lines in Files
	public int count () {
		File record= new File ("Books record.txt");
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
	// For Search Book With the help Of Book Title in Array
	public String Search(BooksRecord[] book,String title) {
		Scanner t= new Scanner(System.in);
		
		
		int count=0;
		for(int i=0;i<book.length;i++)
			if(book[i].Bookname.contains(title))
			{
				System.out.println("*******************BOOK FOUND ******************"
						+ "\n\tBOOK ID = "+(i+1)
						+ "\tBook Name : "+book[i].Bookname+
						"\tAuthors Name : "+book[i].Authorsname+
						"\tPublished Date : "+ book[i].Pdate);
				count++;
				
			}
		if (count==0)
	{
			System.out.println("****************Book Not Found**********************");
	title="";
	}
		return title;
	}
	
public void delete(BooksRecord[] book) {
	File record= new File ("Books record.txt");
	Scanner t= new Scanner(System.in);
	String title;
	System.out.println("ENTER BOOK TITLE");
	title=t.nextLine();
	try {
		FileWriter Fr= new FileWriter(record);
		int count =0;
		int i=0;
		Fr.write("");
		Fr.close();
		Fr= new FileWriter(record,true	);
for (;i<book.length;i++) {
	if(title.equalsIgnoreCase(book[i].Bookname)) ;
		
	else {
	
		id=count;
		count++;
		Fr .write((id+1)+"#"+book[i].Bookname +"#"+book[i].Authorsname+"#" + book[i].Pdate+ "#"	+ book[i].quantity +"\n");
		
	}
}
Fr.close();


}catch(IOException e) {
	
}
	
}
public int update(BooksRecord[] book , String n,int a) {
	
	for(int i=0;i<book.length;i++) {
		if(n.equalsIgnoreCase(book[i].Bookname)) {
			book[i].quantity+=a;
			a=book[i].quantity;
		}
	}
	File record= new File ("Books record.txt");
	try {
		FileWriter Fr= new FileWriter(record);
		int count =0;
		int i=0;
		Fr.write("");
		Fr.close();
		Fr= new FileWriter(record,true	);
for (;i<book.length;i++) {
	
		id=count;
		count++;
		Fr .write((id+1)+"#"+book[i].Bookname +"#"+book[i].Authorsname+"#" + book[i].Pdate+ "#"	+ book[i].quantity +"\n");
		
	}

Fr.close();


}catch(IOException e) {
	
}
	return a;
}
}