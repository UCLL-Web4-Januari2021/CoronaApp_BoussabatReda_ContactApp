countPeopleButton = document.getElementById("countPeople");
countPeopleButton.onclick = countPeople;

async function countPeople(){

    let response  = await fetch("Controller?command=AmountPeople");
    let rooms = await response.json();
    showAmountPeople(rooms);
    await showAmountPeople;


    function showAmountPeople(rooms){
        let roomsTbody = document.getElementById("count")

        roomsTbody.innerHTML = "";
        for (let i = 0; rooms.length; i++){

            roomsTBody.innerHTML += "<tr>" +
                "<td>" + rooms[i].room + "</td>" + "</tr>";
        }
    }
}
