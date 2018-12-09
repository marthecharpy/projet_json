package com.monprojetJson;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monprojetJson.posts.Post;

/**
 * Servlet implementation class postsServlet
 */
@WebServlet("/posts")
public class postsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var posts= new ArrayList<Post>();
		posts.add(new Post(1, "Lorem Elsass", "Lorem Elsass ipsum leo libero. jetz gehts los picon bière quam, consectetur dignissim sit geïz gravida sed Huguette sit Coopé de Truchtersheim pellentesque vulputate tristique id"));
		posts.add(new Post (1, "Lorem ipsum","Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim."));
		request.setAttribute("post", posts);
		this.getServletContext().getRequestDispatcher("/WEB-INF/posts/index.jsp").forward(request, response);
	}

	

}
