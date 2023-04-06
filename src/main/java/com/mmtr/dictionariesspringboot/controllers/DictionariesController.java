package com.mmtr.dictionariesspringboot.controllers;

import com.mmtr.dictionariesspringboot.dao.DictionaryDAO;
import com.mmtr.dictionariesspringboot.models.Dictionary;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dictionaries")
public class DictionariesController {
    private final DictionaryDAO dictionaryDAO;

    @Autowired
    public DictionariesController(DictionaryDAO dictionaryDAO) {
        this.dictionaryDAO = dictionaryDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("dictionaries", dictionaryDAO.index());

        return "dictionaries/index";
    }

    @GetMapping("/id")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("dictionary", dictionaryDAO.show(id));

        return "dictionaries/show";
    }

    @GetMapping("/new")
    public String newWord(@ModelAttribute("dictionary") Dictionary dictionary) {
        return "dictionaries/new";
    }

    @PostMapping
    public String create(@ModelAttribute("dictionary") @Valid Dictionary dictionary,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "dictionaries/new";
        }

        dictionaryDAO.save(dictionary);
        return "redirect:/dictionaries";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("dictionary", dictionaryDAO.show(id));

        return "dictionaries/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("dictionary") @Valid Dictionary dictionary,
                         BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "dictionaries/edit";
        }

        dictionaryDAO.update(id, dictionary);
        return "redirect:dictionaries";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        dictionaryDAO.delete(id);

        return "redirect:dictionaries";
    }
}
