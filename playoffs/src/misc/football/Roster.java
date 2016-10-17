package misc.football;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Roster implements Comparable<Roster>
{
	private float points;
	private List<Player> players = new ArrayList<Player>();

	public boolean canAddPlayer(Player player, RosterSettings rosterSettings)
	{
		// only one player per team
		for (Player playerOnRoster : players)
		{
			if (player.getTeam().equals(playerOnRoster.getTeam()))
			{
				return false;
			}
		}

		if (rosterSettings != null)
		{
			// limit the number per position
			int limit = rosterSettings.getLimit(player.getPosition());
			for (Player playerOnRoster : players)
			{
				if (player.getPosition().equals(playerOnRoster.getPosition()))
				{
					if (--limit == 0)
					{
						return false;
					}
				}
			}
		}

		return true;
	}

	public Roster addPlayer(Player player)
	{
		points += player.getPoints();
		players.add(player);
		return this;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Points: ").append(String.format("%.2f", points)).append("\t");

		for (Player player : players)
		{
			builder.append(player.getName()).append(" (").append(player.getPoints()).append(")\t");
		}

		return builder.toString();
	}

	@Override
	public int compareTo(Roster roster)
	{
		return (roster.points == points) ? 0 : (roster.points < points) ? -1 : 1;
	}

	public String getUniqueKey()
	{
		Collections.sort(players);

		// Generate a new hashCode
		StringBuilder builder = new StringBuilder();
		for (Player p : players)
		{
			builder.append(p.getId()).append(".");
		}

		return builder.toString();
	}

	public Roster getCopy()
	{
		Roster roster = new Roster();
		roster.players = new ArrayList<Player>(players);
		roster.points = points;
		return roster;
	}

	public List<Player> getPlayers()
	{
		return players;
	}
}