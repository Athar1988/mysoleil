package photosoleil.mysoleil.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Table(name = "image_table")
public class ImageModel {
    public ImageModel() {
        super();
    }
    public ImageModel(String name, String type, byte[] picByte, projet p) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
        this.projet=p;
    }
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Column(name = "picByte", length = 1000)
    private byte[] picByte;
    @OneToOne
    private projet projet;

}