package servlet;

import celeb.dto.Celeb;
import celeb.dto.CelebManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/jquery/xml")
public class XmlServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Celeb> celebList = CelebManager.getInstance().getCelebList();

        // 3. view단처리 - xml생성업무를 jsp에 위임
        request.setAttribute("celebList", celebList);
        request.getRequestDispatcher("/WEB-INF/views/jquery/xml/celebList.jsp")
                .forward(request, response);
    }
}
