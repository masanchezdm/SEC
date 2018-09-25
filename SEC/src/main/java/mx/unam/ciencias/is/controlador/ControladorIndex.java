/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jonh
 */
@Controller 
public class ControladorIndex {
    
    
     /**
      * Metodo que responde a la peticion raiz
      * @return el nombre del jsp de inicio
      */
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        return "index";
    
    }
    @RequestMapping(value="/peticion1", method = RequestMethod.GET)
    public void peticion1(HttpServletRequest request){
        String parametro = request.getParameter("parametro");
        System.out.println("La peticion1 es: =================>"+parametro);
    
    }
    
    @RequestMapping(value="/peticion2", method = RequestMethod.GET)
    public ModelAndView peticion2(HttpServletRequest request,ModelMap model){
        String parametro = request.getParameter("parametro");
        System.out.println("La peticion2 es: =================>"+parametro);
        model.addAttribute("parametro", parametro);
        return new ModelAndView("index",model);
    
    }
    
    @RequestMapping(value="/peticion3", method = RequestMethod.GET)
    public ModelAndView peticion3(HttpServletRequest request,ModelMap model){
        String parametro = request.getParameter("param");
        System.out.println("La peticion3 es: =================>"+parametro);
        model.addAttribute("parametro", parametro);
        return new ModelAndView("index",model);
    
    }
    
    @RequestMapping(value="/iniciar_sesion", method = RequestMethod.GET)
    public ModelAndView iniciar_sesion(HttpServletRequest request,ModelMap model){
        HttpSession objSesion = request.getSession(true); 
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        objSesion.setAttribute("usuario", correo );
        model.addAttribute("sesion", (String)objSesion.getAttribute("usuario"));
        return new ModelAndView("index",model);
    
    }
    @RequestMapping(value="/cerrar_sesion", method = RequestMethod.GET)
    public ModelAndView cerrar_sesion(HttpServletRequest request,ModelMap model){
        HttpSession objSesion = request.getSession(true); 
        objSesion.removeAttribute("usuario");
        return new ModelAndView("index",model);
    
    }
    @RequestMapping(value="/editar_perfil", method = RequestMethod.GET)
    public ModelAndView editar_perfil(HttpServletRequest request,ModelMap model){
        HttpSession objSesion = request.getSession(true); 
        objSesion.removeAttribute("usuario");
        return new ModelAndView("editar_perfil",model);
//        return new ModelAndView("editar_admin",model);
    
    }

    @RequestMapping(value="/editar/datos", method = RequestMethod.POST)
    public ModelAndView editar_datos(HttpServletRequest request,ModelMap model){
        HttpSession objSesion = request.getSession(true); 
        String usuario = (String)objSesion.getAttribute("usuario");
        if(objSesion.getAttribute("usuario")== null)
            return new ModelAndView("index",model);
        Enumeration enumeration = request.getParameterNames();
        Map<String, Object> modelMap = new HashMap<>();
        while(enumeration.hasMoreElements()){
            String parameterName = (String) enumeration.nextElement();
            System.out.println(parameterName + " -> "+request.getParameter(parameterName));
//            modelMap.put(parameterName, request.getParameter(parameterName));
        }
        return new ModelAndView("editar_perfil",model);
    }
    
}
