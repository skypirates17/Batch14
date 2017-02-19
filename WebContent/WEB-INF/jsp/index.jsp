
<%@ include file="_header.jspf" %>


    <nav class="fh5co-nav" role="navigation">
        <div class="container">
            <%@ include file="_navigation.jspf" %>
        </div>
    </nav>

    <header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url(images/img_bg_2.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <%@ include file="_banner.jspf" %>
        </div>
    </header>

    <div id="fh5co-couple">
        <div class="container">
        	<a name="hello"></a>
            <%@ include file="_couple.jspf" %>
        </div>
    </div>
    
     <div id="fh5co-counter" class="fh5co-bg fh5co-counter" style="background-image:url(images/img_bg_1.jpg);">
        <a name="count"></a>
        <div class="overlay"></div>
        <div class="container">
            <%@ include file="_counter.jspf" %>
        </div>
    </div>


    <div id="fh5co-couple-story">
		<a name="story"></a>
        <div class="container">
            <%@ include file="_story.jspf" %>
        </div>
    </div>


    <div id="fh5co-event" class="fh5co-bg dropshadow-bottom" style="background-image:url(images/img_bg_3.jpg);">
        <a name="events"></a>
        <div class="overlay"></div>
        <div class="container">
            <%@ include file="_event.jspf" %>
        </div>
    </div>

    <div id="fh5co-gallery" class="fh5co-section-gray">
    	<a name="antipolo"></a>
        <div class="container">
            <%@ include file="_gallery.jspf" %>
        </div>
    </div>

    <div id="fh5co-started" class="fh5co-bg" style="background-image:url(images/img_bg_4.jpg);">
    	<a name="location"></a>
        <div class="overlay"></div>
        <%@ include file="_map.jspf" %>

    </div>

    <div id="fh5co-testimonial">
    	<a name="messages"></a>
        <div class="container">
            <%@ include file="_testimonial.jspf" %>
        </div>
    </div>

<!--  
    <div id="fh5co-services" class="fh5co-section-gray">
        <div class="container">
            <%@ include file="_services.jspf" %>
        </div>
    </div>
-->

    <div id="fh5co-started" class="fh5co-bg dropshadow-bottom" style="background-image:url(images/img_bg_5.jpg);">
        <a name="form"></a>
        <div class="overlay" style="background: rgba(0, 0, 0, 0.65)"></div>
        <div class="container">
            <%@ include file="_form.jspf" %>
        </div>
    </div>

    <%@ include file="_footer.jspf" %>