package io.github.sejoung.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class TestRestControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void api() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/api/")).andDo(print()).andExpect(status().isOk());
  }
}