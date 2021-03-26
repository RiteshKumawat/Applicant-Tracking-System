$(document).ready(function($) {
	alert("GSsdg");	
	configure_page();

	configure_buttons();
});


function configure_page()
{
$("#toggle-manager").click(function(){
    $("#candidate-form").hide();
    $("#manager-form").show();
});

$("#toggle-candidate").click(function(){
    $("#manager-form").hide();
    $("#candidate-form").show();
});
$("#manager-form").hide();
$("#candidate_email_id").click(function(event) {
	$("#message").hide();
});
$("#candidate_password").click(function(event) {
	$("#message").hide();
});
$("#message").hide();
}


function configure_buttons() {
$("#candidate-login-button").click( check_candidate_credentials );
$("#manager-login-button").click( check_manager_credentials );
}


function check_candidate_credentials() {
 var email = $("#candidate_email_id").val().trim();
 var password  = $("#candidate_password").val().trim();


 var credintials_json = {
 	"candidate_email_id" : email,

 	"candidate_password" : password
 }


alert(JSON.stringify(credintials_json));

        if( email != "" && password != "" ){
            $.ajax({
                url:'login/candidate',
                type:'post',
                data: credintials_json,
                success:function(data){
                    alert(JSON.stringify(data));
                
                    if(data.success==true){
                    	alert("success")
                        window.location = "/manager/"+email+"";
                    }else{
                        msg = "Invalid username and password!";
                        alert("error");
                    	show_error_message(msg);
                    }
                    
                }});
}
}
function check_manager_credentials()
{

}

function show_error_message(msg)
{
alert(msg);
$("#message").text(msg);
$("#message").show();
}