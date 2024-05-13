package org.example.springdata20240513;

import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;
@Builder
@Document("characters")
public record Character(
        String id,
        String name,
        int age,
        String occupation
) {

}
