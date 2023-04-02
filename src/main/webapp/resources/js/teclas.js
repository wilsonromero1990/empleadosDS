/**
 * Funciones para control de teclas en el Suti
 */
$(document).ready(function() {
	/**
     * Para controlar al presionar una tecla
     */
    $(document).bind('keydown', function(event) {
    	var e = event || window.event;    	
    	var k = null;
        if(e.which) k = e.which;
        else if(e.keyCode) k = e.keyCode;
        
        //console.log('keydown iframe '+e.keyCode+' '+k+' '+e.ctrlKey);
        
      //Deshabilita Ctrl + R
		if ((e.ctrlKey) && (k === 82)) {
			return false;
		}
		
		//Deshabilita Boton ENTER
        if(k === 13) {
        	return false;
        }
      //Deshabilita Boton F6 y otras teclas
        if(k === 117) {
        	return false;
        }
        // Deshabilita Boton F5
        if(k === 116) {
        	window.parent.Principal.reloadIframe(null);      	
        	return false;
        }
        
    });
});