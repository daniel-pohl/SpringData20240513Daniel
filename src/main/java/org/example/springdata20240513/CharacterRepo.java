package org.example.springdata20240513;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepo extends MongoRepository<Character, String> {

    //List<Character> findCharacterByAgeBetween(int minAge, int maxAge);
    //siehe in Charecterservice die getCharacters methode
}
