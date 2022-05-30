package servlet;

import celeb.dto.Celeb;
import celeb.dto.CelebManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/jquery/csv")
public class CsvServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 사용자 입력 값
        
        // 2. 업무로직
        CelebManager manager = CelebManager.getInstance();
        List<Celeb> celebList = manager.getCelebList();

        // 3. view 단 처리
//        response.setContentType("text/plain; charset=utf-8");
//        response.getWriter()
//                .a
    }
}
