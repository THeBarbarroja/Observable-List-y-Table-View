package app.service;

import a.Producto;
import app.model.Inscripcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;

public class InscripcionService {
	public Inscripcion crearInscripcion(String nombre,String curso,int horas) {
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
		if(curso.isEmpty()) {
			throw new IllegalArgumentException("curso no puede estar vacio");
		}
		
		return new Inscripcion(nombre,curso,horas);
	}
	   private ObservableList<Inscripcion> lista = FXCollections.observableArrayList();
	  

}
