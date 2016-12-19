package misc.football;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Holds all players, grouped by position.
 * 
 * @author M.L Wilson
 */
public class PlayerPool
{
	private Map<String, List<Player>> pool = new HashMap<String, List<Player>>()
	{
		private static final long serialVersionUID = 1L;
		
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

	public Set<String> getPositions()
	{
		return pool.keySet();
	}

	public List<Player> getPlayers(String position)
	{
		return pool.get(position);
	}
}