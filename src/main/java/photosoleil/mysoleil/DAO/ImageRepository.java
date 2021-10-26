package photosoleil.mysoleil.DAO;




import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import photosoleil.mysoleil.Entity.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


@CrossOrigin("*")
@RepositoryRestResource
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
}