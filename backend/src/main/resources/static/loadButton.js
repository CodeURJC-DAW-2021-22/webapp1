// Define our button click listener
$( window ).on("load", function(){
	valueIndex(1);
    $('#btnTrending').on("click",()=>functionCall("btnTrending"))
   
})

var indexTrending;

function functionCall(index){
	 // On click, execute the ajax call.
	 
	 value = searchIndex(index);

        $.ajax({
            type: "GET",
            contenType: "aplication/json",
			url: ('/more/' + value),
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
}

function searchIndex(index) {
	value = 0;
	if (index == "btnTrending") {
		value=indexTrending;
		this.indexTrending += 1;
	}
	return value;
}

function valueIndex(num) {
	this.indexTrending=num;
}