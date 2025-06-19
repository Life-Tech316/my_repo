#include <string>
#include <iostream>
#include "Account.h"

usijng namespace std;

//クラスの定義
Account::Account(string name, string num,long amnt)
{
  full_name = name;
  number = num;
  crnt_balance = amnt;
}

// 預ける
void Account::deposit(long amnt){
  crnt_balance += amnt;
}
//引き出す
void  Account::withdraw(long amnt){n
  crnt_balance -= amnt;
}
