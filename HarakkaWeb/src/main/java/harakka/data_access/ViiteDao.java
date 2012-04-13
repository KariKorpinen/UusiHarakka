/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harakka.data_access;

import java.util.ArrayList;
import harakka.domain.Viite;

/**
 *
 * @author heikki
 */
public interface ViiteDao {
    ArrayList<Viite> palautaViitteet();
}