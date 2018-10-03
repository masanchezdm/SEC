/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.ciencias.is.controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mx.unam.ciencias.is.modelo.Usuario;
import mx.unam.ciencias.is.modelo.UsuarioI;
import mx.unam.ciencias.is.modelo.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
    
    @Autowired
    private UsuarioDAO usuario_bd;
    private static ArrayList<UsuarioI> usuarios = new ArrayList<UsuarioI>();
    private UsuarioI usuario;
     /**
      * Metodo que responde a la peticion raiz
      * @return el nombre del jsp de inicio
      */
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(){
        usuarios.add(new UsuarioI("admin", "admin", 2));
        usuarios.add(new UsuarioI("adriana", "Sanchez", "Del Moral", "adriana", "55", "contrasena", 0));
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
    @RequestMapping(value="/registrarse", method = RequestMethod.GET)
    public ModelAndView registrarse(HttpServletRequest request,ModelMap model){
        return new ModelAndView("mi-registro",model);
    
    }
    
    @RequestMapping(value="/iniciar_sesion", method = RequestMethod.POST)
    public ModelAndView iniciar_sesion(HttpServletRequest request,ModelMap model) throws SQLException{
        HttpSession objSesion = request.getSession(true);   
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");
        usuario= get_user(correo, contrasena);
        if(usuario == null)
            return new ModelAndView("index",model);
        objSesion.setAttribute("usuario", usuario );
        model.addAttribute("parametro", usuario.getNombre());
        model.addAttribute("nombre", ((UsuarioI)objSesion.getAttribute("usuario")).getNombre());
        return new ModelAndView("index",model);
    
    }
    
    private static UsuarioI get_user(String correo, String contrasena){
        if(usuarios.isEmpty())
            System.out.println("No hay nada");
        for(UsuarioI usuario: usuarios){
            System.out.println(usuario.getNombre());
            if(usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)){
                System.out.println("lo encontro");
                return usuario;
            }
        }
        return null;
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
        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("app", usuario.getApp());
        model.addAttribute("apm", usuario.getApm());
        model.addAttribute("correo", usuario.getCorreo());
        model.addAttribute("telefono", usuario.getTelefono());
        model.addAttribute("contrasena", usuario.getContrasena());
        if(usuario.getIs_profesor() != 2)
            return new ModelAndView("editar_perfil",model);
        return new ModelAndView("editar_admin",model);
    
    }
    @RequestMapping(value="/registra/usuario", method = RequestMethod.POST)
    public ModelAndView registra(HttpServletRequest request,ModelMap model){        
        Enumeration enumeration = request.getParameterNames();
        Map<String, Object> modelMap = new HashMap<>();
        Usuario nuevo = new Usuario();
        while(enumeration.hasMoreElements()){
            String parameterName = (String) enumeration.nextElement();
            if((request.getParameter(parameterName)).length() != 0  && parameterName.equals("nombre")){
                nuevo.setNombre(request.getParameter(parameterName));
                System.out.println("entro a nombre "+ request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("app")){
                nuevo.setApp(request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("apm")){
                nuevo.setApm(request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("correo")){
                nuevo.setCorreo(request.getParameter(parameterName));                
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("telefono")){
                nuevo.setTel(request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("contrasena")){
                nuevo.setContrasenia(request.getParameter(parameterName));
            }        
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("is_profe")){
                nuevo.setRol(Integer.parseInt(request.getParameter(parameterName)));
            }        
                
            modelMap.put(parameterName, request.getParameter(parameterName));
        } 
        usuario_bd.guardar(nuevo);
        model.addAttribute("nombre", usuario.getNombre());
        return new ModelAndView("index",model);
        
    
    }

    @RequestMapping(value="/editar/datos", method = RequestMethod.POST)
    public ModelAndView editar_datos(HttpServletRequest request,ModelMap model){
        HttpSession objSesion = request.getSession(true); 
        if(((UsuarioI)objSesion.getAttribute("usuario")).getNombre()== null)
            return new ModelAndView("index",model);
        Enumeration enumeration = request.getParameterNames();
        Map<String, Object> modelMap = new HashMap<>();
        while(enumeration.hasMoreElements()){
            String parameterName = (String) enumeration.nextElement();
            System.out.println(parameterName + " -> "+ ((request.getParameter(parameterName)).length() != 0));
            if((request.getParameter(parameterName)).length() != 0  && parameterName.equals("nombre")){
                usuario.setNombre(request.getParameter(parameterName));
                System.out.println("entro a nombre "+ request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("app")){
                usuario.setApp(request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("apm")){
                usuario.setApm(request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("correo")){
                usuario.setCorreo(request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("telefono")){
                usuario.setTelefono(request.getParameter(parameterName));
            }
            if((request.getParameter(parameterName)).length() != 0 && parameterName.equals("contrasena")){
                usuario.setContrasena(request.getParameter(parameterName));
            }
                
//            modelMap.put(parameterName, request.getParameter(parameterName));
        }        
        model.addAttribute("nombre", usuario.getNombre());
        model.addAttribute("app", usuario.getApp());
        model.addAttribute("apm", usuario.getApm());
        model.addAttribute("correo", usuario.getCorreo());
        model.addAttribute("telefono", usuario.getTelefono());
        model.addAttribute("contrasena", usuario.getContrasena());
        if(usuario.getIs_profesor() != 2)
            return new ModelAndView("editar_perfil",model);
        return new ModelAndView("editar_admin",model);
        
    }
    
}
