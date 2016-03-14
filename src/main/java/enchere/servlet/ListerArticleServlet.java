/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import static enchere.entity.Utilisateur_.articles;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListerArticleServlet", urlPatterns = {"/lister_article_servlet"})
public class ListerArticleServlet extends AutowireServlet {
    
    @Autowired
    private CategorieService categorieService;
    
    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        long catId = Long.parseLong( req.getParameter("idCategorie") );
        Iterable<Article> articles = articleService.findByCategorieId(catId);
        
        req.setAttribute("mesArticles", articles);
        req.getRequestDispatcher("lister_article.jsp").forward(req, resp);
        
    }

    
}
