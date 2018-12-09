package com.monprojetJson;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monprojetJson.posts.Post;
import com.monprojetJson.posts.PostManager;

/**
 * Servlet implementation class postsServlet
 */
@WebServlet("/posts")
public class postsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PostManager postManager;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postsServlet() {
        super();
        
        this.postManager= new PostManager();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("id")== null) {
			request.setAttribute("posts", this.postManager.getAllPosts());
			this.getServletContext().getRequestDispatcher("/WEB-INF/posts/index.jsp").forward(request, response);
		}
		else {
			request.setAttribute("post", this.postManager.getPostById(Integer.parseInt(request.getParameter("id"))));
			this.getServletContext().getRequestDispatcher("/WEB-INF/posts/read.jsp").forward(request, response);
		}
	}

	

}
