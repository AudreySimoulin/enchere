/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.service.ArticleService;
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
@WebServlet(name = "DetailsArticleServlet", urlPatterns = {"/details_article_servlet"})
public class DetailsArticleServlet extends AutowireServlet {
    
    @Autowired
    private ArticleService articleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Article a = articleService.findOne(Long.parseLong(req.getParameter("idArticle")));
        
        req.setAttribute("monArticle", a);
        req.getRequestDispatcher("details_article.jsp").forward(req, resp);
    }
    
    

}
