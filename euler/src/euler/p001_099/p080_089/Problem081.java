package euler.p001_099.p080_089;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import euler.Answerable;
import euler.util.EulerUtilities;

public class Problem081 implements Answerable
{
	public static void main(String[] args) throws IOException, URISyntaxException
	{
		System.out.println(new Problem081().answer());
	}

	@Override
	public Number answer() throws IOException, URISyntaxException
	{
		//427337
		int[][] board = EulerUtilities.getTwoDimentionalBoard("/euler/p001_099/p080_089/p081_matrix.txt", ",");
		EulerUtilities.print(board, "\t");
		
		return null;
	}
}
