package app;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox; 
import app.model.*;
import app.service.*;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.layout.*;
public class Main extends Application{

		
	InscripcionService serviceInscripcionService = new InscripcionService();
	@Override
	
	 public void start(Stage stage)  {
		
		TableView<Inscripcion> tabla = new TableView<>();
		TableColumn<Inscripcion, String> colAlumno = new TableColumn<>("Alumno ");
	    TableColumn<Inscripcion, String> colCurso = new TableColumn<>("Curso ");
	    TableColumn<Inscripcion, Integer> colHoras = new TableColumn<>("Cantidad de horas");
	    
	    colCurso.setCellValueFactory(data ->
	    		new SimpleStringProperty(data.getValue().getCurso()));
	    
	    colAlumno.setCellValueFactory(data ->
		new SimpleStringProperty(data.getValue().getAlumno()));
	    
	    colHoras.setCellValueFactory(data ->
	    		new SimpleIntegerProperty(data.getValue().getHoras()).asObject());
	    
	    tabla.getColumns().addAll(colAlumno,colCurso,colHoras);
	    tabla.setItems(serviceInscripcionService.devolverLista());
	    
	    
	    TextField txtAlumno = new TextField();
	    txtAlumno.setPromptText("Alumno");
	    
	    TextField txtCurso = new TextField();
	    txtCurso.setPromptText("Curso");
	    
	    TextField txtHoras = new TextField();
	    txtHoras.setPromptText("Horas");
	    
	    Label lblhoras = new Label("horas en total");
	    Label lblerror= new Label("");
	    Button btnAgregar = new Button("Agregar");
        Button btnEliminar = new Button("Eliminar");
        
	    
        btnAgregar.setOnAction(e -> {
            try {
            	serviceInscripcionService.crearInscripcion(txtAlumno.getText(),txtCurso.getText(),txtHoras.getText());
            	lblhoras.setText("Horas Totales: "+serviceInscripcionService.calcularHoras());
            	 txtAlumno.clear();
                 txtCurso.clear();
                 txtHoras.clear();
            }catch(IllegalArgumentException ex) {
            	System.out.println("Campos incompletos.Completar campos");
            }
           
        });	
        btnEliminar.setOnAction(e -> {
        	Inscripcion seleccionado=tabla.getSelectionModel().getSelectedItem();
        	if(seleccionado!= null ) {
        		serviceInscripcionService.removerInscripcion(seleccionado);
        	}
        	
        });
              
        HBox inputs = new HBox(10, txtAlumno, txtCurso, txtHoras);
        HBox botones = new HBox(10, btnAgregar, btnEliminar);
        VBox root = new VBox(10, inputs, botones, tabla,lblhoras,lblerror);
        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Registro de Inscripciones");
        stage.setScene(scene);
        stage.show();
	}
	     public static void main(String[] args) {
	         launch();
	}

}
