/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "AjouterArticleServlet", urlPatterns = {"/ajouter_article_servlet"})
public class AjouterArticleServlet extends AutowireServlet {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Autowired
    private CategorieService categorieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("mesCategories", categorieService.findAll());
        req.getRequestDispatcher("ajouter_article.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_MONTH, 10);
        Date dateVente = c.getTime();
        
        Utilisateur u = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        Categorie categorie = categorieService.findOne(Long.parseLong(req.getParameter("categorie")));
        Double prixDep = Double.parseDouble(req.getParameter("prixDepart"));
        
        Article a = new Article(req.getParameter("nom"), req.getParameter("contenu"), prixDep, prixDep, dateVente, u, categorie);
        
        u.getArticles().add(a);
        categorie.getArticles().add(a);
        articleService.save(a);
        utilisateurService.save(u);
        categorieService.save(categorie);
        
        resp.sendRedirect("mes_articles_servlet");
    }
    
    
    
    
    
}
