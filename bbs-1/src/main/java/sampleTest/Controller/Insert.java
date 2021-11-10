package sampleTest.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sampleTest.DAO.InsertThreadDAO;
import sampleTest.entity.Thread;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		Thread thread = new Thread();
		thread.setName(request.getParameter("name"));
		thread.setContent(request.getParameter("content"));
		
		InsertThreadDAO insertDAO = new InsertThreadDAO();
		//１件追加
		insertDAO.insertThread(thread);
		//追加後投稿画面へリダイレクト
		response.sendRedirect(request.getContextPath() + "/home");
	}

}
