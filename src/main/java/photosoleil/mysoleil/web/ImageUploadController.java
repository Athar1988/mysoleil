package photosoleil.mysoleil.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import photosoleil.mysoleil.DAO.*;
import photosoleil.mysoleil.Entity.*;
import java.io.IOException;

@RestController
@CrossOrigin("*")
public class ImageUploadController {

    @Autowired
    private repprojet projetrep ;


    @PostMapping("/upload/{id}")
    public BodyBuilder uplaodImage(@PathVariable("id") Long idProjet, @RequestParam("imageFile") MultipartFile file) throws IOException {
        projet P=projetrep.findById(idProjet).get();
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        P.setNameImage(file.getOriginalFilename());
        P.setTypeImage(file.getContentType());
        P.setPicByte(file.getBytes());
        projetrep.save(P);
        return ResponseEntity.status(HttpStatus.OK);
    }



    @PostMapping("/projets/misejour/{id}")
    public projet modifierProjet(@PathVariable("id") Long idProjet, @RequestBody projet p) throws IOException {
            p.setId(idProjet);
            return   projetrep.save(p);
    }
    /*
    @PostMapping("/imageModels/{id}")
    public BodyBuilder uplaodImage(@RequestParam("imageFile") MultipartFile file, @PathVariable Long id) throws IOException {
        projet p=projetrep.findById(id).get();
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        ImageModel img = new ImageModel(id+".jpg", file.getContentType(),
                compressBytes(file.getBytes()),p);
        System.out.println(img.getId()+"***"+img.getName()+"***"+img.getType()+"***"+img.getPicByte()+"**************** 2 " + p);
        imagerep.save(img);
        System.out.println(imagerep.findByName(id+".jpg")+"**************** 4 " );
        System.out.println("**************** 3 " + img.getProjet().getTitre());
        return ResponseEntity.status(HttpStatus.OK);
    }
*/

  /*  @GetMapping(path = { "/get/{imageName}" })
    public ImageModel getImage(@PathVariable("imageName") String imageName) throws IOException {
        final Optional<ImageModel> retrievedImage = imagerep.findByName(imageName);
        ImageModel img = new ImageModel(retrievedImage.get().getId(),retrievedImage.get().getName(), retrievedImage.get().getType(),
                decompressBytes(retrievedImage.get().getPicByte()),retrievedImage.get().getProjet());
        return img;
    }*/

    // compress the image bytes before storing it in the database
  /*  public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }*/
}