package dnd.mlogger;

import com.mongodb.BasicDBObject;
import dnd.mlogger.domain.Location;
import dnd.mlogger.domain.Person;
import dnd.mlogger.domain.Quest;
import dnd.mlogger.repositories.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.FindPublisherPreparer;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;


@SpringBootApplication
@EnableMongoRepositories
public class MLoggerApplication  implements CommandLineRunner{



    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private QuestRepository questRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) throws Exception{
        SpringApplication.run(MLoggerApplication.class, args);

    }


    /*
    @Bean
    public CommandLineRunner dataLoader(PersonRepository repository){
        return args -> {
            Person augusto = new Person("augusto");
            repository.save(augusto);
            System.out.println("this runs");
        };
    }


     */

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application is running1");

       /// Person anotherPerson = new Person("Another person");
       /// personRepository.save(anotherPerson);
        List<Person> people = personRepository.findAll();
        people.forEach(person -> {
            System.out.println(person.getName());
        });
        /*
        User luiz = new User();
        luiz.setUsername("luizmiotto");
        luiz.setPassword("Iggy27");
        luiz.setFullName("Luiz Miotto");
        luiz.setEmailAddress("luiz.l.miotto94@gmail.com");
        userRepository.save(luiz);
        */


    }


}
