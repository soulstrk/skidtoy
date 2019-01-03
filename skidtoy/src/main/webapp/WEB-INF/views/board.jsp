<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
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
        <div class="row" style="margin-top: 3%;">
            <table class="table table-dark table-striped" id="boardTable">
                <tr>
                    <th>글 번호</th>
                    <th>작성자</th>
                    <th>글 제목</th>
                    <th>날짜</th>
                    <th>조회수</th>
                </tr>
                <c:forEach items="${list }" var="vo">
                <tr>
                    <td>${vo.bNum }</td>
                    <td>${vo.bWriter }</td>
                    <td>${vo.bTitle }</td>
                    <td>${vo.bRegdate }</td>
                    <td>${vo.bHit }</td>
                </tr>
                </c:forEach>
            </table>
        </div>
        
        <div class="row">
            <ul class="pagination">
            	<c:choose>
            		<c:when test="${pu.startPageNum != 1 }">
               	 		<li class="page-item" id="${pu.startPageNum - 1 }"><a class="page-link" href="#">Previous</a></li>
               	 	</c:when>
               	 </c:choose>
               	 
                <c:forEach begin="${pu.startPageNum }" end="${pu.endPageNum }" step="1" var="num">
                	<c:choose>
                		<c:when test="${pu.pageNum == num}">
                			<li class="page-item active" id="${num }"><a class="page-link" href="#">${num }</a></li>
                		</c:when>
                		<c:otherwise>
							<li class="page-item" id="${num }"><a class="page-link" href="#">${num }</a></li>                		
                		</c:otherwise>
                	</c:choose>
                </c:forEach>
                
                <c:choose>
                	<c:when test="${pu.totalPageCount > pu.endPageNum }">
						<li class="page-item" id="${pu.endPageNum + 1 }"><a class="page-link" href="#">Next</a></li>                	
                	</c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</body>

<script>
    var board = {
        pageNumSubmit : function() {
            var pageNum = $(this).attr("id");
            var param = {};
            param.pageNum = pageNum;
            $.ajax ({
                type : "POST",
                url : "board/proc",
                dataType : "json",
                data : param,
                success : function(data) {
                    makeDocument.board(data.list);
                }
            })
        }
    }

    $(function() {
        //paging 버튼 이벤트 리스너
        $(".page-item").on("click", board.pageNumSubmit);
    });

    var makeDocument = {
        board : function(list) {
            $("#boardTable").children().remove();
            var html = "";
            html += "<tr>"
            html += "   <th>글 번호</th>"
            html += "   <th>작성자</th>"
            html += "   <th>글 제목</th>"
            html += "   <th>날짜</th>"
            html += "   <th>조회수</th>"
            html += "</tr>"
            $("#boardTable").append(html);
            list.forEach(function(val, i) {
                html = "";
                html += "<tr>";
                html += "   <td>"+ val.bNum +"</td>";
                html += "   <td>"+ val.bWriter +"</td>";
                html += "   <td>"+ val.bTitle +"</td>";
                html += "   <td>"+ val.bRegdate +"</td>";
                html += "   <td>"+ val.bHit +"</td>";
                html += "<tr>"; 
                $("#boardTable").append(html);                    
            });
        },
        paging : function() {

        }
    }
</script>
</html>



