package com.mmtr.dictionariesspringboot.service;

import com.mmtr.dictionariesspringboot.dao.DictionaryRepository;
import com.mmtr.dictionariesspringboot.entity.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryRepository dictionaryRepository;

    @Override
    public List<Dictionary> getAllDictionaries() {
        return dictionaryRepository.findAll();
    }

    @Override
    public void saveDictionary(Dictionary dictionary) {
        dictionaryRepository.save(dictionary);
    }

    @Override
    public Dictionary getDictionary(int id) {
        Dictionary dictionary = null;

        // Optional нужен, т.к. return type - Employee
        Optional<Dictionary> optional = dictionaryRepository.findById(id);
        // Если в Optional есть работник
        if (optional.isPresent()) {
            dictionary = optional.get();
        }
        return dictionary;
    }

    @Override
    public void deleteDictionary(int id) {
        dictionaryRepository.deleteById(id);
    }
}
