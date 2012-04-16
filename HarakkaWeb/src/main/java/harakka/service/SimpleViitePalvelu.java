/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package harakka.service;

import harakka.domain.Viite;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

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
        //viitteet
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
}
