$(function() {
	
	$("form[id='edit'] input[name='username']").focus();
	
	$("form[id='edit']").validate({
		rules : {
			username : {
				required : true
			},
			oldPassword : {
				required : true
			},
			password2 : {
				equalTo : "#password"
			}
		},
		messages : {
			username : {
				required : "Username cannot be empty!"
			},
			oldPassword : {
				required : "Password cannot be empty!"
			},
			password2 : {
				equalTo : "Passwords must match!"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
