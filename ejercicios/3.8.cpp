#include <iostream>
using namespace std;

int main() {
	float cant,euro,dolar;
	int op;
  cout<<"1. dolares a euros ";
  cout<<endl<<"2. euros a dolares ";
  cout<<endl<<"3. Salir"<<endl;
  cout<<"Seleccione la conversion a sali: ";
  cin>>op;
  cout<<"Ingrese la cantidad a convertir: ";
  cin>>cant;
  dolar=cant*0.84282;
  
  switch(op){
  	case 1:
  		
  		cout<<endl<<cant<<" dolares son "<<dolar<<" euros";
  		break;
  		case 2:
  		euro=cant*1.0831;
  		cout<<endl<<cant<<" euros son "<<euro<<" dolares"<<endl<<endl;
  		break;
  		default:
  			cout<<"vuelva pronto";
  			cin>>op;
  		
  	  }		
}
