package com.mmtr.dictionariesspringboot.service;

import com.mmtr.dictionariesspringboot.entity.Dictionary;

import java.util.List;

public interface DictionaryService {
    public List<Dictionary> getAllDictionaries();

    public void saveDictionary(Dictionary dictionary);

    public Dictionary getDictionary(int id);

    public void deleteDictionary(int id);

    /*public List<Dictionary> findMovieByTitle(String title);

    public List<Dictionary> findMoviesByGenre(String genre);

    public List<Dictionary> findMoviesByRating(int rating);*/
}
