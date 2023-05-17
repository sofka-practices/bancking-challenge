package co.com.banco.appservice.adapters.database.jpa.repositories;

import co.com.banco.appservice.adapters.database.jpa.entities.PersonaData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPAPersonaDataRepository extends CrudRepository<PersonaData, Integer>, QueryByExampleExecutor<PersonaData> {
    PersonaData findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}