package com.mmtr.dictionariesspringboot.controllers;

import com.mmtr.dictionariesspringboot.entity.Dictionary;
import com.mmtr.dictionariesspringboot.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DictionariesController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/dictionaries")
    public List<Dictionary> showAllDictionaries() {
        List<Dictionary> allDictionaries = dictionaryService.getAllDictionaries();

        return allDictionaries;
    }

    @GetMapping("/dictionaries/{id}")
    public Dictionary showDictionary(@PathVariable int id) {
        Dictionary dictionary = dictionaryService.getDictionary(id);

        return dictionary;
    }

    @PostMapping("/dictionaries")
    public Dictionary addNewDictionary(@RequestBody Dictionary dictionary) {
        dictionaryService.saveDictionary(dictionary);

        return dictionary;
    }

    @PutMapping("/dictionaries")
    public Dictionary updateDictionary(@RequestBody Dictionary dictionary) {
        dictionaryService.saveDictionary(dictionary);

        return dictionary;
    }

    @DeleteMapping("/dictionaries/{id}")
    public String deleteDictionary(@PathVariable int id) {
        Dictionary dictionary = dictionaryService.getDictionary(id);

        dictionaryService.deleteDictionary(id);

        return "Dictionary with ID = " + id + " was deleted";
    }
}
