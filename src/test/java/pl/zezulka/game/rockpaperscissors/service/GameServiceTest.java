package pl.zezulka.game.rockpaperscissors.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import pl.zezulka.game.rockpaperscissors.dao.IGameRepository;
import pl.zezulka.game.rockpaperscissors.model.Choice;
import pl.zezulka.game.rockpaperscissors.model.Game;
import pl.zezulka.game.rockpaperscissors.service.impl.GameService;

/**
 * 
 * @author ania
 *
 */
@ExtendWith(MockitoExtension.class)
public class GameServiceTest {

	@Mock
	private IRoundService roundService;
	@Mock
	private IGameRepository gameRepository;

	private IGameService gameService;

	@BeforeEach
	public void setup() {
		gameService = new GameService(roundService, gameRepository);
	}

	@Test
	public void testNoRounds() {

		Game game = new Game();

		Assertions.assertTrue(game.getRounds().isEmpty(), "should be no rounds");

	}

	@Test
	public void testOneRound() {

		Game game = new Game();

		gameService.play(game, Choice.PAPER, Choice.PAPER);

		Assertions.assertEquals(1, game.getRounds().size(), "should be one round");

	}

	@Test
	public void testTwoRounds() {

		Game game = new Game();

		gameService.play(game, Choice.PAPER, Choice.PAPER);
		gameService.play(game, Choice.ROCK, Choice.SCISSORS);

		Assertions.assertEquals(2, game.getRounds().size(), "should be two rounds");

	}

}
