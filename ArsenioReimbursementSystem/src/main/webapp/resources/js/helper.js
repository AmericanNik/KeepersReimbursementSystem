///Global Declarations

let myUsersSessionState = {};

let myUserReimbursements = {};

let allReimbursements ={};

window.onload = function(){
   
    try {
        
        document.getElementById("getMyReimbSubmit").addEventListener('click', getUsersReimbursements);
    } catch (error) {
        console.log(error)
    }

    getUserSession();


}

    ////AJAX call to get the users session. 

function getUserSession(){
        console.log("in user session")
        //step 1: create XMLHttpRequest object
        let xhttp = new XMLHttpRequest();
        //step 2: create the callback function for readystate changes
        xhttp.onreadystatechange = function(){

            try {
                
                if(xhttp.readyState ==4 && xhttp.status==200){
    
                    let session = JSON.parse(xhttp.responseText)
                    console.log(session)
                    myUsersSessionState = session;
                    ourWelcomeDomManipulation(session);
                }
            } catch (error) {
                console.log("user not logged in yet")
            }

        }

        //step 3: create and open a connection
        xhttp.open("GET","http://localhost:9006/ArsenioReimbursementSystem/ses")

        //step 4: send the request

        xhttp.send();

    }



   //only Ajax calls we'll need:
   //one to update reimbursement
   //one to get user info

function getAllReimbursements(){
    console.log("In reimbursement function")

    //Step 1:
    let xhttp = new XMLHttpRequest();
    
    //Step 2:

    xhttp.onreadystatechange = function(){ //notice it is not camel case
        if(xhttp.readyState == 4 && xhttp.status==200){
            console.log("readyState is 4");
    
            let reimbursements = JSON.parse(xhttp.responseText);
            allReimbursements = reimbursements
            viewAllReimbursements(reimbursements);   
        }
    }

    //Step 3:
    xhttp.open("GET","http://localhost:9006/ArsenioReimbursementSystem/json/getAllReimbursements");
    //Step 4:
    xhttp.send()
}



function ourReimbManipulation(ourJSON){

    if(ourJSON == null){
        alert("Did not return anything! " + ourJSON)
    }

}


let commonFunction = function(something){
    console.log("Common FunctioN!" +something);
}

let getUsersReimbursements = function(userJSON){
    
    userJSON.preventDefault();

    document.getElementById("reimbDisplay")
    
    if(userJSON == null){
        alert("Did not return anything! " + ourJSON)
    }
    


    console.log("in user session")
    //step 1: create XMLHttpRequest object
    let xhttp = new XMLHttpRequest();
    //step 2: create the callback function for readystate changes
    xhttp.onreadystatechange = function(){

        if(xhttp.readyState ==4 && xhttp.status==200){

            let reimbursements = JSON.parse(xhttp.responseText)
            console.log(reimbursements)
            myUsersReimbursements = reimbursements
            displayMyReimbursements(reimbursements);
        }
    }

    //step 3: create and open a connection
    xhttp.open("GET","http://localhost:9006/ArsenioReimbursementSystem/json/getmyreimbursements")

    //step 4: send the request

    xhttp.send();



}//end of getUsersReimbursements()


//Filters through ALL REIMBURSEMENTS and shows the selected one.

function showThisReimbId (reimbId){
    //assigns userId to variable
    let selectedReimbId = reimbId.srcElement.id

    console.log("Flagg!!")
    console.log(selectedReimbId)
    //for each loop through each reimbusement
   myUsersReimbursements.forEach(reimbursement =>{
        //if selected ID equals this iterations reimbusement Id, it displays to screen.
       if(reimbursement.reimbId == selectedReimbId){
           console.log(reimbursement);
           displayInReimbDisplay(reimbursement);
       }

   })   
}
/////////////////////////////////////////////////////////////////////////////YOU LEFT OFF HERE!!!!

function showAllReimb(reimbId){

    let selectedReimbId = reimbId.srcElement.id

    console.log("Flagg!!")
    console.log(selectedReimbId)
    //for each loop through each reimbusement
   allReimbursements.forEach(reimbursement =>{
        //if selected ID equals this iterations reimbusement Id, it displays to screen.
       if(reimbursement.reimbId == selectedReimbId){
           console.log(reimbursement);
           displayInReimbDisplay(reimbursement);
       }

   })   

}



