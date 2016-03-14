/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Categorie;
import enchere.service.CategorieService;
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
@WebServlet(name = "ListerCategorieServlet", urlPatterns = {"/lister_categorie_servlet"})
public class ListerCategorieServlet extends AutowireServlet{
    
    @Autowired
    private CategorieService categorieService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Iterable<Categorie> categories = categorieService.findAll();
        
        req.setAttribute("mesCategories", categories);
        req.getRequestDispatcher("lister_categorie.jsp").forward(req, resp);
    }
    
    

}
