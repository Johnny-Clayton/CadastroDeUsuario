package cadastro.complexo;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserMap {

    private Map<String, String> userMap;

    public UserMap() {
        this.userMap = new HashMap<>();
    }

    public Map<String, String> getUserMap() {
        return userMap;
    }

    public String get(String chave) {
        return userMap.get(chave);
    }

    public boolean containsKey(String key) {
        return userMap.containsKey(key);
    }

    public void put(String usuarioNovo, String senhaNova) {
        userMap.put(usuarioNovo, senhaNova);
    }

	public void remove(String usuario) {
		userMap.remove(usuario);
		
	}

	public Set<String> keySet() {
		return userMap.keySet();
	}	
}

