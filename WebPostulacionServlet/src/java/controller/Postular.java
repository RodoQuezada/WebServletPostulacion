/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rodo
 */
@WebServlet(urlPatterns = {"/postular.do"})
public class Postular extends HttpServlet {

    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try {
            Integer.parseInt(s);
            isValidInteger = true;
        } catch (NumberFormatException ex) {

        }
        return isValidInteger;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String error = "";

        String nombre = request.getParameter("nombre");
        String edad = request.getParameter("edad");
        String clave = request.getParameter("clave");
        String clave2 = request.getParameter("clave2");
        String estado = request.getParameter("estado");
        String sexo = request.getParameter("sexo");
        String pais = request.getParameter("pais");

        if (nombre.isEmpty()) {
            error += "- Falta ingresaaaaaaar nombre. <br>";

        }

        if (edad.isEmpty()) {
            error += "- Falta ingresar edad. <br>";
        }

        if (clave.isEmpty()) {
            error += "- Falta ingresar clave. <br>";
        }

        if (clave2.isEmpty()) {
            error += "- Falta ingresar confirmacion de clave. <br>";
        }

        int auxEdad = Integer.parseInt(edad);
        if (auxEdad <= 18 || auxEdad >= 100) {
            error += "- Debe ser mayor de 18 y menor de 100. <br>";
        }
        
        boolean nombreSinNumero;
        if (isInteger(nombre)) {
             error += "- El nombre no debe llevar numeros. <br>";
        }
        
        if (clave.length() > 9) {
            error += "- Clave debe tener por lo menos 8 caracteres. <br>";
        }
        
        if (pais.equals("0")) {
            error +=" - Debe elegir un pais. <br>";
        }
        
        if (!clave.equals(clave2)) {
            error += "- Clave y confirmacion son distintas. <br>";
        }
        

        if (error.isEmpty()) {
            request.setAttribute("ok", "Postulacion Creada!");
        } else {
            request.setAttribute("error", error);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
