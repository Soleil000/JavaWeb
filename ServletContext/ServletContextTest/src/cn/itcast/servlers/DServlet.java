package cn.itcast.servlers;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DServlet
 */
@WebServlet("/DServlet")
public class DServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	//统计访问量
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取application
		//2.获取application中的count
		//3.判断count是否存在
		//4.如果count为null说明还没有开始计数，此为第一次访问，设置count为1
		//5.如果不为null说明非第一次访问，count++
		//6.输出count值给客户端
		//7.把count保存到application中
		ServletContext application = this.getServletContext();
		Integer count = (Integer)application.getAttribute("count");
		if(count == null) {
			count = 1;
		} else {
			count++;
		}  
		response.setContentType("text/html;charset=utf-8");//设置请求头
		response.getWriter().print("本页面是第" + count + "次访问！");
		application.setAttribute("count", count);
    }
}
