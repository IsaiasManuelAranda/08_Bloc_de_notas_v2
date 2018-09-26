
package main;

import controller.ControllerArchivo;
import model.ModelArchivo;
import view.ViewArchivo;

public class Main {
    
    private static ModelArchivo modelArchivo;
    private static ViewArchivo viewArchivo;
    private static ControllerArchivo controllerArchivo;
    
    public static void main(String[] args) {
        modelArchivo = new ModelArchivo();
        viewArchivo = new ViewArchivo();
        controllerArchivo = new ControllerArchivo(modelArchivo, viewArchivo);
    }
    
}
