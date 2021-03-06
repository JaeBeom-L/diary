package gdu.diary.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DBDriverListener implements ServletContextListener {
    // 톰캣 부팅시
    public void contextInitialized(ServletContextEvent sce)  { 
         try {
        	System.out.println(this.getClass()+"로딩 성공");
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("DB Driver 로딩 실패");
			e.printStackTrace();
		}
    }
    // 생성자
    public DBDriverListener() {
      
    }
    // 톰캣 종료시
    public void contextDestroyed(ServletContextEvent sce)  { 
         
    }
}