///Filters through all USER reimbursements and shows the selected one

function showThisUsersReimbId (reimbId){
    //assigns userId to variable
    let selectedReimbId = reimbId.srcElement.id

    console.log("Flagg!!")
    console.log(selectedReimbId)
    //for each loop through each reimbusement
   myUsersReimbursements.forEach(reimbursement =>{
        //if selected ID equals this iterations reimbusement Id, it displays to screen.
       if(reimbursement.reimbId == selectedReimbId){
           console.log(reimbursement);
           displayInReimbDisplay(reimbursement);
       }

   })   
}
/////////////////////////////////////////////////////////////////////////////////////////////////////
////////////DISPLAY IN REIMB DISPLAY

function displayInReimbDisplay(reimbursement){

    document.getElementById('reimbDisplay').innerHTML ='';

    //////get reimbursement status. & reimbursement type & timestamp
    let reimbursementStatus;
    let reimbursementType;

    switch(reimbursement.reimbStatusId){
        case 0:
            reimbursementStatus = "PENDING";
            break;
        case 1:
            reimbursementStatus = "APPROVED";
            break;
        case 2:
            reimbursementStatus = "DENIED";
            break;
        
    }

    //Get & set request type
    switch(reimbursement.reimbTypeId){

        case 0:
            reimbursementType = "LODGING";
            break;
        case 1:
            reimbursementType = "FOOD";
            break;
        case 2:
            reimbursementType = "TRANSPORTATION";
            break;
        case 3:
            reimbursementType = "OTHER";
            break;
    }


    let displaySingleReimb = document.createElement("div");

    //creating reimbursmenet display header of approve/deny/pending
    displaySingleReimb.setAttribute("class","reimbSingleDisplay");
    displaySingleReimb.innerHTML= `<div class="singleReimbHeading" ><h3> REIMBURSEMENT STATUS:  ${reimbursementStatus}  </h3></div>`;

    //Get the reimbDisplay
    let reimbDisplay = document.querySelector("#reimbDisplay");


    // displaying the data to 
    displaySingleReimb.innerHTML += `<div class="singleReimbBody">
    
    <p><b>Request Author:</b> ${reimbursement.authorFirstName} ${reimbursement.authorLastName}</p>
    <p><b>Request Amount:</b> ${reimbursement.reimbAmount}</p>
    <p><b>Request Type: </b> ${reimbursementType}</p>
    <p><b>Request Submitted:</b> ${new Date(reimbursement.reimbSubmitted)}</p>
    <p><b>Request Decided:</b> ${reimbursement.reimbResolved ==null ? " PENDING ":new Date(reimbursement.reimbResolved)}</p>
    <div class="singleReimbDescription">
    <p><b>Reimbursement Description:</b></p>
    <p>${reimbursement.reimbDescription}</p>
    </div>
    
    </div>`;

    //add the new div to reimbDisplay
    reimbDisplay.appendChild(displaySingleReimb);

    //if user is an admin they'll get an additional approve/deny buttons
console.log("USER ACCESS LEVEL: " + myUsersSessionState.userRoleId);
    if(myUsersSessionState.userRoleId ==0 && reimbursement.reimbStatusId==0){
    console.log("Adding Buttons!")

        let approveButton = document.createElement("button");
        let denyButton = document.createElement("button");

        approveButton.innerText="Approve Reimbursement"
        denyButton.innerText="Deny Reimbursement"

        //setting id
        approveButton.setAttribute("id", reimbursement.reimbId);
        denyButton.setAttribute("id", reimbursement.reimbId);

        //setting class
        approveButton.setAttribute("class","approveButton ui button positive");
        denyButton.setAttribute("class","denyButton ui button negative");


        

        approveButton.addEventListener('click', approveReimbursement);
        denyButton.addEventListener("click", denyReimbursement);

        console.log(approveButton);
        console.log(denyButton)
        reimbDisplay.appendChild(approveButton)
        reimbDisplay.appendChild(denyButton);
    }




}

