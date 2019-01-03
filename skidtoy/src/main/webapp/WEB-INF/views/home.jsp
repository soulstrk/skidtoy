<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<button>게시판으로</button>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

<script type="text/javascript">
	$("button").on("click", function() {
		location.href="board";
	})	
</script>
