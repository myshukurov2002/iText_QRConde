package org.example;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main4 {
    public static void main(String[] args) {
        htmlToPdf();
    }

    private static void htmlToPdf() {

        String html = """
                <!DOCTYPE html>
                       <html lang="en">
                       <head>
                           <meta charset="UTF-8">
                           <title>Title</title>
                           <style>
                               .container {
                                   text-align: center;
                               }
                               .page {
                                   font-size: 20px;
                                   width: 100%;
                                   text-align: center;
                               }
                           </style>
                       </head>
                       <body>
                           <div class="container">
                               <div class="page">
                       
                                   <h3>Ariza turi: Darsdan Javob olish bo'yicha</h3>
                       
                                   <p>
                                       Ariza <b>Intellektual Axborot Tizimlari</b> Fakulteti <b>Dasturiy Injiniring</b> yo'nalishi
                                       <b><i>2-kurs</i></b> talabaasi <b><i>Aliyev Ali Alijonovich</i></b> tomonidan taqdim etildi.
                                   </p>
                                   <b>Batafsil sababi:</b>
                                   <p>Men sog'lig'im yomonligi tufayli do'xtir ko'rigidan o'tmoqchiman. Shu sababli 2023-yil 12-dekabrdan 2023-yil
                                   15-chi dekabrgacha meni darslardan ozod qilishingizni so'rayman</p>
                                   <h3>Ariza bo'yicha Mas'ul shaxslar:</h3>
                                   <p>Palonchayev Pismadoncha <b>Arizani Tasdiqladi</b>.</p>
                                   <p>Kalonchayev Kismadoncha <b>Arizani Tasdiqladi</b>.</p>
                                   <p>Salonchayev Sismadoncha <b>Arizani Tasdiqladi</b>.</p>
                                   <!-- Placeholder for the QR code -->
                                   <br>
                                   <br>
                                   <br>
                                   <br>
                                   <br>
                                   
                           </div>
                       </body>
                       </html>
                       """;
        String outputPath = "output1.pdf";

        try {
            convertHtmlToPdf(html, outputPath);
            System.out.println("SUCCESSFUL");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void convertHtmlToPdf(String html, String outputPath) {

        try (FileOutputStream pdfFile = new FileOutputStream(new File(outputPath));
             PdfWriter writer = new PdfWriter(pdfFile);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)) {

            String url = "https://localhost:8080/api/v1/qrcode/generate/aaa08a66-2514-4258-8f0e-f7c0a5b87eaf";
            Image qrCodeImage = addQrCodeToPdf(url);

            document.setTopMargin(650);
            document.setLeftMargin(220);

            document.add(qrCodeImage);


//            document.add();

            HtmlConverter.convertToPdf(html, pdf, new ConverterProperties().setBaseUri(""));
//            HtmlConverter.convertToPdf(new FileInputStream(pdf), );

            System.out.println("PDF created successfully at: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Image addQrCodeToPdf(String url) {
        try {
            byte[] qrCodeBytes = net.glxn.qrgen.javase.QRCode.from(url).stream().toByteArray();
            ImageData imageData = ImageDataFactory.create(qrCodeBytes);
            Image qrCodeImage = new Image(imageData);
            qrCodeImage.setAutoScale(true);
            qrCodeImage.setWidth(128);
            qrCodeImage.setHeight(128);

            return qrCodeImage;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
