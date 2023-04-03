#include <iostream>
using namespace std;

int main() {
  int uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, diez,numero;
  cout<<"    - Ingrese el numero que desea multiplicar, en un intervalo del 1 al 100: ";
  cin>>numero;
  if(numero>0 && numero<=100 ){
  	uno=1*numero;
  	dos=2*numero;
  	tres=3*numero;
  	cuatro=4*numero;
	cinco=5*numero;
  	seis=6*numero;
   	siete=7*numero;
  	ocho=8*numero;
   	nueve=9*numero;
  	diez=10*numero;
  	cout<<endl<<"    |  1 x " <<numero<<" = "<<uno<<"     |"<<endl;
  	cout<<"    |  2 x " <<numero<<" = "<<dos<<"    |"<<endl;
  	cout<<"    |  3 x " <<numero<<" = "<<tres<<"    |"<<endl;
  	cout<<"    |  4 x " <<numero<<" = "<<cuatro<<"    |"<<endl;
  	cout<<"    |  5 x " <<numero<<" = "<<cinco<<"    |"<<endl;
  	cout<<"    |  6 x " <<numero<<" = "<<seis<<"    |"<<endl;
  	cout<<"    |  7 x " <<numero<<" = "<<siete<<"    |"<<endl;
  	cout<<"    |  8 x " <<numero<<" = "<<ocho<<"    |"<<endl;
  	cout<<"    |  9 x " <<numero<<" = "<<nueve<<"    |"<<endl;
  	cout<<"    |  10 x " <<numero<<" = "<<diez<<"   |"<<endl;
  }else{
  	cout<<"ingrese solo numeros en el intervalo indicado";
  }
}
