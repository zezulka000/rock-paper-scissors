/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author ania
 *
 */
public class ScissorsChoiceTest {

	private Choice choice = Choice.SCISSORS;

	@Test
	public void winsWithPaperTest() {
		Assertions.assertTrue(choice.winsWith(Choice.PAPER), "Scissors should win with Paper");
	}

	@Test
	public void loseWithRockTest() {
		Assertions.assertFalse(choice.winsWith(Choice.ROCK), "Paper should lose with Rock");
	}

	@Test
	public void drawWithScissorsTest() {
		Assertions.assertFalse(choice.winsWith(Choice.SCISSORS), "Scissors should draw with Scissors");
	}

	@Test
	public void resultWithPaperTest() {
		Assertions.assertEquals(Result.WIN, choice.resultWith(Choice.PAPER), "Scissors should win with Paper");
	}

	@Test
	public void resultWithRockTest() {
		Assertions.assertEquals(Result.LOSE, choice.resultWith(Choice.ROCK), "Scissors should lose with Rock");
	}

	@Test
	public void resultWithScissorsTest() {
		Assertions.assertEquals(Result.DRAW, choice.resultWith(Choice.SCISSORS), "Scissors should lose with Scissors");
	}

	@Test
	public void resultWithExceptionTest() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> choice.resultWith(null),
				"IllegalArgumentException expected");
	}

}
