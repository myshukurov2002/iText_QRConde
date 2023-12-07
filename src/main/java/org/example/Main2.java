package org.example;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {
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
                        .page {
                            font-size: 20px;
                        }
                    </style>
                </head>
                <body>
                <div class="page" style="width: 100%; text-align: center">
                    <b>OMMAVIY OFERTA</b>
                    <br>
                    <b>(O’zbekiston Respublikasi Fuqorolik to’g’risidagi Kodeksning 369-moddasiga ko’ra ushbu ommaviy oferta yuridik
                        shartnoma bilan tenghuquqqa ega bo’lib, “IT-MAKER” MCHJ “100k.uz” Saytining huquqiyjihatlarini o’z ichiga
                        oladi)</b>
                    <br>
                    <br>
                    <br>
                    <b>Atama va tavsiflar</b>

                        oferta yuridik shartnoma bilan tenghuquqqa ega bo’lib, “IT-MAKER” MCHJ “100k.uz” Saytining huquqiyjihatlarini
                        o’z ichiga oladi)Atama va tavsiflarAxborot vositasi: (Sayt) Faqat internet tizimi orqali savdo-hizmat
                        ko’rsatishfaoliyati bilan shug’ullanuvchi“www.100k.uz” sayti;Axborot vositachisi: (Admin) Ijtimoiy tarmoqlar
                        orqali o’ziga tegishli gruppa vayoki kanallarda e’lon berish huqiqiga ega bo’lgan jismoniy yoki yuridik
                        shaxs;Axborot vositachisi sanalgan, hamda Saytning vakili vazifasini bajarib,Sotuvchi va Xaridor o’rtasida
                        elektron reklamaaylanmasini amalgaoshiruvchi O’zbekiston Respublikasida davlat ro’yhatidan o’tgan yuridik
                        shaxsyoki O’zbekiston Respublikasida doimiy yashovchi va daromadidan soliqto’lanishi ismi-sharifi yoki nomi,
                        uning kontakt aloqa raqamlari vamazkur hujjat bilan belgilangan shakldagi boshqa ma’lumotlarni
                        o’zidamujassamlantirgan elektron hujjat.Tovar(tovarlar) Internet do’konlar tomonidan sotuvga qo’yiladigan
                        vaXaridorning buyurtmasiga binoan Sotuvchi tomonidan masofadan turib(distantsion) sotib olinadigan va Xaridorga
                        jo’natiladigan tovarlar</p>
                    <br>
                    <p><strong></strong></p>
                    <br>
                    
                    <!-- Placeholder for the QR code -->
                    <div id="qrcode"></div>
                </div>
                </body>
                </html>""";
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
