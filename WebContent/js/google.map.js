
var map;
function initialize() {
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 12,
        center: new google.maps.LatLng(14.605501, 121.208969),
        mapTypeId: 'roadmap'
    });

    var iconBase = 'https://maps.google.com/mapfiles/kml/shapes/';
    var icons = {
        parking: {
            url: 'images/map-marker.png', //iconBase + 'parking_lot_maps.png'
            scaledSize: new google.maps.Size(50, 50)
        },
        library: {
            url: 'images/map-marker.png', //iconBase + 'library_maps.png'
            scaledSize: new google.maps.Size(50, 50)
        },
        info: {
            url: 'images/map-marker.png', //iconBase + 'info-i_maps.png'
            scaledSize: new google.maps.Size(50, 50)
        }
    };

    function addMarker(feature) {
        var marker = new google.maps.Marker({
            position: feature.position,

           // labelContent: "ABCD",
            labelAnchor: new google.maps.Point(15, 65),
            //labelClass: "labels", // the CSS class for the label
            labelInBackground: true,

            icon: icons[feature.type],
            map: map
        });

        var iw = new google.maps.InfoWindow({
            content: feature.tooltip
        });

        google.maps.event.addListener(marker, "click", function(e) {
            iw.open(map, this);
        });
    }

    var features = [{
        position: new google.maps.LatLng(14.587630, 121.176758),
        tooltip: 'Antipolo Cathedral',
        type: 'info' // Antipolo Cathedral
    }, {
        position: new google.maps.LatLng(14.594683, 121.167719),
        tooltip: 'Hinulugang Taktak',
        type: 'info' // Hinulugang Taktak
    }, {
        position: new google.maps.LatLng(14.613454, 121.154146),
        tooltip: 'Cloud 9, 360 View',
        type: 'info' // Cloud 9
    }, {
        position: new google.maps.LatLng(14.580940, 121.164216),
        tooltip: 'Pinto Art Museum',
        type: 'info' // Pinto Art Museum
    }, {
        position: new google.maps.LatLng(14.593332, 121.178683),
        tooltip: 'Casa Santa',
        type: 'info' // Casa Santa
    }, {
        position: new google.maps.LatLng(14.605532, 121.208615),
        tooltip: 'Mystical Cave',
        type: 'info' // Mystical Cave
    }, {
        position: new google.maps.LatLng(14.639507, 121.238257),
        tooltip: 'Boso Boso Church',
        type: 'info' // Boso Boso Church
    }, {
        position: new google.maps.LatLng(14.575089, 121.166807),
        tooltip: 'Bosay Resort',
        type: 'info' // Bosay
    }];

    for (var i = 0, feature; feature = features[i]; i++) {
        addMarker(feature);
    }
}

google.maps.event.addDomListener(window, 'load', initialize);
