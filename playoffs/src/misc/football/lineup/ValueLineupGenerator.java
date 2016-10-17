package misc.football.lineup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import misc.football.Delta;
import misc.football.LineupGenerator;
import misc.football.Player;
import misc.football.PlayerPool;
import misc.football.Roster;
import misc.football.RosterSettings;

public class ValueLineupGenerator implements LineupGenerator
{
	public ArrayList<Roster> generate(PlayerPool pool, RosterSettings rosterSettings)
	{
		Roster roster = new Roster();

		while (true)
		{
			List<Delta> deltas = getDeltas(pool, rosterSettings, roster);

			if (deltas.size() > 0)
			{
				roster.addPlayer(deltas.get(0).getPlayer());
				//debug(roster, deltas);
			} else
			{
				break;
			}
		}

		ArrayList<Roster> rosters = new ArrayList<Roster>();
		rosters.add(roster);
		return rosters;
	}

	

	/**
	 * Returns a List of Delta objects. Each Delta object holds the best
	 * <b>starter</b> and the best <b>non starter</b> for a given position. For
	 * example if your rosterSettings say you can have two RBs on your roster
	 * then the Delta will have RB1 and RB3.
	 * 
	 * @return The list of Delta(s) is sorted by the difference in fantasy
	 *         points between the players in the Delta.
	 */
	private List<Delta> getDeltas(PlayerPool pool, RosterSettings rosterSettings, Roster roster)
	{
		List<Delta> deltas = new ArrayList<Delta>();

		for (String position : rosterSettings.getPositions())
		{
			Integer depth = rosterSettings.getLimit(position);
			List<Player> players = pool.getPlayers(position);

			Delta delta = null;
			for (int i = 0; i < players.size(); i++)
			{
				Player nextPlayer = players.get(i);// get the first player.

				if (roster.getPlayers().contains(nextPlayer))
				{
					--depth;
				} else if (delta == null && roster.canAddPlayer(nextPlayer, rosterSettings))
				{
					delta = new Delta(nextPlayer);
				} else
				{
					if (roster.canAddPlayer(nextPlayer, rosterSettings) && (--depth == 0))
					{
						delta.setNextBest(nextPlayer);
					}
				}
			}

			if (delta != null)
			{
				deltas.add(delta);
			}
		}

		Collections.sort(deltas);
		return deltas;
	}
	
	private void debug(Roster roster, List<Delta> deltas)
	{
		for (Delta delta : deltas)
		{
			System.out.println(delta.getPlayer().getPosition() + "\t" + String.format("%.2f", delta.getValue())
					+ " =\t " + delta.getPlayer() + "(" + delta.getPlayer().getPoints() + ")\t-  " + delta.getNextBest()
					+ "(" + (delta.getNextBest() == null ? "0" : delta.getNextBest().getPoints()) + ")");
		}
		System.out.println(roster + "\n");
	}
}