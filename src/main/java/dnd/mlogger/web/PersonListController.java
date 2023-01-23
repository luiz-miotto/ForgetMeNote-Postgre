package dnd.mlogger.web;

import dnd.mlogger.domain.Person;
import dnd.mlogger.repositories.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/personlist")
public class PersonListController {

    private final PersonRepository personRepository;

    public PersonListController(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    @GetMapping
    public String personList(){
        return "personlist";
    }


    @ModelAttribute(name="people")
    public List<Person> addPeopleToModel(Model model){
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(i ->{
            people.add(i);
        });
        return people;

    }



}
