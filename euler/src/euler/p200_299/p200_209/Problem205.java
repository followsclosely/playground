package euler.p200_299.p200_209;

import java.io.IOException;
import java.net.URISyntaxException;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem205 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem205().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		int MAX = 37;

		int[] peterCount = new int[MAX];
		int[] colinCount = new int[MAX];

		// get peter's possible totals for all possible rolls of the dice
		for (int d1 = 1; d1 <= 4; d1++)
			for (int d2 = 1; d2 <= 4; d2++)
				for (int d3 = 1; d3 <= 4; d3++)
					for (int d4 = 1; d4 <= 4; d4++)
						for (int d5 = 1; d5 <= 4; d5++)
							for (int d6 = 1; d6 <= 4; d6++)
								for (int d7 = 1; d7 <= 4; d7++)
									for (int d8 = 1; d8 <= 4; d8++)
										for (int d9 = 1; d9 <= 4; d9++)
										{
											peterCount[d1 + d2 + d3 + d4 + d5 + d6 + d7 + d8 + d9]++;
										}

		// get colin's possible totals for all possible rolls of the dice
		for (int d1 = 1; d1 <= 6; d1++)
			for (int d2 = 1; d2 <= 6; d2++)
				for (int d3 = 1; d3 <= 6; d3++)
					for (int d4 = 1; d4 <= 6; d4++)
						for (int d5 = 1; d5 <= 6; d5++)
							for (int d6 = 1; d6 <= 6; d6++)
							{
								colinCount[d1 + d2 + d3 + d4 + d5 + d6]++;
							}

		// how many possible throws are there?
		int peterTotal = 4 * 4 * 4 * 4 * 4 * 4 * 4 * 4 * 4;
		int colinTotal = 6 * 6 * 6 * 6 * 6 * 6;

		// what are the probabilities of throwing a certain total?
		double[] peterProb = new double[MAX];
		double[] colinProb = new double[MAX];

		for (int i = 0; i < MAX; i++)
		{
			peterProb[i] = (double) peterCount[i] / peterTotal;
			colinProb[i] = (double) colinCount[i] / colinTotal;
		}

		// the probability that peter wins is:
		// probability that colin throws a number * prob that peter throuws a
		// higher number
		double peterWins = 0;
		for (int n = 1; n < peterCount.length; n++)
		{
			peterWins += colinProb[n - 1] * EulerUtilities.arraySum(peterProb, n, peterCount.length);
		}

		return peterWins;
	}
}
