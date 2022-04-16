// INIT FIREBASE
const firebaseConfig = {
  apiKey: "AIzaSyBK3seswLAY4rpSQ8hoNt5Xtsy4YVpNXl0",
  authDomain: "tictactoe-cc03f.firebaseapp.com",
  projectId: "tictactoe-cc03f",
  storageBucket: "tictactoe-cc03f.appspot.com",
  messagingSenderId: "447871283016",
  appId: "1:447871283016:web:0298add2d003b6f9be0d7d",
};
firebase.initializeApp(firebaseConfig);
const db = firebase.firestore();

// Data
const gameInfo = {};
let boardString = "000000000";
let player = "";
let currentTurn = "1";
let gameStatus = "";
let chatMessages = [];
let currentTheme = {};

// Setup button click handlers and UI element interactions
function setupUI() {
  const buttons = document.querySelectorAll("#game-board > button");
  buttons.forEach((btn) => {
    btn.onclick = () => place(btn.id);
  });

  document.getElementById("reset").onclick = () => resetGame();
  document.getElementById("send").onclick = () => sendChatMessage();
  document
    .getElementById("chat-input")
    .addEventListener("keyup", function (event) {
      if (event.key === "Enter") {
        sendChatMessage();
      }
    });
}

// Called whenever the user selects a box
function place(loc) {
  let row = Number(loc.charAt(0));
  let col = Number(loc.charAt(1));

  let index = row * 3 + col;

  if (boardString.charAt(index) != "0") return;
  if (player != currentTurn) return;
  if (gameStatus != "playing") return;

  boardString = boardString.replaceAt(index, player);

  const status = checkWin(boardString);

  db.collection("games")
    .doc(gameInfo.game)
    .update({
      current: player === "1" ? "2" : "1",
      board: boardString,
      status: status,
    })
    .then(() => {
      console.log("Move complete");
    })
    .catch((error) => {
      console.error("Error adding document: ", error);
    });
}

// Reset the game on the server
function resetGame() {
  db.collection("games")
    .doc(gameInfo.game)
    .update({
      board: "000000000",
      current: "1",
      status: "playing",
    })
    .then(() => {
      console.log("Game created");
    })
    .catch((error) => {
      console.error("Error adding document: ", error);
    });
}

// Runs whenever the game state has been updated on the server
function update(doc) {
  let data = doc.data();
  boardString = data.board;
  currentTurn = data.current;
  gameStatus = data.status;
  chatMessages = data.chatMessages;

  updateMarkers();

  // Update the chat
  let chatString = chatMessages
    .map((message) => {
      let playerId = message.charAt(0);
      let messageBody = message.substring(2);
      return "<b>" + playerId + ": </b>" + messageBody;
    })
    .join("<br>");
  const chatbox = document.getElementById("chatbox");
  chatbox.innerHTML = chatString;
  chatbox.scrollTop = chatbox.scrollHeight;

  const setStatus = (html) => {
    document.getElementById("statusbox").innerHTML = html;
  };

  // Check the game status
  if (gameStatus !== "playing") {
    // The game has ended
    if (data.status === "tie") {
      setStatus('<span style="color: gray">Draw</span>');
    } else {
      if (player === gameStatus) {
        // win
        setStatus('<span style="color: blue">You win!</span>');
      } else {
        // loss
        setStatus('<span style="color: red">You lost!</span>');
      }
    }
    document.getElementById("reset").className = "";
  } else {
    if (currentTurn === player) {
      setStatus("Your turn");
    } else {
      setStatus("Waiting for opponent...");
    }
    document.getElementById("reset").className = "hidden";
  }
}

// Update the game board markers
function updateMarkers() {
  // Update the board
  for (let i = 0; i <= 2; i++) {
    for (let j = 0; j <= 2; j++) {
      let index = i * 3 + j;
      let mark = boardString.charAt(index);
      if (mark === "1") {
        mark = currentTheme.marker1;
      } else if (mark === "2") {
        mark = currentTheme.marker2;
      } else {
        mark = "";
      }
      document.getElementById(`${i}${j}`).innerHTML = mark;
    }
  }
}

function listen(game) {
  // Wait for game to be created
  db.collection("games")
    .doc(game)
    .onSnapshot((doc) => {
      console.log("UPDATE");
      update(doc);
    });
}

// Sends a message in the chat
function sendChatMessage() {
  let message = document.getElementById("chat-input").value;
  document.getElementById("chat-input").value = "";
  if (!message) return;

  chatMessages.push(player + ":" + message);
  db.collection("games")
    .doc(gameInfo.game)
    .update({
      chatMessages,
    })
    .then(() => {
      console.log("Message sent");
    })
    .catch((error) => {
      console.error("Error sending message: ", error);
    });
}

function setupGame() {
  let query = window.location.search;
  let params = new URLSearchParams(query);
  gameInfo.player = params.get("user");
  gameInfo.game = params.get("game");
  gameInfo.verified = params.get("verified");
  gameInfo.isHost = params.get("isHost");

  if (!gameInfo.game || !gameInfo.isHost) {
    alert("Invalid URL setup.");
    return;
  }

  const { game, isHost } = gameInfo;
  player = isHost === "true" ? "1" : "2";
  console.log("PLAYING AS: " + player);

  // Create a new game in firebase
  if (isHost === "true") {
    // Create the game in firebase
    db.collection("games")
      .doc(game)
      .set({
        board: "000000000",
        current: "1",
        status: "playing",
        chatMessages: [],
      })
      .then(() => {
        console.log("Game created");
        listen(game);
      })
      .catch((error) => {
        console.error("Error adding document: ", error);
      });
  } else {
    listen(game);
  }
}

// Reskin the game board with the given theme
function configureTheme(theme) {
  currentTheme = theme;
  // Set page bg color
  document.querySelector("body").style["background-color"] =
    theme.backgroundColor;
  document.querySelector("body").style.color = theme.textColor;
  // Set board background color
  document.querySelector("#game-board").style["background-color"] =
    theme.boardColor;
  // Button color configurations
  document.querySelectorAll("#game-board > button").forEach((button) => {
    button.style["background-color"] = theme.buttonColor;
    button.addEventListener("mouseover", (event) => {
      event.target.style["background-color"] = theme.buttonColorHover;
    });
    button.addEventListener("mouseout", (event) => {
      event.target.style["background-color"] = theme.buttonColor;
    });
    button.addEventListener("mousedown", (event) => {
      event.target.style["background-color"] = theme.buttonColor;
    });
  });

  // Update current button markers
  updateMarkers();
}

// EXECUTION
configureTheme(THEMES[1]);
setupGame();
setupUI();
