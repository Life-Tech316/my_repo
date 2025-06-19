#include <string>
#include <iostream>
#include "Account.h"

//名前空間の定義
using namespace std;

//pが指すAccountの口座情報(名義指名・口座番号・預金残高)を表示
void print_Account(string title,Account* p)
{
  cout << title
      << p->name() << "\" (" << p->no() << ") " << p->balance() << "円\n";

}

//メイン関数
int main(){
  //オブジェクトの生成
  Account suzuki("鈴木良一","12345678",1000);
  //オブジェクトの生成
  Account takeda("鈴木良一","12345678",1000);

  suzuki.withdraw(200);
  suzuki.deposit(200);

  print_Account("■鈴木くんの口座" , &suzuki);
  print_Account("■武田くんの口座" , &takeda);

}
