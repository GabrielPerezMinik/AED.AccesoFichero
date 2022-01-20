package dataAcces.accesofichero.Model;

import java.io.File;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AccesoFicheroModelo {

	private StringProperty rutaActual=new SimpleStringProperty(); 
	private StringProperty subRuta=new SimpleStringProperty();
	private ListProperty<File> listadoIzquierdo=new SimpleListProperty<File>(FXCollections.observableArrayList());
	private ListProperty<File> listadoDerecho= new SimpleListProperty<File>(FXCollections.observableArrayList());
	File fichero;
	
	
	
	public File getFichero() {
		return fichero;
	}

	public void setFichero(File fichero) {
		this.fichero = fichero;
	}

	public final StringProperty rutaActualProperty() {
		return this.rutaActual;
	}
	
	public final String getRutaActual() {
		return this.rutaActualProperty().get();
	}
	
	public final void setRutaActual(final String rutaActual) {
		this.rutaActualProperty().set(rutaActual);
	}
	
	public final StringProperty subRutaProperty() {
		return this.subRuta;
	}
	
	public final String getSubRuta() {
		return this.subRutaProperty().get();
	}
	
	public final void setSubRuta(final String subRuta) {
		this.subRutaProperty().set(subRuta);
	}
	
	public final ListProperty<File> listadoIzquierdoProperty() {
		return this.listadoIzquierdo;
	}
	
	public final ObservableList<File> getListadoIzquierdo() {
		return this.listadoIzquierdoProperty().get();
	}
	
	public final void setListadoIzquierdo(final ObservableList<File> listadoIzquierdo) {
		this.listadoIzquierdoProperty().set(listadoIzquierdo);
	}
	
	public final ListProperty<File> listadoDerechoProperty() {
		return this.listadoDerecho;
	}
	
	public final ObservableList<File> getListadoDerecho() {
		return this.listadoDerechoProperty().get();
	}
	
	public final void setListadoDerecho(final ObservableList<File> listadoDerecho) {
		this.listadoDerechoProperty().set(listadoDerecho);
	}
	
	
	
}
