package co.com.banco.appservice.adapters.database.jpa.repositories;

import co.com.banco.appservice.adapters.database.jpa.entities.CuentaData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface JPACuentaDataRepository extends CrudRepository<CuentaData, Integer>, QueryByExampleExecutor<CuentaData> {
    CuentaData findByNumeroCuenta(String numeroCuenta);
    List<CuentaData> findByEstado(String estado);
}