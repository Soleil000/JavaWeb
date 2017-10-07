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

	//ͳ�Ʒ�����
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡapplication
		//2.��ȡapplication�е�count
		//3.�ж�count�Ƿ����
		//4.���countΪnull˵����û�п�ʼ��������Ϊ��һ�η��ʣ�����countΪ1
		//5.�����Ϊnull˵���ǵ�һ�η��ʣ�count++
		//6.���countֵ���ͻ���
		//7.��count���浽application��
		ServletContext application = this.getServletContext();
		Integer count = (Integer)application.getAttribute("count");
		if(count == null) {
			count = 1;
		} else {
			count++;
		}  
		response.setContentType("text/html;charset=utf-8");//��������ͷ
		response.getWriter().print("��ҳ���ǵ�" + count + "�η��ʣ�");
		application.setAttribute("count", count);
    }
}
