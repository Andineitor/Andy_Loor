
#include <iostream>

using namespace std;

int main() {

	string nombre, cd, direc, nomproduc;
  string  desc;
  double produc, uni, total, totaldesc, iva, final,descuento;
  cout<<"Precio del producto: ";
  cin>>produc;
  cout<<endl<<"Unidades: ";
  cin>>uni;
  cout<<endl<<"descuento (s/n)? ";
  cin>>desc;
  cin.get();
  cout<<endl<<"Nombre del cliente: ";
  getline(cin,nombre);
  cout<<endl<<"Ci del cliente: ";
  getline(cin,cd);
  cout<<endl<<"direccion del cliente: ";
  getline (cin, direc);
  cout<<endl<<"Nombre del producto: ";
  getline(cin, nomproduc);
  total=uni*produc;

  iva=total*0.12;

  cout<<endl<<endl<<"Factura:"<<endl;
  cout<<"                           "   <<nombre<<endl;
  cout<<"                           "  <<direc<<endl;
  cout<<"                           " <<cd<<endl<<endl<<endl;
  cout<<"Producto: "<<nomproduc <<endl;
  cout<<"Precio unitario:           "<<produc<<endl;
  cout<<"Unidades:                  "<<uni<<endl;
  cout<<"Total:                     "<<total<<endl;
   if(desc=="s" || desc=="S"){
   	descuento=produc*0.15;
 	 cout<<"Descuento:                 "<<"-"<<descuento<<endl;
  	}else{ 
  	cout<<"Descuento:                 "<<"no tiene desc."<<endl;
  	}
   totaldesc=total-descuento;
  cout<<"Total tras descuento:      "<<totaldesc<<endl; 
   final=totaldesc+iva;
  cout<<"I.V.A.:                    "<<iva<<endl;  

  cout<<"Precio final:              "<<final<<endl;
}
