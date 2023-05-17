package co.com.banco.appservice.adapters.database.jpa.repositories;

import co.com.banco.appservice.adapters.database.jpa.entities.MovimientoData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.Date;
import java.util.List;

public interface JPAMovimientoDataRepository extends CrudRepository<MovimientoData, Integer>, QueryByExampleExecutor<MovimientoData> {
    List<MovimientoData> findByFechaMovimientoBetween(Date inicio, Date fin);

    List<MovimientoData> findByCuentaDataId(Integer id);
}