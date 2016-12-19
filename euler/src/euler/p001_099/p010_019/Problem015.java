package euler.p001_099.p010_019;

import java.io.IOException;
import java.net.URISyntaxException;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem015 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem015().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		int sizeOfOptions = 20;
		
		/*
		 * Yes, it's simple, the formula is: 40! / (20! * 20!). Explanation: start with a 2X2 matrix and a move 
		 * right = "r", move down = "d"; then, all you need to do is find all possible combinations, such as: 
		 * rrdd, rddr, ddrr, drrd, rdrd and drdr. You notice that if instead of r and d we had 4 different 
		 * letters, the whole number of permutations would be 4!. However, the possibilities to combine 2 different 
		 * letters is 2!. So, when 2 letters are equal, you reduce the total number of 4! to just 4!/2!. 
		 * Similarly, two other letters are identical, so you reduce again by 2!, getting thus 4! / (2! * 2!). 
		 * It's easy to generalize that for a 20X20 matrix: you have 40 letters in total, but 20 of them are 
		 * "r" and the other 20 are "d", giving us 40! / (20! * 20!) possible permutations.
		 */
		return (EulerUtilities.factorial(sizeOfOptions*2).divide(
				EulerUtilities.factorial(sizeOfOptions).multiply(EulerUtilities.factorial(sizeOfOptions)))
				);
	}
}