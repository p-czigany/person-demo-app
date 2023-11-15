import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.peterczigany.person.PersonApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(classes = PersonApplication.class)
@AutoConfigureMockMvc
class PersonApplicationAcceptanceTest {
  @Autowired private MockMvc mockMvc;

  @Test
  @SuppressWarnings("java:S2699")
  void emptyTest() {}

  @Test
  void testMockMvcWorking() throws Exception {
    mockMvc
        .perform(get("/some/nonExistent/endpoint").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void testSuccessfulEmptyGetRequest() throws Exception {
    mockMvc
        .perform(get("/persons").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
  }
}
