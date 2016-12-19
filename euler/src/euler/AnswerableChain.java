package euler;

import java.util.ArrayList;
import java.util.List;

import euler.p001_099.p001_009.Problem001;
import euler.p001_099.p001_009.Problem002;
import euler.p001_099.p001_009.Problem003;
import euler.p001_099.p001_009.Problem004;
import euler.p001_099.p001_009.Problem005;
import euler.p001_099.p001_009.Problem006;
import euler.p001_099.p001_009.Problem008;
import euler.p001_099.p001_009.Problem009;
import euler.p001_099.p010_019.Problem010;
import euler.p001_099.p010_019.Problem011;
import euler.p001_099.p010_019.Problem018;
import euler.p001_099.p060_069.Problem067;
import euler.p001_099.p080_089.Problem089;

/*
 * https://github.com/nayuki/Project-Euler-solutions/tree/master/java
 * 
 */
public class AnswerableChain
{
	public static void main(String[] args)
	{
		List<Answerable> problems = new ArrayList<Answerable>();
		problems.add(new Problem001());
		//problems.add(new Problem001s());

		problems.add(new Problem002());
		problems.add(new Problem003());
		problems.add(new Problem004());
		problems.add(new Problem005());
		problems.add(new Problem006());
		problems.add(new Problem008());
		problems.add(new Problem009());
		
		problems.add(new Problem010());
		problems.add(new Problem011());
		problems.add(new Problem018());
		problems.add(new Problem067());
		//problems.add(new Problem081());
		problems.add(new Problem089());

		
		for (Answerable problem : problems)
		{
			try
			{
				long startTime = System.currentTimeMillis();
				Number answer = problem.answer();
				long endTime = System.currentTimeMillis();
				System.out.println((endTime - startTime) + "ms\t" + problem.getClass().getName() + "\t" + answer);
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
