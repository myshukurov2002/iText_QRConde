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

public class Main7 {
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
                       </head>
                       <body>
                       <div style="width: 100%; height: 100%; position: relative; background: white">
                           <div style="width: 140px; left: 407px; top: 140px; position: absolute"><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">yourmail@gmail.com<br/>+33 6 33 33 33 33<br/>Vernouillet<br/><br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">Industry Knowledge<br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Product Design<br/>User Interface<br/>User Experience<br/>Interaction Design<br/>Wireframing<br/>Rapid Prototyping<br/>Design Research<br/><br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">Tools & Technologies<br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Figma, Sketch, Protopie, Framer, Invision, Abstract, Zeplin, Google Analytics, Amplitude, Fullstory...<br/><br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">Other Skills<br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">HTML, CSS, jQuery<br/><br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">Languages<br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">French (native)<br/>English (professionnal)<br/><br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">Social<br/></span><span
                                   style="color: #73808D; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">yoursite.com<br/>linkedin.com/in/yourname<br/>dribbble.com/yourname<br/></span>
                           </div>
                           <div style="width: 335px; left: 48px; top: 140px; position: absolute"><span
                                   style="color: #73808D; font-size: 7px; font-family: Arial; font-weight: 400; text-transform: uppercase; line-height: 18px; letter-spacing: 2px; word-wrap: break-word">experience<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">Senior UI/UX Product Designer<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Enterprise name<br/></span><span
                                   style="color: #73808D; font-size: 9px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Aug 2018 - Present - 1 year, Paris<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Directly collaborated with CEO and Product team to prototype, design and deliver the UI and UX experience with a lean design process: research, design, test, and iterate.<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word"><br/>UI/UX Product Designer<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Enterprise name<br/></span><span
                                   style="color: #73808D; font-size: 9px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Aug 2013 - Aug 2018 - 5 years, Paris<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Lead the UI design with the accountability of the design system, collaborated with product and development teams on core projects to improve product interfaces and experiences.<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word"><br/>UI Designer<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Enterprise name<br/></span><span
                                   style="color: #73808D; font-size: 9px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Aug 2012 - jul 2013 - 1 year, Paris<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Designed mobile UI applications for Orange R&D departement, BNP Paribas, La Poste, Le Cned...<br/><br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">Graphic Designer<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Enterprise name<br/></span><span
                                   style="color: #73808D; font-size: 9px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Sept 2010 - jul 2012 - 2 years, Paris<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">Designed print and web applications for Pau Brasil, Renault,<br/>Le théatre du Mantois, La mairie de Mantes la Ville...<br/><br/></span><span
                                   style="color: #73808D; font-size: 7px; font-family: Arial; font-weight: 400; text-transform: uppercase; line-height: 18px; letter-spacing: 2px; word-wrap: break-word">education<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">Bachelor European in Graphic Design<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">School name<br/></span><span
                                   style="color: #73808D; font-size: 9px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">2009 - 2010, Bagnolet<br/><br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 700; line-height: 18px; word-wrap: break-word">BTS Communication Visuelle option Multimédia<br/></span><span
                                   style="color: #101214; font-size: 11px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">School name<br/></span><span
                                   style="color: #73808D; font-size: 9px; font-family: Arial; font-weight: 400; line-height: 18px; word-wrap: break-word">2007 - 2009, Bagnolet</span>
                           </div>
                           <div style="width: 197px; height: 60px; left: 48px; top: 48px; position: absolute"><span
                                   style="color: #101214; font-size: 24px; font-family: Arial; font-weight: 700; line-height: 28px; word-wrap: break-word">Your Name<br/></span><span
                                   style="color: #101214; font-size: 18px; font-family: Arial; font-weight: 400; line-height: 28px; word-wrap: break-word">Senior Product Designer</span>
                           </div>
                           <img style="width: 72px; height: 72px; left: 407px; top: 36px; position: absolute; box-shadow: 0px 2px 4px rgba(16, 18, 20, 0.08); border-radius: 9999px"
                                src="srsdac/main/resources/gerb/gerb_bayroq.png"/>
                           <div style="width: 595px; height: 4px; left: 0px; top: 0px; position: absolute; background: #101214"></div>
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
