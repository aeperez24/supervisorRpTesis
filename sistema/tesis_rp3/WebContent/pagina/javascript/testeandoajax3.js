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
	wsUrl = "http://192.168.100.1:8080/tesis_rp3/services/Servicio";
	//wsUrl = "http://localhost:8080/tesis_rp2/services/Servicio";

	
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
	
	$("#solucionada").click(ajax_falla_sol);
	
	/*inicio del intervalo para actualizar el estado del sistema*/
	setInterval(ajax_status_sistema,1000);
	
	/*incio del servicio si no esta iniciado*/
	ajax_inicio();


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





/*funcion para animar las barras indicadores de orden*/
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
	$("#orden_1_por_enviar .text_ngalones").val(valida_galones($("#orden_1_por_enviar .text_ngalones").val()));
	
	$("#orden_1_por_enviar .text_nlotes ").val(convertir_lotes($("#orden_1_por_enviar .text_ngalones").val()));
		
	if(convertir_medio_extra($("#orden_1_por_enviar .text_ngalones").val()))
			$("#orden_1_por_enviar .check_extra").prop("checked",true);
		else
			$("#orden_1_por_enviar .check_extra").prop("checked",false);
		
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
		$("#orden_2_por_enviar .text_ngalones").val(valida_galones($("#orden_2_por_enviar .text_ngalones").val()));
	
		$("#orden_2_por_enviar .text_nlotes ").val(convertir_lotes($("#orden_2_por_enviar .text_ngalones").val()));
		
	if(convertir_medio_extra($("#orden_2_por_enviar .text_ngalones").val()))
			$("#orden_2_por_enviar .check_extra").prop("checked",true);
		else
			$("#orden_2_por_enviar .check_extra").prop("checked",false);
	
	
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
	
	
	$("#orden_3_por_enviar .text_ngalones").val(valida_galones($("#orden_3_por_enviar .text_ngalones").val()));
	
	$("#orden_3_por_enviar .text_nlotes ").val(convertir_lotes($("#orden_3_por_enviar .text_ngalones").val()));
	
if(convertir_medio_extra($("#orden_3_por_enviar .text_ngalones").val()))
		$("#orden_3_por_enviar .check_extra").prop("checked",true);
	else
		$("#orden_3_por_enviar .check_extra").prop("checked",false);

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
		
		success: function(){$("#conexion").css("backgroundColor","#0080ff");},
		error: function(){$("#conexion").css("backgroundColor","#f10e13");},
	});

}





/*funcion que inica el intervalo de actualizacion de una orden*/
function inicializacion_intervalo(nOrden)
{
	setInterval(function(){ajax_actualiza_o(nOrden);},1000);
			
}


/*funcion para obtener el estado de alguna orden*/
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
		error: function(){$("#conexion").css("backgroundColor","#f10e13");},
	});

	
	
	

}


/*funcion para avisar al sistema q la falla fue reparada*/
function ajax_falla_sol()
{
	


	$.soap({
		url: wsUrl,
		method:'falla_sol',
		appendMethodToURL: false,
		SOAPAction:'falla_sol',
		data: {	
		},
		
		//success: function(respuesta){actualizar_progreso(nOrden,parseInt(respuesta.toString())),alert(respuesta.toString());},
		success: function(){alert("falla reparada")},
		error: function(){alert("error");},
	});

	
	
	

}

/*funcion para preguntar por el estado del sistema*/
function ajax_status_sistema()
{
	$.soap({
		url: wsUrl,
		method:'get_status_proceso',
		appendMethodToURL: false,
		SOAPAction:'get_status_proceso',
		data: {	
		},
		
		success: function(respuesta){
			var x= $(respuesta.toString()).text();
			if(x==1)
				{$("#estatus").css("backgroundColor","#0080ff");}
			else
				{$("#estatus").css("backgroundColor","#f10e13");}
			
		
		
		},
		error:{},
	});





}