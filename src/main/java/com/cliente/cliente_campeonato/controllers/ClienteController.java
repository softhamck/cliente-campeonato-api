package com.cliente.cliente_campeonato.controllers;

import com.cliente.cliente_campeonato.models.EquipoDTO;
import com.cliente.cliente_campeonato.services.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ApiService apiService;
    
    // Página principal del cliente
    @GetMapping("/")
    public String paginaPrincipal() {
        return "index";
    }
    
    // Mostrar formulario de búsqueda
    @GetMapping("/buscar")
    public String mostrarFormularioBusqueda() {
        return "buscarEquipos";
    }
    
    // BUSCAR POR NOMBRE
    @PostMapping("/buscarPorNombre")
    public String buscarPorNombre(@RequestParam String nombre, Model model) {
        List<EquipoDTO> equipos = apiService.buscarPorNombre(nombre);
        model.addAttribute("equipos", equipos);
        model.addAttribute("tipoBusqueda", "Nombre: " + nombre);
        model.addAttribute("totalResultados", equipos.size());
        return "resultadoEquipos";
    }
    
    // BUSCAR POR CIUDAD
    @PostMapping("/buscarPorCiudad")
    public String buscarPorCiudad(@RequestParam String ciudad, Model model) {
        List<EquipoDTO> equipos = apiService.buscarPorCiudad(ciudad);
        model.addAttribute("equipos", equipos);
        model.addAttribute("tipoBusqueda", "Ciudad: " + ciudad);
        model.addAttribute("totalResultados", equipos.size());
        return "resultadoEquipos";
    }
    
    // BUSCAR POR CAMPEONATO
    @PostMapping("/buscarPorCampeonato")
    public String buscarPorCampeonato(@RequestParam Long idCampeonato, Model model) {
        List<EquipoDTO> equipos = apiService.buscarPorCampeonato(idCampeonato);
        model.addAttribute("equipos", equipos);
        model.addAttribute("tipoBusqueda", "Campeonato ID: " + idCampeonato);
        model.addAttribute("totalResultados", equipos.size());
        return "resultadoEquipos";
    }
    
    // LISTAR TODOS
    @GetMapping("/listarTodos")
    public String listarTodos(Model model) {
        List<EquipoDTO> equipos = apiService.listarEquipos();
        model.addAttribute("equipos", equipos);
        model.addAttribute("tipoBusqueda", "Todos los equipos");
        model.addAttribute("totalResultados", equipos.size());
        return "resultadoEquipos";
    }
}