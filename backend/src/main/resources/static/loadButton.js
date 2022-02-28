// Define our button click listener
$( window ).on("load", function(){
    $('#getDataBtn').on("click",function () {
        // On click, execute the ajax call.
        $.ajax({
            type: "GET",
            contenType: "aplication/json",
			url: ('/more'),
			beforeSend: function () {
                $('#loader').removeClass('hidden')
            },
			success: function (result){
				$('#moreFilms').append(result);
			},
			complete: function () {
                $('#loader').addClass('hidden')
            },
        });
    })
})