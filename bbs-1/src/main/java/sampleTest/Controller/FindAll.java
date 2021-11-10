package sampleTest.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleTest.DAO.FindAllDAO;
import sampleTest.entity.Thread;

/**
 * Servlet implementation class SampleTest
 */
@WebServlet("/home")
public class FindAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		 
		 FindAllDAO findAllDAO = new FindAllDAO();
		 
		 //全権取得
		 List<Thread> list = findAllDAO.findAll();
		 //System.out.println(list);
		 request.setAttribute("list", list);
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/thread.jsp");
		 rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request,response);
	}

}
