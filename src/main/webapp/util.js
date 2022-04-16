function checkWin(boardString) {
  let board = [
    ["", "", ""],
    ["", "", ""],
    ["", "", ""],
  ];

  let full = true;
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      let index = i * 3 + j;
      board[i][j] = boardString.charAt(index);
      if (boardString.charAt(index) == "0") {
        full = false;
      }
    }
  }

  // Check vertical
  for (let i = 0; i <= 2; i++) {
    // Check vertical
    if (
      board[i][0] === board[i][1] &&
      board[i][1] === board[i][2] &&
      board[i][0] != "0"
    ) {
      return board[i][0];
    }
    // Check horizontal
    if (
      board[0][i] === board[1][i] &&
      board[1][i] === board[2][i] &&
      board[0][i] != "0"
    ) {
      return board[0][i];
    }
  }

  // Check diagonals
  if (
    board[0][0] === board[1][1] &&
    board[2][2] === board[1][1] &&
    board[0][0] != "0"
  ) {
    return board[0][0];
  }

  if (
    board[0][2] === board[1][1] &&
    board[1][1] === board[2][0] &&
    board[0][2] != "0"
  ) {
    return board[0][2];
  }

  return full ? "tie" : "playing";
}

String.prototype.replaceAt = function (index, replacement) {
  return (
    this.substring(0, index) +
    replacement +
    this.substring(index + replacement.length)
  );
};
