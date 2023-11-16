import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.peterczigany.person.PersonApplication;
import com.peterczigany.person.model.Person;
import com.peterczigany.person.repository.PersonRepository;
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

  @Autowired private PersonRepository repository;

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
        .andExpect(jsonPath("$._embedded.persons", hasSize(0)));
  }

  @Test
  void testSuccessfulNonEmptyGetRequest() throws Exception {
    Person person = new Person();
    person.setName("Holly Black");
    repository.save(person);

    mockMvc
        .perform(get("/persons").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$._embedded.persons", hasSize(1)))
        .andExpect(jsonPath("$._embedded.persons[0].name", is("Holly Black")));

    repository.deleteAll();
  }

  @Test
  void testSuccessfulGetById() throws Exception {
    Person person = new Person();
    person.setName("Holly Black");
    var personWithIdAssigned = repository.save(person);

    mockMvc
        .perform(
            get("/persons/{id}", personWithIdAssigned.getId())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is("Holly Black")));

    repository.deleteAll();
  }

  @Test
  void testUnsuccessfulGetById() throws Exception {
    mockMvc
        .perform(get("/persons/{id}", 1).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }
}
