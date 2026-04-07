package app.service;


import app.model.Inscripcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class InscripcionService {
	   private ObservableList<Inscripcion> lista = FXCollections.observableArrayList();
	public Inscripcion crearInscripcion(String nombre,String curso,String horasTexto) {
		int horas=Integer.parseInt(horasTexto);
		
		if(nombre.isEmpty()) {
			throw new IllegalArgumentException("El nombre no puede estar vacio");
		}
		if(curso.isEmpty()) {
			throw new IllegalArgumentException(" Curso no puede estar vacio");
		}
		if(horas<=0) {
			throw new IllegalArgumentException(" Horas no puede ser 0 ");
		}
		Inscripcion inscripcion= new Inscripcion(nombre, curso, horas);
		lista.add(inscripcion);
		return inscripcion;	
		}
	
		public void removerInscripcion(Inscripcion inscripcion) {
			lista.remove(inscripcion);
			
		}
		public ObservableList<Inscripcion>devolverLista(){
			return lista;
			
		}
		public int calcularHoras() {
			int sumarTotal=0;
			for(Inscripcion inscripcion:lista) {
				sumarTotal+=inscripcion.getHoras();
			}
			return sumarTotal;
		}


}
