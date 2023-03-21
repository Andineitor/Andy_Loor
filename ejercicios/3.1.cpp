#include <iostream>
using namespace std;
int main() {
	double numero;
	string letra;
cout<< "ingrese su numero: ";
cin>>numero;

cout<< endl<<"ingrese la letra de su medida a convertir: ";
cin>> letra;
if(letra == "P"|| letra == "p"){
const double CM=numero*2.54;
	 cout<<endl<<"    "<<CM<<" cm";
}else if(letra=="M" || letra=="m"){
const double M=numero*1609;
	cout<<endl<<"    "<<M<<" m";
}else if(letra=="F "|| letra=="f"){
const double GC=(numero - 32) * 5/9;
	cout<<endl<<"    "<<GC<<" c";
}else if(letra=="G" || letra=="g"){
const double L=numero*3.785;
	cout<<endl<<"    "<<L<<" l";
}else if(letra=="O" || letra=="o"){
const double GRM=numero*28.35;
	cout<<endl<<"    "<<GRM<<" gr";
}else if(letra=="L" || letra=="l"){
const double KG=numero/2.205;
	cout<<endl<<"    "<<KG<<" kg";
}else if(letra != "P" || letra != "p" || letra != "M" || letra != "m" || 
		 letra != "F" || letra != "f" || letra != "G" || letra != "g"  || 
		 letra != "O" ||letra != "o" ||letra != "L" ||letra != "l" ){
	cout<<endl<<endl<<"    ||||  la letra ingresada y/o el valor numerico es incorrecto  ||||"<<endl<<endl;
}
}
