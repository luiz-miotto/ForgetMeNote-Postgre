package dnd.mlogger.web;

import dnd.mlogger.domain.Person;
import dnd.mlogger.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addperson")
public class PersonAdderController {

    public PersonAdderDto personAdderDto;
    @Autowired
    PersonRepository personRepository;

    @PostMapping
    public String processPerson(PersonAdderDto personAdderDto){
        Person person = new Person(personAdderDto.getName());
        person.setMotivations(personAdderDto.getMotivation());
        person.setSuspectedSecrets(personAdderDto.getSuspectedSecret());
        person.setDescription(personAdderDto.getDescription());
        person.setDispositions(personAdderDto.getDisposition());
        personRepository.save(person);
        return "redirect:/personlist";
    }

    @GetMapping
    public String personAdder(){
        return "addperson";
    }

    @ModelAttribute("personAdderDto")
    public PersonAdderDto person(){
        return new PersonAdderDto();
    }
}
