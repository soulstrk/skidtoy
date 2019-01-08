<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div class="container">
        <div class="row" style="margin-top: 30px;">
        </div>
        <div class="row">
            <form action="" id="writingFrm" enctype="multipart/form-data">
                글쓴이 : <input type="text" name="bWriter" id="bWriter"><br>
                제목 : <input type="text" name="bTitle" id="bTitle"><br>
                내용<textarea name="bContent" id="bContent" cols="30" rows="10"></textarea><br>
                파일첨부<br>
                <input type="file" name="file" id="file">
            </form>
            <button id="writingBtn">글쓰기</button>
        </div>        
    </div>
</body>

<script>
    $(function() {
        $(document).on("click", "#writingBtn", function() {
            $("#writingFrm").attr({
                "action" : "${pageContext.request.contextPath}/board/upload",
                "method" : "post"
            });
            
            $("#writingFrm").submit();
        });
    })
</script>
</html>