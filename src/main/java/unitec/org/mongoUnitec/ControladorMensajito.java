package unitec.org.mongoUnitec;

import java.util.ArrayList;
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
}