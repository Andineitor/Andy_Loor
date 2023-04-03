#include <iostream>
#include <math.h>
using namespace std;

void vuelto();
	
int main() 
{
	vuelto();
}

void vuelto(){
	double valor,precio;
	int dolar, cincuen, veinte, one, cinco, ctvs, diez;
	cout<<"Ingrese el valor pagado: ";
	cin>>valor;
	cout<<"Ingrese el precio del producto: ";
	cin>>precio;
	valor= valor-precio;
	dolar= int(valor);
	ctvs=0.5+(valor - dolar) * 100;
	cincuen = 1;
	veinte = 1;
	diez=1;
	
	if (ctvs <= 99){
		cincuen=ctvs/50;
		ctvs%=50;
		veinte=ctvs/25;
		ctvs%=25;
		diez=ctvs/10;
		ctvs%=10;
		cinco=ctvs/5;
		ctvs%=5;
		one= ctvs/1;	
	 }
	cout<<endl<<" Monedas de 1 dolar: "<<dolar<<endl;
	cout<<" Monedas de 50 centavos: "<<cincuen<<endl;
	cout<<" Monedas de 25 centavos: "<<veinte<<endl;
	cout<<" Monedas de 10 centavos: "<<diez<<endl;
	cout<<" Monedas de 5 centavos: "<<cinco<<endl;
	cout<<" Monedas de 1 centavos: "<<one;
}
