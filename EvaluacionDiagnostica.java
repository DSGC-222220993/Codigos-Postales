//clases importadas
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;//control de flujo


public class EvaluacionDiagnostica {
    public static void main(String[] args) {

        Path archivo= Paths.get("C:\\Users\\Usuario\\Downloads\\codigos_postales_hmo.csv");
        Map<String,Integer> repeticion=new HashMap<>(); // inicializa del mapa para contar la frecuencia con la que se repite el cp

        try (Stream<String> lineas=Files.lines(archivo)){
            lineas.forEach(linea->{
                String[] codigoPostal=linea.split("\t"); //separa la primera parte de la linea (codigo postal) de la colonia
                if (codigoPostal.length>0){
                    String cp=codigoPostal[0];
                    repeticion.put(cp,repeticion.getOrDefault(cp,0)+1);
                }
            });

        } catch (IOException e) {
            System.out.println();
        }
        repeticion.forEach((codpos,rep)->  //Imprime la frecuencia con la que se repite los datos de la primera columna
                System.out.println("El codigo postal "+codpos+" se repite un numero de "+rep+" veces")
        );
    }
}
