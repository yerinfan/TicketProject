package kr.ac.kopo.framework;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.controller.Controller;

//@WebServlet
public class DispatcherServlet extends HttpServlet {

	private HandlerMapping mappings;	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String propName = config.getInitParameter("propName");
		System.out.println(propName);
		mappings = new HandlerMapping(propName);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		uri = uri.substring(contextPath.length());
		System.out.println(uri);
		
		try {
			Controller control = mappings.getController(uri);
			 if (control == null) {
		            throw new ServletException("매핑된 컨트롤러가 없습니다: " + uri);
		        }
		        // 컨트롤러 실행 및 결과 페이지 반환
		        String view = control.handleRequest(request, response);

		        // 리다이렉트 처리
		        if (view.startsWith("redirect:")) {
		            String redirectUrl = view.substring("redirect:".length());
		            response.sendRedirect(contextPath + redirectUrl);
		        } else {
		            // 포워딩 처리
		            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		            dispatcher.forward(request, response);
		        }
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException();
		}
		
	}

	 
}
