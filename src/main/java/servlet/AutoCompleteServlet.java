package servlet;

import celeb.dto.Celeb;
import celeb.dto.CelebManager;
import name.dto.NameManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/jquery/autoComplete")
public class AutoCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 사용자 입력 값 처리
        String search = request.getParameter("search");
        System.out.println("search = " + search);

        // 2. 업무로직
        List<String> names = NameManager.getInstance().getNameList();
        List<String> results = new ArrayList<>();

        // 3. view 단 처리
        for (String name : names) {
            if(name.contains(search)){
                results.add(name);
            }
        }

        // 3. 응답 처리
        response.setContentType("text/csv; charset=utf-8");
        PrintWriter out = response.getWriter();
        for (int i=0; i<results.size(); i++){
            out.append(results.get(i));
            if(i != results.size() -1){
                out.append(",");
            }
        }
    }
}
