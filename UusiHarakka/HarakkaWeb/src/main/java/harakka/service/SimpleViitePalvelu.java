/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package harakka.service;

import harakka.domain.Viite;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Chunk;
import com.lowagie.text.pdf.*;
import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 *
 * @author Kari Korpinen
 */
@Service
public class SimpleViitePalvelu implements ViitePalvelu {

    private List<Viite> viitteet = new ArrayList();

    @Override
    public void lisaa(Viite viite) {
        viitteet.add(viite);
        viite.setTexMuodossa(viitteet);
    }
    public void tallennaBibTex(String tiedostonimi)
    {
        String s = "";
        System.out.println("simple viitepalvelu tallennabibtex "+tiedostonimi);
        try {
            File tiedosto = new File(tiedostonimi);
            FileWriter kirjoittaja = new FileWriter(tiedostonimi);
            System.out.println("Suostuu kirjoittamaan tiedostoon");
            for (int i = 0; i < viitteet.size(); i++){
                // HUOM: viallinen aakkostarkistus
                s = aakkostarkistus(viitteet.get(i).toString());
                kirjoittaja.write(s + "\n\n");
            }
            kirjoittaja.close();
        }
            catch (Exception e){
                System.out.println(e.toString());
                System.out.println("Ei toimi kirjoitus");
            }
        System.out.println("Tallennus BibTexiin - yritetty");
    }
    @Override
    public List<Viite> listaa() {
        List<Viite> viite2 = new ArrayList();
        viite2 = viitteet;
        //System.out.println("listan koko listaa funktiossa "+esi.size());
        return viite2;
        //return viitteet;    
    }

    @Override
    public void poista(int viiteId) {
        System.out.println("override poista viiteid " + viiteId);
        Viite viite = null;
        for (Viite v : viitteet) {

            if (v.getId() == viiteId) {
                viite = v;
                break;
            }
        }

        if (viite != null) {
            System.out.println("override poista loopin jalkeenta viiteid " + viite.getId());
            viitteet.remove(viite);
        }
    }
    @Override
    public String aakkostarkistus(String tarkistaMerkkijono){
        
        String korvaaIsoA= "\\\\\"{A}";
        String korvaaPieniA= "\\\\\"{a}";
        String korvaaIsoO = "\\\\\"{O}";
        String korvaaPieniO = "\\\\\"{o}";
        
        String isoA = "Ä";
        String pieniA = "ä"; 
        String isoO = "Ö";
        String pieniO = "ö";
        
        String s = tarkistaMerkkijono;
        System.out.println(s);
        s = s.replaceAll(isoA, korvaaIsoA);
        s = s.replaceAll(pieniA, korvaaPieniA);
        System.out.println(s + " korvaa pieni aa");
        s = s.replaceAll(isoO, korvaaIsoO);
        System.out.println(s + " korvaa Iso oo");
        s = s.replaceAll(pieniO, korvaaPieniO);
        System.out.println(s);
        
        return s;
        
    }
    @Override
   public void luoPdf(String tiedostonimiPdf)
   {
        //ViitePalvelu viitepalvelu2;
        System.out.println("viitteet koko "+viitteet.size());
       	try {
                    List<Viite> viite3 = new ArrayList();
                    viite3=viitteet;
                    String tallenna=" ";
                    //viite3.
                   
                    //viite3.toArray()[4].toString();
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(tiedostonimiPdf));
                              //  + "//C:\\AbciTextTest.pdf"));
                        System.out.println(tiedostonimiPdf);
            document.open();

            // create a chunk object using chunk class of itext library.
			Chunk underlined = new Chunk("Tämä on testi pdf tiedosto tekijänä Harakka: ");

			// set the distance between text and line.
			underlined.setTextRise(8.0f);

			// set the width of the line, 'y' position, color and design of the line
			underlined.setUnderline(new Color(0x00, 0x00, 0xFF),0.0f, 0.2f, 3.0f, 0.0f,PdfContentByte.LINE_CAP_PROJECTING_SQUARE);

			// finally add object to the document.
			document.add(underlined);
                        for(int koko=0;koko<viitteet.size();koko++)
                        {
                            tallenna="";
                            
                           // tallenna=viitteet.toString();
            //document.add(new Paragraph(tallenna,FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new Color(255, 150, 200))));;
                           tallenna=viite3.get(koko).getTunnus()+" "+viite3.get(koko).getViitenimi()+" "+viite3.get(koko).getAuthor()+" "+viite3.get(koko).getBooktitle()+" "+Integer.toString(viite3.get(koko).getVuosi());
                          //  tallenna=viite3.get(koko).getTunnus()+viite3.get(koko).getViitenimi()+viite3.get(koko).getAuthor()+viite3.get(koko).getBooktitle()+Integer.toString(viite3.get(koko).getVuosi());
            document.add(new Paragraph(tallenna,FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new Color(255, 150, 200))));;
            // document.add(new Paragraph("Mahendra Singh",
            //FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new Color(255, 150, 200))));;
                        }		
            document.close();
                        System.out.println("dokumentti suljettu");
                        writer.close();
		} 
		catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
       
   }
}
