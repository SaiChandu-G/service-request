
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const childUl = document.getElementById("childUl");

const childValues = [];

const parentPlus = document.querySelector(".fa-stack");
const inputField = document.getElementById("parentInput");
const inputFieldDiv = document.getElementById("parentInputDiv");

const addedValues = sessionStorage.getItem("childvalues");

let itemsArray;
if (addedValues) {
    itemsArray = addedValues.split(",");
}

if (itemsArray) {
    for (var i = 0; i < itemsArray.length; i++) {
        var li = document.createElement("li");
        li.innerHTML = `<div id="children${i + 1}" class="childDiv">
                           <div class="childInfo">
                              <p class="child-p">${itemsArray[i]}</p>
                              <div id="childInputDiv${i + 1}" class="inputChildHide">
                                 <input type="text" id="input${i + 1}" class="childInputField"/>
                                 <button id="button${i + 1}" class="childButton">Enter</button>
                              </div>
                           </div> 
                           <ol id="grandChildOl${i + 1}" class="gc"></ol>
                        </div>`
        childUl.appendChild(li);
    }
}

parentPlus.addEventListener("click", function () {
    console.log(inputFieldDiv.style.display === "none");
    if (inputFieldDiv.style.display === "block") {
        inputFieldDiv.style.display = "none";
    } else {
        inputFieldDiv.style.display = "block";
    }
});

document.getElementById("parentButton").addEventListener("click", () => {
    let value = inputField.value;
    if (value === undefined || value === "" || value === null || value.length === 0) {
        alert("enter a value")
    } else {
        let listSize = childUl.children.length;
        let childLi = document.createElement("li");
        childLi.innerHTML = `<div id="children${listSize + 1}" class="childDiv">
                                <div class="childInfo">
                                   <p class="child-p">${value}</p>
                                   <div id="childInputDiv${listSize + 1}" class="inputChildHide">
                                      <input type="text" id="input${listSize + 1}" class="childInputField"/>
                                      <button id="button${listSize + 1}" class="childButton">Enter</button>
                                   </div>
                                </div>
                                <ol id="grandChildOl${listSize + 1}" class="gc"></ol>
                            </div>`
        childValues.push(value);
        childUl.appendChild(childLi);
        inputField.value = "";
        inputFieldDiv.style.display = "none";
        if (addedValues) {
            var appendValues = [
                ...addedValues.split(",").map(value => value)
            ]
            sessionStorage.setItem("childvalues", [...appendValues, ...childValues]);
        }
        else {
            sessionStorage.setItem("childvalues", childValues);
        }
    }
});

var childElems = document.querySelectorAll(".childButton");

for (let i = 0; i < childElems.length; i++) {
    let grandChildOl = document.getElementById(`grandChildOl${i + 1}`);
    document.getElementById(`button${i + 1}`).addEventListener("click", function (e) {
        let inputValue = document.getElementById(`input${i + 1}`).value;
        if (inputValue === undefined || inputValue === "" || inputValue === null || inputValue.length === 0) {
            alert("enter a value")
        } else {
            let grandChildLi = document.createElement("li");
            grandChildLi.innerHTML = `<p id="grandChildren${i + 1}" class="grandChild-p">${inputValue}</p>`
            grandChildOl.appendChild(grandChildLi);
            document.getElementById(`input${i + 1}`).value = "";
        }
    })
}






/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


// // Define the canvas element and context
// const canvas = document.getElementById("canvas");
// const ctx = canvas.getContext("2d");

// // Set the canvas dimensions to the screen size
// canvas.width = window.innerWidth;
// canvas.height = window.innerHeight;

// // Define the node radius and spacing between nodes
// const radius = 20;
// const spacing = 50;

// // Define the binary tree data structure
// class Node {
//     constructor(value) {
//         this.value = value;
//         this.left = null;
//         this.right = null;
//     }
// }

// class BinaryTree {
//     constructor() {
//         this.root = null;
//     }

//     // Recursive function to add a new node to the tree
//     addNode(value, node) {
//         if (!node) {
//             return new Node(value);
//         }
//         if (value < node.value) {
//             node.left = this.addNode(value, node.left);
//         } else {
//             node.right = this.addNode(value, node.right);
//         }
//         return node;
//     }

//     // Function to draw a node
//     drawNode(x, y, value) {
//         ctx.beginPath();
//         ctx.arc(x, y, radius, 0, 2 * Math.PI);
//         ctx.stroke();
//         ctx.fillText(value, x, y);
//     }

//     // Function to draw a line between two nodes
//     drawLine(x1, y1, x2, y2) {
//         ctx.beginPath();
//         ctx.moveTo(x1, y1);
//         ctx.lineTo(x2, y2);
//         ctx.stroke();
//     }

//     // Recursive function to draw the tree
//     drawTree(node, x, y) {
//         if (!node) {
//             return;
//         }
//         // Draw the current node
//         this.drawNode(x, y, node.value);
//         // Draw the left and right children
//         const leftX = x - spacing;
//         const leftY = y + spacing;
//         this.drawTree(node.left, leftX, leftY);
//         if (node.left) {
//             this.drawLine(x, y + radius, leftX + radius, leftY - radius);
//         }
//         const rightX = x + spacing;
//         const rightY = y + spacing;
//         this.drawTree(node.right, rightX, rightY);
//         if (node.right) {
//             this.drawLine(x, y + radius, rightX - radius, rightY - radius);
//         }
//     }

//     // Function to add a new node to the tree and redraw it
//     addAndDrawNode(value) {
//         this.root = this.addNode(value, this.root);
//         this.drawTree(this.root, canvas.width / 2, spacing);
//     }
// }

// // Create a new binary tree
// const tree = new BinaryTree();

// // Add some initial nodes
// tree.addAndDrawNode(5);
// tree.addAndDrawNode(3);
// tree.addAndDrawNode(7);
// tree.addAndDrawNode(2);
// tree.addAndDrawNode(4);
// tree.addAndDrawNode(6);
// tree.addAndDrawNode(8);

// // Add event listener to the "Add Node" button
// const addNodeButton = document.getElementById("add-node-input");
// addNodeButton.addEventListener("change", (e) => {
//     // const value = prompt("Enter a value:");
//     // if (value) {
//         tree.addAndDrawNode(parseInt(addNodeButton.value))
//         //console.log(addNodeButton.value)
//         addNodeButton.value=""
//         // Add the new node and redraw the tree
//         //tree.addAndDrawNode(parseInt(value));
//     //}
// })

