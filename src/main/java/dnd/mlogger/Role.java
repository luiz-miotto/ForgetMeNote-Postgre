package dnd.mlogger;


import dnd.mlogger.security.ERole;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection= "roles")
public class Role {
    @Id
    private String id;
    private ERole name;

    public Role(){

    }



    public Role(ERole name){
        this.name = name;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setName(ERole name){
        this.name = name;
    }

    public ERole getName(){
        return name;
    }

    public ERole getRole(){
        return name;
    }
}
