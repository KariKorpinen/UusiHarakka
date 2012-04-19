/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harakka.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kari Korpinen
 */
public class Viite {
    private int id;
    private String tunnus;
    private String viitenimi;//title
    private String author;
    private String booktitle;
    private List<Viite> texMuodossa = new ArrayList();

    public List<Viite> getTexMuodossa() {
        return texMuodossa;
    }

    public void setTexMuodossa(List<Viite> texMuodossa) {
        this.texMuodossa = texMuodossa;
    }
    private int vuosi;

    public String getTunnus() {
        return tunnus;
    }
    
    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(int vuosi) {
        this.vuosi = vuosi;
    }
    //author, title, booktitle, year
    private static int LASKURI = 1;
    public Viite() {
        id = LASKURI++;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getViitenimi() {
        return viitenimi;
    }

    public void setViitenimi(String viitenimi) {
        this.viitenimi = viitenimi;
    }
    public static int getLASKURI() {
        return LASKURI;
    }

    public static void setLASKURI(int LASKURI) {
        Viite.LASKURI = LASKURI;
    }
    
    @Override
    public String toString () {
        return "@inproceedings{" + this.tunnus + ",\n"
                + "author = {"+ this.author +"},\n"
                + "title = {" + this.viitenimi + "},\n"
                + "booktitle = {" + this.booktitle + "},\n"
                + "year = {"+ this.vuosi +"},\n"
                + "}";
    }
    
}
