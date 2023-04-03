#include "Operaciones.h"
#include<math.h>
#include<iostream>

using namespace std;
int menu()
{
	int op;
	cout<<"Bienvenido a esta calculadora"<<endl;
	cout<<"1.-SUMAR"<<endl;
	cout<<"2.-RESTAR"<<endl;
	cout<<"3.-MULTIPLICAR"<<endl;
	cout<<"4.-DIVIDIR"<<endl;
	cout<<"5.-POTENCIA"<<endl;
	cout<<"6.-RAIZ"<<endl;
	cout<<"7.-FACTORIAL"<<endl;
	cout<<"0.-SALIR"<<endl;
	cout<<"Selecciona: ";
	cin>>op;
	return op;
}
void sumar()
{
	float n1,n2,resp;
	cout<<"Ingrese el primer numero: ";
	cin>>n1;
	cout<<"Ingrese el segundo numero: ";
	cin>>n2;
	resp=n1+n2;
	cout<<"La suma es: ["<<resp<<"]"<<endl<<endl;
}
void restar()
{
	float n1,n2,resp;
	cout<<"Ingrese el primer numero: ";
	cin>>n1;
	cout<<"Ingrese el segundo numero: ";
	cin>>n2;
	resp=n1-n2;;
	cout<<"La resta es: ["<<resp<<"]"<<endl<<endl;
}
void multiplicar()
{
	float n1,n2,resp;
	cout<<"Ingrese el primer numero: ";
	cin>>n1;
	cout<<"Ingrese el segundo numero: ";
	cin>>n2;
	resp=n1*n2;;
	cout<<"La multiplicacion es: ["<<resp<<"]"<<endl<<endl;
}
void dividir()
{
	float n1,n2,resp;
	cout<<"Ingrese el primer numero: ";
	cin>>n1;
	cout<<"Ingrese el segundo numero: ";
	cin>>n2;
	resp=n1/n2;;
	cout<<"La division es: ["<<resp<<"]"<<endl<<endl;
}
void potencia()
{
    float n1,n2,resp;
	cout<<"Ingrese el primer numero: ";
	cin>>n1;
	cout<<"Ingrese el segundo numero: ";
	cin>>n2;
	resp=pow(n1,n2);
	cout<<"La potenciacion es: ["<<resp<<"]"<<endl<<endl;
}
void raiz()
{
	float n1,n2,resp;
	cout<<"Ingrese un numero: ";
	cin>>n1;
	resp=sqrt(n1);
	cout<<"La raiz cuadrada es: ["<<resp<<"]"<<endl<<endl;
}
void factorial()
{
	int fact=1,n1;
	cout<<"Ingrese un numero: ";
	cin>>n1;
	for(int i=1;i<n1+1;i++)
	{
	fact=fact*i;
	}
	cout<<"El factorial del numero es: ["<<fact<<"]"<<endl<<endl;
}
