/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package harakka.service;

import harakka.domain.Viite;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import java.io.File;
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
}
