window.onload = updateTwenty;

let registerButton = document.getElementById('registerButton');
registerButton.onclick = addContact;


let updateTwentyRequest = new XMLHttpRequest();

let newContactRequest = new XMLHttpRequest();

function updateTwenty() {
    updateTwentyRequest.open("GET", "Controller?command=Home", true);
    updateTwentyRequest.onreadystatechange = showTwenty;
    updateTwentyRequest.send();
}

function showTwenty() {
    if (updateTwentyRequest.readyState === 4) {
        if (updateTwentyRequest.status === 200) {
            let contacts = JSON.parse(updateTwentyRequest.responseText);
            let contactsTable = document.getElementById("twenty");
            contactsTable.innerHTML = "";

            if (contactsTable.childNodes.length !== 0) {
                while (contactsTable.firstChild) {
                    contactsTable.removeChild(contactsTable.lastChild);
                }
            }
            contactsTable = fillContactTr(contactsTable, contacts);
            setTimeout(updateTwenty, 1000);
            document.getElementById("countRegistered").innerHTML = "Amount registered contacts: " + contacts.length;
        }
    }
}

function fillContactTr(contactTable, contacts) {

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

function addContact() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let date = document.getElementById("date").value;
    let room = document.getElementById("room").value;
    let gsm = document.getElementById("gsm").value;

    // Parameter moet & voor hebben staan

    firstName = "firstName=" + encodeURIComponent(firstName);
    lastName = "lastName=" + encodeURIComponent(lastName);
    date = "date=" + encodeURIComponent(date);
    room = "room=" + encodeURIComponent(room);
    gsm = "gsm=" + encodeURIComponent(gsm);


    let information = "command=RegisterContact&" + firstName + "&" + lastName + "&" + date + "&" + room + "&" + gsm;
    newContactRequest.open("POST", "Controller", true);
    newContactRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
    newContactRequest.send(information);
}
