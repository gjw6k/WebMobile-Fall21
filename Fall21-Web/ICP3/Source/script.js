var userChoice;
function reply_click(obj) {
    userChoice = obj.id;
    const computerChoice = ["rock", "paper", "scissors"][Math.floor(Math.random() * 3)];

    let compare = function (choice1, choice2) {                // written a function for comparing values
        if (choice1 === choice2) {
            alert("Both matched");
        }
        if (choice1 === "rock") {
            if (choice2 === "scissors") {
                alert("You selected rock and computer selected scissors");
                alert("You Won");
            } else {
                alert("You selected rock and computer selected paper")
                alert("Computer Won");
            }
        }
        if (choice1 === "paper") {
            if (choice2 === "rock") {
                alert("You selected paper and computer selected rock");
                // paper wins
                alert( "You Won");
            } else {
                // scissors wins
                alert("You selected paper and computer selected scissors")
                alert("Computer Won");
            }
        }
        if (choice1 === "scissors") {
            if (choice2 === "rock") {
                alert("You selected scissors and computer selected rock");
                // rock wins
                alert("Computer Won");
            } else {
                // scissors wins
                alert("You selected scissors and computer selected paper")
                alert("You Won");
            }
        }
    }
//document.write("<p>User Choice:" + " " + userChoice + "</p>");
//document.write("<p>Computer Choice:" + " " + computerChoice + "</p>");        // displaying values
    compare(userChoice, computerChoice);
}