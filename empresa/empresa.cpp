#include <iostream>
#include <fstream>
#include <ctime>                                 
#include <cstdlib>  
using namespace std;

void cocaCola();
 int a;
void cocaCola()
{
    string nombre, apellido;
    int edad, anios;
    double sueldo,  ganancia, aumento;
    ofstream archivoprueba;
    archivoprueba.open("Coca-Cola.txt", ios::out);
    archivoprueba << "\t COCA-COLA" << endl;
    do {   
		cout << endl;
		cout << "Nombre del empleado: ";
        cin.ignore();
        getline(cin,nombre);
        cout << "Apellido del empleado: ";
        cin >> apellido;
        cout << "Edad del empleado: ";
        cin >> edad;
        cout << "Ingrese el sueldo del empleado: ";
        cin >> sueldo;
        cout << "Anios de trabajo: ";
        cin >> anios;
        cout << endl;
        cout << "Ingrese 1 para ingresar mas datos, 0 para guardar en el archivo: ";
        cin >> a;
        cin.ignore();
        
        if (anios > 10)
        {
        	aumento = (sueldo*10)/100;
        	ganancia = sueldo + aumento;
		}
		else if (anios <=10 && anios > 5)
		{
			aumento = (sueldo*7)/100;
        	ganancia = sueldo + aumento;
		}
		else if (anios <=5 && anios > 3)
		{
			aumento = (sueldo*5)/100;
        	ganancia = sueldo + aumento;
		}
		else if(anios < 3)
		{
			aumento = (sueldo*3)/100;
        	ganancia = sueldo + aumento;
		}

    archivoprueba <<"\t Reporte de salarios"<< endl <<endl;
    archivoprueba <<"\t REGISTRO "<< "\t\tDATOS"<<endl;
    archivoprueba << "Numero del empleado: \t\t" << nombre << endl;
    archivoprueba << "Apellido del empleado: \t\t" << apellido << endl;
    archivoprueba << "Edad del empleado: \t\t" << edad << endl;
    archivoprueba << "Sueldo mensual del empleado: \t$" << sueldo << endl;
    archivoprueba << "Anios de trabajo: \t\t" << anios << endl;
    archivoprueba << "Recibe ganancia: \t\tsi"<< endl;
    archivoprueba << "Nuevo Sueldo a Recibir: \t$"<< ganancia << endl;
        
    } while (a != 0);
	cout << endl;
    cout << "Datos guardados correctamente" << endl;
    archivoprueba.close();
}

int main()
{
   	cout << endl;
    	cout << "Bienvenido a Coca-Cola" << endl <<endl;
        cout << "\t 1.- Finanzas Coca-Cola" << endl;
        cout << "\t 0.- Salir"<<endl<<endl;
        cout << "Ingrese su opcion: ";
        cin >> a;
         while ( a != 0  )
    {
    
        switch (a)
        {
        case 1:
        {
         cocaCola();
        }
        break;
        case 2:
        {
        	cout<<endl;
            cout << "Gracias por usar esta plataforma";
        }
        break;
        default:
        {
            cout << "Ingrese una opcion valida" << endl;
        }
        }
    }
}
