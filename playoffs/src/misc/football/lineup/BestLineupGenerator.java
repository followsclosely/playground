package misc.football.lineup;

import java.util.ArrayList;
import java.util.List;

import misc.football.LineupGenerator;
import misc.football.Player;
import misc.football.PlayerPool;
import misc.football.Roster;
import misc.football.RosterSettings;

/**
 * This LineupGenerator takes the highest scoring player available until the
 * roster is filled.
 */
public class BestLineupGenerator implements LineupGenerator
{
	public ArrayList<Roster> generate(PlayerPool pool, RosterSettings rosterSettings)
	{
		Roster roster = new Roster();

		Player best = getBestAvailable(pool, roster, rosterSettings);
		while (best != null)
		{
			roster.addPlayer(best);
			best = getBestAvailable(pool, roster, rosterSettings);
		}

		ArrayList<Roster> rosters = new ArrayList<Roster>();
		rosters.add(roster);
		return rosters;
	}

	public Player getBestAvailable(PlayerPool pool, Roster roster, RosterSettings rosterSettings)
	{
		Player best = null;

		for (String position : rosterSettings.getPositions())
		{
			List<Player> players = pool.getPlayers(position);
			for (Player player : players)
			{
				if (roster.canAddPlayer(player, rosterSettings))
				{
					if (best == null || best.getPoints() < player.getPoints())
					{
						best = player;
					}
				}
			}
		}

		return best;
	}
}