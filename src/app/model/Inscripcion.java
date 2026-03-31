package app.model;

public class Inscripcion {
	private String alumno;
	private String curso;
	private int horas;
	public Inscripcion(String alumno, String curso, int horas) {
		
		this.alumno = alumno;
		this.curso = curso;
		this.horas = horas;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	

}
