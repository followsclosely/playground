package misc.football;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.ParseException;

import misc.football.lineup.BestLineupGenerator;
import misc.football.lineup.SimpleLineupGenerator;
import misc.football.lineup.ValueLineupGenerator;

public class Launcher
{
	protected PlayerPool playerPool = null;
	protected RosterSettings rosterSettings = null;
	protected List<LineupGenerator> lineupGenerators = null;
	
	public void execute()
	{
		for (LineupGenerator lineupGenerator : lineupGenerators)
		{
			long start = System.currentTimeMillis();
			List<Roster> sortedRosters = lineupGenerator.generate(playerPool, rosterSettings);
			System.out.println("(" + (System.currentTimeMillis() - start) + "ms) " + lineupGenerator.getClass().getName());
			for (int i = 0, size = Math.min(sortedRosters.size(), 20); (i < size); i++)
			{
				System.out.println(sortedRosters.get(i));
			}
			System.out.println();

		}
	}

	public static void main(String[] args) throws IOException, ParseException
	{
		Launcher launcher = new Launcher();
		launcher.setLineupGenerators(Arrays.asList(new LineupGenerator[]{ 
				new SimpleLineupGenerator(), 
				new BestLineupGenerator(), 
				new ValueLineupGenerator() 
				}));
		launcher.setPlayerPool(new DefaultPlayerPoolLoader("src/misc/football/stats/2017-W3.csv").load(new PlayerPool()));
		
		launcher.setRosterSettings(new RosterSettings()
				.addLimit("QB", 1)
				.addLimit("RB", 2)
				.addLimit("WR", 3)
				.addLimit("TE", 1)
				.addLimit("K", 1)
				.addLimit("D", 1));
		launcher.execute();
	}
	
	public void setPlayerPool(PlayerPool playerPool){this.playerPool = playerPool;}
	public void setRosterSettings(RosterSettings rosterSettings){this.rosterSettings = rosterSettings;}
	public void setLineupGenerators(List<LineupGenerator> lineupGenerators){this.lineupGenerators = lineupGenerators;}
}
