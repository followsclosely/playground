package misc.football;

import org.springframework.beans.factory.FactoryBean;

public class PlayerPoolFactoryBean extends DefaultPlayerPoolLoader implements FactoryBean<PlayerPool>
{
	@Override public PlayerPool getObject() throws Exception
	{
		return load(new PlayerPool());
	}
	@Override public Class<?> getObjectType(){return PlayerPool.class;}
	@Override public boolean isSingleton(){return false;}
}
