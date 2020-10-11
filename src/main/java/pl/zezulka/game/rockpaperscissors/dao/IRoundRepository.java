/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.dao;

import java.util.List;

import pl.zezulka.game.rockpaperscissors.model.Round;

/**
 * @author ania
 *
 */
public interface IRoundRepository {

	Round save(Round round);

	List<Round> findAll();

}
