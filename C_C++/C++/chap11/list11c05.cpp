#include <iostream>

//個別の識別子の通用する範囲を指定する論理的な単位
using namespace std;
#define DEBUG 0

int main(){
  int a = 5;
  int x = 10;
#if DEBUG == 1
  a = x;
#endif
  cout << "aの値は" << a <<"です。\n";
}
