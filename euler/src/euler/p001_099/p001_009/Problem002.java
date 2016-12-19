package euler.p001_099.p001_009;

import euler.Answerable;

public class Problem002 implements Answerable
{
	public static void main(String[] args)
	{
		System.out.println(new Problem002().answer());
	}
	
	@Override
	public Number answer()
	{
		long sum = 2, lastValue = 1, currentValue = 2, tempValue = 0;
		while (currentValue < 4000000)
		{
			if ((tempValue = lastValue + currentValue) % 2 == 0)
			{
				sum += currentValue;
			}

			lastValue = currentValue;
			currentValue = tempValue;
		}
		return sum;
	}
}