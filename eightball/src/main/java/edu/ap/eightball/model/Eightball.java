package edu.ap.eightball.model;

public class Eightball {
    
    
    public String vraag;
    public String Antwoord;

    public Eightball() {
    }

    public Eightball(String vraag, String Antwoord) {
        this.vraag = vraag;
        this.Antwoord = Antwoord;
    }

    public String getVraag() {
        return this.vraag;
    }

    public void setVraag(String vraag) {
        this.vraag = vraag;
    }

    public String getAntwoord() {
        return this.Antwoord;
    }

    public void setAntwoord(String Antwoord) {
        this.Antwoord = Antwoord;
    }

}