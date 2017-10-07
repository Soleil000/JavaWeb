package cn.itcast.servlers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.omg.CORBA.portable.InputStream;

/**
 * Servlet implementation class AServlet
 */
@WebServlet("/AServlet")
public class AServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		ServletContext sc = this.getServletContext();
		//��ȡ��ʵ·��
		String path = sc.getRealPath("/WEB-INF/web.xml");
		response.getWriter().print(path + "<br/>");//��Ӧ���ͻ���
		
		//��ȡ��Դ��
		java.io.InputStream input = sc.getResourceAsStream("/WEB-INF/web.xml");
		response.getWriter().print(IOUtils.toString(input));
		
		//����������
		sc.setAttribute("name", "lisi");
		 
	}

	

}
