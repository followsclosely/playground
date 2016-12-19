package misc.football;

import java.io.IOException;
import java.util.List;

import misc.football.lineup.BestLineupGenerator;
import misc.football.lineup.SimpleLineupGenerator;
import misc.football.lineup.ValueLineupGenerator;

public class Launcher
{
	public static void main(String[] args) throws IOException
	{
		PlayerPool pool = new DefaultPlayerPoolLoader("src/misc/football/W2015.csv").load(new PlayerPool());

		RosterSettings rosterSettings = new RosterSettings()
				.addLimit("QB", 1)
				.addLimit("RB", 2)
				.addLimit("WR", 2)
				.addLimit("TE", 2)
				.addLimit("K", 1)
				.addLimit("D", 1);

		LineupGenerator[] lineupGenerators = new LineupGenerator[]
		{
				new SimpleLineupGenerator(),
				new BestLineupGenerator(), 
				new ValueLineupGenerator()
		};

		for (LineupGenerator lineupGenerator : lineupGenerators)
		{
			long start = System.currentTimeMillis();
			List<Roster> sortedRosters = lineupGenerator.generate(pool, rosterSettings);
			System.out.println("(" + (System.currentTimeMillis() - start) + "ms) " + lineupGenerator.getClass().getName());
			for (int i = 0, size = Math.min(sortedRosters.size(),20); (i < size); i++)
			{
				System.out.println(sortedRosters.get(i));
			}
			System.out.println();
			
		}
	}
}
