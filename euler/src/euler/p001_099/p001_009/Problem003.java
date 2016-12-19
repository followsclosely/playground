package euler.p001_099.p001_009;

import euler.Answerable;

public class Problem003 implements Answerable
{
	public static void main(String[] args)
	{
		System.out.println(new Problem003().answer());
	}

	@Override
	public Number answer()
	{
		// 6857
		long num = 600851475143L;
		long prime = 0L;
		long i = 2;
		
		while (num > 1)
		{
			if (isPrime(i) && num % i == 0)
			{
				num /= i;
				if (i > prime)
				{
					prime = i;
				}
				i = 2;
			}
			i++;
		}

		return prime;
	}

	public static boolean isPrime(long num)
	{
		for (long i = 2L; i < num; i++)
		{
			if (num % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}