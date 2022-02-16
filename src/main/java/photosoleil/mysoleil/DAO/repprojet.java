package photosoleil.mysoleil.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import photosoleil.mysoleil.Entity.*;

import java.util.List;


@CrossOrigin("*")
@RepositoryRestResource
public interface repprojet extends JpaRepository<projet,Long> {


    @RestResource(path="/selectedProjetType")
    public List<projet> findByTypeContains(@Param("type") String type);

}