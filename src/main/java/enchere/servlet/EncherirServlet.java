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
import enchere.service.EncherirService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
@WebServlet(name = "EncherirServlet", urlPatterns = {"/encherir_servlet"})
public class EncherirServlet extends AutowireServlet {
    
    @Autowired
    private EncherirService encherirService;
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Utilisateur u = utilisateurService.findOneByLogin((String) req.getSession().getAttribute("login"));
        Article a = articleService.findOne(Long.parseLong(req.getParameter("idArticle")));
        Utilisateur dernierEncherisseur = a.getDernierEncherisseur();
        
        if(!a.getUtilisateur().getId().equals(u.getId()))
        if(dernierEncherisseur == null || !dernierEncherisseur.getId().equals(u.getId())){
            encherirService.encherir(u, a);
            resp.sendRedirect("mes_encheres_servlet");
            return;
        }
        
        req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
        
        
    }
    
    

}
