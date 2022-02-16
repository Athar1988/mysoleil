package photosoleil.mysoleil.Entity;

import lombok.*;

import javax.persistence.*;

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
    @Column(length=10485760)
    private String description;
    private String nameImage;
    private String typeImage;
    private byte[] picByte;

}