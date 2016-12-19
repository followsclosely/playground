package euler.p001_099.p001_009;

import euler.Answerable;

public class Problem005 implements Answerable
{
	public static void main(String[] args)
	{
		System.out.println(new Problem005().answer());
	}

	@Override
	public Number answer()
	{
		long answer = 20;
		for(; answer < Integer.MAX_VALUE; answer+=20)
		{
			boolean isDivisable = true;
			//Don't need to test 1-10 as they are multiples of 11-20. Just test 11-19 as we know 20 is good.
			for(int i=11; isDivisable && i<20; i++)
			{
				if( answer % i != 0)
				{
					isDivisable = false;
				}
			}
			
			if( isDivisable == true)
			{
				break;
			}
		}
		
		return answer;
	}
}