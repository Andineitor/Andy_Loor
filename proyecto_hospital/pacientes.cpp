#include<iostream>
#include<string>
#include<fstream>
#include<iomanip>
#include <cstdlib>
#include<windows.h>
#define color SetConsoleTextAttribute
HANDLE hConsole = GetStdHandle(STD_OUTPUT_HANDLE);
using namespace std;
const int MAX = 100;
#include "funciones.h"
#include "desarrollo.h"
int main() {
	
    bool exito;
    cargar(list, exito);
    if (!exito) {
    	color(hConsole, 4);
        cout << "No se ha podido cargar la lista" << endl;
        color(hConsole, 7);
    }
    else {
        int op;
        do {
            cout << endl << endl;
            color(hConsole, 3);
            cout << "\t\t\t\t\t\t\t :::: PLATAFORMA DIGITAL REGISTRO DE PACIENTES ::::" << endl<<endl;
            color(hConsole, 7);
            cout << " 1.-MOSTAR PACIENTES" << endl;
            cout << " 2.-AGREGAR PACIENTES" << endl;
            cout << " 3.-ELIMINAR PACIENTES" << endl;
            cout << " 4.-BUSCAR PACIENTE" << endl;
            cout << " 0.-SALIR" << endl <<endl;
            cout << " OPCION -->  ";
            cin >> op;
            switch (op) {
            case 1:
            {
                system("cls");
                ordenarBurburjaa(list, info);
                mostrarpasientes(list, list.contador);
                break;
            }
            case 2:
            {
                system("cls");
                agendarcita();
                break;
            }
            case 3:
            {
            	
            	int pos;
                pos = datoelim(list);
            	system("cls");    
                elimina(list, list.contador, pos);
                break;
            }
            case 4:
            {
                system("cls");
                int x;
                cout << "\n\n\n\n ";
                color(hConsole, 11);
                cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t|         BUSCAR PACIENTES            |" << endl;
                cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl << endl;
                color(hConsole, 7);
                cout<<endl<<endl<<endl << "\t\t\t\tINGRESA EL NUMERO DE CEDULA DEL PASCIENTE: ";
                cin >> x;
                consultar(list, x);
                break;
            }

            }
        } while (op != 0);
        guardar(list);
    }
    color(hConsole, 3);
    cout<<endl<<endl<<"\t\t\t\t\t\t :::::::: GRACIAS POR USAR NUESTRO SISTEMA ::::::::"<<endl<<endl;
    color(hConsole, 7);
}
