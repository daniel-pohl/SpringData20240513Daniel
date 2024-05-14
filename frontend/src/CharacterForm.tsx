// src/CharacterForm.tsx
import React, { useState } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

interface CharacterFormProps {
    fetchCharacters: () => void;
}

const CharacterForm: React.FC<CharacterFormProps> = ({ fetchCharacters }) => {
    const [name, setName] = useState<string>('');
    const [age, setAge] = useState<string>('');
    const [occupation, setOccupation] = useState<string>('');

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const newCharacter = { name, age: parseInt(age), occupation };

        try {
            await axios.post('/api/asterix/characters', newCharacter);
            fetchCharacters(); // Refresh the character list after adding a new character
            setName('');
            setAge('');
            setOccupation('');
        } catch (error) {
            console.error('There was an error creating the character!', error);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="mt-4">
            <div className="form-group">
                <label htmlFor="name">Name: </label>
                <input className="form-control" type="text" value={name} onChange={(e) => setName(e.target.value)} required />
            </div>
            <div className="form-group">
                <label htmlFor="name">Age: </label>
                <input className="form-control" type="number" value={age} onChange={(e) => setAge(e.target.value)} required />
            </div>
            <div className="form-group">
                <label htmlFor="name">Occupation: </label>
                <input className="form-control" type="text" value={occupation} onChange={(e) => setOccupation(e.target.value)} required />
            </div>
            <button className="btn btn-primary" type="submit">Create Character</button>
        </form>
    );
};

export default CharacterForm;
