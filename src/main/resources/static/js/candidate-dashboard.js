$(document).ready(function($) {
getNotifications();
});

function getNotifications()
{
var email = sessionStorage.getItem("email_id");
console.log(email);
	 $.ajax({
                url:"/dashboard/candidate/"+email+"",
                type:'get',
                success:function(data){
                    console.log(JSON.stringify(data));
                
                    if(data.success==true){
                    	console.log("success "+data.result);
                    	console.log("success json"+JSON.stringify(data.result));
                    	setData(data.result);
                        
                    }else{
                        msg = "Invalid username and password!";
                        console.log("error");
                    	show_error_message(msg);
                    }
                    
                }});
}


function setData(myData)
{
   console.log("MY DATA : "+myData);
   console.log("MY DATA : "+JSON.stringify(myData));
var serial_number = 1;
$('#dataTable').dataTable({
     data: myData,
     "bDestroy": true,
     columns: [
       {
      "render": function(data, type, full, meta) {
        return serial_number++;
      }
    },
     { data: 'name' },
     { data: 'manager_email_id'},
     { data: 'phone' },
     { data: 'department' },
         ]
});
}