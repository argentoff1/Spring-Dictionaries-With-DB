package com.mmtr.dictionariesspringboot.dao;

import com.mmtr.dictionariesspringboot.entity.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DictionaryRepository extends JpaRepository<Dictionary, Integer> {
    /*public List<Dictionary> findMovieByTitle(String title);

    public List<Dictionary> findMoviesByGenre(String genre);

    public List<Dictionary> findMoviesByRating(int rating);*/
}
