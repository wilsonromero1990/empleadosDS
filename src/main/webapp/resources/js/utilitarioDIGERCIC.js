function permite(elEvento, permitidos) {
	// Variables que definen los caracteres permitidos
	var numeros = "0123456789";
	var caracteres = " abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
	var numeros_caracteres = numeros + caracteres;
	var teclas_especiales = [ 8, 9, 127 ];
	// 8 = BackSpace, 46 = . y Supr (teclado español), 37 = flecha izquierda, 39
	// = flecha derecha, 9 = tab, 127 = Del
	// Seleccionar los caracteres a partir del parámetro de la función
	switch (permitidos) {
	case 'num':
		permitidos = numeros;
		break;
	case 'car':
		permitidos = caracteres;
		break;
	case 'num_car':
		permitidos = numeros_caracteres;
		break;
	case 'none':
		permitidos = "";
		break;
	}
	// Obtener la tecla pulsada
	var evento = elEvento || window.event;
	var codigoCaracter = evento.charCode || evento.keyCode;
	var caracter = String.fromCharCode(codigoCaracter);
	// Comprobar si la tecla pulsada es alguna de las teclas especiales
	// (teclas de borrado y flechas horizontales)
	var tecla_especial = false;
	for ( var i in teclas_especiales) {
		if (codigoCaracter == teclas_especiales[i]) {
			tecla_especial = true;
			break;
		}
	}
	// Comprobar si la tecla pulsada se encuentra en los caracteres permitidos
	// o si es una tecla especial
	return permitidos.indexOf(caracter) != -1 || tecla_especial;
}

function ButtonChangePassword_onclick() {
	window
			.open(
					"./CambiarClave.jsf",
					null,
					"top=150,left=200,height=245,width=352,menubar=no,scrollbars=no,status=no,toolbar=no");
	return;
}

function refrescar() {
	location.reload(true);
}

function sleep() {
	setTimeout(function() {
		location.reload()
	}, 3000);
}

function ShowSelected(varid1, vard2) {
	var lista = document.getElementById(varid1);
	var indiceSeleccionado = lista.selectedIndex;
	var opcionSeleccionada = lista.options[indiceSeleccionado];
	var textoSeleccionado = opcionSeleccionada.text;
	document.getElementById(vard2).value = textoSeleccionado;
}

function ShowSelectedCom(varid1, vard2, aux) {
	var lista = document.getElementById(varid1);
	var indiceSeleccionado = lista.selectedIndex;
	var opcionSeleccionada = lista.options[indiceSeleccionado];
	var textoSeleccionado = opcionSeleccionada.text;
	if(aux == null){
		document.getElementById(vard2).value = textoSeleccionado;
	}else{
		document.getElementById(vard2).value = document.getElementById(vard2).value+" / "+textoSeleccionado;
	}
}

/**
 * Funciones para manejo de las pantallas
 */
Principal = {
		/**
		 * Id del Tab de transacciones
		 */
		idTab:0,
		/**
		 * Fija el valor del Tab actual para transacciones
		 */
		idTabChange: function(index) {
			alert(index);
    		Principal.idTab = index;
    	},
    	/**
    	 * Carca la pagina y titulo en el iframe de transaccion
    	 */
    	loadPage: function(page, title) {
    		console.log(page);
	        $("#tab"+Principal.idTab).attr("src", page);
	        $("a[href='#tabs\\:tabprin"+Principal.idTab+"']").first().text(title);
	    },
	    /**
	     * Obtiene el contexto
	     */
	    getContext: function(){
			var dieccion = window.location.pathname.split("/");
		    return dieccion[1];
		},
		/**
		 * Agreg un tab
		 */
		addTab: function(){
			
		},
		/**
		 * Abre una ventana emergente
		 */
		openDocument: function(){
			window.open(window.location.href.split('pages')[0]+"pages/documento/view.jsf", "Titlebar=Document" ,"scrollbars=NO");
		}
}

function validateMail(valor)
{
	// Patron para el correo
	var patron=/[\w\.-]*[a-zA-Z0-9_]@[\w\.-]*[a-zA-Z0-9]\.[a-zA-Z][a-zA-Z\.]*[a-zA-Z]/;
	if(patron.test(valor.value))
	{
		return true;
	}else{
		valor.value=null;
		return false;
	}
}
function textoUpercase(cadena){
	cadena = cadena.toUpperCase();
}

function textoUpercase(cadena){
	cadena = cadena.toUpperCase();
}


function posicionScrollInicio() {
	var el = document.getElementById('content');
	// get scroll position in px
	console.log(el);
	console.log(el.scrollLeft, el.scrollTop);

	// set scroll position in px
	el.scrollLeft = 0;
	el.scrollTop = 0;
	console.log(el.scrollLeft, el.scrollTop);
}