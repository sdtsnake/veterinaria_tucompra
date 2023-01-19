package work.appdeploys.veterinaria.constans;

public enum MessageResource {
    USUARIO_ALREADY_EXISTS ("El usuario ya esta registrado"),
    USUARIO_DOCUMENT_TYPE_NOT_EXISTS ("Tipo de identificaion no catalagado"),
    USUARIO_SEX_CODE_NOT_EXISTS ("Codigo del sexo no esta catalogado");
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
