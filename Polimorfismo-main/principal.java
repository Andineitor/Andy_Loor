public class principal {
    public static void main(String[] args) {
        Usuario obj = new Usuario();
        obj.setNombre();
        obj.setNombre("Saul");
        System.out.printf("el nuevo nombre es: "+ obj.getNombre());

        obj.setCargo();
        obj.setCargo("Administrador");
        System.out.println("\nEl nuevo cargo es: "+ obj.getCargo());

        obj.setId();
        obj.setId(123456789);
        System.out.println("La nueva cedula es: "+ obj.getid());

        obj.setEdad();
        obj.setEdad(23);
        System.out.println("La nueva edad es: "+ obj.getEdad());
    }
}
