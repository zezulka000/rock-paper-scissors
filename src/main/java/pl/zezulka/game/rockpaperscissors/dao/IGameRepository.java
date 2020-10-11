/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.dao;

import java.util.Optional;

import pl.zezulka.game.rockpaperscissors.model.Game;

/**
 * @author ania
 *
 */
public interface IGameRepository {

	Game save(Game game);

	Optional<Game> findById(Long id);

}
