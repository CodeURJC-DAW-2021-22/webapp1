// Define our button click listener
$(window).on("load", function(){
	// Loading Buttons from menu
	valueIndex(1);
    $('#btnTrending').on("click",()=>functionCall("btnTrending", '#moreFilmsTrending', '#loaderTrending', null))
    $('#btnAction').on("click",()=>functionCall("btnAction", '#moreFilmsAction', '#loaderAction', "ACTION"))
    $('#btnAdventure').on("click",()=>functionCall("btnAdventure", '#moreFilmsAdventure', '#loaderAdventure', "ADVENTURE"))
    $('#btnAnimation').on("click",()=>functionCall("btnAnimation", '#moreFilmsAnimation', '#loaderAnimation', "ANIMATION"))
    $('#btnComedy').on("click",()=>functionCall("btnComedy", '#moreFilmsComedy', '#loaderComedy', "COMEDY"))
    $('#btnDrama').on("click",()=>functionCall("btnDrama", '#moreFilmsDrama', '#loaderDrama', "DRAMA"))
    $('#btnHorror').on("click",()=>functionCall("btnHorror", '#moreFilmsHorror', '#loaderHorror', "HORROR"))
    $('#btnScifi').on("click",()=>functionCall("btnScifi", '#moreFilmsScifi', '#loaderScifi', "SCIENCE_FICTION"))

	// Loading Button from film info
	$('#btnComment').on("click",()=>functionComment("btnComment", '#moreComments', '#loaderComment'))

})

var indexTrending;
var indexAction;
var indexAdventure;
var indexAnimation;
var indexComedy;
var indexDrama;
var indexHorror;
var indexScifi;

var indexComment;

function functionCall(index, where, spinner, genre) {
	value = searchIndex(index);
	 
	if (genre==null) {
		url=('/more/' + value);
	} else {
		url=('/moreGenre/'+ genre + '/' + value);
	}
	
    $.ajax({
    	type: "GET",
        contenType: "aplication/json",
		url: url,
		beforeSend: function () {
        	$(spinner).removeClass('hidden')
        },
		success: function (result) {
			$(where).append(result);
		},
		complete: function () {
        	$(spinner).addClass('hidden')
        },
	});
}

function functionComment(index, where, spinner) {
	value = searchIndex(index);
	
	// Search parameter in url
	const arrayPath = window.location.pathname.split('/');
	const id= arrayPath[2];

	url=('/moreComments/' + id + '/' + value);
	
    $.ajax({
    	type: "GET",
        contenType: "aplication/json",
		url: url,
		beforeSend: function () {
        	$(spinner).removeClass('hidden')
        },
		success: function (result) {
			$(where).append(result);
		},
		complete: function () {
        	$(spinner).addClass('hidden')
        },
	});
}

function searchIndex(index) {
	value = 0;
	
	switch(index){
		case ("btnTrending"): 
			value = indexTrending;
			this.indexTrending += 1;
			break;
		case ("btnAction"): 
			value = indexAction;
			this.indexAction += 1;
			break;
		case ("btnAdventure"): 
			value = indexAdventure;
			this.indexAdventure += 1;
			break;
		case ("btnAnimation"): 
			value = indexAnimation;
			this.indexAnimation += 1;
			break;
		case ("btnComedy"): 
			value = indexComedy;
			this.indexComedy += 1;
			break;
		case ("btnDrama"): 
			value = indexDrama;
			this.indexDrama += 1;	
			break;	
		case ("btnHorror"): 
			value = indexHorror;
			this.indexHorror += 1;
			break;
		case ("btnScifi"): 
			value = indexScifi;
			this.indexScifi += 1;	
			break;
		case ("btnComment"): 
			value = indexComment;
			this.indexComment += 1;	
			break;
	}
	
	return value;
}

function valueIndex(num) {
	this.indexTrending = num;
	this.indexAction = num;
	this.indexAdventure = num;
	this.indexAnimationn = num;
	this.indexComedy = num;
	this.indexDrama = num;
	this.indexHorror = num;
	this.indexScifi = num;
	
	this.indexComment = num;
}