package com.example.demo.controller;

import com.example.demo.model.Contact;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by jjmendoza on 31/8/2018.
 */
@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("person", new Person());
        return "index";
    }

    @PostMapping("/addContact")
    public String addContact(Person person){
        person.getContactList().add(new Contact());
        return "index :: contacts"; // returning the updated section
    }

    @PostMapping("/removeContact")
    public String removeContact(Person person, @RequestParam("removeContact") Integer contactIndex){
        person.getContactList().remove(contactIndex);
        return "index :: contacts"; // returning the updated section
    }

    @PostMapping("/")
    public String save(@Valid Person person, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("errorMessage", "The submitted data has errors.");
        }else {
            model.addAttribute("person", personRepository.save(person));
            model.addAttribute("successMessage", "Person saved successfully!");
        }

        return "index";
    }
}
