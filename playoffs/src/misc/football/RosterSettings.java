package misc.football;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RosterSettings
{
	protected Map<String, Integer> limits = new HashMap<String, Integer>();
	public void setLimits(Map<String, Integer> limits){this.limits = limits;}

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