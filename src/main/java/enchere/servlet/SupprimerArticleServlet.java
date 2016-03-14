/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
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
@WebServlet(name = "SupprimerArticleServlet", urlPatterns = {"/supprimer_article_servlet"})
public class SupprimerArticleServlet extends AutowireServlet {
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private EnchereService enchereService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enchere e = enchereService.findOne(Long.parseLong(req.getParameter("idArticle")));
        Article a = articleService.findOne(Long.parseLong(req.getParameter("idArticle")));
        enchereService.delete(e);
        articleService.delete(a);
        
        resp.sendRedirect("mes_articles_servlet");
        
    }
    
    

}
