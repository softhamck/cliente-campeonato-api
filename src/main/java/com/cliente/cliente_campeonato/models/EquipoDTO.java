package com.cliente.cliente_campeonato.models;

public class EquipoDTO {
    private Long id;
    private String nombre;
    private String ciudad;
    private String directorTecnico;
    private String nombreCampeonato;
    private String nombreGrupo;
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    
    public String getDirectorTecnico() { return directorTecnico; }
    public void setDirectorTecnico(String directorTecnico) { this.directorTecnico = directorTecnico; }
    
    public String getNombreCampeonato() { return nombreCampeonato; }
    public void setNombreCampeonato(String nombreCampeonato) { this.nombreCampeonato = nombreCampeonato; }
    
    public String getNombreGrupo() { return nombreGrupo; }
    public void setNombreGrupo(String nombreGrupo) { this.nombreGrupo = nombreGrupo; }
}