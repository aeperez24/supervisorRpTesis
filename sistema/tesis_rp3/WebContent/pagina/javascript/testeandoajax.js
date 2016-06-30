/**
 * primera prueba sin hacer llamadas ajax (soap)
 */
$(document).ready(inicializar);

var o1_runing=false;
var o2_runing=false;
var o3_runing=false;
var wsUrl;
function inicializar()
{
	//wsUrl = "http://192.168.1.101:8080/servicio_tesis/services/Servicio";
	wsUrl = "http://localhost:8080/servicio_tesis_2/services/Servicio";

	
	/*inicializacin de los eventos*/
	$("#orden_1_por_enviar button").click(armaorden1);
	$("#orden_1_por_enviar button").click(function(){$("#orden_1_por_enviar input,#orden_1_por_enviar select,#orden_1_por_enviar button").attr("disabled","disabled")});
	$("#orden_1_por_enviar button").click(ajax_o1);
	$("#orden_2_por_enviar button").click(armaorden2);
	$("#orden_2_por_enviar button").click(function(){$("#orden_2_por_enviar input,#orden_2_por_enviar select,#orden_2_por_enviar button").attr("disabled","disabled")});
	$("#orden_2_por_enviar button").click(ajax_o2);
	
	$("#orden_3_por_enviar button").click(armaorden3);
	$("#orden_3_por_enviar button").click(function(){$("#orden_3_por_enviar input,#orden_3_por_enviar select,#orden_3_por_enviar button").attr("disabled","disabled")});
	$("#orden_3_por_enviar button").click(ajax_o3);
	/*incio del servicio si no esta iniciado*/
	ajax_inicio();
//setInterval(function() {hola("andres");}, 1000);

}

/*funcion para convertir un booleano en string*/
function bstr(x)
{
	if(x==true)
		return "true";
		else
			return "false";
}


/*funcion para convertir una orden en string */
function armaorden1()
{
	var nOrden=$("#orden_1_por_enviar .text_norden ").val();
	var nLotes=$("#orden_1_por_enviar .text_nlotes ").val();
	var aux=$("#orden_1_por_enviar .check_extra ").prop("checked");
	var loteExtra=bstr(aux);
	var color=$("#orden_1_por_enviar select").val();
	var cadena=nOrden+":"+nLotes+":"+loteExtra+":"+color;
	alert(cadena);
	return cadena;
	

}

/*funcion para convertir una orden en string */

function armaorden2()
{
	var nOrden=$("#orden_2_por_enviar .text_norden ").val();
	var nLotes=$("#orden_2_por_enviar .text_nlotes ").val();
	var aux=$("#orden_2_por_enviar .check_extra ").prop("checked");
	var loteExtra=bstr(aux);
	var color=$("#orden_2_por_enviar select").val();
	var cadena=nOrden+":"+nLotes+":"+loteExtra+":"+color;
	alert(cadena);
	return cadena;
	

}

/*funcion para convertir una orden en string */

function armaorden3()
{
	var nOrden=$("#orden_3_por_enviar .text_norden ").val();
	var nLotes=$("#orden_3_por_enviar .text_nlotes ").val();
	var aux=$("#orden_3_por_enviar .check_extra ").prop("checked");
	var loteExtra=bstr(aux);
	var color=$("#orden_3_por_enviar select").val();
	var cadena=nOrden+":"+nLotes+":"+loteExtra+":"+color;
	alert(cadena);
	return cadena;
	

}


/*actualiza el progreso de la orden numero 1*/

function actualizar_progreso_1(str){
	aux=str.split(":");
	$("#barra_1_premezcla").css("width",aux[0]*2);
	$("#barra_1_premezcla").text(aux[0]);
	
	
	$("#barra_1_transporte").css("width",aux[1]*2);
	$("#barra_1_transporte").text(aux[1]);
	
	$("#barra_1_agitado").css("width",aux[2]*2);
	$("#barra_1_agitado").text(aux[2]);
	
}





