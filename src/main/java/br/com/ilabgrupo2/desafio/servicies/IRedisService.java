package br.com.ilabgrupo2.desafio.servicies;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public interface IRedisService {
    Jedis connecting();
    Set<String> getClients();
    void disconnecting(Jedis pool);
}
