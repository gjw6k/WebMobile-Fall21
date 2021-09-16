function getGithubInfo(user) {

    //1. Create an instance of XMLHttpRequest class and send a GET request using it.
    // The function should finally return the object(it now contains the response!)
    const xhttp = new XMLHttpRequest();
    var url = "https://api.github.com/users/"+user;
    xhttp.open("GET",url);
    xhttp.onload = function () {
        if (xhttp.status == 200) {
            showUser(JSON.parse(xhttp.responseText));
            //else display error message
        } else if (xhttp.status == 404) {
            noSuchUser(user);
        }
    };
    xhttp.send();
}

function showUser(user) {
    //2. set the contents of the h2 and the two div elements in the div '#profile' with the user content
    $("#profile").text(user.username);
   $(".information").html("<label>UserName: </label>"+user.name +
       "<br/><label>Id: </label>"+user.id
       +"<br/>"
       +"<br/><label>Profile Picture: </label><br/><img src='"+user.avatar_url+"' height='200' width='200'>"
       +"<br/>"
   +"<br/><label>Link to URL: </label>" + "var link = <a target='_blank' href='"+user.html_url+"'>'"+user.html_url+"'</a>");

}

function noSuchUser(username) {
    //3. set the elements such that a suitable message is displayed
    $(".information").text("No user found");
}

$(document).ready(function () {
    $(document).on('keypress', '#username', function (e) {
        //check if the enter(i.e return) key is pressed
        if (e.which == 13) {
            //get what the user enters
            username = $(this).val();
            //reset the text typed in the input
            $(this).val("");
            //get the user's information and store the respsonse
            response = getGithubInfo(username);
            //if the response is successful show the user's details
            if (response.status == 200) {
                showUser(JSON.parse(response.responseText));
                //else display suitable message
            } else {
                noSuchUser(username);
            }
        }
    })
});
