package com.berkay.test.controllers;

import com.berkay.test.entities.Person;
import com.berkay.test.services.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {
    @Autowired
    private PersonServiceImpl personServiceImpl;

    @GetMapping("/")
    public String viewHomePage(){
    return "index";
}

    @GetMapping("/personList")
    public String viewHomePage(Model model) {
        model.addAttribute("allpersonlist",personServiceImpl.getAllPerson());
        return "personList";
    }

    @GetMapping("/addnew")
    public String addNewAccount(Model model) {
        Person account = new Person();
        model.addAttribute("person", account);
        return "newperson";
    }
    @PostMapping("/save")
    public String saveAccount(@ModelAttribute("person") Person person) {
        personServiceImpl.save(person);
        return "redirect:/personList";
    }
    @GetMapping("/updatePerson/{id}")
    public String editPerson(@PathVariable Long id, Model model) {
        Person person = personServiceImpl.getPersonById(id);
        model.addAttribute("person", person);
        return "updatePerson";
    }
    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable Long id) {
        personServiceImpl.deleteById(id);
        return "redirect:/personList";
    }


}
