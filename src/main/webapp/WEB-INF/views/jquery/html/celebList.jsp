<%@ page import="celeb.dto.Celeb" %>
<%@ page import="java.util.List" %>
<%@ page import="celeb.dto.CelebType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Celeb> celebList = (List<Celeb>) request.getAttribute("celebList");

    for(Celeb celeb : celebList){


%>
    <tr>
        <td><%=celeb.getNo()%></td>
        <td><%=celeb.getName()%></td>
        <td>
            <select>
                <option value="ACTOR"><%= celeb.getType() == CelebType.ACTOR ? "selected" : ""%></option>
                <option value="SINGER"><%= celeb.getType() == CelebType.SINGER ? "selected" : ""%></option>
                <option value="MODEL"><%= celeb.getType() == CelebType.MODEL ? "selected" : ""%></option>
                <option value="COMEDIAN"><%= celeb.getType() == CelebType.COMEDIAN ? "selected" : ""%></option>
                <option value="ENTERTAINER"><%= celeb.getType() == CelebType.ENTERTAINER ? "selected" : ""%></option>
            </select>
        </td>
        <td>
            <img src="<%=request.getContextPath()%>/images/<%= celeb.getProfile()%>" alt="" />
        </td>
    </tr>
<%
    }
%>

