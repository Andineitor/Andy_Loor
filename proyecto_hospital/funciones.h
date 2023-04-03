
//estructura de los datos a ingresar
typedef struct {
    int id;
    string nom;
    int edad;
    float peso;
    float estatura;
    string sangre;
    int cel;
    string correo;
}tHospital;

//estructura de los datos a ingresar en un arreglo
typedef struct {
    tHospital datoslista[MAX];
    int contador;
}tDatos;

//estructuras de datos en variable
tHospital info;
tDatos list;

//menu 
void agendarcita();

//carga citas ongresadas
void cargar(tDatos& list, bool& ok);

//muestra pacientes ingresados
void ordenarBurburjaa(tDatos& list, tHospital& nom);
void mostrarpasientes(tDatos list, int contador);

//consulta citas ongresadas
void consultar(const tDatos& list, string buscar);

//eliminar datos ingresados
int datoelim(tDatos list);
void elimina(tDatos& list, int& contador, int pos);


