package backend.org;


import javax.imageio.ImageIO;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<Byte> image = new ArrayList<Byte>();
        try{

        DatagramSocket socket = new DatagramSocket(44);


        while(true) {
            byte[] data = new byte[1024];
            DatagramPacket paquete = new DatagramPacket(data, data.length);
            socket.receive(paquete);

            boolean vacio = true;
            for(byte b: data){
                System.out.println(b);
                if( b == 1){
                   vacio = false;
                }
            }

            if(vacio){
                break;
            }


            System.out.println(paquete.toString());
            for (byte b : data) {
                image.add(b);
            }


        }
        }catch (IOException ex){
            System.out.println(ex);
        }

        try{
            FileOutputStream fos = new FileOutputStream("imagen.png");

            byte[] imageInBytes = new byte[image.size()];
            for (int i = 0; i < image.size(); i++) {
                imageInBytes[i] = image.get(i);
            }

            fos.write(imageInBytes);
            ByteArrayInputStream bais = new ByteArrayInputStream(imageInBytes);
            BufferedImage bufferedImage = ImageIO.read(bais);
            ImageDisplayer id = new ImageDisplayer(bufferedImage);
        }catch(IOException ex){
            System.out.println(ex);
        }




    }
}