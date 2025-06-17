#include <string>
#include <iostream>

using namespace std;

class Account{
public :
    string name;
    string number;
    long balance;
};

int main ()
{
    Account suzuki;
    Account takeda;

    suzuki.name = "鈴木龍一";
    suzuki.number = "12345678";
    suzuki.balance = 10000;

    takeda.name = "武田浩文";
    takeda.number = "87654321";
    takeda.balance = 10000;

    suzuki.balance -= 200;
    takeda.balance += 100;

    cout << suzuki.name <<suzuki.number << "\n";
    cout << takeda.name <<takeda.number << "\n";

    return 0;
  }
