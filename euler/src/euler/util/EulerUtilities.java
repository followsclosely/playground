package euler.util;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EulerUtilities
{
	public static int[] getOneDimentionalBoard(String resource, String delim) throws IOException, URISyntaxException
	{
		String content = new String(
				Files.readAllBytes(Paths.get(EulerUtilities.class.getClass().getResource(resource).toURI())));

		int[] numbers = null;

		if (delim == null)
		{
			content = content.replaceAll("\n|\r", "");
			numbers = new int[content.length()];
			for (int i = 0, length = numbers.length; i < length; i++)
			{
				numbers[i] = Integer.parseInt(content.substring(i, i + 1));
			}
		}

		return numbers;
	}

	public static int[][] getTwoDimentionalBoard(String resource, String delim) throws IOException, URISyntaxException
	{
		String content = new String(
				Files.readAllBytes(Paths.get(EulerUtilities.class.getClass().getResource(resource).toURI())));

		String[] lines = content.split("\n");

		int[][] board = new int[lines.length][];

		int x = 0;
		for (String line : lines)
		{
			int y = 0;
			String[] values = line.split(delim);
			board[x] = new int[values.length];
			for (String value : values)
			{
				board[x][y++] = Integer.parseInt(value.trim());
			}
			x++;
		}

		return board;
	}

	public static void print(int[] board, String delim)
	{
		for (int x = 0, xlength = board.length; x < xlength; x++)
		{
			System.out.print(board[x]);
			if (delim != null && x < xlength - 1)
			{
				System.out.print(delim);
			}
		}
		System.out.println();
	}

	public static void print(int[][] board, String delim)
	{
		for (int x = 0, xlength = board.length; x < xlength; x++)
		{
			for (int y = 0, ylength = board[x].length; y < ylength; y++)
			{
				System.out.print(board[x][y]);
				if (delim != null && x < xlength - 1)
				{
					System.out.print(delim);
				}
			}
			System.out.println();
		}
	}

	public static boolean isPalindrome(String message)
	{
		int n = message.length();
		for (int i = 0; i < n / 2; i++)
		{
			if (message.charAt(i) != message.charAt(n - i - 1))
			{
				return false;
			}
		}
		return true;
	}

	public static boolean isPrime(long num)
	{
		boolean isPrime = true;
		for (long j = 2; j <= Math.sqrt(num); j++)
		{
			if (num % j == 0)
			{
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}

	public static BigInteger factorial(int value)
	{
		BigInteger result = BigInteger.ONE;
		for (int i = 1; i < value; i++)
		{
			result = result.multiply(BigInteger.valueOf(i));
		}

		return result;
	}
	
	public static double arraySum(double[] a, int start, int end)
	{
		double sum = 0;

		for(int i = start; i < end; i++)
			sum += a[i];

		return sum;
	}

}