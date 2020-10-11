/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.core.impl;

import org.springframework.stereotype.Component;

import pl.zezulka.game.rockpaperscissors.core.IChoiceStrategy;
import pl.zezulka.game.rockpaperscissors.model.Choice;

/**
 * @author ania
 *
 */
@Component(value = "rockChoice")
public class RockChoice implements IChoiceStrategy {

	@Override
	public Choice selectChoice() {
		return Choice.ROCK;
	}

}
