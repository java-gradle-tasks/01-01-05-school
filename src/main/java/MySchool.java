import java.util.Scanner;

public class MySchool{

	public static void main(final String[] args) {
		// Write your solution here
		System.out.println("Osztaly adatok!");
		System.out.print("Adja meg melyik evfolyamra jar:");
		Scanner in=new Scanner(System.in);
		int evfolyam=in.nextInt();
		System.out.print("A "+String.valueOf(evfolyam)+". evfolyam melyik osztalyaba jar:");
		char osztaly=in.next().charAt(0);
		System.out.println("A diak a "+evfolyam+". evfolyam "+osztaly+" osztalyaba jar!");
		in.close();
	}

}
