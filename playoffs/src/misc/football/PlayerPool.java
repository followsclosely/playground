package misc.football;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PlayerPool
{
	private Map<String, List<Player>> pool = new HashMap<String, List<Player>>()
	{
		public List<Player> get(Object key)
		{
			List<Player> players = super.get(key);
			if (players == null)
			{
				super.put((String) key, players = new ArrayList<Player>());
			}
			return players;
		}
	};

	public void load(String resource) throws IOException
	{
		int i = 0;
		String line = null;
		Set<String> lock = new HashSet<String>();

		BufferedReader br = new BufferedReader(new FileReader(resource));

		// File must be sorted by most fantasy points descending
		while ((line = br.readLine()) != null)
		{
			if (!line.startsWith("#")) // Comment out players with a #
			{
				String[] values = line.split(",");
				Player player = new Player(String.valueOf(i++), values[0], Float.parseFloat(values[3]), values[2], values[1]);

				String key = player.getPosition() + player.getTeam();

				// Only add one player per team for every position is needed.
				if (!lock.contains(key))
				{
					pool.get(player.getPosition()).add(player);
					lock.add(key);
				}
			}
		}

		br.close();

		for (String position : getPositions())
		{
			List<Player> players = getPlayers(position);
			Collections.sort(players);
		}
	}

	public Set<String> getPositions()
	{
		return pool.keySet();
	}

	public List<Player> getPlayers(String position)
	{
		return pool.get(position);
	}
}