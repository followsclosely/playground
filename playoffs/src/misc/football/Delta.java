package misc.football;

public class Delta implements Comparable<Delta>
{
	private float value;
	private Player player;
	private Player nextBest;

	public Delta(Player player)
	{
		this.player = player;
	}

	public float getValue()
	{
		return value;
	}

	public Player getPlayer()
	{
		return player;
	}

	public Player getNextBest()
	{
		return nextBest;
	}
	public void setNextBest(Player nextBest)
	{
		this.nextBest = nextBest;
		this.value = player.getPoints() - nextBest.getPoints();
	}
	
	@Override
	public int compareTo(Delta delta)
	{
		return (delta.getValue() == value) ? 0 : (delta.getValue() < value) ? -1 : 1;
	}
}