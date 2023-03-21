#include <iostream>
#include <ctime>
using namespace std;

int main() {
	
	unsigned  t1;
 	string letra;
 	float min,paga;
 	cout<<"precione s para iniciar llamada: ";
 	cin>>letra;
	if(letra=="s" || letra=="S" ){
	
	}
	cout<<"precione s para finalizar llamada: ";

	cin>>letra;
	t1= clock();
	if(letra=="s" || letra=="S" ){
	double time = (double (t1/CLOCKS_PER_SEC));
	min=time/60;
	paga=min*0.60;
	cout <<endl<< "el saldo a pagar es de: " << paga<<" cntvs" << endl;
}
}

