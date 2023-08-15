//Redirect - Cadastro User
function acessoUser(){
	window.location.href="cadastroUsuario";
}

function loginValid(){
	
	 let user = document.getElementById("inputUser").value // Acessar o campo inputUser 
	 let pass = document.getElementById("inputPass").value // Acessar o campo inputPass
	 
	 if(user == ""){
		 alert("O campo Usuário não pode ficar em branco.");
	 }else if(pass == ""){
		 alert("O campo Senha não pode ficar em branco.");

	 }else{
		formLogin.submit();
 
	 }
	 
	
	 
}