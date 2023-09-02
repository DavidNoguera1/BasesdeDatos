
package servlets;

import com.umariana.mundo.Video;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {
    ArrayList<Video> misVideos = new ArrayList<>();
    
    @Override
    public void init() throws ServletException {
        super.init();
        // Asegúrate de obtener el ServletContext correctamente
        ServletContext servletContext = getServletContext();
        
        // Cargar los videos serializados al iniciar la aplicación
        cargarVideosDesdeArchivo(servletContext);
    }
    


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Aquí vienen los datos por doPost
        // Manda las variables por debajo del bus
        String idVideo = request.getParameter("idVideo");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String anio = request.getParameter("anio");
        String url = request.getParameter("url");
        String categoria = request.getParameter("categoria");
        String letra = request.getParameter("letra");   

        try {
            int idVideoInt = Integer.parseInt(idVideo);
            // Ingresar datos al objeto
            Video miVideo = new Video(idVideoInt, titulo, autor, anio, categoria, url, letra);
            misVideos.add(miVideo);
        } catch (NumberFormatException e) {
            // Manejo de la excepción si idVideo no es un número válido
            e.printStackTrace();
            System.out.println("Error al convertir idVideo a entero: " + e.getMessage());
        }

        // Guardar la lista de videos en un archivo
        guardarVideosEnArchivo();

        // Agregar el ArrayList al objeto de solicitud
        request.setAttribute("misVideos", misVideos);

        // Redireccionar a la página web destino
        request.getRequestDispatcher("listarVideos.jsp").forward(request, response);
    }


    // Método para guardar la lista de videos en un archivo
    private void guardarVideosEnArchivo() {
        try {
            // Obtener la ruta real de la carpeta "data" en el proyecto web
            String dataPath = getServletContext().getRealPath("/data");

            // Verificar si la carpeta "data" existe, si no, crearla
            File dataFolder = new File(dataPath);
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }

            // Crear un archivo para guardar o reescribir la lista de videos serializada
            String filePath = dataPath + File.separator + "videos.ser";
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(misVideos);
            oos.close();
            System.out.println("Datos de videos guardados exitosamente en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos de videos: " + e.getMessage());
        }
    }
    
    // Método para cargar los videos desde el archivo
    private void cargarVideosDesdeArchivo(ServletContext servletContext) {
        try {
            // Obtener la ruta real del archivo de datos
            String dataPath = servletContext.getRealPath("/data/videos.ser");
            
            // Verificar si el archivo existe
            File archivo = new File(dataPath);
            if (archivo.exists()) {
                FileInputStream fis = new FileInputStream(dataPath);
                ObjectInputStream ois = new ObjectInputStream(fis);
                misVideos  = (ArrayList<Video>) ois.readObject();
                ois.close();
                System.out.println("Datos de videos cargados exitosamente desde: " + dataPath);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los datos de videos: " + e.getMessage());
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

