/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harakka.service;

import harakka.domain.Viite;
import java.util.List;

/**
 *
 * @author Kari Korpinen
 */
public interface ViitePalvelu {
   public void lisaa(Viite viite);
   public List<Viite> listaa();
   public void poista(int viiteId);   
}
