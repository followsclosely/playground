package euler.p001_099.p010_019;

import java.io.IOException;
import java.net.URISyntaxException;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem010 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem010().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		long answer = 0;
		
		for(int i=2; i<2000000; i++)
		{
			if( EulerUtilities.isPrime(i))
			{
				answer += i;
			}
		}
		
		return answer;
	}
}