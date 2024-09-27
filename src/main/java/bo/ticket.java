/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ma.fstm.ilisi.metier.bo;
/*
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.io.image.ImageDataFactory;
*/
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 *
 * @author khawl
 */
public class ticket {
    private static int id=0;
    private int  id_ticket ;
    private Reservation reservation;
    private static String qrCodeImagePath ;
    
//    public ticket(Reservation r) throws IOException, WriterException {
//        //chercher depart
//        reservation = r;
//	id_ticket=++id;
//       // generateQRCode();
//    }

    public static String getQrCodeImagePath() {
        return qrCodeImagePath;
    }
    
    public Reservation getRes() {
		return reservation;
	}

	public void setRes(Reservation res) {
		this.reservation = res;
	}

	public int getId_ticket() {
		return id_ticket;
	}

	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}

//     private void generateQRCode() throws IOException, WriterException {
//        String qrCodeText = toString(); // Contenu du QR code
//        int width = 300;
//        int height = 300;
//        
//        String filePath = "./QRCode_Ticket_" + id_ticket + ".png"; // Chemin de l'image QR code
//
////        // Créer les paramètres de configuration
////        Hashtable<EncodeHintType, Object> hints = new Hashtable<>();
////        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8"); 
////        try {
////            // Générer le QR code
////            BitMatrix bitMatrix = new MultiFormatWriter().encode(qrCodeText, BarcodeFormat.QR_CODE, width, height, hints);
////
////            // Enregistrer le QR code dans un fichier
////            //Path path = FileSystems.getDefault().getPath(filePath);
////            MatrixToImageWriter.writeToFile(bitMatrix,"PNG",new File(filePath));
////            System.out.println("QR code généré avec succès pour le ticket ID : " + id_ticket);
////            qrCodeImagePath = filePath; // Stocker le chemin de l'image QR code dans l'attribut correspondant
////        } catch (WriterException e) {
////        }
//    }
     
     
    @Override
    public String toString() {
        
        return "ticket{" + "id_ticket=" + id_ticket + ", reservation de \n" + reservation.getFrom() + "\na "+reservation.getTo() + '}';
    }

}
