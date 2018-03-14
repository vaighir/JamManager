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
				required : "Username cannot be empty!"
			},
			password : {
				required : "Password cannot be empty!"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
