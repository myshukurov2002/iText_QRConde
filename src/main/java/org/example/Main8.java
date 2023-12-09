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

public class Main8 {
    public static void main(String[] args) {
        htmlToPdf();
    }

    private static void htmlToPdf() {
        String html = """
                           
                <!DOCTYPE html>
                <html>
                  <head>
                    <meta charset="utf-8" />
                  </head>
                  <body>
                    <div class="yourname-CV">
                      <div class="div">
                        <p class="infos">
                          <span class="text-wrapper">yourmail@gmail.com<br />+33 6 33 33 33 33<br />Vernouillet<br /><br /></span>
                          <span class="span">Industry Knowledge<br /></span>
                          <span class="text-wrapper"
                            >Product Design<br />User Interface<br />User Experience<br />Interaction Design<br />Wireframing<br />Rapid
                            Prototyping<br />Design Research<br /><br
                          /></span>
                          <span class="span">Tools &amp; Technologies<br /></span>
                          <span class="text-wrapper"
                            >Figma, Sketch, Protopie, Framer, Invision, Abstract, Zeplin, Google Analytics, Amplitude, Fullstory...<br /><br
                          /></span>
                          <span class="span">Other Skills<br /></span>
                          <span class="text-wrapper">HTML, CSS, jQuery<br /><br /></span>
                          <span class="span">Languages<br /></span>
                          <span class="text-wrapper">French (native)<br />English (professionnal)<br /><br /></span>
                          <span class="span">Social<br /></span>
                          <span class="text-wrapper">yoursite.com<br />linkedin.com/in/yourname<br />dribbble.com/yourname<br /></span>
                        </p>
                        <p class="xp">
                          <span class="text-wrapper-2">experience<br /></span>
                          <span class="text-wrapper-3">Senior UI/UX Product Designer<br /></span>
                          <span class="text-wrapper-4">Enterprise name<br /></span>
                          <span class="text-wrapper-5">Aug 2018 - Present - 1 year, Paris<br /></span>
                          <span class="text-wrapper-4"
                            >Directly collaborated with CEO and Product team to prototype, design and deliver the UI and UX experience
                            with a lean design process: research, design, test, and iterate.<br
                          /></span>
                          <span class="text-wrapper-3"><br />UI/UX Product Designer<br /></span>
                          <span class="text-wrapper-4">Enterprise name<br /></span>
                          <span class="text-wrapper-5">Aug 2013 - Aug 2018 - 5 years, Paris<br /></span>
                          <span class="text-wrapper-4"
                            >Lead the UI design with the accountability of the design system, collaborated with product and development
                            teams on core projects to improve product interfaces and experiences.<br
                          /></span>
                          <span class="text-wrapper-3"><br />UI Designer<br /></span>
                          <span class="text-wrapper-4">Enterprise name<br /></span>
                          <span class="text-wrapper-5">Aug 2012 - jul 2013 - 1 year, Paris<br /></span>
                          <span class="text-wrapper-4"
                            >Designed mobile UI applications for Orange R&amp;D departement, BNP Paribas, La Poste, Le Cned...<br /><br
                          /></span>
                          <span class="text-wrapper-3">Graphic Designer<br /></span>
                          <span class="text-wrapper-4">Enterprise name<br /></span>
                          <span class="text-wrapper-5">Sept 2010 - jul 2012 - 2 years, Paris<br /></span>
                          <span class="text-wrapper-4"
                            >Designed print and web applications for Pau Brasil, Renault,<br />Le théatre du Mantois, La mairie de
                            Mantes la Ville...<br /><br
                          /></span>
                          <span class="text-wrapper-2">education<br /></span>
                          <span class="text-wrapper-3">Bachelor European in Graphic Design<br /></span>
                          <span class="text-wrapper-4">School name<br /></span>
                          <span class="text-wrapper-5">2009 - 2010, Bagnolet<br /><br /></span>
                          <span class="text-wrapper-3">BTS Communication Visuelle option Multimédia<br /></span>
                          <span class="text-wrapper-4">School name<br /></span>
                          <span class="text-wrapper-5">2007 - 2009, Bagnolet</span>
                        </p>
                        <p class="title">
                          <span class="text-wrapper-6">Your Name<br /></span>
                          <span class="text-wrapper-7">Senior Product Designer</span>
                        </p>
                        <img class="avatar" src="src/main/resources/gerb_bayroq.png" />
                        <div class="top-line"></div>
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
