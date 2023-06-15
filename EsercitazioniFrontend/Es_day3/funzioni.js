function cambiaPagina(pagina) {
    window.location.href = pagina;
}

function ottieniParagrafi(){
    const urlParams = new URLSearchParams(window.location.search);
    const value1 = urlParams.get('paragrafo1');
    const value2 = urlParams.get('paragrafo2');
    const value3 = urlParams.get('paragrafo3');

    document.getElementById('Parag1').innerText = 'Input 1: ' + value1;
    document.getElementById('Parag2').innerText = 'Input 2: ' + value2;
    document.getElementById('Parag3').innerText = 'Input 3: ' + value3;
}

function leggiJSON(){
    var data = {
        "success": true,
        "data": {
            "specializzazione": "Design",
            "ambito": {
                "contesto": "Enterprise"
           }
        }
    };
    document.getElementById('specializzazione').innerText = data.data.specializzazione;
    document.getElementById('contesto').innerText = data.data.ambito.contesto;
}

function leggiJSONurlNOPARAM(){
    try{
        let request = new XMLHttpRequest();
        request.open('GET', 'http://cicacademy2023.ddns.net/esercizi/get', false);
        request.send(null);

        if(request.status === 200){
            let data = JSON.parse(request.responseText);
            document.getElementById('specializzazione').innerText = data.data.specializzazione;
            document.getElementById('contesto').innerText = data.data.ambito.contesto;
        }else{
            throw new Error('Response status !=200: ' + request.status);
        }
    }catch(error){
        alert('Endpoint remoto - GET - /get_data non disponibile');
    }
}

function inviaUsername(){
    const username = document.getElementById("username-lab").value;
    leggiJSONurlPARAM(username);
}

function leggiJSONurlPARAM(username){
    try{
        let request = new XMLHttpRequest();
        const requestParams = "username="+username;
        request.open('GET', 'http://cicacademy2023.ddns.net/esercizi/getParam?' + requestParams, false);
        request.send();

        if(request.status === 200){
            let data = JSON.parse(request.responseText);
            if(data.success === true){
                document.getElementById('specializzazione').innerText = data.data.specializzazione;
                document.getElementById('contesto').innerText = data.data.ambito.contesto;
            }else{
                alert("Errore");
            }
        }else{
            throw new Error('Response status !=200: ' + request.status);
        }
    }catch(error){
        alert('Endpoint remoto - GET - /get_data non disponibile');
    }
}