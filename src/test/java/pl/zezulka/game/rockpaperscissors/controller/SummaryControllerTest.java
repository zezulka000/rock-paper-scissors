/**
 * 
 */
package pl.zezulka.game.rockpaperscissors.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author ania
 *
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SummaryControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getSummaryTest() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/summary").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

		String resultContent = result.getResponse().getContentAsString();
		Assertions.assertNotNull(resultContent);

	}

}
