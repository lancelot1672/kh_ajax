package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jquery/text")
public class TextServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q = request.getParameter("q");
        int mode = Integer.parseInt(request.getParameter("mode"));
        boolean isFinal = Boolean.parseBoolean(request.getParameter("isFinal"));
        System.out.println("q = " + q);
        System.out.println("mode = " + mode);
        System.out.println("isFinal = " + isFinal);

        // 2. 업무 로직

        // 3. view 단 처리 - ㅅtext 직접 작성
        response.setContentType("text/plain; charset=utf-8");
        response.getWriter()
                .append("q = " + q + ", mode = "+ mode + ", isFinal = " + isFinal)
                .append("\n")
                .append("데이터 처리 완료!");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
