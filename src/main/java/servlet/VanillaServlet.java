package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/vanilla-js/search")
public class VanillaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String q= request.getParameter("q");
        System.out.println("q = " + q);

        // 2. 업무로직

        // 3. view단 처리 - text | html | json | xml
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.append("<h3>요청한 검색어는 [" + q + "]입니다.</h3>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        try{
            // 1. 사용자 입력 값 처리
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            System.out.println("username = " + username);
            System.out.println("email = " + email);

            if(username.isEmpty() || email.isEmpty())
                throw new IllegalArgumentException("사용자 이름 또는 이메일을 꼭 작성해주세요.");

            // 2. 업무 로직

            // 3. view단 처리 - 비동기요청 DML은 redirect 필요치 않는다.
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().append("회원가입 성공!");
        }catch (Exception e){
            e.printStackTrace();

            // 사용자 응답 비동기 처리
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().append(e.getMessage());
        }
    }
}
