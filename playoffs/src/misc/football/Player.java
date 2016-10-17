package misc.football;

public class Player implements Comparable<Player>
{
	private String id;
	private String name;
	private float points;
	private String position;
	private String team;

	public Player(String id, String name, float points, String position, String team)
	{
		this.id = id;
		this.name = name;
		this.points = points;
		this.position = position;
		this.team = team;
	}

	@Override
	public String toString()
	{
		return name;
	}

	@Override
	public int compareTo(Player player)
	{
		return (player.getPoints() == points) ? 0 : (player.getPoints() < points) ? -1 : 1;
	}

	public String getName(){return name;}
	public float  getPoints(){return points;}
	public String getPosition(){return position;}
	public String getTeam(){return team;}
	public String getId(){return id;}
}
