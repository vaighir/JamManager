$(function() {
	
	
	$("form[id='edit']").validate({
		rules : {
			date : {
				required : true
			},
			city : {
				required : true
			},
			place : {
				required : true,
				minlength : 10
			},
			description : {
				required : true,
				minlength : 20
			}
		},
		messages : {
			date : {
				required : "Date cannot be empty!"
			},
			city : {
				required : "City cannot be empty!"
			},
			place : {
				required : "Place cannot be empty!",
				minlength : "Place description must be at least 10 characters long!"
			},
			description : {
				required : "Description cannot be empty!",
				minlength : "Description must be at least 20 characters long!"

			}
		},
		submitHandler : function(form) {
			form.submit();
		}
	});
});
