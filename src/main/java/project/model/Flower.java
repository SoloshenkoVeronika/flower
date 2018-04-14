package project.model;

import javax.persistence.*;

@Entity
@Table(name = "flower")
public class Flower{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFl;

    @Basic
    @Column(name = "species", nullable = false, length = 256)
    private String viewFl;

    @Basic
    @Column(name = "sort", nullable = false, length = 256)
    private String sortFl;

    @Basic
    @Column(name = "color", nullable = false, length = 256)
    private String colorFl;

    @Basic
    @Column(name = "length", nullable = false)
    private float height;

    @Basic
    @Column(name = "amount", nullable = false)
    private int countFl;

    @Basic
    @Column(name = "price", nullable = false)
    private float priceFl;


    @Basic
    @Column(name = "picture", nullable = true, length = 256)
    private String pictureFl;


    public int getIdFl() {
        return idFl;
    }
    public void setIdFl(int idFl) {
        this.idFl = idFl;
    }


    public String getViewFl() {
        return viewFl;
    }

    public void setViewFl(String viewFl) {
        this.viewFl = viewFl;
    }


    public String getSortFl() {
        return sortFl;
    }

    public void setSortFl(String sortFl) {
        this.sortFl = sortFl;
    }


    public String getColorFl() {
        return colorFl;
    }

    public void setColorFl(String colorFl) {
        this.colorFl = colorFl;
    }


    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


    public int getCountFl() {
        return countFl;
    }

    public void setCountFl(int countFl) {
        this.countFl = countFl;
    }


    public float getPriceFl() {
        return priceFl;
    }

    public void setPriceFl(float priceFl) {
        this.priceFl = priceFl;
    }

    public String getPictureFl() {
        return pictureFl;
    }

    public void setPictureFl(String pictureFl) {
        this.pictureFl = pictureFl;
    }

    @Override
    public String toString() {
        return "Flowers{" + "idFl=" + idFl + ", viewFl='" + viewFl + '\'' + ", sortFl='" + sortFl + '\'' + ", colorFl='" + colorFl + '\'' + ", height=" + height + ", countFl=" + countFl + ", priceFl=" + priceFl + ", pictureFl='" + pictureFl + '\'' + '}';
    }
}

