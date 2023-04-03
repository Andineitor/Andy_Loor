#include <iostream>
using namespace std;

int main() {
	int n1, n2, n3, grande,producto, peque;
	double promedio, suma;
  cout<<"Escriba tres enteros diferentes: ";
  cin>>n1;
  cin>> n2;
  cin>> n3;
  suma=n1+n2+n3;
  cout<<endl<<"La suma: "<<suma<<endl;
  promedio=suma/3;
  cout<<"El promedio: "<<promedio<<endl;
  producto=n1*n2*n3;
  cout<<"El producto: "<<producto<<endl;
  if (n1>n2 && n1>n3){
  cout<<"El numero mayor es: "<<n1<<endl;
 }else if (n2>n1 && n2>n3){
 	cout<<"El numero mayor es: "<<n2<<endl;
 }else{
 	cout<<"El numero mayor es: "<<n3<<endl;
 }
   if (n1<n2 && n1<n3){
  cout<<"El numero menor es: "<<n1;
 }else if (n2<n1 && n2<n3){
 	cout<<"El numero menor es: "<<n2;
 }else{
 	cout<<"El numero menor es: "<<n3;
 }
}
