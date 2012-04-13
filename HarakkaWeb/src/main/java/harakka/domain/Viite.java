/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harakka.domain;

/**
 *
 * @author Kari Korpinen
 */
public class Viite {
    private int id;
    private String viitenimi;//title
    private String author;
    private String booktitle;
    private int vuosi;

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
    
}
