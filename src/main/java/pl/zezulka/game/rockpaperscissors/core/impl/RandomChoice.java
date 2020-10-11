/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.core.impl;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

import pl.zezulka.game.rockpaperscissors.core.IChoiceStrategy;
import pl.zezulka.game.rockpaperscissors.model.Choice;

/**
 * @author ania
 *
 */
@Component(value = "randomChoice")
public class RandomChoice implements IChoiceStrategy {

	private static final Choice[] values = Choice.values();
	private static final Random random = new SecureRandom();

	public static Choice getRandomChoice() {
		return values[random.nextInt(values.length)];
	}

	@Override
	public Choice selectChoice() {
		return getRandomChoice();
	}

}
