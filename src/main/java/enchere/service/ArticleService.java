/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import enchere.entity.Article;
import enchere.entity.Utilisateur;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ArticleService extends CrudRepository<Article, Long>{
    
    public Iterable<Article> findByCategorieId(long id);
    public Iterable<Article> findByUtilisateur(Utilisateur u);
    public Iterable<Article> findDistinctArticleByEncheresUtilisateurOrderByDateVente(Utilisateur u);
}
