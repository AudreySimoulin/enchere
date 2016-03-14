/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import enchere.enumeration.StatutArticle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private String contenu;

    private Double prixDepart;

    private Double prixActuel;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVente;

    @Enumerated(EnumType.STRING)
    private StatutArticle statutArticle = StatutArticle.disponible;

    @OneToMany(mappedBy = "article")
    private List<Enchere> encheres = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "UTIL_ID")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "CATEGORIE_ID")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "DERNIERENCHERISSEUR_ID")
    private Utilisateur dernierEncherisseur;

    public Article() {
    }

    public Article(Long id, String nom, String contenu, Double prixDepart, Date dateVente) {
        this.id = id;
        this.nom = nom;
        this.contenu = contenu;
        this.prixDepart = prixDepart;
        this.dateVente = dateVente;
    }

    public Article(String nom, String contenu, Double prixDepart, Double prixActuel, Date dateVente, Utilisateur utilisateur, Categorie categorie) {
        this.nom = nom;
        this.contenu = contenu;
        this.prixDepart = prixDepart;
        this.prixActuel = prixActuel;
        this.dateVente = dateVente;
        this.utilisateur = utilisateur;
        this.categorie = categorie;
    }

    public Utilisateur getDernierEncherisseur() {
        return dernierEncherisseur;
    }

    public void setDernierEncherisseur(Utilisateur dernierEncherisseur) {
        this.dernierEncherisseur = dernierEncherisseur;
    }

    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Double getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Double prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Double getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(Double prixActuel) {
        this.prixActuel = prixActuel;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public StatutArticle getStatutArticle() {
        return statutArticle;
    }

    public void setStatutArticle(StatutArticle statutArticle) {
        this.statutArticle = statutArticle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enchere.entity.Article[ id=" + id + " ]";
    }

}
