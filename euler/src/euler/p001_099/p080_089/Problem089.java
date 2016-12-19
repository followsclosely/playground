package euler.p001_099.p080_089;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import euler.Answerable;

public class Problem089 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem089().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		//I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1,000
		//743 characters shorter
		
		String originalContent = new String(Files.readAllBytes(Paths.get(getClass().getResource("/euler/p001_099/p080_089/p089_roman.txt").toURI())));
		
		//If you want a clean file then do this.
		String newContent = originalContent.replaceAll("DCCCC", "CM");
		newContent = newContent.replaceAll("LXXXX", "XC");
		newContent = newContent.replaceAll("VIIII", "IX");
		newContent = newContent.replaceAll("CCCC", "CD");
		newContent = newContent.replaceAll("XXXX", "XL");
		newContent = newContent.replaceAll("IIII", "IV");
		
		//If you want just the count this will do.
		newContent = originalContent.replaceAll("(DCCCC|LXXXX|VIIII|CCCC|XXXX|IIII)", "--");

		return originalContent.length() - newContent.length();
	}
}
