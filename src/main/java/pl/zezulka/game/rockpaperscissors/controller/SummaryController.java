/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.zezulka.game.rockpaperscissors.service.IGameService;

/**
 * @author ania
 *
 */
@Controller
@RequestMapping("/summary")
public class SummaryController {

	private IGameService gameService;

	public SummaryController(IGameService gameService) {
		super();
		this.gameService = gameService;
	}

	@GetMapping()
	public ModelAndView summary() {
		ModelAndView modelAndView = new ModelAndView("summary");
		modelAndView.addObject("summary", gameService.gameSummary());
		return modelAndView;
	}

}
