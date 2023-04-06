package com.mmtr.dictionariesspringboot.dao;

import com.mmtr.dictionariesspringboot.models.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DictionaryDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DictionaryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Dictionary> index() {
        return jdbcTemplate.query("SELECT * FROM Dictionary", new BeanPropertyRowMapper<>(Dictionary.class));
    }

    public Dictionary show(int id) {
        return jdbcTemplate.query("SELECT * FROM Dictionary WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Dictionary.class))
                .stream().findAny().orElse(null);
    }

    public void save(Dictionary dictionary) {
        jdbcTemplate.update("INSERT INTO Dictionary VALUES (1, ?, ?)",
                dictionary.getWord(), dictionary.getTranslatedWord());
    }

    public void update(int id, Dictionary updatedDictionary) {
        jdbcTemplate.update("UPDATE Dictionary SET word=?, translatedWord=? WHERE id=?",
                updatedDictionary.getWord(), updatedDictionary.getTranslatedWord(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Dictionary WHERE id=?", id);
    }
}
