//package org.example.springdata20240513;
//
//import org.junit.jupiter.api.Test;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//class CharacterServiceTest {
//
//    CharacterRepo mockUserRepo = mock(CharacterRepo.class);
//    CharacterService characterService = new CharacterService(mockUserRepo);
//    @Test
//    void getCharacters() {
//        //GIVEN
//        Character c1 = new Character("1","name1", 3,"occupation1");
//        List<Character> characters = List.of(c1);
//        when(mockUserRepo.findAll()).thenReturn(characters);
//
//        //WHEN
//        List<Character> actual = characterService.getCharacters();
//
//        //THEN
//        verify(mockUserRepo).findAll();
//        assertEquals(characters, actual);
//    }
//    @Test
//    void getCharacterById() {
//        // GIVEN
//        Character c1 = new Character("1", "name1", 3, "occupation1");
//        when(mockUserRepo.findById("1")).thenReturn(Optional.of(c1));
//
//        // WHEN
//        Optional<Character> actual = characterService.getCharacterById("1");
//
//        // THEN
//        assertEquals(c1, actual.get());
//    }
//}