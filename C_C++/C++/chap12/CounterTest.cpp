#include <iostream>
#include "Counter.h"

using namespace std;

int main(){
  int no;
  //カウンタオブジェクトの生成
  Counter x;

  cout << "現在のカウンタ : " << x.value() << '\n';
  cout << "カウントアップ回数:" ;
  cin >> no;

  for (int i = 0; i < no ; i++){
    x.increment();
    cout << x.value() << '\n';
  }
  cout << "カウントダウン回数:" ;
  cin >> no;

  for (int i = 0;i < no; i++){
    x.decrement();
    cout << x.value() << '\n';
  }
}
