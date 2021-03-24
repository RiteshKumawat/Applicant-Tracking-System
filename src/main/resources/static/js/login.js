jQuery(document).ready(function($) {
	$("#manager-form").hide();
	configurations();
});

function configurations()
{
$("#toggle-manager").click(function(){
    $("#candidate-form").hide();
    $("#manager-form").show();
});

$("#toggle-candidate").click(function(){
    $("#manager-form").hide();
    $("#candidate-form").show();
});


}