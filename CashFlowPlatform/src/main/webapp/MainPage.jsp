<!-- 508170222 Nick Chen, 508170301 Matt Hsiao  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="NewFile.css">
<title>Main Page</title>
</head>
<body>
<%
// to avoid backword button
response.setHeader("Cache-Contorl", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cachae");
response.setHeader("Expires", "0");

if(session.getAttribute("id") == null) {
	response.sendRedirect("Login_or_SignUp.jsp");
}
%>
<div id=ContentSection>

<!-- hello section -->
<div id=hello>
	Hello, ${id}!
</div>
<br>

<!-- profile section -->
<div id=profile>
	<div id=your>
		Your<br>
	</div>
	<div id=accountNumber>
		account number<br>
	</div>
	<div id=is>
		is
	</div>
	<div id=account>
		${accountNumber}
	</div>
</div>

<!-- deposit section -->
<div id=deposit>
	<div id=depositText>
		Deposit to your account:
	</div>
	<form action="Deposit" method="post">
		<input type="text" name="depositAmount">
		<input type="submit" value="Deposit">
	</form>
	<%session.getAttribute("depositMessage"); %>
	${depositMessage}
</div>

<!-- balance section -->
<div id=balanceSection>
	<%session.getAttribute("balance"); %>
	<div id=yourbalance>
		Balance:
	</div>
	<form action="Profile" method="post">
		<input type="submit" value="Update profile">
	</form>	
</div>
<div id=balance>
	${balance}
</div>

<!-- transfer section -->
<div id=transfer>
	<div id=transferText>
		Transfer
	</div>
	<form action="Transfer" method="post">
			Transfer to : <input type="text" name="counterSide"><br>
			Amount : <input type="text" name="amount"><br>
			<input type="submit" value="Verify & transfer money">
	</form>
	<%session.getAttribute("transferMessage");%>
	${transferMessage}
</div>


<!-- details section -->
<div id=details>
	<div id=detailsText>
		Details
	</div>
	<%session.getAttribute("deteils"); %>
	<br>
		${details[9]}
	<br>
		${details[8]}
	<br>
		${details[7]}
	<br>
		${details[6]}
	<br>
		${details[5]}
	<br>
		${details[4]}
	<br>
		${details[3]}
	<br>
		${details[2]}
	<br>
		${details[1]}
	<br>
		${details[0]}
	<br>
</div>
	<!-- log out button -->
	<div id=logout>
		<div id=logoutText>
			Logout here
		</div>
		<form action="Logout">
			<input type="submit" value="Logout">
		</form>
	</div>
	
</div>
</body>
</html>