package misc.football;
import java.util.List;

public interface LineupGenerator
{
	public abstract List<Roster> generate(PlayerPool pool, RosterSettings rosterSettings);
}