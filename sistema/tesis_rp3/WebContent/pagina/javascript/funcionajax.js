var wsUrl;
$(document).ready(function () {
	wsUrl = "http://localhost:8080/Calculadora_repaso/services/Operacion";
	
	$("button").click(llamada);	
	
	$("#numero1").val("0");
	$("#numero2").val("3");

});
	





function llamada(){
	
	
	$.soap({
		url: wsUrl,
		method:'suma',
		appendMethodToURL: false,
		SOAPAction:'suma',
		data: {
			a: parseInt($("#numero1").val()),
			b: parseInt($("#numero2").val()),
				
		},
		
		success: processSuccess,
		error: processError,
	});

	
}








function processSuccess(data)
{
	var x=$(data.toString()).text();
	alert(x);}

function processError(soapResponse) {
	alert(soapResponse.toString());
} 


    
