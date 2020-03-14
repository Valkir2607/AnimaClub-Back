package com.example.AnimaClub.dto;


public class CompteDTO {

    private int id;
    private String pseudo;
    private String mail;
    private String password;
    private byte[] profilPicture;
    private byte[] background;

    public CompteDTO() {
    }

    public CompteDTO(int id, String pseudo, String mail, String password) {
        this.id = id;
        this.pseudo = pseudo;
        this.mail = mail;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setProfilPicture(byte[] profilPicture) {
        this.profilPicture = profilPicture;
    }

    public void setBackground(byte[] background) {
        this.background = background;
    }

    public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getProfilPicture() {
        return profilPicture;
    }

    public byte[] getBackground() {
        return background;
    }
}
