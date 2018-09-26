
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class ModelArchivo {
    
    String path;
    String message;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    public void readFile(String path){
        try{
            String row;
            String noteMessage = "";
            try(FileReader file = new FileReader(path)){
                BufferedReader bufferedReader;
                bufferedReader = new BufferedReader(file);
                while ((row = bufferedReader.readLine()) != null){
                    noteMessage = noteMessage + row + "\n";
                }
                this.setMessage(noteMessage);
                bufferedReader.close();
            }
        }catch(FileNotFoundException err){
            JOptionPane.showMessageDialog(null, "File not found: " + err.getMessage());
        }catch(IOException err){
            JOptionPane.showMessageDialog(null, "Fallo de entrada o salida: " + err.getMessage());
        }
    }
    public void writeFile(String path, String message){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, false);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(message);
                printWriter.close();
            }
        }catch(FileNotFoundException err){
            JOptionPane.showMessageDialog(null, "File not found: " + err.getMessage());
        }catch(IOException err){
            JOptionPane.showMessageDialog(null, "Fallo de entrada o salida: " + err.getMessage());
        }
    }
}
