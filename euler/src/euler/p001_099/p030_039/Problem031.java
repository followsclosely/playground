package euler.p001_099.p030_039;

import java.io.IOException;
import java.net.URISyntaxException;

import euler.Answerable;

public class Problem031 implements Answerable
{
	int total = 200;
	int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200 };
	
	/**
	 * 1 / (1−x)(1−x2)(1−x5)(1−x10)(1−x20)(1−x50)(1−x100)(1−x200)
	 */

	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem031().answer());
	}

	public Number answer()
	{
		int[] ways = new int[total + 1];
		ways[0] = 1;

		for (int i = 0, length = coins.length; i < length; i++)
		{
			for (int j = coins[i]; j <= total; j++)
			{
				ways[j] += ways[j - coins[i]];
			}
		}
		return ways[total];
	}
}