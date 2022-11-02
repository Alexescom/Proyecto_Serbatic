package Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;

import dao.pojos.Articulo;

public class Ordenacion {
	
	
    public void ordenarListaMarcas(ArrayList<Articulo> lista, String campoOrdenacion, int tipoOrdenacion) throws Exception {
	    BeanComparator fieldComparator = new BeanComparator(campoOrdenacion);
	   
	    if(tipoOrdenacion== 0) {
		    Comparator<Articulo> comparador = Collections.reverseOrder(fieldComparator);
		    Collections.sort(lista, comparador);
	    } else {
	    	Collections.sort(lista, fieldComparator);
	    }
    }
	

}