//////////SUBMIT REVIEW
 function submitReview (judgement, reimbursementId){

    console.log(judgement)
    console.log(reimbursementId)
    console.log("YOU HAVE " + (judgement==1? "BEEN APPROVED!":"BEEN DENIED"));

    let judgementObj = {
        "reimbStatusId" : judgement,
        "reimbId" : reimbursementId
    }
    console.log(reimbursementId)
    console.log("------")
    console.log(judgementObj);
//////////////////



//////////////////////
var xhr = new XMLHttpRequest();
xhr.open("POST", "http://localhost:9006/ArsenioReimbursementSystem/json/judgeReimbursement", true);
xhr.setRequestHeader('Content-Type', 'application/json');
xhr.send(JSON.stringify(judgementObj));

}

//approve/deny functions

function approveReimbursement(reimbursement){
    console.log("Approving Reimbursement!!");
    console.log(reimbursement.srcElement.id);

    document.getElementById('reimbDisplay').innerHTML ='';

    /////Submit ID to be approved

    console.log("!!!!!!")
    submitReview(1, reimbursement.srcElement.id);

    ////////Display approval notification
    let approveNotification = document.createElement("h3");
    approveNotification.setAttribute("class","evaluationMessage")
    approveNotification.innerText="Reimbursement Approved.";
    reimbDisplay.appendChild(approveNotification);

    

}

function denyReimbursement(reimbursement){

    document.getElementById('reimbDisplay').innerHTML ='';

    ///////////Display denial to screen
    let denyNotification = document.createElement("h3");
    denyNotification.setAttribute("class","evaluationMessage")
    denyNotification.innerText="Reimbursement Denied.";

    /////submit id to be denied

    submitReview(2, reimbursement.srcElement.id);

    ////

    console.log("Denying Reimbursement!!");
    console.log(reimbursement.srcElement.id);

    reimbDisplay.appendChild(denyNotification);
}

////////////////submit reimbursement

let submitReimbursement = function(event){
    event.preventDefault();

    ///gets query to clear display
    let reimbDisplay = document.querySelector('#reimbDisplay');

    reimbursementPayload = {
        reimbAmount: event.srcElement[0].value,
        reimbDescription: event.srcElement[1].value,
        reimbTypeId: 0,
        reimbAuthor: myUsersSessionState.userId
    }


    ///checks to see which reimbursement radio button is selected
    for(i=2;i<=5; i++){
        if(event.srcElement[i].checked ==true){
            console.log("Reimb Type: " + event.srcElement[i].value);
            reimbursementPayload.reimbTypeId = event.srcElement[i].value;
        }
    };


    //submits new reimbursement payload

    var xhr = new XMLHttpRequest();
xhr.open("POST", "http://localhost:9006/ArsenioReimbursementSystem/json/submitreimbursement", true);
xhr.setRequestHeader('Content-Type', 'application/json');
xhr.send(JSON.stringify(reimbursementPayload));

    console.log("payload:")
    console.log(reimbursementPayload)
    console.log("Submitted!");


    reimbDisplay.innerHTML='<h3>Your Reimbursement Was Successfully Submitted</h3>';

}

///////////////create new reimbursement function

