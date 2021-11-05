package photosoleil.mysoleil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import photosoleil.mysoleil.DAO.*;
import photosoleil.mysoleil.Entity.ImageModel;
import photosoleil.mysoleil.Entity.admin;
import photosoleil.mysoleil.Entity.projet;

@SpringBootApplication
public class MysoleilApplication implements CommandLineRunner {
    @Autowired
    private repadmin adminRep;
    @Autowired
    private repprojet repprojet;
    @Autowired
    private ImageRepository repprimage;

    public static void main(String[] args) {
        SpringApplication.run(MysoleilApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        adminRep.save(new admin(null,"salah","12345"));
          }
}
