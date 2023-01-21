package work.appdeploys.veterinaria.constans;

public enum MessageResource {
    USUARIO_ALREADY_EXISTS ("El usuario ya esta registrado"),
    USUARIO_DOCUMENT_ID_ALREADY_EXISTS ("Numero de documento ya esta en otro usuario"),
    USUARIO_DOCUMENT_TYPE_NOT_EXISTS ("Tipo de identificaion no catalagado"),
    USUARIO_NOT_EXISTS_DELETE ("El usuario no esta en la base de datos, no se puede eliminar"),
    USUARIO_SEX_CODE_NOT_EXISTS ("Codigo del sexo no esta catalogado para el usuario"),
    USUARIO_NOT_FOUND ("No existen usuarios para listar"),
    USUARIO_NOT_EXISTS ("El usuario no esta en la base de datos"),
    MASCOTA_ALREADY_EXISTS ("Nombre de mascota ya se encuentra asocida al usurio"),
    MASCOTA_SEX_CODE_NOT_EXISTS ("Codigo del sexo no esta catalogado para la mascota"),
    MASCOTA_ALREADY_EXISTS_ID ("La mascota ya esta registrada en la base de datos por id"),
    MASCOTA_NOT_EXISTS_DELETE ("La mascota no esta en la base de datos por ese id no se puede borrar"),
    MASCOTA_NOT_EXISTS ("La mascota no esta en la base de datos"),
    MASCOTAS_NOT_FOUND ("No existen macotas para listar"),
    HISTORIA_CLINICA_NOT_EXISTS ("La historia clinica no esta en la base de datos"),
    HISTORIA_CLINICA_ALREADY_EXISTS ("Ya exite historia clinica en la base de datos"),
    HISTORIA_CLINICA_MASCOTA_ALREADY_EXISTS ("Macota ya tiene historia clinica"),
    HISTORIA_CLINICA_NOT_FOUND ("No existe historia clinica para listar"),
    COLABORADOR_ALREADY_EXISTS ("El colaborador ya esta registrado"),
    COLABORADOR_DOCUMENT_ID_ALREADY_EXISTS ("Numero de documento ya esta en otro colaborador"),
    COLABORADOR_DOCUMENT_TYPE_NOT_EXISTS ("Tipo de identificaion no catalagado del colaborador"),
    COLABORADOR_NOT_EXISTS_DELETE ("El colaborador no esta en la base de datos, no se puede eliminar"),
    COLABORADOR_NOT_FOUND ("No existen colaboradores para listar"),
    COLABORADOR_NOT_EXISTS("El colaborador no esta en la base de datos por ese id"),
    NAME_NULL ("El nombre se encuentra en blanco"),
    LAST_NAME_NULL ("El apellido se encuentra en blanco"),
    CONDITION_NULL ("El estado se encuentra en blanco"),
    POSITION_NULL("El cargo se encuentra en blanco"),
    HISTORIA_DETALLE_CLINICA_ALREADY_EXISTS("Ya exite ese id detalle de la historia clinica en la base de datos"),
    HISTORIA_DETALLE_CLINICA_NOT_EXISTS("No exite ese id detalle de la historia clinica en la base de datos"),
    HISTORIA_DETALLE_CLINICA_INVALID_DATE_TIME("Fecha y hora del detalle de la historia clinica no es valido"),
    DETALLE_HISTORIA_CLINICA_NOT_FOUND ("No existe detalle de historia la clinica para listar"),
    CONSTRAIN_VIOLATION("Existen relacion contras tablas no se puede eliminar"),
    DATE_NOT_VALID("Fecha no valida");
    private String value;
    public String getValue()
    {
        return this.value;
    }
    MessageResource(String value)
    {
        this.value = value;
    }
}