let createReimbursement = function(){
    console.log("Clicked create reimbursement!");
    
    document.getElementById('reimbDisplay').innerHTML='';


    let reimbDisplay = document.querySelector('#reimbDisplay');
    let displayForm = document.createElement('form');

    //creating linebreak
    let lineBreak = document.createElement('br');
    
    //adding event listener to the form to handle the submit
    displayForm.addEventListener('submit', submitReimbursement)

    displayForm.setAttribute('class','newReimbursementForm');
    displayForm.setAttribute("id", "newReimbursementForm")
    
    //creating a heading for the form inputs
    reimbAmountHeader =document.createElement("h3");
    reimbAmountHeader.innerText="Reimbursement Total Requested:"

    displayForm.appendChild(reimbAmountHeader);


    //creating the reimb amount
    let reimbAmount = document.createElement('input')
    reimbAmount.type='number';
    reimbAmount.name="reimbNumb";
    reimbAmount.setAttribute("step","any")
    reimbAmount.setAttribute("class","ui input large")
    reimbAmount.setAttribute("label","Reimbursement Amount Requested:");
    reimbAmount.appendChild(lineBreak);

    //creating a heading for the description input
    reimbDescHeader =document.createElement("h3");
    reimbDescHeader.innerText="Reimbursement Description:"
    
    //creating the reimbDescription
    let reimbursementDescription = document.createElement('input');

    reimbursementDescription.type = 'TEXTAREA';
    reimbursementDescription.name = 'reimbDescription';
    reimbursementDescription.setAttribute("class","ui input large")
    reimbursementDescription.appendChild(lineBreak);

    //creating radio buttons

    let reimbTypeSelection = document.createElement('div')
    reimbTypeSelection.setAttribute("class","radioSelection")
    reimbTypeSelection.innerHTML = '<input type="radio" name="reimbType" value="0">Lodging</input><br><input type="radio" name="reimbType" value="1">Travel</input><br><input type="radio" name="reimbType" value="2">Food</input><br><input type="radio" name="reimbType" value="3">Other</input><br>';


    //radio button header
    let reimbTypeHeader =document.createElement("h3");
    reimbTypeHeader.innerText="Reimbursement Type:"

    //creating reimbSubmit button
    let submitReimb = document.createElement("input")
    submitReimb.type='submit';
    submitReimb.name="submitReimbButton";
    submitReimb.setAttribute("class","ui button positive submitReimb")
    
    //appending all the stuffs onto the form
    displayForm.appendChild(reimbAmount);
    displayForm.appendChild(reimbDescHeader);
    displayForm.appendChild(reimbursementDescription);
    displayForm.appendChild(lineBreak);
    displayForm.appendChild(reimbTypeHeader);
    displayForm.appendChild(reimbTypeSelection)
    displayForm.appendChild(lineBreak);
    displayForm.appendChild(submitReimb);


    reimbDisplay.appendChild(displayForm);






}

///////////////view all reimbursements function

let viewAllReimbursements = function(reimbursements){

    console.log("Admin View All Options Button Clicked!");
    console.log(reimbursements)

    

    document.getElementById('reimbDisplay').innerHTML ='';

    let reimbDisplay = document.querySelector("#reimbDisplay");
    let displayTable = document.createElement("table");
    displayTable.setAttribute("class","reimbursementsTable");
    displayTable.innerHTML="<th>Reimbursements</th>"
    
    reimbDisplay.appendChild(displayTable)


    reimbursements.forEach(elem=>{

        console.log(elem);

/////////////
    let newTableRow = document.createElement("TR")
    let newDiv = document.createElement("div");

    newDiv.id=elem.reimbId;
    //newDiv.setAttribute("onClick","showThisReimbId");

    //step 3: create a text node then append to our new div

    let submittedDate = new Date( elem.reimbSubmitted).toString();
    let resolvedDate = new Date(elem.reimbResolved).toString();

    

    let divText = document.createTextNode("ID: " + elem.reimbId + " $" + elem.reimbAmount +" submitted: " +submittedDate.slice(0,15)  +" Status: " +elem.reimbStatusId );

    //setting background color. Approved = Green, pending=yellow, denied = red.
    statusColorStyle = "";
    //tag for the UI css
    statusColorStyleTag = "";

    if(elem.reimbStatusId==0){
        statusColorStyle = "background-color: yellow;"
        statusColorStyleTag = "yellow";
    }else if(elem.reimbStatusId==1){
        statusColorStyle = "background-color: green;"
        statusColorStyleTag = "green";
    }else{
        statusColorStyle="background-color:red;"
        statusColorStyleTag = "red";
    }

    //Setting class attributes
    newDiv.setAttribute("class",`newReimbDiv ${statusColorStyleTag} ui button`);


    // newTableRow.setAttribute("style", statusColorStyle);


    //step 4: appending the child 
    newDiv.appendChild(divText);

    //Get the reimbDisplay
    //let reimbDisplay = document.querySelector("#reimbDisplay");
    //add an event listener
    newDiv.addEventListener('click',showAllReimb);
    //add the new div to reimbDisplay
    newTableRow.appendChild(newDiv)
    displayTable.appendChild(newTableRow)
    //reimbDisplay.appendChild(newDiv);
    //document.getElementById(elem.reimbId).addEventListener('click', showThisReimbId);
    //////////
    })

}




