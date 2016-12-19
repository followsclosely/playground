package euler.p001_099.p001_009;

import euler.Answerable;

public class Problem001 implements Answerable
{
	public static void main(String[] args)
	{
		System.out.println(new Problem001().answer());
	}

	@Override
	public Number answer()
	{
		int answer = 0;

		for (int i = 3; i < 1000; i++)
		{
			if (i % 3 == 0 || i % 5 == 0)
			{
				answer += i;
			}
		}
		return answer;
	}
	
	
}
