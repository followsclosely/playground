package euler.p001_099.p001_009;

import java.io.IOException;
import java.net.URISyntaxException;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem008 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem008().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		int lengthOfAdjacent = 13;
		long maxAnswer = 0, answer = 0;

		int[] board = EulerUtilities.getOneDimentionalBoard("/euler/p001_099/p001_009/p008_number.txt", null);
		// EulerUtilities.print(board, null);

		for (int x = 0, length = (board.length - lengthOfAdjacent); x < length; x++)
		{
			answer = board[x];
			for (int i = 1; i < lengthOfAdjacent; i++)
			{
				answer *= board[x + i];
			}

			if (answer > maxAnswer)
			{
				maxAnswer = answer;
			}
		}

		return maxAnswer;
	}
}