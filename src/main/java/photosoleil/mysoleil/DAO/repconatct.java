package photosoleil.mysoleil.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import photosoleil.mysoleil.Entity.*;

@CrossOrigin("*")
@RepositoryRestResource
public interface repconatct extends JpaRepository<contact,Long> {

}