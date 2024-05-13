package org.example.springdata20240513;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepo characterRepo;

    public CharacterService(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }
    public List<Character> getCharacters() {
        return characterRepo.findAll();
    }
    public Optional<Character> getCharacterById(String id) {
        return characterRepo.findById(id);
    }
    public Character addCharacter(Character character) {
        return characterRepo.save(character);
    }
    public String deleteCharacter(String id) {
        for (Character character : characterRepo.findAll()) {
            if (character.id().equals(id)) {
                characterRepo.delete(character);
                return "Character with ID " + id + " removed successfully.";
            }
        }
        return "Character with ID " + id + " not found.";
    }
    public String updateCharacter(String id, Character characterToUpdate) {
            //hier das
        // optional
        if (characterRepo.findById(characterToUpdate.id())) {
            Character existingCharacter = Character.builder()
                    .id(characterToUpdate.id())
                    .name(characterToUpdate.name()==null?character.name(): characterToUpdate.name())
                    .age(characterToUpdate.age())
                    .occupation(characterToUpdate.occupation())
                    .build();
            characterRepo.save(existingCharacter);
            return "Character with ID " + id + " updated successfully.";
        } else {
            return "Character with ID " + id + " not found.";
        }
    }
}
