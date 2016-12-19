package misc.football;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
 * This PlayerPoolLoader loads the first player for each position per team.
 * Assumes the player file is sorted and in the following format:
 * <p><pre>
 *   <b>PlayerName,Team,Position,Points</b>
 *   Tom Brady,NE,QB,58.71
 * </pre></p>
 * 
 * TODO: Extract Interface if needed.
 * 
 * @author M.L. Wilson
 */
public class DefaultPlayerPoolLoader implements PlayerPoolLoader
{
	private String resource = null;
	
	public DefaultPlayerPoolLoader(String resource)
	{
		this.resource = resource;
	}

	/* (non-Javadoc)
	 * @see misc.football.PlayerPoolLoaderd#load(misc.football.PlayerPool)
	 */
	@Override
	public PlayerPool load(PlayerPool pool) throws IOException
	{
		int i = 0;
		String line = null;
		Set<String> lock = new HashSet<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(resource)))
		{
			// File must be sorted by most fantasy points descending
			while ((line = br.readLine()) != null)
			{
				if (!line.startsWith("#")) // Comment out players with a #
				{
					String[] values = line.split(",");
					Player player = new Player(String.valueOf(i++), values[0], Float.parseFloat(values[3]), values[2], values[1]);

					String key = player.getPosition() + player.getTeam();

					// Only add one player per team for every position is
					// needed.
					if (!lock.contains(key))
					{
						pool.getPlayers(player.getPosition()).add(player);
						lock.add(key);
					}
				}
			}
		}

		for (String position : pool.getPositions())
		{
			List<Player> players = pool.getPlayers(position);
			Collections.sort(players);
		}
		
		return pool;
	}
}