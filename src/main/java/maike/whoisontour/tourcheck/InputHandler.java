package maike.whoisontour.tourcheck;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputHandler {
	
	public static String getArtist() {
		System.out.println("Enter artist name: ");
		
		String artist;
		Scanner scanner = new Scanner(System.in);;
		try {
			artist = scanner.nextLine().trim();
			
		} catch(NoSuchElementException e) {
			artist = null;
		} finally {
			scanner.close();
		}
		
		return artist;
	}
}
