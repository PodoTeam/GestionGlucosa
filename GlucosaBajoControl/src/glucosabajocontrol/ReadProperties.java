/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glucosabajocontrol;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author bryan
 */
public class ReadProperties {
      String raiz = System.getProperty("user.dir");
    
     public  String obtenerProperties(String key) throws IOException {

        Properties property = new Properties();
        String propFileName = "glucosabajocontrol/config.properties";

        //direccion de propiedades
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        //cargo la direccion
        if (inputStream != null) {
            property.load(inputStream);
        } else {
            
            throw new FileNotFoundException("Propierties file no encontrado " + propFileName);
        }
        
        //guardar elemento
   
        return property.getProperty(key);
    }
    
    public String obtenerURL()throws IOException
    {
        return obtenerProperties("URL")+raiz+"\\GlucosaBajoControlBD.accdb";
    }
}
