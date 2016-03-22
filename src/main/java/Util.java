import Domain.Change;
import Domain.InvalidResponse;
import Domain.Response;
import Domain.TimeLine;
import Domain.Usuario;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by juan.portillo on 21/03/16.
 */
public class Util {
    static ObjectMapper mapper = new ObjectMapper();

    public static Response mapper(String jsonInString) throws IOException {
        return mapper.readValue(jsonInString, Response.class);
    }

    public static List<Change> getChanges (Response response) {
        List listaDeCambios = new ArrayList<Change>();
        for (TimeLine timeLine : response.getTimeline()) {
            Change change = new Change();
            change.setJugador(getJugadorName(timeLine.getMensaje()));
            change.setUsuario(timeLine.getUsuario());
            listaDeCambios.add(change);
        }
        return listaDeCambios;
    }

    private static String getJugadorName(String mensaje) {
        String[] jugador = mensaje.split(" ");
        String jugadorParser = jugador[jugador.length-2].concat(jugador[jugador.length-1]);
        return jugadorParser;
    }

    public static Map<String,List<Usuario>> getChangesRank(List<Change> cambios) {
        Map<String,List<Usuario>> changesRank = new HashMap<String, List<Usuario>>();
        for (Change change : cambios) {
            if (!changesRank.isEmpty() && changesRank.containsKey(change.getJugador())) {
                changesRank.get(change.getJugador()).add(change.getUsuario());
            } else {
                List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
                listaDeUsuarios.add(change.getUsuario());
                changesRank.put(change.getJugador(), listaDeUsuarios);
            }
        }
        return changesRank;
    }

    public static String getCSFRCode(String s) throws IOException {
        InvalidResponse invalidResponse = mapper.readValue(s, InvalidResponse.class);
        return invalidResponse.getRemCSRF();
    }
}
