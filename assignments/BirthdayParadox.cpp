/*
Program no. -- 02 (Birthday Paradox)
Performed by-- Priyanka P Vidhate
*/

include<iostream>
#include<stdlib.h>
#include<math.h>
#include<cmath>
using namespace std;

void  Num_People(float p)
{
int a=0;
a= ceil (sqrt(2*365*log(1/(1-p))));
cout<<"Number of for people for particular probability"<<a;
}

void probability(int d)  /*function to calculate probability that  two persons  among  n people have     same birthday*/
//formula to calculate probability c=1-(364/365)^n
{
float a=(float)((d*d)/(2*365));
float b=exp(-a);
float c=1-b;
cout<<"probabality  that  two persons  among  n people have  same birthday"<<c;
}

int main()
{
float b;
int a,c;
char ans;
do{
cout<<"\nenter choice";
cin>>a;
switch(a)
{
case 1:cout<<"\nEnter probability";
       cin>>b;
       Num_People(b);
       break;
case 2:cout<<"\nEnter number of people in group";
       cin>>c;
       probability(c);
       break;
}
cout<<"\ndo u want to continue y/n?\n";
cin>>ans;
}while(ans=='y');
return(1);
}

