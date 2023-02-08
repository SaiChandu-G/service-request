// input fields
const description = document.querySelector("#description");
const priorityLevel = document.querySelector("#priorityLevel");
const issueType = document.querySelector("#type");

// button
const button = document.querySelector(".create");

// labels
const descriptionError = document.getElementById("descriptionError");
const priorityLevelError = document.getElementById("priorityLevelError");
const issueTypeError = document.getElementById("issueTypeError");

// Request Object
const requestObj = {};

// employee ID
const employeeId = 1;

button.addEventListener("click", (e) => {
    e.preventDefault();
    if (description.value === "") {
        descriptionError.innerText = "Please enter description";
        return;
    }
    if (priorityLevel.value === "") {
        priorityLevelError.innerText = "Please enter priority level";
        return;
    }
    if (issueType.value === "") {
        issueTypeError.innerText = "Please enter issue type";
        return;
    }

    let url = "http://localhost:10000/request/create?";

    requestObj.description = description.value;
    requestObj.priorityLevel = priorityLevel.value;
    requestObj.issueType = issueType.value;

    const newRequestObj = Object.assign({ employeeId: employeeId }, requestObj);

    // log object to console
    console.log(newRequestObj);

    Object.keys(newRequestObj).forEach((key) => {
        url += key + "=" + newRequestObj[key] + "&";
    });

    fetch(url, {
        method: "POST",
    })
        .then((response) => response.json())
        .then((data) => {
            if (data.status) {
                alert(data.message);
            }
        })
        .catch((error) => console.error(error));

    description.value = "";
    priorityLevel.value = "";
    issueType.value = "";
});

const handleDescription = (val) => {
    if (val.trim().length > 0) descriptionError.innerText = "";
};

const handlePriority = (val) => {
    if (val.trim().length > 0) priorityLevelError.innerText = "";
};

const handleIssueType = (val) => {
    if (val.trim().length > 0) issueTypeError.innerText = "";
};
