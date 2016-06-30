/**
 * primera prueba sin hacer llamadas ajax (soap)
 */
$(document).ready(inicializar);

var o1_runing=false;
var o2_runing=false;
var o3_runing=false;

function inicializar()
{
	
var x	=	$("#orden_3_por_enviar .check_extra").prop("checked",true);
	
	$("#orden_1_por_enviar button").click(armaorden1);
	$("#orden_1_por_enviar button").click(function(){$("#orden_1_por_enviar input,#orden_1_por_enviar select,#orden_1_por_enviar button").attr("disabled","disabled")});
	
	$("#orden_2_por_enviar button").click(armaorden2);
	$("#orden_2_por_enviar button").click(function(){$("#orden_2_por_enviar input,#orden_2_por_enviar select,#orden_2_por_enviar button").attr("disabled","disabled")});
	
	$("#orden_3_por_enviar button").click(armaorden3);
	$("#orden_3_por_enviar button").click(function(){$("#orden_3_por_enviar input,#orden_3_por_enviar select,#orden_3_por_enviar button").attr("disabled","disabled")});
	

//setInterval(function() {hola("andres");}, 1000);

}


function bstr(x)
{
	if(x==true)
		return "true";
		else
			return "false";
}


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


function actualizar_progreso_1(){
	var str="70:80:50";
	aux=str.split(":");
	$("#barra_1_premezcla").css("width",aux[0]*2);
	$("#barra_1_premezcla").text(aux[0]);
	
	
	$("#barra_1_transporte").css("width",aux[1]*2);
	$("#barra_1_transporte").text(aux[1]);
	
	$("#barra_1_agitado").css("width",aux[2]*2);
	$("#barra_1_agitado").text(aux[2]);
	
}

function actualizar_progreso_2(){
	var str="70:80:50";
	aux=str.split(":");
	$("#barra_2_premezcla").css("width",aux[0]*2);
	$("#barra_2_premezcla").text(aux[0]);
	
	
	$("#barra_2_transporte").css("width",aux[1]*2);
	$("#barra_2_transporte").text(aux[1]);
	
	$("#barra_2_agitado").css("width",aux[2]*2);
	$("#barra_2_agitado").text(aux[2]);
	
}


function actualizar_progreso_3(){
	var str="70:80:50";
	aux=str.split(":");
	$("#barra_3_premezcla").css("width",aux[0]*2);
	$("#barra_3_premezcla").text(aux[0]);
	
	
	$("#barra_3_transporte").css("width",aux[1]*2);
	$("#barra_3_transporte").text(aux[1]);
	
	$("#barra_3_agitado").css("width",aux[2]*2);
	$("#barra_3_agitado").text(aux[2]);
	
}


function hola(x)
{
alert("hola"+x);	
}