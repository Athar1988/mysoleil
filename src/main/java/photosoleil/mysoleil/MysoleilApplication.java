package photosoleil.mysoleil;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import photosoleil.mysoleil.DAO.*;
import photosoleil.mysoleil.Entity.*;
import photosoleil.mysoleil.Entity.projet;

@SpringBootApplication
public class MysoleilApplication implements CommandLineRunner {
    @Autowired
    private repadmin adminRep;


    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(MysoleilApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(
                projet.class,
                contact.class,
                admin.class);

       // adminRep.save(new admin(null,"solar","solar"));
    }
}