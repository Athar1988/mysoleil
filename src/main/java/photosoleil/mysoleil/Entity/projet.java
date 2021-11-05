package photosoleil.mysoleil.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "reddit_projets")
public class projet {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String titre;
    private String description;
    @OneToOne(mappedBy = "projet")
    private ImageModel image;
}