/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harakka.data_access;

import harakka.domain.Viite;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author heikki
 */
public class FileViiteDAO implements ViiteDao {

    private File tiedosto;
    private ArrayList<Viite> viitteet;

    public FileViiteDAO(File tiedosto) {
        this.tiedosto = tiedosto;

    }

    public void ReadFile() {

    }

    public void WriteFile() {
  
    }


    public ArrayList<Viite> palautaViitteet() {
        return viitteet;
    }


}
