/**
 * 
 */
function convertir_lotes(cantidad_galones)
{	
	return parseInt(cantidad_galones/60);
	

}
function convertir_medio_extra(cantidad_galones)
{
	if(cantidad_galones%60==0)
		return false
		else
			return true

}

function valida_galones(cantidad_galones)
{
	
if(cantidad_galones%30==0)
	{return cantidad_galones}
else
	{
	var i=1;
	while(i*30<cantidad_galones)
		i++;
	return i*30;
		
	
	}
}