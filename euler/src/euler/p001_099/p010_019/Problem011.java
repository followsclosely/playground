package euler.p001_099.p010_019;

import java.io.IOException;
import java.net.URISyntaxException;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem011 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem011().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		int lengthOfAdjacent = 4;
		
		//70600674
		int max = 0;
		String foundText = null;

		int[][] board = EulerUtilities.getTwoDimentionalBoard("/euler/p001_099/p010_019/p011_grid.txt", " ");
		//EulerUtilities.print(board, " ");

		int size = board.length;

		for (int x = 0; x < size; x++)
		{
			for (int y = 0; y < size; y++)
			{
				// check down
				if (y < size - lengthOfAdjacent)
				{
					int total = board[x][y];
					for(int i=1; i<lengthOfAdjacent; i++) total*=board[x][y + i];
					
					if (total > max)
					{
						max = total; foundText = "Found at [" + x +","+ y+ "] down.";
					}
				}
				
				// across
				if (x < size - lengthOfAdjacent)
				{
					int total = board[x][y];
					for(int i=1; i<lengthOfAdjacent; i++) total*=board[x+i][y];
					
					if (total > max)
					{
						max = total; foundText = "Found at [" + x +","+ y+ "] across.";
					}
				}
				
				// back slash
				if (x < size - lengthOfAdjacent && y < size - lengthOfAdjacent)
				{
					int total = board[x][y];
					for(int i=1; i<lengthOfAdjacent; i++) total*=board[x+i][y + i];
					
					if (total > max)
					{
						max = total; foundText = "Found at [" + x +","+ y+ "] back slash.";
					}
				}
				
				// slash (THIS HITS THE CORRECT NUMBER)
				if (x >= lengthOfAdjacent && y < size - lengthOfAdjacent)
				{
					int total = board[x][y];
					for(int i=1; i<lengthOfAdjacent; i++) total*=board[x-i][y + i];
					
					if (total > max)
					{
						max = total; foundText = "Found at [" + x +","+ y+ "] slash.";
					}
				}
			}
		}

		//System.out.println(foundText);
		return max;
	}

}
