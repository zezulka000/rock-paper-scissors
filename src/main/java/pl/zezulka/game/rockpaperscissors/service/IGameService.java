/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.service;

import pl.zezulka.game.rockpaperscissors.exception.GameNotFoundException;
import pl.zezulka.game.rockpaperscissors.model.Choice;
import pl.zezulka.game.rockpaperscissors.model.Game;
import pl.zezulka.game.rockpaperscissors.model.Summary;

/**
 * @author ania
 *
 */
public interface IGameService {

	Game create(Game game);

	Game find(Long gameId) throws GameNotFoundException;

	void play(Game game, Choice playerOneChoice, Choice playerTwoChoice);

	Summary gameSummary();

}
