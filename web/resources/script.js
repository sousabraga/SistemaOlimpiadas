var ajax;

function validaFormLogin() {
    var login = document.getElementById("login").value;
    var senha = document.getElementById("senha").value;
   
    var contemLetraMinuscula = new RegExp(/[a-z]{1,}/).test(senha);
    var contemLetraMaiuscula = new RegExp(/[A-Z]{1,}/).test(senha);
    var contemDigito = new RegExp(/[0-9]{1,}/).test(senha);
    var contemOitoCaracteres = senha.length >= 8;
    
    var mensagemErro = document.getElementById("mensagemErro");
    
    if (!login) {
        mensagemErro.innerHTML = "Favor preencher o campo login.";
        return false;
    } else if (!senha) {
        mensagemErro.innerHTML = "Favor preencher o campo senha.";
        return false;
    } else if (!(contemOitoCaracteres && contemLetraMaiuscula && contemLetraMinuscula && contemDigito)) {
        mensagemErro.innerHTML = "A senha deve ter no mínimo 8 caracteres, com pelo menos 1 letra maiúscula, 1 letra minúscula e 1 digito.";
        return false;
    } else {
        return true;
    }
}

function validaLoginAjax() {
    document.getElementById("mensagemErro").innerHTML = "";
    criarXMLHttpRequest();

    var login = document.getElementById("login").value;

    ajax.open("GET", "/SistemaOlimpiadas/LoginAJAX?login=" + login);
    
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {  
            var respostaJSON = JSON.parse(ajax.responseText);

            if (respostaJSON) {
                var mensagem = respostaJSON.respostaServidor;
                document.getElementById("mensagemErro").innerHTML = mensagem;
            } else {
                console.log("Requisição AJAX falhou: " + ajax.status + " " + ajax.statusText);
            }
        } 
    }
    
    ajax.send(); 
}

function validaFormCadastroUsuario() {
    var email = document.getElementById("email").value;
    var login = document.getElementById("login").value;
    var senha = document.getElementById("senha").value;
    var confirmacaoSenha = document.getElementById("confirmacaoSenha").value;
   
    var contemLetraMinuscula = new RegExp(/[a-z]{1,}/).test(senha);
    var contemLetraMaiuscula = new RegExp(/[A-Z]{1,}/).test(senha);
    var contemDigito = new RegExp(/[0-9]{1,}/).test(senha);
    var contemOitoCaracteres = senha.length >= 8;
    
    var mensagemErro = document.getElementById("mensagemErro");
    
    if (!email) {
       mensagemErro.innerHTML = "Favor preencher o campo e-mail.";
       return false; 
    } else if (!login) {
        mensagemErro.innerHTML = "Favor preencher o campo login.";
        return false;
    } else if (!senha) {
        mensagemErro.innerHTML = "Favor preencher o campo senha.";
        return false;
    } else if (!(contemOitoCaracteres && contemLetraMaiuscula && contemLetraMinuscula && contemDigito)) {
        mensagemErro.innerHTML = "A senha deve ter no mínimo 8 caracteres, com pelo menos 1 letra maiúscula, 1 letra minúscula e 1 digito.";
        return false;
    }  else if (!confirmacaoSenha) {
        mensagemErro.innerHTML = "Favor preencher o campo de confirmação da senha.";
        return false;
    }  else if (!(senha == confirmacaoSenha)) {
        mensagemErro.innerHTML = "As senhas devem ser iguais.";
        return false;
    } else {
        cadastroUsuarioAjax();
        return false;
    }
}

function cadastroUsuarioAjax() {
    criarXMLHttpRequest();

    var email = document.getElementById("email");
    var login = document.getElementById("login");
    var senha = document.getElementById("senha");
    var confirmacaoSenha = document.getElementById("confirmacaoSenha");

    ajax.open("GET", "/SistemaOlimpiadas/CadastroUsuarioAJAX?email=" + email.value + "&login=" + login.value + "&senha=" + senha.value);
    
    ajax.onreadystatechange = function () {
        if (ajax.readyState == 4 && ajax.status == 200) {  
            var respostaJSON = JSON.parse(ajax.responseText);

            if (respostaJSON) {
                var mensagem = respostaJSON.respostaServidor;
                document.getElementById("mensagemSucesso").innerHTML = mensagem;
                email.value = login.value = senha.value = confirmacaoSenha.value = "";
            } else {
                console.log("Requisição AJAX falhou: " + ajax.status + " " + ajax.statusText);
            }
        } 
    }
    
    ajax.send(); 
}

function criarXMLHttpRequest() {
    try {
        ajax = new XMLHttpRequest();
    } catch (trymicrosoft) {
        try {
            ajax = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (othermicrosoft) {
            try {
                ajax = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (failed) {
                ajax = null;
            }
        }
    }

    if (ajax == null)
        console.log("Erro ao criar o objeto XMLHttpRequest.");
}

function validaValorInput() {
    var valorInput = document.getElementById("valorInput").value;
    
    var contemDigito = new RegExp(/[0-9]{1,}/).test(valorInput);
    
    var mensagemErro = document.getElementById("mensagemErro");
    
    if (valorInput.trim().length <= 0) {
        mensagemErro.innerHTML = "O valor não pode ser vazio.";
        return false;
    } else if (contemDigito) {
        mensagemErro.innerHTML = "O valor não deve conter dígitos.";
        return false;
    }
    
    return true;
}

function limpaMensagemErro() {
    document.getElementById("mensagemErro").innerHTML = "";
}

function limpaMensagens() {
    document.getElementById("mensagemErro").innerHTML = "";
    document.getElementById("mensagemSucesso").innerHTML = "";
}
