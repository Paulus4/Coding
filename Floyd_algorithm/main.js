let n = 4;
let initialArray = [
    0,   1, 999, 999, 
  999,   0,   1,   1, 
  999, 999,   0,   1, 
    1, 999, 999,   0,
];

console.log("Initial array:");
print2dArray(initialArray);

console.log("\nResult: ");
floyd(initialArray);

// for r := 1 to n do:
//  N := B
//  for i := 1 to n do:
//    for j := 1 to n do:
//      Nij := min(Bij, Bir + Brj)
//      B := N
// return B

function floyd(array) {
  let length = array.length;
  let n = Math.sqrt(length);

  for (let r = 0; r < n; r++) {
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (array[i * n + j] > array[i * n + r] + array[r * n + j]) {
          array[i * n + j] = array[i * n + r] + array[r * n + j];
        }
      }
    }
  }
  print2dArray(array);
}


function print2dArray(array) {
  let length = array.length;
  let cols = (rows = Math.sqrt(length));
  // console.log("rows: " + rows);
  // console.log("cols: " + cols)
  process.stdout.write("[");

  for (let i = 0; i < rows; i++) {
    if (i != 0) process.stdout.write(" ");
    process.stdout.write("(");

    for (let j = 0; j < cols; j++) {
      process.stdout.write(array[i * n + j].toString().padStart(3, " "));
      if (j != cols - 1) process.stdout.write(", ");
    }

    process.stdout.write(")");
    if (i != rows - 1) process.stdout.write(",\n");
  }

  process.stdout.write("]\n");
}
