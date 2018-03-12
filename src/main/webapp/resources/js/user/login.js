$(function() {
	
	$("form[id='login'] input[name='username']").focus();
	
	$("form[id='login']").validate({
		rules : {
			username : {
				required : true
			},
			password : {
				required : true
			}
		},
		messages : {
			username : {
				required : "Nie podałeś loginu"
			},
			password : {
				required : "Nie podałeś hasła"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
