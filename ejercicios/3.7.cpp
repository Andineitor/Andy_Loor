#include <iostream>
#include <math.h>

using namespace std;

int main() {
  float masa1, masa2, distancia,cm,kilogramo1,kilogramo2 ;
  const  float G=0.0000000000667;
  cout<<"Introduca la masa 1 en toneladas: ";
  cin>>masa1;
   cout<<endl<<"Introduca la masa 2 en toneladas: ";
  cin>>masa2;
   cout<<endl<<"Introduca la distancia entre ellos en cm: ";
  cin>>distancia;
  kilogramo1=masa1*1000;
  kilogramo2=masa2*1000;
  cm=distancia/100;
    const float F=G*((kilogramo1*kilogramo2)/ pow(cm,2));
    cout<<endl<<"Fuerza de atraccion = "<<F<<" N";
 
}
