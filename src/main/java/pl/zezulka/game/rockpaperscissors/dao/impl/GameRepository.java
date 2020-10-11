/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.dao.impl;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import pl.zezulka.game.rockpaperscissors.dao.IGameRepository;
import pl.zezulka.game.rockpaperscissors.model.Game;

/**
 * @author ania
 *
 */
@Repository
public class GameRepository implements IGameRepository {

	private final AtomicLong counter = new AtomicLong();
	private final Map<Long, Game> result = new ConcurrentHashMap<>();

	@Override
	public Game save(Game game) {
		game.setId(counter.incrementAndGet());
		result.put(game.getId(), game);
		return game;
	}

	@Override
	public Optional<Game> findById(Long id) {
		return Optional.ofNullable(result.get(id));
	}

}
