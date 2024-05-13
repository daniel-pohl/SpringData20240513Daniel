package org.example.springdata20240513;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CharacterRepo extends MongoRepository<Character, String> {



}
