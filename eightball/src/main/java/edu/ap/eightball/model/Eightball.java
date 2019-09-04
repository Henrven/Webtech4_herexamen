package edu.ap.eightball.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;

/**
 * Eightball
 */
@Entity
public class Eightball {
    
    @Id
    @GeneratedValue
    private Long id;
    
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