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
			},
			whatsapp : {
				minlength : 5,
				maxlength : 15,
				digits : true
			},
			gg : {
				minlength : 5,
				maxlength : 15,
				digits : true
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
			},
			whatsapp : {
				minlength : "Must be longer than 5 characters!",
				maxlength : "Cannot be longer than 15 characters!",
				digits : "Must be digits only!"
			},
			gg : {
				minlength : "Must be longer than 5 characters!",
				maxlength : "Cannot be longer than 15 characters!",
				digits : "Must be digits only!"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
