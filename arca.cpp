#include <iostream>
using namespace std;

int main() {
	int pe, ga, co, ig, coco, ave, cantidad;
	float pel, gal, igl, col,cocol, avel, peso, total;
  cout<<"ingrese la cantidad de cada uno de los animales " <<endl;
  cout<<"Perros: ";
  cin>>pe;
  cout<<"Gato: ";
  cin>>ga;
  cout<<"Conejos: ";
  cin>>co;
  cout<<"Iguanas: ";
  cin>>ig;
  cout<<"Cocodrilos: ";
  cin>>coco;
  cout<<"Aves: ";
  cin>>ave;
  cantidad = pe+ga+co+ig+coco+ave;
  cout<<endl<<endl;
   cout<<"ingrese el peso de cada uno de los animales " <<endl;
  cout<<"Perros: ";
  cin>>pel;
  cout<<"Gato: ";
  cin>>gal;
  cout<<"Conejos: ";
  cin>>col;
  cout<<"Iguanas: ";
  cin>>igl;
  cout<<"Cocodrilos: ";
  cin>>cocol;
  cout<<"Aves: ";
  cin>>avel;
  peso= pel+gal+col+igl+cocol+avel;
  cout<<endl<<endl;
  total= cantidad*peso;
  cout<<"El peso total del arca es: " <<total;
}
