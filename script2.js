const hyphenElement = document.getElementById('p');
var number = 25986;
var silly = "";
function output() {
    document.getElementById('output').textContent += "25986 \n";
}
// Function to generate a random RGB color
function getRandomColor() {
    const r = Math.floor(Math.random() * 256);
    const g = Math.floor(Math.random() * 256);
    const b = Math.floor(Math.random() * 256);
    return `rgb(${r}, ${g}, ${b})`;
}

// Function to format time with leading zeros
function formatTime(unit) {
    return unit < 10 ? `0${unit}` : unit;
}

// Function to update the time and change the background color
function updateTimerAndColor() {
    const now = new Date();
    const hours = now.getHours();
    const minutes = now.getMinutes();
    const seconds = now.getSeconds();
    if(number == 25986){
         number  = 2598;
       document.getElementById('h1').textContent = number; 
    }
    else if(number == 2598){
         number  = 259;
       document.getElementById('h1').textContent = number; 
    }
    else if(number == 259){
         number  = 25;
       document.getElementById('h1').textContent = number; 
    }
    else if(number == 25){
         number  = 2;
       document.getElementById('h1').textContent = number; 
    }
    else{
        number = 25986;
        document.getElementById('h1').textContent = number; 
    }
    if(silly == ""){
        silly = "I"
    }
    else if(silly == "I"){
        silly = "I "
    }
    else if(silly == "I "){
        silly = "I a"
    }
    else if(silly == "I a"){
        silly = "I am"
    }
    else if(silly == "I am"){
        silly = "I am "
    }
    else if(silly == "I am "){
        silly = "I am a"
    }
    else if(silly == "I am a"){
        silly = "I am a "
    }
    else if(silly == "I am a "){
        silly = "I am a s"
    }
    else if(silly == "I am a s"){
        silly = "I am a si"
    }
    else if(silly == "I am a si"){
        silly = "I am a sil"
    }
    else if(silly == "I am a sil"){
        silly = "I am a sill"
    }
    else if(silly == "I am a sill"){
        silly = "I am a silly"
    }
    else if(silly == "I am a silly"){
        silly = "I am a silly I am a silly"
    }
    else if(silly == "I am a silly I am a silly"){
        silly = ""
    }
    const timeString = `${formatTime(hours)}:${formatTime(minutes)}:${formatTime(seconds)}`;
    const randomLength = Math.floor(Math.random() * 25) + 5;
    const hyphenString = "-".repeat(randomLength);
    const hyphenString2 = "-".repeat(randomLength-1);
    // Update the timer display
    document.getElementById('p').textContent = hyphenString; 
    document.getElementById('p1').textContent = hyphenString2; 
    document.getElementById('input').value = silly; 

    // Change the background color
    document.body.style.backgroundColor = getRandomColor();
}

// Update the timer and color immediately on page load
updateTimerAndColor();

// Set an interval to call the function every second (1000 milliseconds)
setInterval(updateTimerAndColor, 200);

