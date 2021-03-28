$(document).ready(function($) {
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


function check_candidate_credentials(event) {
event.preventDefault();
 var email = $("#candidate_email_id").val().trim();
 var password  = $("#candidate_password").val().trim();


 var credintials_json = {
 	"email_id" : email,

 	"password" : password
 }


console.log(JSON.stringify(credintials_json));

        if( email != "" && password != "" ){
            $.ajax({
                url:'/login/candidate',
                type:'post',
                data: credintials_json,
                success:function(data){
                    console.log("kaka : "+JSON.stringify(data));  
                    if(data.success==true){
                    	console.log("success")
                        send_To_Candidate_Dashboard(email);
                        //window.location = "/dashboard/candidate/"+email+"";
                    }else{
                        msg = "Invalid username and password!";
                        console.log("error");
                    	show_error_message(msg);
                    }
                    
                }});
}
}
function check_manager_credentials(event)
{

event.preventDefault();
 var email = $("#manager_email_id").val().trim();
 var password  = $("#manager_password").val().trim();


 var credintials_json = {
    "manager_email_id" : email,

    "manager_password" : password
 }


console.log(JSON.stringify(credintials_json));

        if( email != "" && password != "" ){
            $.ajax({
                url:'/login/manager',
                type:'post',
                data: credintials_json,
                success:function(data){
                    console.log("Manager Data : "+JSON.stringify(data));  
                    if(data.success==true){
                        console.log("success")
                        send_To_Manager_Dashboard(email);
                        //window.location = "/dashboard/candidate/"+email+"";
                    }else{
                        msg = "Invalid username and password!";
                        console.log("error");
                        show_error_message(msg);
                    }
                    
                }});
}


}




function send_To_Candidate_Dashboard(email)
{
    console.log("go to dashboard");
    sessionStorage.setItem("email_id", email);
    window.location = "CandidateDashboard.html";
}




function send_To_Manager_Dashboard(email)
{
    console.log("go to dashboard");
    sessionStorage.setItem("email_id", email);
    window.location = "ManagerDashboard.html";
}


function show_error_message(msg)
{
console.log(msg);
$("#message").text(msg);
$("#message").show();
}