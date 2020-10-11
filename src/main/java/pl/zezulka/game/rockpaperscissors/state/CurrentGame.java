package pl.zezulka.game.rockpaperscissors.state;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import pl.zezulka.game.rockpaperscissors.model.Game;

@Component
@SessionScope
public class CurrentGame {

	private Game game;

	public CurrentGame() {
		this.game = new Game();
	}

	public Game getGame() {
		return game;
	}

	public void restart() {
		this.game = new Game();
	}

}
