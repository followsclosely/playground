package misc.football;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RosterSettings
{
	private Map<String, Integer> limits = new HashMap<String, Integer>();

	public Integer getLimit(String position)
	{
		return limits.get(position);
	}

	public RosterSettings addLimit(String position, Integer limit)
	{
		limits.put(position, limit);
		return this;
	}

	public Set<String> getPositions()
	{
		return limits.keySet();
	}
}