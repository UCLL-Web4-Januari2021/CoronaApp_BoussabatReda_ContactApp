$(document).ready(function (){
    $("#addFriendButton").click(function (){
        $email = document.getElementById("email").value;
        $.post("Controller?command=Friends", {email:$email}, function (data){
            let firstName = data.firstName + " " + data.lastName;
            if (data.status !== true){
                var newParagraph = $('<p class="healthy" />').text(firstName);
                $('#friendList').append(newParagraph);
            }
            if (data.status === true){
                var newParagraph = $('<p class="sick" />').text(firstName);
                $('#friendList').append(newParagraph);
            }

        });
    });
});