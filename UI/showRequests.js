var table = document.getElementById("myTable");
var tbody = table.getElementsByTagName("tbody")[0];

const getUrl = "http://localhost:10000/request/requests";
//let putUrl = "http://localhost:10000/request/request?";

const employeeId = 1;

document.addEventListener("DOMContentLoaded", (e) => {
    e.preventDefault();

    fetch(getUrl, {
        method: "GET",
    })
        .then((response) => response.json())
        .then(({ status, message, requests }) => {
            if (status) {
                for (var i = 0; i < requests.length; i++) {
                    var tr = document.createElement("tr");

                    var tdId = document.createElement("td");
                    console.log(requests[i].id);
                    tdId.innerHTML = requests[i].id;
                    tr.appendChild(tdId);

                    var tdDescription = document.createElement("td");
                    tdDescription.innerHTML = requests[i].description;
                    tr.appendChild(tdDescription);

                    var tdPriority = document.createElement("td");
                    tdPriority.innerHTML = requests[i].priority;
                    tr.appendChild(tdPriority);

                    var tdIssueType = document.createElement("td");
                    tdIssueType.innerHTML = requests[i].issueType;
                    tr.appendChild(tdIssueType);

                    var tdEdit = document.createElement("td");
                    var tdButton = document.createElement("button");

                    tdButton.setAttribute("type", "button");
                    tdButton.setAttribute('onclick', 'myFunction(' + JSON.stringify(Object.assign(requests[i], { employeeId: employeeId })) + ')');
                    tdButton.setAttribute("class", "myBtn");
                    tdButton.textContent = "Edit";

                    tdEdit.appendChild(tdButton);
                    tr.appendChild(tdEdit);

                    tbody.appendChild(tr);
                }
            }
        })
        .catch((error) => console.error(error));

})

let existingId = document.getElementById("id");
let existingDescription = document.getElementById("description");
let existingPriority = document.getElementById("priority");
let existingIssueType = document.getElementById("issueType");
const form = document.querySelector('#updateForm');

// Get the modal
var modal = document.querySelector(".modal");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
function myFunction(request) {
    console.log(request)
    modal.style.display = "block";
    existingId.value = request.id;
    existingDescription.value = request.description;
    existingPriority.value = request.priority;
    existingIssueType.value = request.issueType;
}

span.onclick = function () {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

form.addEventListener('submit', function (event) {
    event.preventDefault(); // prevent the default form submit action

    const formData = new FormData(form); // create a new FormData object with the form data
    const description = formData.get('description');
    const priority = formData.get('priority');
    const issueType = formData.get('issueType');
    const id = formData.get('id');

    console.log(description, priority, issueType, id);
    const putUrl = `http://localhost:10000/request/request?description=${description}&priority=${priority}&issueType=${issueType}&id=${id}&employeeId=${employeeId}`;

    fetch(putUrl, {
        method: "PUT",
    })
        .then((response) => response.json())
        .then((data) => {
            if (data.status) {
                alert(data.message);
            }
        })
        .catch((error) => console.error(error));
    modal.style.display = "none";
})



