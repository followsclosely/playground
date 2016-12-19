package euler.p001_099.p001_009;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem004 implements Answerable
{
	public static void main(String[] args)
	{
		System.out.println(new Problem004().answer());
	}

	@Override
	public Number answer()
	{
		for(long a=999; a>900; a--)
		{
			for(long b=999; b>900; b--)
			{
				//System.out.println(a + "*" + b + "=" + (a*b));
				if (EulerUtilities.isPalindrome(Long.toString(a*b)))
				{
					//System.out.println(a + "*" + b + "=" + value);
					return a*b;
				}
			}
		}
		
		return Float.NaN;
	}
}