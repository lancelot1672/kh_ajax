<%--
  Created by IntelliJ IDEA.
  User: lancelot
  Date: 2022-05-30
  Time: 오후 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
    <h1>text</h1>
    <button id="btn1">text</button>
    <table id="tbl-celeb">
        <thead>
            <tr>
                <th>Index</th>
                <th>Name</th>
                <th>Type</th><!-- select 태그 하위에 해당타입이 selected처리 -->
                <th>ProFile</th> <!-- img 태그 -->
            </tr>
        </thead>
        <tbody></tbody>
    </table>
    <script>
        btn1.addEventListener('click', (e)=>{
            $.ajax({
                url: "<%= request.getContextPath()%>/jquery/text",
                method : "GET",
                data : {
                    q : "abcde"
                },
                dataType : "text", //text / html/ script / json / xml
                beforeSend(){
                    //요청전 호출 메서드
                    console.log("beforeSend");
                },
                success(responseText){
                    console.log("success : ", responseText);
                },
                error(xhr, textStatus, err){
                    console.log("error : ",xhr, textStatus, err);
                },
                complete(){
                    //응답후(성공, 실패) 반드시 실행하는 메소드
                    console.log("complete");
                }
            });
        });
    </script>
</body>
</html>
