/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.zezulka.game.rockpaperscissors.dao.IRoundRepository;
import pl.zezulka.game.rockpaperscissors.model.Choice;
import pl.zezulka.game.rockpaperscissors.model.Game;
import pl.zezulka.game.rockpaperscissors.model.Round;
import pl.zezulka.game.rockpaperscissors.service.IRoundService;

/**
 * @author ania
 *
 */
@Service
public class RoundService implements IRoundService {

	private IRoundRepository roundRepository;

	public RoundService(IRoundRepository roundRepository) {
		super();
		this.roundRepository = roundRepository;
	}

	@Override
	public Round create(Game game, Choice playerOneChoice, Choice playerTwoChoice) {
		Round round = new Round();
		round.setGame(game);
		round.setPlayerOneChoice(playerOneChoice);
		round.setPlayerTwoChoice(playerTwoChoice);
		round.setPlayerOneResult(playerOneChoice.resultWith(round.getPlayerTwoChoice()));
		roundRepository.save(round);
		return round;
	}

	@Override
	public List<Round> findAll() {
		return roundRepository.findAll();
	}

}
