package euler.p001_099.p001_009;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem007 implements Answerable
{
	public static void main(String[] args)
	{
		System.out.println(new Problem007().answer());
	}

	@Override
	public Number answer()
	{
		long largePrime = 0;
		for(int count=0; count!=10001; largePrime++)
		{
			if(EulerUtilities.isPrime(largePrime))
			{
				count++;
			}
		}
		
		return largePrime;
	}
}