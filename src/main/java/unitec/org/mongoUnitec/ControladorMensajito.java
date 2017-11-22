package unitec.org.mongoUnitec;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ControladorMensajito{

    @Autowired RepositorioMensajito repoMensa;
    //  aqui a contnuacion van las 5 operaciones basicas con la entidad mensaje

    @RequestMapping(value="/buscar", method=RequestMethod.GET,
            headers = {"Accept=application/json"})
    public ArrayList<Mensajito> obtenerMensajito()throws Exception{
        return (ArrayList<Mensajito>) repoMensa.findAll();
    }

}