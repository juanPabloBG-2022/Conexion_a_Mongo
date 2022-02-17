package conexion_a_mongp;

public class Conexion_a_Mongp {

    public static void main(String[] args) {
        
        Conexion conec = new Conexion();
 //       conec.insertar("Nadar");
            conec.Mostrar();
    //    conec.Actualizar("correr", "brincar");
      //  conec.Mostrar();
      conec.Eliminar("Nadar");
      conec.Mostrar();
      
    }
    
}
