package org.example.springdata20240513;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/asterix")
public class AsterixController {

    private final CharacterRepo characterRepo;

    @Autowired
    public AsterixController(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;

    }
    @GetMapping("/characters")
    public List<Character> getCharacters() {
        return characterRepo.findAll();
    }
    @GetMapping("/characters/{id}")
    public Optional<Character> getCharacterById(@PathVariable String id) {
        return characterRepo.findById(id);
    }

    @PostMapping("/characters")
    public Character addCharacter(@RequestBody Character character) {
        return characterRepo.save(character);
    }
    @DeleteMapping("/characters/{id}")
    public String deleteCharacter(@PathVariable String id) {
        for (Character character : characterRepo.findAll()) {
            if (character.id().equals(id)) {
                characterRepo.delete(character);
                return "Character with ID " + id + " removed successfully.";
            }
        }
        return "Character with ID " + id + " not found.";
    }
    @PutMapping("/characters/{id}")
    public String updateCharacter(@PathVariable String id, @RequestBody Character updatedCharacter) {
        Optional<Character> characterOptional = characterRepo.findById(id);
        if (characterOptional.isPresent()) {
            Character existingCharacter = characterOptional.get();

            existingCharacter.setName(updatedCharacter.getName());
            existingCharacter.setAge(updatedCharacter.getAge());
            existingCharacter.setOccupation(updatedCharacter.getOccupation());

            characterRepo.save(existingCharacter);
            return "Character with ID " + id + " updated successfully.";

        } else {
            return "Character with ID " + id + " not found.";
        }
    }


}

