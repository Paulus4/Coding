console.log('Hello World');

let person = {
    name: 'Paul',
    age: 20
}

console.log(person);
console.log(person.age);

person['name'] = 'Paulus';
person.age = 100;

console.log(person);


let colors = ['green', 'orange', 'blue'];
colors[3] = 'red';
colors[2] = 100;
console.log(colors);

function logAll(array) {
    for (let i = 0; i < array.length; i++) {
        console.log(array[i]);        
    }
}

logAll(colors);
