// The Browser API key obtained from the Google Developers Console.
var developerKey = 'AIzaSyCKKv9zphjdS6ij536kE0hzxaMwP0_X9G0';

// The Client ID obtained from the Google Developers Console. Replace with your own Client ID.
var clientId = "167601974448-70tl9a7aamuq7dvfnpqevd6h3a6ojagk.apps.googleusercontent.com"

// Scope to use to access user's photos.
var scope = ['https://www.googleapis.com/auth/drive'];

var pickerApiLoaded = false;
var oauthToken;

// Use the API Loader script to load google.picker and gapi.auth.
function onApiLoad() {
    gapi.load('auth', {'callback': onAuthApiLoad});
    gapi.load('picker', {'callback': onPickerApiLoad});
}

function onAuthApiLoad() {
    window.gapi.auth.authorize(
            {
                'client_id': clientId,
                'scope': scope,
                'immediate': false
            },
    handleAuthResult);
}

function onPickerApiLoad() {
    pickerApiLoaded = true;
    createPicker();
}

function handleAuthResult(authResult) {
    if (authResult && !authResult.error) {
        oauthToken = authResult.access_token;
        createPicker();
    }
}



// Create and render a Picker object for picking user Photos.
function createPicker() {
    if (pickerApiLoaded && oauthToken) {
        var picker = new google.picker.PickerBuilder().
                addView(new google.picker.DocsUploadView()).
                setOAuthToken(oauthToken).
                setDeveloperKey(developerKey).
                setCallback(pickerCallback).
                build();
        picker.setVisible(true);
    }
}

// A simple callback implementation.
function pickerCallback(data) {
    var url = '';
    if (data[google.picker.Response.ACTION] == google.picker.Action.PICKED) {
        var doc = data[google.picker.Response.DOCUMENTS][0];
        url = doc[google.picker.Document.URL];
    }
    document.getElementById("form:link").value = url;    
}