package org.example.springdata20240513;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/asterix")
public class AsterixController {

    private final CharacterService characterService;

    public AsterixController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    public List<Character> getCharacters() {
        return characterService.getCharacters();
    }
    @GetMapping("/characters/{id}")
    public Optional<Character> getCharacterById(@PathVariable String id) {
        return characterService.getCharacterById(id);
    }

    @PostMapping("/characters")
    public Character addCharacter(@RequestBody Character character) {
        return characterService.addCharacter(character);
    }
    @DeleteMapping("/characters/{id}")
    public String deleteCharacter(@PathVariable String id) {
        return characterService.deleteCharacter(id);
    }

    @PutMapping("/characters/{id}")
    public String updateCharacter(@PathVariable String id, @RequestBody Character updatedCharacter) {
        return characterService.updateCharacter(id, updatedCharacter);
    }


}

