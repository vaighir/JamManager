$(function() {

	$("form[id='add'] input[name='username']").focus();

	$("form[id='add']").validate({
		rules : {
			username : {
				required : true
			},
			email : {
				required : true,
				email: true
			},
			password : {
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
			email : {
				required : "Email cannot be empty!",
				email: "Must be a valid email address!"
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