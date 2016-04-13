function autorizar() {
    Trello.authorize({
        interactive: false,
        type: "popup",
        expiration: "never",
        name: "Gerenciamento IFPB",
        persist: true,
        success: function () {
            onAuthorizeSuccessful();
        },
        error: function () {
            onFailedAuthorization();
        },
        scope: {read: true, write: true},
    });
}

Trello.setToken("575ffe565284514bce10ddfbc875e42b924287d7bb9674b51cab5f0cd8f4bd93");

function onAuthorizeSuccessful() {
    var token = Trello.token();
    console.log(token);
}

function onFailedAuthorization() {
    console.log("Authorization failed.");
}


var sucesso = function (successMsg) {
    console.log(successMsg);
    location.reload();
};

var erro = function (errorMsg) {
    console.log(errorMsg);
};

function novaTurma(identificacaoTurma) {
    Trello.post("lists", {name: identificacaoTurma, idBoard: "56479d1e4366946e5cb74ede"}, sucesso, erro);
}

function novoCard(nome, turma, urlAtividade, dataEntrega) {
    var card =
            {
                name: nome,
                pos: "top",
                due: dataEntrega,
                idList: turma,
                urlSource: urlAtividade,
                desc: urlAtividade
            };

    Trello.post("/cards", card, sucesso, erro);
}

function novaAtividade(nome, turma, urlAtividade, dataEntrega) {

    Trello.get("boards/56479d1e4366946e5cb74ede/lists", function (data) {
        var existeTurma = false;
        for (var i = 0, max = data.length; i < max; i++) {
            if (data[i].name === turma) {
                existeTurma = true;
                novoCard(nome, data[i].id, urlAtividade, dataEntrega);
                break;
            }
        }
        if (existeTurma === false) {
            novaTurma(turma);
            novaAtividade(nome, turma, urlAtividade, dataEntrega);
        }
    }, erro);

}

function convertData(d) {
    data = new Date(d);
    dia = data.getDate();
    mes = data.getMonth();
    ano = data.getFullYear();
    if (dia < 10)
        dia = "0" + dia;
    if (ano < 2000)
        ano = "19" + ano;

    var date = dia + "/" + (mes + 1) + "/" + ano;
    return date;
}

function reload() {
    location.reload();
}

function renderAtividades(turma, name, link, data, id) {
    var del = "Trello.delete('/cards/" + id + "', reload, erro)";
    var html = "<tr><td>" + turma + "</td><td>" + name + "</td><td>" + link + "</td><td>" + convertData(data) + "</td><td><button onclick=\"" + del + "\">Excluir</button></td></tr>";
    $("#listaAtividades").append(html);
}


function renderAtividadesAluno(turma, name, link, data) {
    var html = "<tr><td>" + turma + "</td><td>" + name + "</td><td>" + link + "</td><td>" + convertData(data) + "</td></tr>";
    $("#listaAtividades").append(html);
}

function getAtividades(turma, tipo) {
    Trello.get("boards/56479d1e4366946e5cb74ede/lists", function (data) {
        for (var i = 0, max = data.length; i < max; i++) {
            if (data[i].name === turma) {
                Trello.get("/lists/" + data[i].id + "/cards", function (cards) {
                    for (var i = 0, max = cards.length; i < max; i++) {
                        if (tipo === "aluno") {
                                renderAtividadesAluno(turma, cards[i].name, cards[i].desc, cards[i].due);
                        } else {
                            renderAtividades(turma, cards[i].name, cards[i].desc, cards[i].due, cards[i].id);
                        }
                    }
                }, erro);
                break;
            }
        }
    }, erro);
}



function getNotifications(turma) {
    Trello.get("boards/56479d1e4366946e5cb74ede/lists", function (data) {
        for (var i = 0, max = data.length; i < max; i++) {
            if (data[i].name === turma) {
                Trello.get("/lists/" + data[i].id + "/actions", function (notify) {                                        
                    for (var i = 0, max = notify.length; i < max && i < 10; i++) {
                        getInfoNotificacao(notify[i].id);
                    }
                }, erro);
                break;
            }
        }
    }, erro);
}

function getInfoNotificacao(id) {
    Trello.get("actions/" + id + "/display", function (notify) {        
        console.log(notify.translationKey);
        switch (notify.translationKey) {
            case "action_create_card":
            {
                var html = "<span class='label label-info'><em>"+notify.entities.list.text + "</em> tem uma nova atividade:<b> "+notify.entities.card.text+"</b></span><br/>";
                $("#notificacoes").append(html);
                break;
            }
            case "action_delete_card":
            {
                var html = "<span class='label label-info'>Uma atividade da turma <em>"+notify.entities.list.text + "</em> foi removida</span><br/>";
                $("#notificacoes").append(html);
                break;
            }
        }
    }, erro);
}

function processInfo() {
    var e = document.getElementById("form:turmaSelecionada");
    var turma = e.options[e.selectedIndex].text;

    if ($("#nomeAtividade").val() && $("#linkAtividade").val() && $("#dataAtividade").val()) {
        novaAtividade($("#nomeAtividade").val(), turma, $("#linkAtividade").val(), $("#dataAtividade").val());
    }

}

$(document).ready(function () {
    autorizar();
});