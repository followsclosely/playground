package euler.p001_099.p001_009;

import java.util.stream.IntStream;

import euler.Answerable;

public class Problem001s implements Answerable
{
	public static void main(String[] args)
	{
		System.out.println(new Problem001s().answer());
	}

	@Override
	public Number answer()
	{
		return IntStream.range(3, 1000).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
	}
}
