package org.example;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

//        String html = HtmlUtil.getApplication();
        String html;
        html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
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
                    <p>OMMAVIY OFERTA(O’zbekiston Respublikasi Fuqorolik to’g’risidagi Kodeksning 369-moddasiga ko’ra ushbu ommaviy
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
                    <p>QR Code URL: <strong>https://localhost:8080/api/v1/qrcode/generate/aaa08a66-2514-4258-8f0e-f7c0a5b87eaf</strong></p>
                
                    <div id="qrcode"></div>
                
                    <button onclick="generatePDF()">Download PDF</button>
                
                    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
                    <script src="https://cdn.rawgit.com/eKoopmans/html2pdf/master/dist/html2pdf.bundle.js"></script>
                    <script src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
                
                    <script>
                        function generatePDF() {
                            var url = "https://localhost:8080/api/v1/qrcode/generate/aaa08a66-2514-4258-8f0e-f7c0a5b87eaf";
                
                            var qrcode = new QRCode(document.getElementById("qrcode"), {
                                text: url,
                                width: 128,
                                height: 128
                            });
                
                            html2pdf(document.body);
                        }
                    </script>
                </div>
                </body>
                </html>
                """;

        String outputPath = "output.pdf";

        try {
            convertHtmlToPdf2(html, outputPath);
            System.out.println("SUCCESSFULL");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private static void convertHtmlToPdf(String html, String outputPath) {
        try {
            FileOutputStream pdfFile = new FileOutputStream(new File(outputPath));
            HtmlConverter.convertToPdf(html, pdfFile);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void convertHtmlToPdf2(String html, String outputPath) {
        try (FileOutputStream pdfFile = new FileOutputStream(new File(outputPath));
             PdfWriter writer = new PdfWriter(pdfFile);
             PdfDocument pdf = new PdfDocument(writer);
             Document document = new Document(pdf)) {

            // Convert HTML to PDF and add it to the document
            HtmlConverter.convertToPdf(html, pdf, new ConverterProperties().setBaseUri("."));

            System.out.println("PDF created successfully at: " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}