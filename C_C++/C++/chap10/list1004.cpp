#include <string>
#include <iostream>

//名前空間の定義
using namespace std;

//クラスの作成
class Account{
private :
    string full_name;
    string number;
    long crnt_balance;
public:
    //コンストラクタの定義
    Account(string name,string num,long amnt);
    string name(){ return full_name; }
    string no(){ return number; }
    long balance(){ return crnt_balance; }
    void deposit(long amnt);
    void withdraw(long amnt);
};

Account::Account(string name,string num,long amnt){
      full_name = name;
      number = num;
      crnt_balance = amnt;
    }
void Account::deposit(long amnt){
      crnt_balance += amnt;
    }

void Account::withdraw(long amnt){
      crnt_balance -= amnt;

}

int main ()
{
    Account suzuki("鈴木龍一","12345678",10000);
    Account takeda("武田浩文","87654321",1000);

    suzuki.withdraw(200);
    takeda.deposit(100);

    cout << suzuki.no() << " " << suzuki.balance() << "\n";
    cout << takeda.no() << " " << takeda.balance() << "\n";

    return 0;
  }
