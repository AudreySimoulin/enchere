/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "MesEncheresServlet", urlPatterns = {"/mes_encheres_servlet"})
public class MesEncheresServlet extends AutowireServlet {

    @Autowired
    private UtilisateurService utilisateurService;

    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateur u = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        Iterable<Article> articles = articleService.findDistinctArticleByEncheresUtilisateurOrderByDateVente(u);
        
        req.setAttribute("mesArticles", articles);
        req.getRequestDispatcher("mes_encheres.jsp").forward(req, resp); 
    }

}
