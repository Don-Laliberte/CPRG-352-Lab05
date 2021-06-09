/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import domain.Note;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toesl
 */
public class NoteServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String edit = request.getParameter("edit");
        
        //gets real path of note.txt (Not hardcoded)
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        // to read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));

        
        //creates note parameter using file content
        Note note = new Note(br.readLine(), br.readLine());

        
        //Sets the attribute in the jsp to the Note Bean        
        request.setAttribute("note", note);
        //closes the buffered reader
        br.close();
        
        //Checks if you are on the edit page or the view page through string query in the viewnote jsp and sends you to correspsonding page
        if (edit != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
        else {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //gets real path of note.txt (Not hardcoded)
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");

        // to write to a file
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        //Check sequence for null entries to prevent errors
        if(request.getParameter("titleinput") != null || request.getParameter("contentsinput") != null) {      
            pw.println(request.getParameter("titleinput"));
            pw.println(request.getParameter("contentsinput")); 
        }
        
        //closes printwriter
        pw.close();
        //creates note JavaBean
        Note note = new Note((String)request.getParameter("titleinput"), (String)request.getParameter("contentsinput"));
        //Sets the attribute in the jsp to the Note Bean
        request.setAttribute("note", note);

        //reopens the viewnote page
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

}
