let searchbydateButton = document.getElementById('searchbydate');
searchbydateButton.onclick = searchByDate;
window.onload = updateSearchByDate;

let searchbydateRequest = new XMLHttpRequest();

function updateSearchByDate(){
    searchbydateRequest.onreadystatechange = showSearchByDateResult;
    searchbydateRequest.send();
}


function searchByDate() {
    let date = document.getElementById("date").value;

    date = "date=" + encodeURIComponent(date);

    let information = "command=SearchByDate&" + date;

    searchbydateRequest.open("POST", "Controller", true);
    searchbydateRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
    searchbydateRequest.send(information);
}

function showSearchByDateResult() {
    if(searchbydateRequest.readyState === 4){
        if(searchbydateRequest.status === 200){
            let searchbydateresults = JSON.parse(searchbydateRequest.responseText);

            let searchbydateResult = document.getElementById("searchbydateResult")

            searchbydateResult.innerHTML = "";

            if (searchbydateResult.childNodes.length !== 0){
                while (searchbydateResult.firstChild){
                    searchbydateResult.removeChild(searchbydateResult.lastChild);
                }
            }

            searchbydateResult = fillSearchByDateTr(searchbydateResult,searchbydateresults);


        }
    }

    function fillSearchByDateTr(contactTable, contacts) {

        for (let i = 0; i < contacts.length; i++) {
            let contactTr = contactTable.childNodes[i];
            contactTr = document.createElement("tr");
            let firstName = document.createTextNode(contacts[i].firstName);
            let lastName = document.createTextNode(contacts[i].lastName);
            let dateValue = contacts[i].date;
            let day = dateValue.dayOfMonth;
            let month = dateValue.monthValue;
            let year = dateValue.year;
            let date = document.createTextNode(day + "-" + month + "-" + year);
            let room = document.createTextNode(contacts[i].room);
            let email = document.createTextNode(contacts[i].email);
            let gsm = document.createTextNode(contacts[i].gsm);


            let firstNameTd = contactTr.childNodes[0];
            let lastNameTd = contactTr.childNodes[1];
            let dateTd = contactTr.childNodes[2];
            let roomTd = contactTr.childNodes[3];
            let emailTd = contactTr.childNodes[4];
            let gsmTd = contactTr.childNodes[5];


            firstNameTd = document.createElement('td');
            firstNameTd.appendChild(firstName);
            contactTr.appendChild(firstNameTd);

            lastNameTd = document.createElement('td');
            lastNameTd.appendChild(lastName);
            contactTr.appendChild(lastNameTd);

            dateTd = document.createElement('td');
            dateTd.appendChild(date);
            contactTr.appendChild(dateTd);

            roomTd = document.createElement('td');
            roomTd.appendChild(room);
            contactTr.appendChild(roomTd);

            emailTd = document.createElement('td');
            emailTd.appendChild(email);
            contactTr.appendChild(emailTd);

            gsmTd = document.createElement('td');
            gsmTd.appendChild(gsm);
            contactTr.appendChild(gsmTd);

            contactTable.appendChild(contactTr)
        }
        return contactTable;
    }

}
