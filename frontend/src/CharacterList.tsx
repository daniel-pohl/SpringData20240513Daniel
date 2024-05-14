// src/CharacterList.tsx
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

interface Character {
    id: string;
    name: string;
    age: number;
    occupation: string;
}

const CharacterList: React.FC = () => {
    const [characters, setCharacters] = useState<Character[]>([]);

    const fetchCharacters = async () => {
        try {
            const response = await axios.get('/api/asterix/characters');
            setCharacters(response.data);
        } catch (error) {
            console.error('There was an error fetching the characters!', error);
        }
    };

    useEffect(() => {
        fetchCharacters();
    }, []);

    useEffect(() => {
        fetchCharacters(); // Aktualisieren der Liste nach dem Formularabsenden
    }, [characters]); // Diese Funktion wird immer dann aufgerufen, wenn sich die "characters" State-Variable ändert


    return (
        <div>
            <h2 className="mt-5">Character List</h2>
            <div className="d-flex flex-row flex-wrap justify-content-start">
                {characters.map(character => (
                    <div key={character.id} className="card m-2">
                        <div className="card-body">
                            <h5 className="card-title">{character.name}</h5>
                            <p className="card-text">Age: {character.age}</p>
                            <p className="card-text">{character.occupation}</p>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default CharacterList;
