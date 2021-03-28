$(document).ready(function($) {
	configure_page();
console.log("Doc ready")
	configure_buttons();
});


function configure_page()
{
$("#message").hide();
$("form").click(function(event) {
	$("#message").hide();
});
}


function configure_buttons() {
$("#register-button").click( send_register_request );


}


function send_register_request(event) {
event.prevenDefault();
/*var data={

var fullname = $("#first-name")+ $("#last-name");
	"name" : fullname,
	"email" : $("#email"),
	"password":$("#password"),
"phone":$("#password"),
	"dob":$("#dob"),
"address":$("#address"),
	"education":$("#education"),
	"expirence":$("#expirence")
}
*/
        // if( email != "" && password != "" ){
        //     $.ajax({
        //         url:'login/candidate',
        //         type:'post',
        //         data: credintials_json,
        //         success:function(data){
        //             console.log(JSON.stringify(data));
                
        //             if(data.success==true){
        //             	console.log("success")
        //                 window.location = "/manager/"+email+"";
        //             }else{
        //                 msg = "Invalid username and password!";
        //                 console.log("error");
        //             	show_error_message(msg);
        //             }
                    
        //         }});

var fullname = $("#first-name").val() + $("#last-name").val();
/*
	"name" : fullname,
	"email" : $("#email"),
	"password":$("#password"),
"phone":$("#phone"),
	"dob":$("#dob"),
"address":$("#address"),
	"education":$("#education"),
	"expirence":$("#expirence")
}
*/
var resume = $('input[name="resume"]').get(0).files[0];
var formData = new FormData();
formData.append('resume', resume);
formData.append('name', fullname);
formData.append('email_id',$("#email").val() );

formData.append('phone_number', $("#phone").val());
formData.append('address', $("#address").val());



formData.append('password', $("#password").val());
formData.append('dob', $("#dob").val());
formData.append('education', $("#education").val());
formData.append('experience', $("#experience").val());




console.log(formData);
console.log(JSON.stringify(formData));



for(let [name, value] of formData) {
  console.log(`${name} = ${value}`); // key1 = value1, then key2 = value2
}

    $.ajax({
        url : "register/add",
        type: 'POST',
        data: formData,
       success:function(data){
                    console.log(JSON.stringify(data));
                
                    if(data.success==true){
                    	console.log("success")
                        window.location = "/login/candidate";
                    }else{
                        msg = "Invalid username and password!";
                        console.log("error");
                    	show_error_message(msg);
                    }
             }
    });
}

function show_error_message(msg)
{
console.log(msg);
$("#message").text(msg);
$("#message").show();
}