function  rc = enviaralookout(archivo,item,dato)
chan = ddeinit('Lookout',archivo);
rc = ddepoke(chan,item,dato);
rc=ddeterm(chan);