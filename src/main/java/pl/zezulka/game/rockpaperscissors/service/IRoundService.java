/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.service;

import java.util.List;

import pl.zezulka.game.rockpaperscissors.model.Choice;
import pl.zezulka.game.rockpaperscissors.model.Game;
import pl.zezulka.game.rockpaperscissors.model.Round;

/**
 * @author ania
 *
 */
public interface IRoundService {

	Round create(Game game, Choice playerOneChoice, Choice playerTwoChoice);

	List<Round> findAll();

}