/*actualiza el progreso de la orden numero 2 */
/*
	function actualizar_progreso_2(str){
	aux=str.split(":");
	$("#barra_2_premezcla").css("width",aux[0]*2);
	$("#barra_2_premezcla").text(aux[0]);
	
	
	$("#barra_2_transporte").css("width",aux[1]*2);
	$("#barra_2_transporte").text(aux[1]);
	
	$("#barra_2_agitado").css("width",aux[2]*2);
	$("#barra_2_agitado").text(aux[2]);
	
}

/*actualiza el progreso de la orden numero 3*/

/*function actualizar_progreso_3(str){
	aux=str.split(":");
	$("#barra_3_premezcla").css("width",aux[0]*2);
	$("#barra_3_premezcla").text(aux[0]);
	
	
	$("#barra_3_transporte").css("width",aux[1]*2);
	$("#barra_3_transporte").text(aux[1]);
	
	$("#barra_3_agitado").css("width",aux[2]*2);
	$("#barra_3_agitado").text(aux[2]);
	
}
*/

function actualizar_progreso(n,str){
	aux=str.split(":");
	$("#barra_"+n+"_premezcla").css("width",aux[0]*2);
	$("#barra_"+n+"_premezcla").text(aux[0]);
	
	
	$("#barra_"+n+"_transporte").css("width",aux[1]*2);
	$("#barra_"+n+"_transporte").text(aux[1]);
	
	$("#barra_"+n+"_agitado").css("width",aux[2]*2);
	$("#barra_"+n+"_agitado").text(aux[2]);
	
}



/*funciones para hacer las peticiones ajax*/
function ajax_o1()
{
	$.soap({
		url: wsUrl,
		method:'incluir_orden',
		appendMethodToURL: false,
		SOAPAction:'incluir_orden',
		data: {
			orden:armaorden1(),	
		},
		
		success: function(){alert("orden1 enviada");inicializacion_intervalo(1);},
		error: function(){alert("orden1 fallida");},
	});

}


function ajax_o2()
{
	$.soap({
		url: wsUrl,
		method:'incluir_orden',
		appendMethodToURL: false,
		SOAPAction:'incluir_orden',
		data: {
			orden:armaorden2(),	
		},
		
		success: function(){alert("orden2 enviada");inicializacion_intervalo(2);},
		error: function(){alert("orden2 fallida");},
	});

}



function ajax_o3()
{
	$.soap({
		url: wsUrl,
		method:'incluir_orden',
		appendMethodToURL: false,
		SOAPAction:'incluir_orden',
		data: {
			orden:armaorden3(),	
		},
		
		success: function(){alert("orden3 enviada");inicializacion_intervalo(3);},
		error: function(){alert("orden3 fallida");},
	});

}


/*llama a la inicializacion del serivcio del servicio*/
function ajax_inicio()
{
	$.soap({
		url: wsUrl,
		method:'inicio',
		appendMethodToURL: false,
		SOAPAction:'inicio',
		data: {	
		},
		
		success: function(){alert("iniciado");},
		error: function(){alert("inicio fallido");},
	});

}






function inicializacion_intervalo(nOrden)
{
	setInterval(function(){ajax_actualiza_o(nOrden);},1000);
			
}



function ajax_actualiza_o(nOrden)
{
	


	$.soap({
		url: wsUrl,
		method:'obtener_orden',
		appendMethodToURL: false,
		SOAPAction:'obtener_orden',
		data: {	x:nOrden,
		},
		
		//success: function(respuesta){actualizar_progreso(nOrden,parseInt(respuesta.toString())),alert(respuesta.toString());},
		success: function(respuesta){actualizar_progreso(nOrden,$(respuesta.toString()).text());/*$(respuesta.toString()).text()*/},
		error: function(){alert("actualizacion mal");},
	});


}