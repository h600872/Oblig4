package no.hvl.dat108.oblig4.model;


import no.hvl.dat108.oblig4.Util.PassordUtil;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "oblig4")

public class Deltaker {

    @Pattern(regexp = "^[A-ZÆØÅ][a-zæøå\\s\\-]+$", message = "Passord må starte med stor forbokstav etterfulgt av små bokstaver")
    @Size(min = 2, max = 20)
    private String fornavn;

    @Pattern(regexp = "^[A-ZÆØÅ][a-zæøå\\-]+$", message = "Passord må starte med stor forbokstav etterfulgt av små bokstaver")
    @Size(min = 2, max = 20)
    private String etternavn;

    @Id
    @Pattern(regexp = "^\\d{8}$", message = "Mobilnummer må være 8 sifre langt")
    private String mobilnummer;

    private String passord;

    @Pattern(regexp = "^mann|kvinne$")
    private String kjonn;

    private String salt;

    public Deltaker() {

    }

    public Deltaker(String fornavn, String etternavn, String mobilnummer, String passord, String kjonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.mobilnummer = mobilnummer;
        this.salt = PassordUtil.genererSalt();
        this.passord = PassordUtil.hashMedSalt(passord, salt);
        this.kjonn = kjonn;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getMobilnummer() {
        return mobilnummer;
    }

    public void setMobilnummer(String mobilnummer) {
        this.mobilnummer = mobilnummer;
    }

    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        salt = PassordUtil.genererSalt();
        this.passord = PassordUtil.hashMedSalt(passord, salt);
    }


    public String getKjonn() {
        return kjonn;
    }

    public void setKjonn(String kjonn) {
        this.kjonn = kjonn;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt() {
        salt = PassordUtil.genererSalt();
    }

    @Override
    public String toString() {
        return "Deltaker{" +
                "fornavn='" + fornavn + '\'' +
                ", etternavn='" + etternavn + '\'' +
                ", mobilnummer='" + mobilnummer + '\'' +
                ", passord='" + passord + '\'' +
                ", kjonn='" + kjonn + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}