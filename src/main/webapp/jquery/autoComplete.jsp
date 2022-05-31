<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>JQuery - autoComplete</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
</head>
<body>
    <h1>autoComplete</h1>
    <input id="names" autofocus>
<script>
    $("#names").autocomplete({
        source(request,response){
            console.log(request,response);
            $.ajax({
                url : `<%=request.getContextPath()%>/jquery/autoComplete`,
                method : "GET",
                data : {
                    search : request.term
                },
                dataType : "text",
                success(response){
                    console.log(response);
                    const names = response.split(",");
                    names.map((name) => ({
                        label : name,
                        value : name
                    }));
                },
                error : console.log
            })
        },
        minLength : 1,
        delay : 500,
        focus(e, item) {
            console.log(e, item);
            return false;
        },
        select(e, {item}){
            //선택했을 때 처리코드
            alert(item.value);
        }
    });
</script>
</body>
</html>
