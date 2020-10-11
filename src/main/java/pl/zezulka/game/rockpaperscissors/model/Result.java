/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.model;

/**
 * @author ania
 *
 */
public enum Result {

	DRAW("Draw"), //
	WIN("Player One Wins"), //
	LOSE("Player Two Wins"),//

	;

	private final String displayName;

	private Result(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
