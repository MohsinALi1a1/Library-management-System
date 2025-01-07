package Library;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Fine {
public static long Comparison(String a)
{ DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	LocalDate localDate1 = LocalDate.parse(a,formatter);
	
	LocalDate localDate2 = LocalDate.now();
	

	// calculate difference
	long days = Period.between(localDate1, localDate2).getDays();
	long year = Period.between(localDate1, localDate2).getYears();
	long month = Period.between(localDate1, localDate2).getMonths();
	// print days
	days+=(month*31);
	days+=(year*365);
	System.out.println("You are  Returning  Book After  :" + days+" Days" );
	return days;
}
public static String getdate() {
	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
	   LocalDateTime now = LocalDateTime.now();  
	   return dtf.format(now);
}
public static void fine() {
	System.out.println("Pay Rs 100 Fine Otherwise You are Not Eligible for Borrow Again Book");
	Scanner t= new Scanner(System.in);
	int amount;
	do
	{
		System.out.println("Enter Amount");
		amount=t.nextInt();
if(amount<100)
	System.out.print("Insufficient Amount\nRe");
}while (amount<100);
	
		System.out.println("--------------------Thanks For Paying fine-----------------------\n"
				+ "Remaing Cash "+ (amount-100));
	
	
	
	
}}
