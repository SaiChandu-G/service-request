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

                    tbody.appendChild(tr);
                }
            }
        })
        .catch((error) => console.error(error));


    // for (var i = 0; i < servcieRequests.length; i++) {
    //     var tr = document.createElement("tr");

    //     var id = document.createElement("td");
    //     id.innerHTML = servcieRequests[i].id;
    //     tr.appendChild(id);

    //     var description = document.createElement("td");
    //     description.innerHTML = servcieRequests[i].description;
    //     tr.appendChild(description);

    //     var priority = document.createElement("td");
    //     priority.innerHTML = servcieRequests[i].priority;
    //     tr.appendChild(priority);

    //     var issueType = document.createElement("td");
    //     issueType.innerHTML = servcieRequests[i].issueType;
    //     tr.appendChild(issueType);

    //     tbody.appendChild(tr);
    // }

    // table.appendChild(tbody)

})


// var data = [{ name: "John Doe", age: 30, city: "New York" }, { name: "Jane Doe", age: 28, city: "London" }, { name: "Jim Smith", age: 35, city: "Paris" }];

// for (var i = 0; i < data.length; i++) {
//     var tr = document.createElement("tr");

//     var tdName = document.createElement("td");
//     tdName.innerHTML = data[i].name;
//     tr.appendChild(tdName);

//     var tdAge = document.createElement("td");
//     tdAge.innerHTML = data[i].age;
//     tr.appendChild(tdAge);

//     var tdCity = document.createElement("td");
//     tdCity.innerHTML = data[i].city;
//     tr.appendChild(tdCity);

//     tbody.appendChild(tr);
// }