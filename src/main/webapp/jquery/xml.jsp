<%--
  Created by IntelliJ IDEA.
  User: lancelot
  Date: 2022-05-31
  Time: 오전 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JQuery - XML</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
  <h1>xml</h1>
<button id="btn1">sample</button>
  <table id="tbl-books">
      <thead>
      <tr>
          <th>분류</th>
          <th>제목</th>
          <th>저자</th>
      </tr>
      </thead>
      <tbody></tbody>
  </table>
<div id="result-sample"></div>
<script>
  btn1.addEventListener('click',()=>{
      $.ajax({
          url : "<%= request.getContextPath()%>/jquery/sample.xml",
          method : "GET",
          dataType : "xml",
          success(doc){
              //응답받은 xml을 jquery가 parsing 처리 후 DOM으로 전달.
              console.log(doc);
              console.dir(doc); //document;

              const root = doc.querySelector(":root"); //books 태그
              console.dir(root);

              //사용자 속성 가져오기
              console.log(root.myattr); // undefined root.attributes(NamedNodeMap타입)속성에서 관리됨.
              console.log(root.getAttribute("myattr")); //hello

              //tbody 가져오기
              const tbody = document.querySelector("#tbl-books tbody");
              tbody.innerHTML = "";

              const books = [...root.children]; // Array.from(유사배열)
              console.log(books);

              books.forEach((book)=>{
                  //구조 분해 할당
                  const [subject, title, author] = book.children;
                  console.log(subject,title,author);
                  tbody.innerHTML += `<tr>
                  <td>${subject.textContent}</td>
                  <td>${title.textContent}</td>
                  <td>${author.textContent}</td>
                  </tr>
                  `;
              })
          },
          error : console.log
      });
  });
</script>
  <button id="btn2">Celeb</button>
<table id="tbl-celebs">
    <thead>
        <th>No</th>
        <th>Name</th>
        <th>Type</th>
        <th>Profile</th>
    </thead>
    <tbody>

    </tbody>
</table>
<script>
    btn2.addEventListener('click',(e)=>{
        const tbody = document.querySelector("#tbl-celebs tbody");
        tbody.innerHTML = "";

        $.ajax({
            url : '<%=request.getContextPath()%>/jquery/xml',
            success(doc) {
                console.log(doc);
                const root = doc.querySelector(":root");    //celebs 태그

                console.log(`총 ${root.getAttribute("len")}개의 데이터가 조회되었습니다.`);

                const celebs = [...root.children];

                tbody.innerHTML =
                celebs.reduce((html,celeb)=>{
                    const [name, type, profile] = celeb.children;
                    const no = celeb.getAttribute("no");

                    const tr = `<tr>
                        <td>${no}</td>
                        <td>${name.textContent}</td>
                        <td>${type.textContent}</td>
                        <td><img src="<%=request.getContextPath()%>/images/${profile.textContent}" alt = "images"></td></tr>
                    `;
                    return html + tr;
                }, "");
            },
            error : console.log
        });
    })
</script>
</body>
</html>
