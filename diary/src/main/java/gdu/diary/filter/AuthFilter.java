package gdu.diary.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/_auth/*")
// Auth/IndexController
// -> 요청 1. EncodingFilter 2. AuthFilter 3. IndexController 4. AuthFilter 5. EncodingFilter
public class AuthFilter implements Filter {

	// 필터 메서드
	@Override
 	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
 		// 타겟요청이 실행전
 		// 로그인이 되어있지 않은 상태에서 "/auth/문자로 시작하는 요청이 들어오면 redirect"
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpSession session = httpRequest.getSession();
		
		if(session.getAttribute("sessionMember") == null) {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect(httpRequest.getContextPath()+"/login");
			return; // 새로운 요청발생으로 doFilter메서드를 종료
		}
		
 		chain.doFilter(request, response);
 		// 타겟요청이 실행후 
 	}

 	// 생성자
 	 public AuthFilter() {

     }

     // 필터 시작시
  	public void init(FilterConfig fConfig) throws ServletException {
  		
  	}
  	
     // 필터 종료시
 	public void destroy() {
 		
 	}
}
