<!DOCTYPE html>

<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">

<jsp:include page="../fragments/staticFiles.jsp" />

<body>
	<div class="container">
	
		<jsp:include page="../fragments/bodyHeader.jsp" />

		<!-- Pizza list goes here -->
        
		<div class="row">
			<div class="leftcolumn">
				<c:forEach var="pizza" items="${pizzas}">
					<div class="card">
				    	<h2><a href="/pizza/${pizza.id}"><c:out value="${pizza.name}"/></a></h2>
				      	<h5>Price: $ ${pizza.price}</h5>
				    </div>
	    		</c:forEach>
  			</div>
			<div class="rightcolumn">
				<div class="card">
					<h2>About Me</h2>
					<div class="fakeimg" style="height: 100px;">Image</div>
					<p>Some text about me</p>
				</div>
			</div>
		</div>

		<jsp:include page="../fragments/footer.jsp" />

	</div>
</body>

</html>
