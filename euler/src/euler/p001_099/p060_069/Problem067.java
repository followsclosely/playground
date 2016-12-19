package euler.p001_099.p060_069;

import java.io.IOException;
import java.net.URISyntaxException;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem067 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem067().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		// 427337
		int[][] board = EulerUtilities.getTwoDimentionalBoard("/euler/p001_099/p060_069/p067_triangle.txt", " ");

		//EulerUtilities.print(board, " ");
		
		// Start at the bottom of the board and work up.
		for (int row = board.length - 1; row >= 0; row--)
		{
			for (int x = 1, xlength = board[row].length; x < xlength; x++)
			{
				// Take the larger of the two numbers and add it to the value
				// above in the triangle.
				board[row - 1][x - 1] = board[row - 1][x - 1] + Math.max(board[row][x], board[row][x - 1]);
			}
			//EulerUtilities.print(board, " ");
		}

		return board[0][0];
	}

}
