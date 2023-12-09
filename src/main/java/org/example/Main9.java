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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main9 {
    public static void main(String[] args) {
        htmlToPdf();
    }

    private static void htmlToPdf() {
        String html = """
                
                <!DOCTYPE html>
                <html>
                  <head>
                    <meta charset="utf-8" />
                <!--    <link rel="stylesheet" href="globals.css" />-->
                <!--    <link rel="stylesheet" href="style.css" />-->
                    <style>
                      @import url("https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css");
                      @import url("https://fonts.googleapis.com/css?family=Istok+Web:400|Inter:400");
                      * {
                        -webkit-font-smoothing: antialiased;
                        box-sizing: border-box;
                      }
                      html,
                      body {
                        margin: 0px;
                        height: 100%;
                      }
                      /* a blue color as a generic focus style */
                      button:focus-visible {
                        outline: 2px solid #4a90e2 !important;
                        outline: -webkit-focus-ring-color auto 5px !important;
                      }
                      a {
                        text-decoration: none;
                      }
                      .a {
                        background-color: transparent;
                        display: flex;
                        flex-direction: row;
                        justify-content: center;
                        width: 100%;
                      }
                
                      .a .div {
                        background-image: url(./img/a4-2.svg);
                        background-size: cover;
                        background-position: 50% 50%;
                        width: 592px;
                        height: 842px;
                        position: relative;
                      }
                
                      .a .TTPU-LOGO {
                        position: absolute;
                        width: 100px;
                        height: 100px;
                        top: 33px;
                        left: 43px;
                        object-fit: cover;
                      }
                
                      .a .element-toshkent-she {
                        position: absolute;
                        width: 267px;
                        height: 54px;
                        top: 66px;
                        left: 182px;
                      }
                
                      .a .frame {
                        position: absolute;
                        width: 8px;
                        height: 10px;
                        top: 159px;
                        left: 32px;
                      }
                
                      .a .TURIN-POLYTECHNIC {
                        position: absolute;
                        width: 334px;
                        height: 11px;
                        top: 42px;
                        left: 182px;
                      }
                
                      .a .rectangle {
                        position: absolute;
                        width: 16px;
                        height: 172px;
                        top: 0;
                        left: 576px;
                        background-color: #385e71;
                      }
                
                      .a .line {
                        position: absolute;
                        width: 77px;
                        height: 1px;
                        top: 170px;
                        left: 42px;
                        object-fit: cover;
                      }
                
                      .a .img {
                        position: absolute;
                        width: 46px;
                        height: 1px;
                        top: 170px;
                        left: 136px;
                        object-fit: cover;
                      }
                
                      .a .text-wrapper {
                        position: absolute;
                        width: 12px;
                        top: 158px;
                        left: 124px;
                        font-family: "Istok Web", Helvetica;
                        font-weight: 400;
                        color: #000000;
                        font-size: 10px;
                        letter-spacing: 0;
                        line-height: normal;
                      }
                
                      .a .text-wrapper-2 {
                        position: absolute;
                        top: 158px;
                        left: 43px;
                        font-family: "Inter", Helvetica;
                        font-weight: 400;
                        color: #000000;
                        font-size: 10px;
                        letter-spacing: 0;
                        line-height: normal;
                        white-space: nowrap;
                      }
                
                      .a .text-wrapper-3 {
                        position: absolute;
                        top: 158px;
                        left: 137px;
                        font-family: "Inter", Helvetica;
                        font-weight: 400;
                        color: #000000;
                        font-size: 10px;
                        letter-spacing: 0;
                        line-height: normal;
                        white-space: nowrap;
                      }
                
                      .a .line-2 {
                        position: absolute;
                        width: 494px;
                        height: 2px;
                        top: 754px;
                        left: 34px;
                      }
                
                      .a .rectangle-2 {
                        position: absolute;
                        width: 45px;
                        height: 45px;
                        top: 772px;
                        left: 514px;
                        background-color: #d9d9d9;
                        border: 1px solid;
                        border-color: #385e71;
                      }
                    </style>
                  </head>
                  <body>
                    <div class="a">
                      <div class="div">
                        <img class="TTPU-LOGO" src="img/ttpu-logo-2.png" />
                        <img class="element-toshkent-she" src="img/100095-toshkent-she-olmazor-tumani-kichik-xalqa-yoili-17-uy-t.svg" />
                        <img class="frame" src="img/frame.svg" />
                        <img class="TURIN-POLYTECHNIC" src="img/turin-polytechnic-university-in-tashkent.png" />
                        <div class="rectangle"></div>
                        <img class="line" src="img/line-4.svg" />
                        <img class="img" src="img/line-5.svg" />
                        <div class="text-wrapper">№</div>
                        <div class="text-wrapper-2">%date</div>
                        <div class="text-wrapper-3">%app_id</div>
                        <img class="line-2" src="img/line-3.svg" />
                        <div class="rectangle-2"></div>
                      </div>
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

            document.setMargins(0,0,0,0);
//            document.setTopMargin(650);
//            document.setLeftMargin(220);

            document.add(qrCodeImage);


//            document.add();

            HtmlConverter.convertToPdf(new FileInputStream("C:\\Users\\shuku\\IdeaProjects\\ITextPDF\\src\\main\\java\\org\\example\\AnimaPackage-Html-TgY9w\\index.html"), pdf, new ConverterProperties().setBaseUri(""));
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
                qrCodeImage.setWidth(48);
            qrCodeImage.setHeight(48);

            return qrCodeImage;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
