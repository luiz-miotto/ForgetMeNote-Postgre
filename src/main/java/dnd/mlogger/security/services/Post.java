package dnd.mlogger.security.services;

import dnd.mlogger.User;
import dnd.mlogger.security.RegistrationForm;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.*;

public class Post implements Serializable {

    private RestTemplate restTemplate;
    private User user;


    public Post(){
        this.restTemplate = new RestTemplate();
    }

    public Post createPost(RegistrationForm registrationForm){
        String url = "http://localhost:8080/api/auth/signup";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        //headers.set("x-request-source", "desktop");
        Map<String, Object> map = new HashMap<>();
        List<String> roles = new ArrayList<>();
        roles.add("user");
        roles.add("mod");
        map.put("fullName", registrationForm.getFullName());
        map.put("username", registrationForm.getUserName());
        map.put("email", registrationForm.getEmailAddress());
        map.put("password", registrationForm.getPassword());
        map.put("roles", roles);
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map,headers);
        ResponseEntity<Post> response = this.restTemplate.postForEntity(url, entity, Post.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody();
        } else {
            return null;
        }

    }
}
