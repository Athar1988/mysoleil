package photosoleil.mysoleil.DAO;




import photosoleil.mysoleil.Entity.*;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
}