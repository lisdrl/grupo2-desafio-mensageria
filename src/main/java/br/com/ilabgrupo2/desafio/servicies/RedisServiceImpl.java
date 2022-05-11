package br.com.ilabgrupo2.desafio.servicies;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ilabgrupo2.desafio.dao.UsuarioDAO;
import redis.clients.jedis.Jedis;
import br.com.ilabgrupo2.desafio.model.Clientes;

@Service
public class RedisServiceImpl implements IRedisService{
    @Autowired
    UsuarioDAO dao; 

    @Override
    public Jedis connecting() {
        Jedis pool = new Jedis("http://localhost:6379");
        return pool; 
    };
    
    @Override
    public Set<String> getClients() {
        Jedis pool = this.connecting();
        
        List<Clientes> clientes; 

        Set<String> clientesRedis = pool.smembers("clientes");

        if (clientesRedis.size() == 0) { 
            System.out.print("Entrou no if e pegou dados no db \n \n"); 
            clientes = dao.findAll();
            
            for (Clientes cliente : clientes) { 
                pool.sadd("clientes", cliente.getNome());
            }
            pool.expire("clientes", 30);

            clientesRedis = pool.smembers("clientes");
        }
        this.disconnecting(pool);

        return clientesRedis; 
    }

    @Override
    public void disconnecting(Jedis pool) { 
        pool.close();
    }


}
