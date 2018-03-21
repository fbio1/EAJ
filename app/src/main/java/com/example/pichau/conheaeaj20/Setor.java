package com.example.pichau.conheaeaj20;


import java.io.Serializable;

public class Setor implements Serializable {

    private int id;
    private double latitude;
    private double longitude;
    private String nomeSetor;
    private int horarioFuncionamento;
    private String emailResponsavel;
    private String nomeResponsavel;
    private int image;
    private int descricao;
    private int imageFragment;
    private String telefone;

    public Setor() {

    }

//    public Setor(String nomeSetor, int horarioFuncionamento, String emailResponsavel, String nomeResponsavel, int image, int descricao, String telefone, double latitude, double longitude) {
//        this.id = id;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.nomeSetor = nomeSetor;
//        this.horarioFuncionamento = horarioFuncionamento;
//        this.emailResponsavel = emailResponsavel;
//        this.nomeResponsavel = nomeResponsavel;
//        this.image = image;
//        this.descricao = descricao;
//        this.telefone = telefone;
//    }


    public Setor(String nomeSetor, int horarioFuncionamento, String emailResponsavel, String nomeResponsavel, int image, int descricao, int imageFragment, String telefone, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nomeSetor = nomeSetor;
        this.horarioFuncionamento = horarioFuncionamento;
        this.emailResponsavel = emailResponsavel;
        this.nomeResponsavel = nomeResponsavel;
        this.image = image;
        this.descricao = descricao;
        this.imageFragment = imageFragment;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public int getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(int horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public String getEmailResponsavel() {
        return emailResponsavel;
    }

    public void setEmailResponsavel(String emailResponsavel) {
        this.emailResponsavel = emailResponsavel;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getDescricao() {
        return descricao;
    }

    public void setDescricao(int descricao) {
        this.descricao = descricao;
    }

    public int getImageFragment() {
        return imageFragment;
    }

    public void setImageFragment(int imageFragment) {
        this.imageFragment = imageFragment;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Setor setor = (Setor) o;

        if (id != setor.id) return false;
        if (Double.compare(setor.latitude, latitude) != 0) return false;
        if (Double.compare(setor.longitude, longitude) != 0) return false;
        if (horarioFuncionamento != setor.horarioFuncionamento) return false;
        if (image != setor.image) return false;
        if (descricao != setor.descricao) return false;
        if (imageFragment != setor.imageFragment) return false;
        if (!nomeSetor.equals(setor.nomeSetor)) return false;
        if (!emailResponsavel.equals(setor.emailResponsavel)) return false;
        if (!nomeResponsavel.equals(setor.nomeResponsavel)) return false;
        return telefone.equals(setor.telefone);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + nomeSetor.hashCode();
        result = 31 * result + horarioFuncionamento;
        result = 31 * result + emailResponsavel.hashCode();
        result = 31 * result + nomeResponsavel.hashCode();
        result = 31 * result + image;
        result = 31 * result + descricao;
        result = 31 * result + imageFragment;
        result = 31 * result + telefone.hashCode();
        return result;
    }
}
