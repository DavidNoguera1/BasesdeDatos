
package servlets;

import com.umariana.mundo.Video;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {

    
    ArrayList <Video> misVideos = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Aqui vienen los datos por GET
        // Hace visibles las variables   
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Aqui vienen los datos por doPost
        // Manda las variables por debajo del bus
        String idVideo = request.getParameter("idVideo");
        //System.out.println("idVideo:"+idVideo);
        
        String titulo = request.getParameter("titulo");
        //System.out.println("Titulo: " + titulo);

        String autor = request.getParameter("autor");
        //System.out.println("Autor: " + autor);
        
        String anio = request.getParameter("anio");
        //System.out.println("Año: " + anio);
        
        String url = request.getParameter("url");
        //System.out.println("URL: " + url);
        
        String categoria = request.getParameter("categoria");
        //System.out.println("Categoria: " + categoria);
        
        String letra = request.getParameter("letra");
        //System.out.println("Letra: " + letra);   
        
        //Ingresar datos al objeto
        Video miVideo = new Video(Integer.parseInt(idVideo), titulo, autor, anio, categoria, url, letra);
        misVideos.add(miVideo);
        
        //agregar el arraylist al objeto de solicitud
        request.setAttribute("misVideos", misVideos);
        
        //redireccionar a la pagina web destino
        request.getRequestDispatcher("listarVideos.jsp").forward(request, response);
        
        /*for (Video v:misVideos)
        {
            
        System.out.println("idVideo: "+v.getIdVideo());
        System.out.println("Titulo: "+v.getTitulo());
        System.out.println("Autor: "+v.getAutor());
        System.out.println("Año: "+v.getAnio());
        System.out.println("Categoria: "+v.getCategoria());
        System.out.println("Url: "+v.getUrl());
        System.out.println("Letra: "+v.getLetra());
        System.out.println("----------------------");
        
        }*/
        
        
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
