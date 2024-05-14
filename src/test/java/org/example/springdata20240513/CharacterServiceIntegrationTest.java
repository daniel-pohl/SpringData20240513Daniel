package org.example.springdata20240513;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CharacterServiceIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private CharacterRepo characterRepo;

    @Test
    @DirtiesContext
    public void getCharacters() throws Exception {
        //Given
        Character c1 = new Character("7", "datding", 99, "tada");
        characterRepo.save(c1);
        //WHEN
        mockMvc.perform(get("/api/asterix/characters"))
                //THEN
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(
                        """
                                                    [
                                {"id": "7",
                                "name": "datding",
                                "age": 99,
                                "occupation": "tada"}
                                                    ]
                                """));

    }

}
