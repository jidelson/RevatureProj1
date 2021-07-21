const url = "http://localhost:8080/ers/managers/";

document.getElementById("all").addEventListener("click", viewAllFunction);
document.getElementById("statusFilter").addEventListener("click", filterFunction);
document.getElementById("submitReimb").addEventListener("click", submitReimbFunction);
document.getElementById("backBtn").addEventListener("click", backFunction);

async function viewAllFunction(){
    let response = await fetch(url + "all", {credentials: "include"});

    if(response.status === 200){
        console.log(response);
        let data = await response.json();
        
        for(let reimb of data){
            console.log(reimb);
            let theRow = document.createElement("tr");

            let cellData1 = document.createElement("td");
            cellData1.innerHTML = reimb.reimb_amount;
            theRow.appendChild(cellData1);

            let cellData2 = document.createElement("td");
            cellData2.innerHTML = reimb.reimb_submitted;
            theRow.appendChild(cellData2);

            let cellData3 = document.createElement("td");
            cellData3.innerHTML = reimb.reimb_description;
            theRow.appendChild(cellData3);

            let cellData4 = document.createElement("td");
            cellData4.innerHTML = reimb.reimb_author;
            theRow.appendChild(cellData4);

            let cellData5 = document.createElement("td");
            cellData5.innerHTML = reimb.reimb_resolver;
            theRow.appendChild(cellData5);

            if(reimb.reimb_status_id == 2){
                let cellData6 = document.createElement("td");
                cellData6.innerHTML = "Accepted";
                theRow.appendChild(cellData6);
            } else if(reimb.reimb_status_id == 3){
                let cellData6 = document.createElement("td");
                cellData6.innerHTML = "Rejected";
                theRow.appendChild(cellData6);
            } else {
                let cellData6 = document.createElement("td");
                cellData6.innerHTML = "Pending";
                theRow.appendChild(cellData6);
            }

            let cellData7 = document.createElement("td");
            switch(reimb.reimb_type_id){
                case 1:
                    cellData7.innerHTML = "Lodging";
                    break;
                
                case 2:
                    cellData7.innerHTML = "Travel";
                    break;

                case 3: 
                    cellData7.innerHTML = "Food";
                    break;
                
                case 4: 
                    cellData7.innerHTML = "Other";
                    break;
            }
            theRow.appendChild(cellData7);

            let cellData8 = document.createElement("td");
            cellData8.innerHTML = reimb.reimb_id;
            theRow.appendChild(cellData8);
            document.getElementById("managerTableBody1").appendChild(theRow);
        }
    }
}

async function filterFunction(){
    let filterInput = document.getElementById("statusFilterInput").value;

    let userInput = {
        reimb_status_id: filterInput
    };

    let response = await fetch(url + "filter", {
        method: "POST",
        body: JSON.stringify(userInput),
        credentials: "include"
    });

    if(response.status === 200){
        console.log(response);
        let data = await response.json();

        for(let reimb of data){
            console.log(reimb);
            let theRow = document.createElement("tr");

            let cellData1 = document.createElement("td");
            cellData1.innerHTML = reimb.reimb_amount;
            theRow.appendChild(cellData1);

            let cellData2 = document.createElement("td");
            cellData2.innerHTML = reimb.reimb_submitted;
            theRow.appendChild(cellData2);

            let cellData3 = document.createElement("td");
            cellData3.innerHTML = reimb.reimb_description;
            theRow.appendChild(cellData3);

            let cellData4 = document.createElement("td");
            cellData4.innerHTML = reimb.reimb_author;
            theRow.appendChild(cellData4);

            let cellData5 = document.createElement("td");
            cellData5.innerHTML = reimb.reimb_resolver;
            theRow.appendChild(cellData5);

            if(reimb.reimb_status_id == 2){
                let cellData6 = document.createElement("td");
                cellData6.innerHTML = "Accepted";
                theRow.appendChild(cellData6);
            } else if(reimb.reimb_status_id == 3){
                let cellData6 = document.createElement("td");
                cellData6.innerHTML = "Rejected";
                theRow.appendChild(cellData6);
            } else {
                let cellData6 = document.createElement("td");
                cellData6.innerHTML = "Pending";
                theRow.appendChild(cellData6);
            }

            let cellData7 = document.createElement("td");
            switch(reimb.reimb_type_id){
                case 1:
                    cellData7.innerHTML = "Lodging";
                    break;
                
                case 2:
                    cellData7.innerHTML = "Travel";
                    break;

                case 3: 
                    cellData7.innerHTML = "Food";
                    break;
                
                case 4: 
                    cellData7.innerHTML = "Other";
                    break;
            }
            theRow.appendChild(cellData7);

            let cellData8 = document.createElement("td");
            cellData8.innerHTML = reimb.reimb_id;
            theRow.appendChild(cellData8);
            document.getElementById("managerTableBody2").appendChild(theRow);
        }
    }
}

async function submitReimbFunction(){
    let reimbInput = document.getElementById("reimbIdInput").value;
    let statusResolveInput = document.getElementById("statusResolveInput").value;

    let userInput = {
        reimb_id: reimbInput,
        reimb_status_id: statusResolveInput
    };

    console.log(userInput);

    let response = await fetch(url + "resolve", {
        method: "POST",
        body: JSON.stringify(userInput),
        credentials: "include"
    });

    if(response.status == 200){
        document.getElementById("successMsg").style.display = "block";
    }
}

function backFunction(){
    window.location.href = "index.html";
}