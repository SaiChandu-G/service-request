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

button.addEventListener("click", e => {
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
    requestObj.description = description.value;
    requestObj.priorityLevel = priorityLevel.value;
    requestObj.issueType = issueType.value;
    console.log(requestObj);
    description.value = "";
    priorityLevel.value = "";
    issueType.value = "";
});

const handleDescription = (val) => {
    if (val.trim().length > 0) descriptionError.innerText = "";
}

const handlePriority = (val) => {
    if (val.trim().length > 0) priorityLevelError.innerText = "";
}

const handleIssueType = (val) => {
    if (val.trim().length > 0) issueTypeError.innerText = "";
}

