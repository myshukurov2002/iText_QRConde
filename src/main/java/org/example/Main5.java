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

public class Main5 {
    public static void main(String[] args) {
        htmlToPdf();
    }

    private static void htmlToPdf() {
        String html = """
           
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Application</title>
                    <style>
                        /*.container {*/
                        /*    text-align: center;*/
                        /*}*/
                        body {
                            font-family: "Times New Roman";
                        }
                        .page {
                            font-size: 16px;
                            width: 100%;
                            /*text-align: center;*/
                        }
                        .top {
                            text-align: center;
                        }
                        .flag {
                            height: 100px;
                            width: auto;
                        }
                        .hr1 {
                            color: darkblue;
                            border: 4px solid darkblue;
                        }
                        .hr2 {
                            color: darkblue;
                            border: 1px solid darkblue;
                            position: relative;
                            width: 100%;
                            top: -4px;
                        }
                
                        .head {
                            /*margin-top: 10px;*/
                        }
                        .head_items {
                            display: flex;
                            justify-content: space-between;
                        }
                
                        .head_item {
                            display: flex;
                            flex-direction: column;
                        }
                
                        .box_text {
                            display: flex;
                            justify-content: center;
                        }
                
                        .p_text {
                            text-align:justify;
                            word-spacing:-2px;
                            width: 70%;
                        }
                
                        .head_item_element {
                            display: flex;
                            justify-content: right;
                        }
                
                        h4, h5 {
                            color: #006087;
                        }
                    </style>
                </head>
                <body>
                <div class="container">
                    <small>Ariza IDsi: yt43-hjh45-jkhffd0-3434234</small>
                    <div class="page">
                
                        <div class="top">
                            <img class="flag" src='gerb_bayroq.png' alt=gerb_bayroq'>
                            <h4>O‘ZBEKISTON RESPUBLIKASI OLIY VA O‘RTA МАХSUS <br>
                                ТА’LIM VAZIRLIGI</h4>
                            <h5>MINISTRY OF HIGHER AND SECONDARY SPECIALIZED EDUCATION <br>
                                OF THE REPUBLIC OF UZBEKISTAN</h5>
                            <small>100095, Тoshkent sh. 2-Chimboy ko‘chasi, 96-uy. Теl: (998) 71 246-01-95, e-mail: devonxona@edu.uz, edu@exat.uz, veb-sayt: www.edu.uz</small>
                        </div>
                
                
                        <hr class="hr1">
                        <hr class="hr2">
                
                
                        <div class="head">
                            <div class="head_items">
                               <div>
                                   <span>2021-yil 09-oktabr</span>
                               </div>
                
                                <div class="head_item">
                                    <div>
                                        <span>5/22-09/10-son</span>
                                    </div>
                                    <br>
                                    <div class="head_item_element">
                                        <div style="width: 70%"></div>
                                        <div style="width: 50%">
                                            <b style="width: 70%">Oliy ta’lim muassasalari
                                                rektorlari va filiallar
                                                direktorlariga</b>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                
                        <br>
                
                        <div class="box_text">
                            <p class="p_text">
                                 O‘zbekiston Respublikasi Vazirlar Mahkamasining 2021-yil 15-iyundagi
                                “Raqamli iqtisodiyot va elektron hukumatning rivojlanish holatini reyting baholash
                                tizimini yanada takomillashtirish chora-tadbirlari to‘g‘risida”gi 373-sonli qarori
                                3-ilovasida davlat organlari, xo‘jalik birlashmalari va mahalliy ijro etuvchi
                                hokimiyati organlarining rasmiy veb-sayti va axborot tizimlari xavfsizligiga
                                qo‘yiladigan asosiy talablar belgilangan.
                                Oliy va o‘rta maxsus ta’lim vazirligining 2021-yil 26-avgustdagi 372-sonli
                                buyrug‘i ilovasining 10-bandida oliy ta’lim muassasalarining Raqamli
                                texnologiyalar markazlariga “Oliy ta’lim jarayonlarini boshqarish - HEMIS”
                                axborot tizimining texnik qo’llab quvvatlash va uzluksiz ishlashini hamda axborot
                                xavfsizligini ta’minlash vazifasi yuklatilgan.
                                Yuqorida keltirib o‘tilgan topshiriqlar ijrosi yuzasidan 2021-yil 9-oktabr
                                holatiga o‘tkazilgan monitoring natijalariga ko‘ra bir nechta oliy ta’lim muassasalari
                                va filiallarning HEMIS axborot tizimida (ro‘yxat ilova qilinadi) axborotlarni
                                kriptografik himoyalash va xavfsiz uzatishni ko‘zda tutadigan protokol (SSL
                                sertifikati) bilan himoyalanmaganligi aniqlandi.
                                Yuqoridagilarni inobatga olib Sizdan, siz rahbarlik qilayotgan tashkilot va
                                muassasalarining serverlariga o‘rnatilgan HEMIS axborot tizimiga 3 kun muddatda
                                SSL sertifikati (https) o‘rnatilishini ta’minlashingiz so‘raladi. SSL sertifikatini
                                o‘rnatmagan oliy ta’lim muassasalarining HEMIS dasturidan foydalanishi to‘xtatib
                                qo‘yilishini ma’lum qilamiz.</p>
                        </div>
                        <i>Ilova 4 bet</i>
                        <br>
                        <b>Vazir o‘rinbosari Y.Absoatov</b>
                        <small>jrochi: A.Abdullayev <br>
                            Tel.: 71 246-10-71</small>
                
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