/////////////////////Displays all users reimbursements to reimbDisplay
function displayMyReimbursements(reimbursements){
    
    
    document.getElementById('reimbDisplay').innerHTML ='';

    let reimbDisplay = document.querySelector("#reimbDisplay");
    let displayTable = document.createElement("table");
    displayTable.setAttribute("class","reimbursementsTable");
    displayTable.innerHTML="<th>My Reimbursements</th>"
    
    reimbDisplay.appendChild(displayTable)


    reimbursements.forEach(elem =>{
        // console.log(elem)
       
        //////////
        let newTableRow = document.createElement("TR")
        let newDiv = document.createElement("div");
    
        newDiv.id=elem.reimbId;

        statusColorStyleTag = "";

        if(elem.reimbStatusId==0){
           
            statusColorStyleTag = "yellow";
        }else if(elem.reimbStatusId==1){

            statusColorStyleTag = "green";
        }else{
            statusColorStyleTag = "red";
        }
    

        newDiv.setAttribute("class",`newReimbDiv ui button ${statusColorStyleTag}`);

        let submittedDate = new Date( elem.reimbSubmitted).toString();
        let resolvedDate = new Date(elem.reimbResolved).toString();
    
        
    
        let divText = document.createTextNode("ID: " + elem.reimbId + " Total: $" + elem.reimbAmount +" submitted: " +submittedDate.slice(0,15) + " resolved: " +resolvedDate.slice(0,15) +" Status: " +elem.reimbStatusId + " Type: " + elem.reimbTypeId);
        //step 4: appending the child 
        newDiv.appendChild(divText);
    
        //Get the reimbDisplay
        //let reimbDisplay = document.querySelector("#reimbDisplay");
        //add an event listener
        newDiv.addEventListener('click',showThisUsersReimbId);
        //add the new div to reimbDisplay
        newTableRow.appendChild(newDiv)
        displayTable.appendChild(newTableRow)


    })


}

let logoutUser = function(){

    console.log("Logging out!")

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:9006/ArsenioReimbursementSystem/ses", true);

    xhr.send();

    window.location.replace("/ArsenioReimbursementSystem/");

}


function ourWelcomeDomManipulation(userJSON){

    commonFunction("Get users reim");

    try {
        document.getElementById("userWelcomeHeading").innerText = "Welcome " + userJSON.userFirstName;
        //if Role = 0 return Admin, else return Employee
        document.getElementById("userAccessLevel").innerText = (userJSON.userRoleId ==0 ? "Admin" : "Employee");

        //customize navbar to the specific user

        //Create & append logout button
        let logoutButton = document.createElement("button");

        logoutButton.setAttribute("class","logoutButton ui button primary");
        logoutButton.setAttribute("id","logoutButton")
        logoutButton.innerText="Logout";
        //adding event handler to logout button
        logoutButton.addEventListener('click', logoutUser)

        let navOptions = document.getElementById('rightNav');

        navOptions.appendChild(logoutButton);


    
        if(userJSON.userRoleId==0){
    
            
            //append a button to allow the admin to view all reimbursements and approve/disapprove a reimbursement. 
            let viewAllReimbursementsButton = document.createElement("button");
            viewAllReimbursementsButton.setAttribute("class","viewAllButton ui standard  button");
            //creating reimbursmenet display header of approve/deny/pending
            viewAllReimbursementsButton.innerText = 'View All Reimbursements';
    ;
        
            //Get the reimbDisplay
            let reimbOptions = document.querySelector("#userOptions");
            //add event listener for the view all reimbursements
            viewAllReimbursementsButton.addEventListener("click", getAllReimbursements );
    
            //add the admin button to display
            reimbOptions.appendChild(viewAllReimbursementsButton);

        }else{
            //append a button to allow a customer to create a reimbursement
            let createReimbursementButton = document.createElement("button");
            createReimbursementButton.setAttribute("class","createReimbursement ui button positive");
            //putting text into the button
            createReimbursementButton.innerText="Request New Reimbursement";
            //add event listener to trigger create reimbursement function
            createReimbursementButton.addEventListener("click",createReimbursement)
            //get reimb display
            let reimbOptions = document.querySelector("#userOptions");
            //create reimbursement form and place it to reimbDisplay
    

            reimbOptions.appendChild(createReimbursementButton);
        }

        
    } catch (error) {
        console.log("User not logged in yet!")
    }



}

