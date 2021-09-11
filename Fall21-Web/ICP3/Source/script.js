const userChoice = document.getElementById("scissor").onclick; //user choice
prompt(userChoice)

let computerChoice = Math.random();                         //computer choice
if (computerChoice < 0.34) {
    computerChoice = "rock";
} else if(computerChoice <= 0.67) {
    computerChoice = "paper";
} else {
    computerChoice = "scissors";
}
if( userChoice == computerChoice ){
    alert("Both are matched")
}