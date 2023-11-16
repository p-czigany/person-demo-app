import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.peterczigany.person.PersonApplication;
import com.peterczigany.person.model.Person;
import com.peterczigany.person.repository.PersonRepository;
import org.junit.jupiter.api.AfterEach;
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

  @AfterEach
  public void tearDown() {
    repository.deleteAll();
  }

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
    persistPersonWithName("Holly Black");

    mockMvc
        .perform(get("/persons").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$._embedded.persons", hasSize(1)))
        .andExpect(jsonPath("$._embedded.persons[0].name", is("Holly Black")));
  }

  @Test
  void testSuccessfulGetById() throws Exception {
    var personWithIdAssigned = persistPersonWithName("Holly Black");

    mockMvc
        .perform(
            get("/persons/{id}", personWithIdAssigned.getId())
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is("Holly Black")));
  }

  @Test
  void testUnsuccessfulGetById() throws Exception {
    mockMvc
        .perform(get("/persons/{id}", 1).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }

  @Test
  void testSuccessfulCreation() throws Exception {
    mockMvc
        .perform(
            post("/persons")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Holly Black\"}"))
        .andExpect(status().isCreated());
  }

  @Test
  void testSuccessfulPatch() throws Exception {
    var persistedPerson = persistPersonWithName("Holly Black");

    mockMvc
        .perform(
            patch("/persons/{id}", persistedPerson.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\": \"Dolly White\"}"))
        .andExpect(status().isNoContent());

    assertThat(repository.findById(persistedPerson.getId()))
        .hasValueSatisfying(
            actualPerson -> assertThat(actualPerson.getName()).isEqualTo("Dolly White"));
  }

  private Person persistPersonWithName(String name) {
    Person person = new Person();
    person.setName(name);
    return repository.save(person);
  }
}
