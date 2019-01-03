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
            <table class="table table-dark table-striped">
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
               	 		<li class="page-item"><a class="page-link" href="board?pageNum=${pu.startPageNum - 1 }">Previous</a></li>
               	 	</c:when>
               	 </c:choose>
               	 
                <c:forEach begin="${pu.startPageNum }" end="${pu.endPageNum }" step="1" var="num">
                	<c:choose>
                		<c:when test="${pu.pageNum == num}">
                			<li class="page-item active"><a class="page-link" href="#">${num }</a></li>
                		</c:when>
                		<c:otherwise>
							<li class="page-item"><a class="page-link" href="board?pageNum=${num }">${num }</a></li>                		
                		</c:otherwise>
                	</c:choose>
                </c:forEach>
                
                <c:choose>
                	<c:when test="${pu.totalPageCount > pu.endPageNum }">
						<li class="page-item"><a class="page-link" href="board?pageNum=${pu.endPageNum + 1 }">Next</a></li>                	
                	</c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</body>
</html>



