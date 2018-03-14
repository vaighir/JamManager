$(function() {

	$("form[id='signup'] input[name='username']").focus();

	$("form[id='signup']").validate({
		rules : {
			username : {
				required : true
			}
		},
		messages : {
			username : {
				required : "Username cannot be empty!"
			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});