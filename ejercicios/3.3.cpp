#include <iostream>
using namespace std;
int main() {
	string op;
	float num1, num2, resul;
	cout<<" Ingrese la oprecion que desea hacer con la siguiente estructura: "<<endl;
	cout<<" Oprendo | Operador | Operando: "<<endl<<endl;
	cin>>num1;
	cin>>op;
	cin>>num2;
	if(op=="+"){
		resul= num1+num2;
		cout<<num1<<" + "<<num2<<" = "<<resul;
	}else if(op=="-"){
	    resul= num1-num2;
		cout<<num1<<" - "<<num2<<" = "<<resul;	
	}else if(op=="*"){
	    resul= num1*num2;
		cout<<num1<<" x "<<num2<<" = "<<resul;	
	}else if(op=="/"){
	    resul= num1/num2;
		cout<<num1<<" / "<<num2<<" = "<<resul;	
	}else{
		cout<<"ingrese un operador valido";
	}	
}
