package misc.football;

import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLauncher extends Launcher
{
	public static void main(String[] args) throws IOException, ParseException
	{
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/misc/football/spring.xml"))
		{
			Launcher launcher = context.getBean(Launcher.class, "Launcher");
			launcher.execute();
		};
	}
}
