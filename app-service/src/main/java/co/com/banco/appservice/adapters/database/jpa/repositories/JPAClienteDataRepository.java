package co.com.banco.appservice.adapters.database.jpa.repositories;

import co.com.banco.appservice.adapters.database.jpa.entities.ClienteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface JPAClienteDataRepository extends CrudRepository<ClienteEntity, Integer>, QueryByExampleExecutor<ClienteEntity> {
    List<ClienteEntity> findByEstado(String estado);
}