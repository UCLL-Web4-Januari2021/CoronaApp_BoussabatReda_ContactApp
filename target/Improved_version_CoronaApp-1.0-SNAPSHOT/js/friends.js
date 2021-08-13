$(document).ready(function (){
    $("#addFriendButton").click(function (){
        $email = document.getElementById("email").value;
        $.post("Controller?command=Friends", {email:$email}, function (data){
            let firstName = data.firstname + " " + data.lastname;

            if (data.positive !== true) {
                var newParagraph = $('<p class="healthy" />').text(firstName);
                $('#friendList').append(newParagraph);
                positiveCount();
            }
            if (data.positive === true) {
                var newParagraph = $('<p class="sick" />').text(firstName);
                $('#friendList').append(newParagraph);
                negativeCount();
            }
        });
    });
});

function positiveCount(){
    var positiveCount = document.getElementById('positiveCount');
    var count = positiveCount.innerHTML;
    count++;
    positiveCount.innerHTML = count;
}

function negativeCount(){
    var negativeCount = document.getElementById('negativeCount');
    var count = negativeCount.innerHTML;
    count++;
    negativeCount.innerHTML = count;
}
