//Get the modal
// data-toggle="modal" data-target="#picmodal"
window.onload = function(){ 
	var modal = document.getElementById('picmodal');
	var modalImg = document.getElementById("img01");
	var captionText = document.getElementById("captionnew");
	$('.timeline-badge').on('click', function() {
	    modal.style.display = "block";
	    modalImg.src = $(this).css('background-image').replace(/^url\(['"](.+)['"]\)/, '$1');
	    captionText.innerHTML = $(this).next().find(".timeline-title").text();
	    //alert($(this).next().find('h3').text());
	    //alert($(this).next().find('h3.timeline-title').text());
	});
	//Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	    modal.style.display = "none";
	}
}
