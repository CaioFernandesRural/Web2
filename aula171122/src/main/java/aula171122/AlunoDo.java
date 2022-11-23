package aula171122;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class alunoDo
 */
@WebServlet("/AlunoDo")
public class AlunoDo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlunoDo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		int cont = 0;
		
		if (request.getParameter("radio").equals("todos")) {
			out.println("<h1>Todos: </h1>");
			for (Aluno i : alunos ) {
				out.println("<p>Nome: "+i.getNome()+"</p>"+"<p>Matricula: "+i.getMatricula()+"</p><br>");
			}
		} else if (request.getParameter("radio").equals("nome")) {
			for (Aluno i : alunos ) {
				if(i.getNome().equals(request.getParameter("nomePesquisa"))) {
					cont++;
					out.println("<p>Nome: "+i.getNome()+"</p>"+"<p>Matricula: "+i.getMatricula()+"</p><br>");
				}
			}
			if(cont == 0) {
				out.println("<h1>Nome não encontrado.</h1>");
			}
		} else if (request.getParameter("radio").equals("matricula")) {
			for (Aluno i : alunos ) {
				if(i.getNome().equals(request.getParameter("nomePesquisa"))) {
					cont++;
					out.println("<p>Nome: "+i.getNome()+"</p>"+"<p>Matricula: "+i.getMatricula()+"</p><br>");
				}
			}
			if(cont == 0) {
				out.println("<h1>Matrícula não encontrada.</h1>");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Aluno Aluno = new Aluno();
		Aluno.setNome(request.getParameter("nome"));
		Aluno.setMatricula(request.getParameter("matricula"));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<p>Nome: "+Aluno.getNome()+"</p>" + "<p>Matricula: "+Aluno.getMatricula()+"</p>");
		
		alunos.add(Aluno);
	}

}
