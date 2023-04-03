#include<iostream>
#include<string>
#include<iomanip>
#include<fstream>

using namespace std;
const int Max = 100;

typedef struct {
    string nom;
    int numcan;
    string autor;
    string gen;
}tDatos;

typedef struct {
    tDatos contenido[Max];
    int con;
}tLista;

void ordenar( tLista& lista);
int menu();
void listado(const tLista& lista);
void cargar(tLista& lista, bool& ok);
void guardar(const tLista& lista);
void leer(tDatos& datos,tLista lista);
void insertar(tLista& lista, tDatos datos, bool& ok);
void mostrar(tDatos datos);
void ordenarBurburja(tLista& lista, tDatos& nom);
bool operator<(tDatos opIzq, tDatos opDer);

int menu() {
    int op;
	cout<<endl<<endl;
    do {
        cout <<" 1.-Mostar lista original."<<endl;
        cout << " 2.-Agregar una nueva cancion." << endl;
        cout << " 3.-Mostrar canciones ordenadas por titulo o autor." << endl;
        cout << " 4.-Ordenar canicones por numero de cancion." << endl;
        cout << " 0.-Salir" << endl;
        cout << " Opcion: ";
        cin >> op;
        
    } while ((op < 0) || (op > 5));
    return op;
}

void cargar(tLista& lista, bool& ok) {
    tDatos datos;
    ifstream archivo;
    char aux;
    lista.con = 0;//INICIAMOS LA LISTA
    archivo.open("canciones.txt");
    if (!archivo.is_open()) {
        ok = false;
    }
    else {
        ok = true;
        archivo >> datos.numcan;
        while ((datos.numcan != -1) && (lista.con< Max)) {
            archivo>> datos.nom;
            archivo>> datos.autor;
            archivo>> datos.gen;
            archivo.get(aux);//SALTAMOS INTRO
            lista.contenido[lista.con] = datos;//AL FINAL
            lista.con++;
            archivo >> datos.numcan;//SIGUIENTE NOMBRE
        } //SI HAY MAS DE MAX ESTUDIANTES, IGNORAMOS EL RESTO
        archivo.close();
    }
}
void guardar(const tLista& lista) {
    ofstream archivo;
    archivo.open("canciones.txt");
    for (int i = 0; i < lista.con; i++) {
        archivo << lista.contenido[i].numcan << endl;
        archivo << lista.contenido[i].nom << endl;
        archivo << lista.contenido[i].autor << endl;
        archivo << lista.contenido[i].gen << endl;
    }
    archivo << -1 << endl;//CENTINELA
    archivo.close();
}
void leerDatos(tDatos& datos,tLista lista) {
    cin.ignore(80, '\n');
    cout <<endl<< "Titulo de la cancion: ";
     getline(cin,datos.nom);
    cout << "Nombre del Autor: ";
    getline(cin,datos.autor);
    cout << "Genero:  ";
    getline(cin,datos.gen);
    datos.numcan = lista.con+1;
    cin.sync();
}
void insertarDatos(tLista& lista, tDatos datos, bool& ok) {
    ok = true;
    if (lista.con == Max) {
        ok = false;
    }
    else {
        lista.contenido[lista.con] = datos;
    
        lista.con++;
    }
}

void mostrarDatos(tDatos datos) {
    cout << setw(2) << right << datos.numcan << "  ";
    cout << setw(40) << left << datos.nom;
    cout << setw(30) << left << datos.autor;
    cout << setw(12) << left << datos.gen<<endl;
}
void listado(const tLista& lista) {
    cout<<endl << setw(11) << right << "Numero" << setw(40) << left << " Titulo" << setw(30) << left << " Autor" << setw(12) << left << " Genero"  << endl;
    for (int i = 0; i < lista.con; i++) {
    	cout<<"\t";
        mostrarDatos(lista.contenido[i]);
    }
}
void ordenarBurburja(tLista& lista, tDatos& nom) {
    int i = 0;
    bool inter = true;
    tDatos temp;
    if (lista.con == 0) {
        cout << endl << "ERROR! No existen registro de cancion" << endl << endl;
    }
    else {
        while ((i < lista.con - 1) && inter) {
            inter = false;
            for (int j = lista.con - 1; j > i; j--) {
                if (lista.contenido[j] < lista.contenido[j - 1]) {
                    temp = lista.contenido[j];
                    lista.contenido[j] = lista.contenido[j - 1];
                    lista.contenido[j - 1] = temp;
                    inter = true;
                }
            }
            if (inter) {
                i++;
            }
        }
        cout << endl << " Canciones Ordenadas Por Autor " << endl << endl;
        listado(lista);
    }
}

bool operator<(tDatos opIzq, tDatos opDer) {
    return (opIzq.nom < opDer.nom);
}

int main() {
    tLista lista;
    tDatos datos;
    bool exito;
    int op, pos;
    cout<<endl<<endl<<"\t\t\t\t :::: Sistema de Canciones ::::"<<endl <<endl;
    cargar(lista, exito);
    if (!exito) {
        cout << "No se ha podido cargar la lista" << endl;
    }
    else {
        do {
            op = menu();
            switch (op) {
              case 1:
              {
                listado(lista);
                break;
              }
            case 2:
            {
                leerDatos(datos,lista);
                insertarDatos(lista, datos, exito);
                if (!exito) {
                    cout << "Lista llena: imposible ingresar mas canciones" << endl;
                }
            }
            break;
            case 3:
            {
                ordenarBurburja(lista, datos);
            

            }
            break;
            
            case 4: 
            ordenar(lista);
               listado(lista);
            
            }
        } while (op != 0);
        guardar(lista);
    }
    return 0;
}


void ordenar(tLista& lista)
{
    tDatos aux;
    for (int i = 0; i < lista.con; i++)
    {
        for (int j = i + 1; j < lista.con; j++)
        {
            if (lista.contenido[i].numcan > lista.contenido[j].numcan)
            {
                aux = lista.contenido[i];
                lista.contenido[i] = lista.contenido[j];
                lista.contenido[j] = aux;
            }
        }
    }
    cout << endl;
    cout << " Canciones Ordenadas por Numero" << endl;
}


