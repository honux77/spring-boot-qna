package com.codessquad.qna.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class WelcomeControllerTest {
	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() throws Exception {
		mvc.perform(get("/")).andExpect(status().isOk());
	}
}
