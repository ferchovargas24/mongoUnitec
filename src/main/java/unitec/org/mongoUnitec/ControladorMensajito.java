package unitec.org.mongoUnitec;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ControladorMensajito{

    @Autowired RepositorioMensajito repoMensa;
    //  aqui a contnuacion van las 5 operaciones basicas con la entidad mensaje

    @RequestMapping(value="/mensajito", method=RequestMethod.GET,
            headers = {"Accept=application/json"})
    public ArrayList<Mensajito> obetenerTodos()throws Exception{
        return (ArrayList<Mensajito>) repoMensa.findAll();
    }

    @RequestMapping(value="/mensajito/{id}", method=RequestMethod.GET,
            headers = {"Accept=application/json"})
    public Mensajito obetenerPorId(@PathVariable String id)throws Exception{
        return repoMensa.findOne(id);
    }

    //Metodo POST para guardar version para clientes varibles (web y desktop)
    @RequestMapping(value="/mensajito/{titulo}/{cuerpo}", method=RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarMensajito(@PathVariable String titulo, @PathVariable String cuerpo)throws Exception{
        repoMensa.save(new Mensajito(titulo,cuerpo));
        Estatus estatus = new Estatus();
        estatus.setSuccess(true);
        return estatus;
    }

    //Metodo POST para guardar, pero es una version mas pura y efectiva
    @RequestMapping(value="/mensajito}", method=RequestMethod.POST,
            headers = {"Accept=application/json"})
    public Estatus guardarMensajitoPuro(@RequestBody String json)throws Exception{
        ObjectMapper maper = new ObjectMapper();
        Mensajito mensa = maper.readValue(json, Mensajito.class);
        repoMensa.save(mensa);
        Estatus es = new Estatus();
        es.setSuccess(true);
        return es;
    }
}