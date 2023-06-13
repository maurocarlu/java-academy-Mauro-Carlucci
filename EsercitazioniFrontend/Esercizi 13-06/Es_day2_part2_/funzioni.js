
function cambiaTesto() {
    var paragrafo = document.getElementById("mioParagrafo");
    paragrafo.innerHTML = "mondo";
  }

function inserisciA() {
    var td = document.getElementsByTagName("td");
    for (var i = 0; i < td.length; i++) {
        if(i==0 || i==4 || i==8){
            td[i].innerHTML = "a";
        } else {
            td[i].innerHTML = "";
        }
        
    }
}

function inserisciImmagine() {
    var immagine = document.getElementById("meme");
    immagine.src = "C:/Users/franc/OneDrive/Desktop/ProvaIBM/Es_day2_part2_/meme.jpg";
    immagine.style.width = "600px";
    immagine.style.height = "500px";
}