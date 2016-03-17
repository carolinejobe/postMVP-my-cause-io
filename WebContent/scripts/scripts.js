$( "#connect" ).click(function() {
	
	var email = document.getElementById("contact").name
	var res = email.split("@");
    console.log(res);
	var res1 = res.slice(0,1);
    console.log(res1);
	var res2 = res[1].split(".");
    console.log(res2);
	var res3 = res2.slice(1,2);
    console.log(res3);
	
	res2 = res2.slice(0,1);
    console.log(res2);
	
	res1.push("[at]");
    console.log(res1);
	
	res2.push("[dot]");
    console.log(res2);
	
	var newEmailArr = res1.concat(res2).concat(res3);
    console.log(newEmailArr);
	
	var newEmail = " ";
	
	newEmailArr.forEach(rejoin);
	function rejoin(item,index,array) {
		newEmail += item;
        console.log(newEmail);
	}
	
	
	//alert("Email "+ newEmail + " to connect to this cause");
	swal({   title: "Send an email!",
		//text: "A custom <span style="color:#F8BB86">html<span> message.",
		
		text: "Click to send an email to <a href='mailto:"+email+"'>"+ newEmail +"</a>",
		html: true });
	
});

$(document).ready(function(){
	var loginValue = Cookies.get("userid");

	if(loginValue != null) {
		
		$(".nav").append(
			"<li><a href=\"logout.html\">Logout</a></li>"
		);
		$("#login").hide();
		$("#signup").hide();
	
	}
});
