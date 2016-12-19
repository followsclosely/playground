package euler.p001_099.p001_009;

import euler.Answerable;

public class Problem006 implements Answerable
{
	public static void main(String[] args)
	{
		System.out.println(new Problem006().answer());
	}

	@Override
	public Number answer()
	{
		int sum = 0, sum2 = 0;
		
		for (int i = 1; i <= 100; i++)
		{
			sum += i;
			sum2 += i * i;
		}
		return sum * sum - sum2;
	}
}