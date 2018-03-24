package project.model;

import javax.persistence.*;

@Entity
@Table(name = "flower")
public class Flower{
    @Id
    @Column(name = "id_fl", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFl;

    @Basic
    @Column(name = "view_fl", nullable = false, length = 256)
    private String viewFl;

    @Basic
    @Column(name = "sort_fl", nullable = false, length = 256)
    private String sortFl;

    @Basic
    @Column(name = "color_fl", nullable = false, length = 256)
    private String colorFl;

    @Basic
    @Column(name = "height", nullable = false)
    private int height;

    @Basic
    @Column(name = "count_fl", nullable = false)
    private int countFl;

    @Basic
    @Column(name = "price_fl", nullable = false)
    private int priceFl;


    @Basic
    @Column(name = "picture_fl", nullable = true, length = 256)
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


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    public int getCountFl() {
        return countFl;
    }

    public void setCountFl(int countFl) {
        this.countFl = countFl;
    }


    public int getPriceFl() {
        return priceFl;
    }

    public void setPriceFl(int priceFl) {
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

