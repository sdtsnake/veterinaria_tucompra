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
