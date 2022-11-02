package Service;



public class Comprobador {

	//Variables
    
    
    //Métodos
    public boolean comprobarNull(String usuario, String contraseña) {
    	
    	if (usuario == "") {
    		
    		return false;
    		
    	}else if (contraseña == "") {
    		
    		return false;
    		
    	}else {
    		
    		return true;
    		
    	}
    }
}
