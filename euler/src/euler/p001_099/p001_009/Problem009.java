package euler.p001_099.p001_009;

import java.io.IOException;
import java.net.URISyntaxException;

import euler.Answerable;

public class Problem009 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem009().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		long maxAnswer = 0;

		for (int a = 3; a < 1000; ++a)
		{
			for (int b = 3; b < 1000 - a; ++b)
			{
				int c = 1000 - a - b;
				if (c * c == a * a + b * b)
				{
					maxAnswer = a * b * c;
					break;
				}
			}
		}

		return maxAnswer;
	}
}