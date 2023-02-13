var table = document.getElementById("myTable");
var tbody = table.getElementsByTagName("tbody")[0];

const url = "http://localhost:10000/request/requests";

document.addEventListener("DOMContentLoaded", (e) => {
    e.preventDefault();

    fetch(url, {
        method: "GET",
    })
        .then((response) => response.json())
        .then(({ status, message, requests }) => {
            if (status) {
                for (var i = 0; i < requests.length; i++) {
                    var tr = document.createElement("tr");

                    var tdId = document.createElement("td");
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
                    tdEdit.innerHTML = "Edit";
                    tr.appendChild(tdEdit);

                    tbody.appendChild(tr);
                }
            }
        })
        .catch((error) => console.error(error));

})


// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("myBtn");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal
btn.onclick = function () {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}



