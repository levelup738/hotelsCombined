package com.servlet.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ResAdminDAO;
import com.DAO.ReservationDAO;

/**
 * Servlet implementation class UpdateReState
 */
@WebServlet("/updateReState.jsp")
public class UpdateReState extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String status = request.getParameter("status");
		String resIdx = request.getParameter("resIdx");
		//System.out.println(status);
		//System.out.println(resIdx);
		ResAdminDAO resAdminDAO = new ResAdminDAO();
		if(resAdminDAO.updateStatus(status, resIdx) == 1) {
			//System.out.println("UpdateReState 성공");
		}

		
		RequestDispatcher rd = request.getRequestDispatcher("/reservationListLogic.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}