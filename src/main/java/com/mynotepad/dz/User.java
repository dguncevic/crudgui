package com.mynotepad.dz;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class User {   //TODO toString samo ime i prezime, ne zaboravi hashcode i equals

    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private String adresa;
    public static int counter = 0;

    private int uid;

    public User() {

        uid = ++counter;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User temp = (User) obj;

        return (this.ime.equals(temp.ime) && this.prezime.equals(temp.prezime) && this.adresa.equals(temp.adresa) && this.datumRodjenja == temp.datumRodjenja) ? true : false;
    }

    @Override
    public String toString() {
        return "UID: " + uid + "\t" + ime + " " + prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

}
