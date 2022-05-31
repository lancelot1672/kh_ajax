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

@WebServlet("/jquery/html")
public class HtmlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Celeb> celebList = CelebManager.getInstance().getCelebList();

        // 3. view 단 처리
        request.setAttribute("celebList", celebList);
        request.getRequestDispatcher("/WEB-INF/views/html/celebList.jsp")
                .forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
