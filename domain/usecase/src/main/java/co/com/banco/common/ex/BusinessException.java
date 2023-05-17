package co.com.banco.common.ex;

import java.util.function.Supplier;

public class BusinessException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public enum Type {
        ERROR_BASE_DATOS("Error en base de datos"),
        SALDO_INFERIOR_CERO("Saldo no disponible"),
        CUENTA_NO_ENCONTRADA("La cuenta no existe!"),
        ERROR_CAMPO_NULL_CUENTA("Se detecto un campo vacio, por favor validar los datos de la cuenta."),
        ERROR_CAMPO_NULL_CLIENTE("Se detecto un campo vacio, por favor validar los datos del cliente."),
        ERROR_CAMPO_NULL_MOVIMIENTO("Se detecto un campo vacio, por favor validar los datos del movimiento."),
        ERROR_CAMPO_NULL_PERSONA("Se detecto un campo vacio, por favor validar los datos de la persona."),
        ERROR_PERSONA_NO_REGISTRADA("La Persona no se encuentra registrada."),
        ERROR_CLIENTE_NO_REGISTRADO("El cliente no se encuentra registrado."),
        MOVIMIENTO_NO_ENCONTRADO("Movimiento Bancario No Encontrado."),
        ERROR_CUENTA_NO_REGISTRADO("La Cuenta no se encuentra registrada."),
        PERSONA_EXISTE("La persona ya se encuentra registrada."),
        CUENTA_YA_EXISTE("La cuenta ya se encuentra registrada."),
        FORMATO_FECHA_INVALID("Formato de fecha invalido, formato requerido: yyyy-MM-dd"),
        FECHA_INICIAL_MAYOR("La fecha inicial no debe ser posterior a la fecha final."),
        FECHA_PARAMETRO_NO_ENCONTRADO("Falta algun parametro para generar reporte. Parametros: inicio=yyyy-MM-dd y fin=yyyy-MM-dd."),
        TIPO_MOVIMIENTO_NO_VALIDO("Tipo de movimiento Bancario No Valido."),
        ID_NULL(" El id no puede ser null"),
        MOVIMIENTO_NO_PERMITIDO("El valor del movimiento bancario debe ser superior a cero."),
        MOVIMIENTO_NO_ES_ULTIMO("Solo se permite modificar el último movimiento bancario."),
        OPERACION_NO_PERMITDA("Operacion no permitida."),
        PATH_NO_IGUAL_ID("Id y Path del objeto a editar deben ser iguales."),
        TIPO_CUENTA_NO_VALIDO("Tipo de cuenta no valido.");

        private final String message;

        public String getMessage() {
            return message;
        }

        public BusinessException build() {
            return new BusinessException(this);
        }

        public Supplier<Throwable> defer() {
            return () -> new BusinessException(this);
        }

        Type(String message) {
            this.message = message;
        }

    }

    private final Type type;

    public BusinessException(Type type){
        super(type.message);
        this.type = type;
    }

    public BusinessException(Type type,String menssage){
        super(menssage);
        this.type = type;
    }

    @Override
    public String getCode(){
        return type.name();
    }


}
