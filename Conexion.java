package conexion_a_mongp;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    DB BaseDatos;
    DBCollection coleccion;
    BasicDBObject documento = new BasicDBObject();
    
    public Conexion (){
        try{
        Mongo mongo = new Mongo("localHost",27017);
        BaseDatos= mongo.getDB("Actividad502");//nombre de la base de datos
        coleccion=BaseDatos.getCollection("Actividad502");//colecion 
            System.out.println("conexion exitosa");
            
        
        }catch(UnknownHostException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
            
        }
    }
    
    //C-CRETE R-READ U-UPDATE D-DELETE
    
    public boolean insertar(String accion){
    documento.put("accion",accion);
    coleccion.insert(documento);
        return true;
    }
    
    public void Mostrar(){
         
        DBCursor cursor = coleccion.find();
         while(cursor.hasNext()){
             System.out.println(cursor.next());
         }
    }
    
    public boolean Actualizar(String accionVieja,String acccionNueva)
    {
        documento.put("accion", accionVieja);
        BasicDBObject documentoNuevo = new BasicDBObject();
        documentoNuevo.put("accion", acccionNueva);
        coleccion.findAndModify(documento, documentoNuevo);
        return true;
    }
    
    public boolean Eliminar(String accion){
        documento.put("accion", accion);
        coleccion.remove(documento);
        
        return true;
    }
}














