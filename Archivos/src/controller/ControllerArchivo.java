
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ModelArchivo;
import view.ViewArchivo;
import javax.swing.JFileChooser;

public class ControllerArchivo implements ActionListener {
    
    private final ModelArchivo modelArchivo;
    private final ViewArchivo viewArchivo;

    public ControllerArchivo(ModelArchivo modelArchivo, ViewArchivo viewArchivo) {
        this.modelArchivo = modelArchivo;
        this.viewArchivo = viewArchivo;
        
        viewArchivo.jmi_open.addActionListener(this);
        viewArchivo.jmi_save.addActionListener(this);
        initComponents();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewArchivo.jmi_open){
            selectPath();
            openFile();
        }
        else if (e.getSource() == viewArchivo.jmi_save){
            savePath();
            saveFile();
        }
    }
    public void openFile(){
        modelArchivo.readFile(modelArchivo.getPath());
        viewArchivo.jta_file.setText(modelArchivo.getMessage());
        
    }
    public void saveFile(){
        modelArchivo.setMessage(viewArchivo.jta_file.getText());
        modelArchivo.writeFile(modelArchivo.getPath(), modelArchivo.getMessage());
    }
    
    public void selectPath(){
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        modelArchivo.setPath("" + chooser.getSelectedFile());
    }
    
    public void savePath(){
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);
        modelArchivo.setPath("" + chooser.getSelectedFile());
    }
    
    public void initComponents(){
        viewArchivo.setTitle("Bloc de notas Chay");
        viewArchivo.setVisible(true);
        viewArchivo.setLocationRelativeTo(null);
        
    }
    
}
