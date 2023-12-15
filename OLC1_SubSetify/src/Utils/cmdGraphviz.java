package Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
public class cmdGraphviz {

    public void generarGrafico(String lectura, String escritura){
         
        String dotFilePath = lectura;
        String outputImagePath = escritura;

        try {
            String command = "dot -Tpng " + dotFilePath + " -o " + outputImagePath;
            ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", command);
            processBuilder.redirectErrorStream(true);

            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();

            System.out.println("Código de salida: " + exitCode);

            if (exitCode == 0) {
                Runtime.getRuntime().exec("cmd /c start " + outputImagePath);
            } else {
                System.out.println("Error al generar la imagen.");
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
