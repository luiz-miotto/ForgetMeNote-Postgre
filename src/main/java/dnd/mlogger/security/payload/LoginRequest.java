package dnd.mlogger.security.payload;

import dnd.mlogger.security.services.Post;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Data

public class LoginRequest {

        private Post post;

        @NotBlank
        private String username;

        @NotBlank
        private String password;

        public LoginRequest(){
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }


        public LoginRequest(String username, String password){
            this.username = username;
            this.password = password;


        }

        @ModelAttribute("newLogin")
        public LoginRequest toLogin(){
            return new LoginRequest();
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @PostMapping("/doLogin")
        public Post sendPost(){
          return   post.login(username,password);
        }
}
