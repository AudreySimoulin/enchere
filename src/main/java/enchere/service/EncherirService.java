/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class EncherirService {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private EnchereService enchereService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    public void encherir(Utilisateur u, Article a){
        Double enchere = 10.0;
        
        Enchere e = new Enchere(new Date(), a, u);
        
        a.setPrixActuel(a.getPrixActuel()+enchere);
        a.getEncheres().add(e);
        a.setDernierEncherisseur(u);
        u.getEncheres().add(e);
        u.getArticlesLastEncherisseur().add(a);
        
        enchereService.save(e);
        utilisateurService.save(u);
        articleService.save(a);
    }
    
}
