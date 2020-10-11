/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import pl.zezulka.game.rockpaperscissors.dao.IGameRepository;
import pl.zezulka.game.rockpaperscissors.exception.GameNotFoundException;
import pl.zezulka.game.rockpaperscissors.model.Choice;
import pl.zezulka.game.rockpaperscissors.model.Game;
import pl.zezulka.game.rockpaperscissors.model.Result;
import pl.zezulka.game.rockpaperscissors.model.Round;
import pl.zezulka.game.rockpaperscissors.model.Summary;
import pl.zezulka.game.rockpaperscissors.service.IGameService;
import pl.zezulka.game.rockpaperscissors.service.IRoundService;

/**
 * @author ania
 *
 */
@Service
public class GameService implements IGameService {

	private IRoundService roundService;
	private IGameRepository gameRepository;

	public GameService(IRoundService roundService, IGameRepository gameRepository) {
		super();
		this.roundService = roundService;
		this.gameRepository = gameRepository;
	}

	@Override
	public Game create(Game game) {
		gameRepository.save(game);
		return game;
	}

	@Override
	public Game find(Long gameId) throws GameNotFoundException {
		Game game = gameRepository.findById(gameId)
				.orElseThrow(() -> new GameNotFoundException(String.format("Game with id=%s not found", gameId)));
		return game;
	}

	@Override
	public void play(Game game, Choice playerOneChoice, Choice playerTwoChoice) {
		Round round = roundService.create(game, playerOneChoice, playerTwoChoice);
		game.addRound(round);
	}

	@Override
	public Summary gameSummary() {
		List<Round> list = roundService.findAll();

		Map<Result, Long> counted = list.stream()
				.collect(Collectors.groupingBy((Round round) -> round.getPlayerOneResult(), Collectors.counting()));

		// init values - 0
		Stream.of(Result.values()).filter(x -> !counted.containsKey(x)).forEach(x -> counted.put(x, 0L));

		return new Summary(counted.get(Result.WIN), counted.get(Result.LOSE), counted.get(Result.DRAW));
	}

}
