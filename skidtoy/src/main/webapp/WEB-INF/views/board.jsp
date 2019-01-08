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
        	<a href="${pageContext.request.contextPath}/board/write">글 쓰기</a>
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
                url : "${pageContext.request.contextPath}/board/proc",
                dataType : "json",
                data : param,
                success : function(data) {
                    console.log(data.pu);
                    makeDocument.board(data.list);
                    makeDocument.paging(data.pu);
                }
            })
        }
    }

    $(function() {
        //paging 버튼 이벤트 리스너
        //$(".page-item").on("click", board.pageNumSubmit);
        //동적으로 사용하기 위해 $(document)로 잡아와야한다.
        $(document).on("click",".page-item",board.pageNumSubmit);
    });

    var makeDocument = {
        // Table 그리기
        board : function(list) {
            $("#boardTable").find("tr").first().nextAll().remove();
            list.forEach(function(val, i) {
                var html2 = "";
                html2 += "<tr>";
                html2 += "   <td>"+ val.bNum +"</td>";
                html2 += "   <td>"+ val.bWriter +"</td>";
                html2 += "   <td>"+ val.bTitle +"</td>";
                html2 += "   <td>"+ val.bRegdate +"</td>";
                html2 += "   <td>"+ val.bHit +"</td>";
                html2 += "</tr>"; 
                $("#boardTable").children().append(html2);
            });
        },

        // paging 부분 그리기
        paging : function(pu) {
            var html = "";
			$(".pagination").children().remove();
            if(pu.startPageNum !== 1) {
                html += "<li class='page-item' id='"+(parseInt(pu.startPageNum) - 1)+"'><a class='page-link' href='#'>Previous</a></li>";
            }
            for(let i = pu.startPageNum; i <= pu.endPageNum; i++) {
                if (pu.pageNum === i) {
                    html += "<li class='page-item active' id='"+i+"'><a class='page-link' href='#'>"+i+"</a></li>";    
                } else {
                    html += "<li class='page-item' id='"+i+"'><a class='page-link' href='#'>"+i+"</a></li>";
                }
            }
            if(pu.endPageNum < pu.totalPageCount) {
                html += "<li class='page-item' id='"+(parseInt(pu.endPageNum) + 1)+"'><a class='page-link' href='#'>Next</a></li>";
            }

            $(".pagination").append(html);	
        }
    }
    
</script>
</html>



