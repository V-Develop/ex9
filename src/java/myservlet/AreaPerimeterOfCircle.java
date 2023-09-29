/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarun
 */
public class AreaPerimeterOfCircle extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void init()
            throws ServletException {
        System.out.println("Init"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        System.out.println("Destroy"); //To change body of generated methods, choose Tools | Templates.
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String radiusString = request.getParameter("radius");
        String sendType = request.getParameter("send");
        DecimalFormat twoDigits = new DecimalFormat("0.00");
        if (sendType.equals("Area")) {
            radiusString = twoDigits.format(Double.parseDouble(radiusString));
            Double area = calculateArea(Double.parseDouble(radiusString));
            try {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>AreaPerimeterOfCircle</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>For the circle with radius = " + radiusString + "</h1>");
                out.println("<h1>area is " + area + "</h1>");
                out.println("</body>");
                out.println("</html>");

            } finally {
                out.close();
            }
        } else if (sendType.equals("Perimeter")) {
            radiusString = twoDigits.format(Double.parseDouble(radiusString));
            Double perimeter = calculatePerimeter(Double.parseDouble(radiusString));
            try {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>AreaPerimeterOfCircle</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>For the circle with radius = " + radiusString + "</h1>");
                out.println("<h1>perimeter is " + perimeter + "</h1>");
                out.println("</body>");
                out.println("</html>");

            } finally {
                out.close();
            }
        }
    }

    public Double calculateArea(Double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public Double calculatePerimeter(Double radius) {
        return 2 * Math.PI * radius;
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
