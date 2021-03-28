$(document).ready(function($) {
 configure_button();
 get_candidates_list();
});


function configure_button()
{
 $("#send_button").click(function(event) {
  var message="";
  var result = [];
  var email_id = sessionStorage.getItem("email_id");
  console.log("1st");
  $("#dataTable input[type=checkbox]:checked").each(function () {
    var row = $(this).closest("tr")[0];
    message = row.cells[1].innerHTML;
    result.push({"id":message})
               // message += "   " + row.cells[2].innerHTML;
                //message += "   " + row.cells[3].innerHTML;
                //message += "\n";
                console.log("INSIDE");
              });
  console.log("2nd");
  console.log(JSON.stringify (result));

  if( result.length>0  ){
    $.ajax({
      url:"/dashboard/select/"+email_id+"",
      type:'post',
      headers: {
        'Content-Type':'application/json'
      },
      data: JSON.stringify(result),
      success:function(data){
        console.log("kaka : "+JSON.stringify(data));  
        if(data.success==true){
          console.log("success")
          send_To_Login();
                        //window.location = "/dashboard/candidate/"+email+"";
                      }else{
                        msg = "Invalid username and password!";
                        console.log("error");
                        show_error_message(msg);
                      }

                    }});
  }


});
}


function send_To_Login()
{
  window.location = "/";
}

function get_candidates_list()
{
 var email = sessionStorage.getItem("email_id");
 console.log(email);
 $.ajax({
   url:"/dashboard/candidate/get_list",
   type:'get',
   success:function(data){
     console.log(JSON.stringify(data));

     if(data.success==true){
                    	//console.log("success "+data.result);
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
 var serial_number  = 1; 
 $('#dataTable').dataTable({
   data: myData,
   "bDestroy": true,
   columns: [
   {
    "render": function() {
      return serial_number++;
    }
  },
  { data: 'id' },
  { data: 'name' },
  { data: 'skills'},
  { data: 'email_id' },
  { data: 'phone_number' },
  {
   data:   "active",
   render: function ( data, type, row ) {
    if ( type === 'display' ) {
      return '<input type="checkbox" class="editor-active">';
    }
    return data;
  },
  className: "dt-body-center"
}],
select: {
  style: 'os',
            selector: 'td:not(:last-child)' // no row selection on last column
          }
        } );

}
